package com.doctorwork.union.module.shopkeeper.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.doctorwork.union.common.config.ShopkeeperProperties;
import com.doctorwork.union.common.utils.PssportUtil;
import com.doctorwork.union.module.doctor.bean.Doctor;
import com.doctorwork.union.module.invitation.vo.ClinicRetVo;
import com.doctorwork.union.module.invitation.vo.ClinicVo;
import com.doctorwork.union.module.shopkeeper.service.ShopkeeperService;
import com.doctorwork.union.module.shopkeeper.vo.ShopkeeperDoctorParam;
import com.doctorwork.union.module.shopkeeper.vo.ShopkeeperDoctorVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * Created by barry on 2017/10/20.
 */
@Service
@Slf4j
public class ShopkeeperServiceImpl implements ShopkeeperService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private ShopkeeperProperties shopkeeperProperties;

    //获取诊所名称
    @Override
    public Map<String,ClinicVo> getClinicNames(Set<String> keys){
        Map<String,Object> param = new HashMap<>();
        Map<String,ClinicVo> map = new HashMap<>();
        if (keys.isEmpty()) {
            return  map;
        }
        param.put("data",keys);
        log.info("url:{}", JSON.toJSON(param));
        HttpHeaders headers = new HttpHeaders();
        //一定要设置好ContentType为utf8否则会乱码
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        HttpEntity<String> entity=new HttpEntity<>(JSON.toJSONString(param),headers);
        String res = restTemplate.postForObject(shopkeeperProperties.getUrl()+"/server/wallet/profiles",entity,String.class);
        log.info("shopkeeper result:{}",res);
        ClinicRetVo<List<ClinicVo>> clinicRetVo = JSON.parseObject(res, new TypeReference<ClinicRetVo<List<ClinicVo>>>(){});

        if(clinicRetVo!=null && "0000".equals(clinicRetVo.getStatus()) && clinicRetVo.getData()!=null && clinicRetVo.getData().size()>0){
            for (ClinicVo o : clinicRetVo.getData()) {
                map.put(o.getId(),o);
            }
        }
        return map;
    }

   public void synDoctorClinic(Doctor doctor) throws  Exception{
        Map<String,Object> param = new HashMap<>();
       ShopkeeperDoctorParam<ShopkeeperDoctorVo> shopkeeperDoctorVoShopkeeperDoctorParam=new ShopkeeperDoctorParam<>();
       ShopkeeperDoctorVo shopkeeperDoctorVo=new ShopkeeperDoctorVo();
       shopkeeperDoctorVo.setName(doctor.getDoctorName());
       shopkeeperDoctorVo.setCellphone(doctor.getPhone());
       shopkeeperDoctorVo.setPassportId(Integer.parseInt(doctor.getPassportId().trim()));
       shopkeeperDoctorVoShopkeeperDoctorParam.setData(shopkeeperDoctorVo);
       shopkeeperDoctorVoShopkeeperDoctorParam.setTime(System.currentTimeMillis());
       shopkeeperDoctorVoShopkeeperDoctorParam.setSource("doctorUnion");
       param.put("name",doctor.getDoctorName());
       param.put("cellphone",doctor.getPhone());
       param.put("passportId",doctor.getPassportId());

       String params = convert2SignContent(param);
       if(StringUtils.isNotBlank(params) &&params.endsWith("&")){
           params=params.substring(0,params.length()-1);
       }
       log.info("md5 before:{}",shopkeeperProperties.getSecret() + params);
       String sign = PssportUtil.md5(shopkeeperProperties.getSecret() + params);

       shopkeeperDoctorVoShopkeeperDoctorParam.setThirdSignature(sign);



       HttpHeaders headers = new HttpHeaders();
       MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
       headers.setContentType(type);
       log.info("====>"+JSON.toJSONString(shopkeeperDoctorVoShopkeeperDoctorParam));
       HttpEntity<String> entity=new HttpEntity<>(JSON.toJSONString(shopkeeperDoctorVoShopkeeperDoctorParam),headers);
       String res = restTemplate.postForObject(shopkeeperProperties.getUrl()+"/server"+"/user/thirdAddUser",entity,String.class);
       //String res = restTemplate.postForObject("http://192.168.0.25:9527"+"/shopkeeper/user/thirdAddUser",entity,String.class);
       log.info("shopkeeper result:{}",res);
       ClinicRetVo<String> clinicRetVo = JSON.parseObject(res, new TypeReference<ClinicRetVo<String>>(){});


   }

    public static String convert2SignContent(Map<String, Object> paramsMap) {
        if (paramsMap == null) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        List<String> keys = new ArrayList<>(paramsMap.keySet());
        Collections.sort(keys); // 字典顺序排序

        for (String key : keys) {
            Object valueObj = paramsMap.get(key);
            if ( ! isEmptyObject(valueObj)) { // 过滤空值
                builder.append(key).append("=").append(valueObj.toString()).append("&");
            }
        }

        String signContent = builder.toString().replaceAll("\\s+", "");

        if (signContent.length() == 0) {
            return "";
        }

        return signContent;
    }
    private static boolean isEmptyObject(Object obj) {
        if (obj == null) {
            return true;
        }

        String objStr = obj.toString();

        return objStr == null || objStr.length() == 0 || objStr.trim().length() == 0;
    }

}
