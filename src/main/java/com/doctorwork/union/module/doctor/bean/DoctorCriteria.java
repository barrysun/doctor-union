package com.doctorwork.union.module.doctor.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DoctorCriteria {
    /**
     * t_doctor
     */
    protected String orderByClause;

    /**
     * t_doctor
     */
    protected boolean distinct;

    /**
     * t_doctor
     */
    protected List<Criteria> oredCriteria;

    public DoctorCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * t_doctor 2017-10-24
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNull() {
            addCriterion("agent_id is null");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNotNull() {
            addCriterion("agent_id is not null");
            return (Criteria) this;
        }

        public Criteria andAgentIdEqualTo(String value) {
            addCriterion("agent_id =", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotEqualTo(String value) {
            addCriterion("agent_id <>", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThan(String value) {
            addCriterion("agent_id >", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThanOrEqualTo(String value) {
            addCriterion("agent_id >=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThan(String value) {
            addCriterion("agent_id <", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThanOrEqualTo(String value) {
            addCriterion("agent_id <=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLike(String value) {
            addCriterion("agent_id like", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotLike(String value) {
            addCriterion("agent_id not like", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdIn(List<String> values) {
            addCriterion("agent_id in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotIn(List<String> values) {
            addCriterion("agent_id not in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdBetween(String value1, String value2) {
            addCriterion("agent_id between", value1, value2, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotBetween(String value1, String value2) {
            addCriterion("agent_id not between", value1, value2, "agentId");
            return (Criteria) this;
        }

        public Criteria andDoctorNameIsNull() {
            addCriterion("doctor_name is null");
            return (Criteria) this;
        }

        public Criteria andDoctorNameIsNotNull() {
            addCriterion("doctor_name is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorNameEqualTo(String value) {
            addCriterion("doctor_name =", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotEqualTo(String value) {
            addCriterion("doctor_name <>", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameGreaterThan(String value) {
            addCriterion("doctor_name >", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_name >=", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameLessThan(String value) {
            addCriterion("doctor_name <", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameLessThanOrEqualTo(String value) {
            addCriterion("doctor_name <=", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameLike(String value) {
            addCriterion("doctor_name like", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotLike(String value) {
            addCriterion("doctor_name not like", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameIn(List<String> values) {
            addCriterion("doctor_name in", values, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotIn(List<String> values) {
            addCriterion("doctor_name not in", values, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameBetween(String value1, String value2) {
            addCriterion("doctor_name between", value1, value2, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotBetween(String value1, String value2) {
            addCriterion("doctor_name not between", value1, value2, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorAvatarIsNull() {
            addCriterion("doctor_avatar is null");
            return (Criteria) this;
        }

        public Criteria andDoctorAvatarIsNotNull() {
            addCriterion("doctor_avatar is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorAvatarEqualTo(String value) {
            addCriterion("doctor_avatar =", value, "doctorAvatar");
            return (Criteria) this;
        }

        public Criteria andDoctorAvatarNotEqualTo(String value) {
            addCriterion("doctor_avatar <>", value, "doctorAvatar");
            return (Criteria) this;
        }

        public Criteria andDoctorAvatarGreaterThan(String value) {
            addCriterion("doctor_avatar >", value, "doctorAvatar");
            return (Criteria) this;
        }

        public Criteria andDoctorAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_avatar >=", value, "doctorAvatar");
            return (Criteria) this;
        }

        public Criteria andDoctorAvatarLessThan(String value) {
            addCriterion("doctor_avatar <", value, "doctorAvatar");
            return (Criteria) this;
        }

        public Criteria andDoctorAvatarLessThanOrEqualTo(String value) {
            addCriterion("doctor_avatar <=", value, "doctorAvatar");
            return (Criteria) this;
        }

        public Criteria andDoctorAvatarLike(String value) {
            addCriterion("doctor_avatar like", value, "doctorAvatar");
            return (Criteria) this;
        }

        public Criteria andDoctorAvatarNotLike(String value) {
            addCriterion("doctor_avatar not like", value, "doctorAvatar");
            return (Criteria) this;
        }

        public Criteria andDoctorAvatarIn(List<String> values) {
            addCriterion("doctor_avatar in", values, "doctorAvatar");
            return (Criteria) this;
        }

        public Criteria andDoctorAvatarNotIn(List<String> values) {
            addCriterion("doctor_avatar not in", values, "doctorAvatar");
            return (Criteria) this;
        }

        public Criteria andDoctorAvatarBetween(String value1, String value2) {
            addCriterion("doctor_avatar between", value1, value2, "doctorAvatar");
            return (Criteria) this;
        }

        public Criteria andDoctorAvatarNotBetween(String value1, String value2) {
            addCriterion("doctor_avatar not between", value1, value2, "doctorAvatar");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andHospitalIsNull() {
            addCriterion("hospital is null");
            return (Criteria) this;
        }

        public Criteria andHospitalIsNotNull() {
            addCriterion("hospital is not null");
            return (Criteria) this;
        }

        public Criteria andHospitalEqualTo(String value) {
            addCriterion("hospital =", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalNotEqualTo(String value) {
            addCriterion("hospital <>", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalGreaterThan(String value) {
            addCriterion("hospital >", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalGreaterThanOrEqualTo(String value) {
            addCriterion("hospital >=", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalLessThan(String value) {
            addCriterion("hospital <", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalLessThanOrEqualTo(String value) {
            addCriterion("hospital <=", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalLike(String value) {
            addCriterion("hospital like", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalNotLike(String value) {
            addCriterion("hospital not like", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalIn(List<String> values) {
            addCriterion("hospital in", values, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalNotIn(List<String> values) {
            addCriterion("hospital not in", values, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalBetween(String value1, String value2) {
            addCriterion("hospital between", value1, value2, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalNotBetween(String value1, String value2) {
            addCriterion("hospital not between", value1, value2, "hospital");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIsNull() {
            addCriterion("specialty is null");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIsNotNull() {
            addCriterion("specialty is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialtyEqualTo(String value) {
            addCriterion("specialty =", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotEqualTo(String value) {
            addCriterion("specialty <>", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyGreaterThan(String value) {
            addCriterion("specialty >", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyGreaterThanOrEqualTo(String value) {
            addCriterion("specialty >=", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLessThan(String value) {
            addCriterion("specialty <", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLessThanOrEqualTo(String value) {
            addCriterion("specialty <=", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLike(String value) {
            addCriterion("specialty like", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotLike(String value) {
            addCriterion("specialty not like", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIn(List<String> values) {
            addCriterion("specialty in", values, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotIn(List<String> values) {
            addCriterion("specialty not in", values, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyBetween(String value1, String value2) {
            addCriterion("specialty between", value1, value2, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotBetween(String value1, String value2) {
            addCriterion("specialty not between", value1, value2, "specialty");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andWorkPriceIsNull() {
            addCriterion("work_price is null");
            return (Criteria) this;
        }

        public Criteria andWorkPriceIsNotNull() {
            addCriterion("work_price is not null");
            return (Criteria) this;
        }

        public Criteria andWorkPriceEqualTo(Long value) {
            addCriterion("work_price =", value, "workPrice");
            return (Criteria) this;
        }

        public Criteria andWorkPriceNotEqualTo(Long value) {
            addCriterion("work_price <>", value, "workPrice");
            return (Criteria) this;
        }

        public Criteria andWorkPriceGreaterThan(Long value) {
            addCriterion("work_price >", value, "workPrice");
            return (Criteria) this;
        }

        public Criteria andWorkPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("work_price >=", value, "workPrice");
            return (Criteria) this;
        }

        public Criteria andWorkPriceLessThan(Long value) {
            addCriterion("work_price <", value, "workPrice");
            return (Criteria) this;
        }

        public Criteria andWorkPriceLessThanOrEqualTo(Long value) {
            addCriterion("work_price <=", value, "workPrice");
            return (Criteria) this;
        }

        public Criteria andWorkPriceIn(List<Long> values) {
            addCriterion("work_price in", values, "workPrice");
            return (Criteria) this;
        }

        public Criteria andWorkPriceNotIn(List<Long> values) {
            addCriterion("work_price not in", values, "workPrice");
            return (Criteria) this;
        }

        public Criteria andWorkPriceBetween(Long value1, Long value2) {
            addCriterion("work_price between", value1, value2, "workPrice");
            return (Criteria) this;
        }

        public Criteria andWorkPriceNotBetween(Long value1, Long value2) {
            addCriterion("work_price not between", value1, value2, "workPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNull() {
            addCriterion("order_price is null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNotNull() {
            addCriterion("order_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceEqualTo(Long value) {
            addCriterion("order_price =", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotEqualTo(Long value) {
            addCriterion("order_price <>", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThan(Long value) {
            addCriterion("order_price >", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("order_price >=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThan(Long value) {
            addCriterion("order_price <", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThanOrEqualTo(Long value) {
            addCriterion("order_price <=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIn(List<Long> values) {
            addCriterion("order_price in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotIn(List<Long> values) {
            addCriterion("order_price not in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceBetween(Long value1, Long value2) {
            addCriterion("order_price between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotBetween(Long value1, Long value2) {
            addCriterion("order_price not between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIsNull() {
            addCriterion("account_status is null");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIsNotNull() {
            addCriterion("account_status is not null");
            return (Criteria) this;
        }

        public Criteria andAccountStatusEqualTo(Integer value) {
            addCriterion("account_status =", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotEqualTo(Integer value) {
            addCriterion("account_status <>", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusGreaterThan(Integer value) {
            addCriterion("account_status >", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_status >=", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusLessThan(Integer value) {
            addCriterion("account_status <", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusLessThanOrEqualTo(Integer value) {
            addCriterion("account_status <=", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIn(List<Integer> values) {
            addCriterion("account_status in", values, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotIn(List<Integer> values) {
            addCriterion("account_status not in", values, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusBetween(Integer value1, Integer value2) {
            addCriterion("account_status between", value1, value2, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("account_status not between", value1, value2, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Long value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Long value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Long value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Long value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Long value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Long> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Long> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Long value1, Long value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Long value1, Long value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andInvitationCountIsNull() {
            addCriterion("invitation_count is null");
            return (Criteria) this;
        }

        public Criteria andInvitationCountIsNotNull() {
            addCriterion("invitation_count is not null");
            return (Criteria) this;
        }

        public Criteria andInvitationCountEqualTo(Integer value) {
            addCriterion("invitation_count =", value, "invitationCount");
            return (Criteria) this;
        }

        public Criteria andInvitationCountNotEqualTo(Integer value) {
            addCriterion("invitation_count <>", value, "invitationCount");
            return (Criteria) this;
        }

        public Criteria andInvitationCountGreaterThan(Integer value) {
            addCriterion("invitation_count >", value, "invitationCount");
            return (Criteria) this;
        }

        public Criteria andInvitationCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("invitation_count >=", value, "invitationCount");
            return (Criteria) this;
        }

        public Criteria andInvitationCountLessThan(Integer value) {
            addCriterion("invitation_count <", value, "invitationCount");
            return (Criteria) this;
        }

        public Criteria andInvitationCountLessThanOrEqualTo(Integer value) {
            addCriterion("invitation_count <=", value, "invitationCount");
            return (Criteria) this;
        }

        public Criteria andInvitationCountIn(List<Integer> values) {
            addCriterion("invitation_count in", values, "invitationCount");
            return (Criteria) this;
        }

        public Criteria andInvitationCountNotIn(List<Integer> values) {
            addCriterion("invitation_count not in", values, "invitationCount");
            return (Criteria) this;
        }

        public Criteria andInvitationCountBetween(Integer value1, Integer value2) {
            addCriterion("invitation_count between", value1, value2, "invitationCount");
            return (Criteria) this;
        }

        public Criteria andInvitationCountNotBetween(Integer value1, Integer value2) {
            addCriterion("invitation_count not between", value1, value2, "invitationCount");
            return (Criteria) this;
        }

        public Criteria andCardUserNameIsNull() {
            addCriterion("card_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCardUserNameIsNotNull() {
            addCriterion("card_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCardUserNameEqualTo(String value) {
            addCriterion("card_user_name =", value, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardUserNameNotEqualTo(String value) {
            addCriterion("card_user_name <>", value, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardUserNameGreaterThan(String value) {
            addCriterion("card_user_name >", value, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("card_user_name >=", value, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardUserNameLessThan(String value) {
            addCriterion("card_user_name <", value, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardUserNameLessThanOrEqualTo(String value) {
            addCriterion("card_user_name <=", value, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardUserNameLike(String value) {
            addCriterion("card_user_name like", value, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardUserNameNotLike(String value) {
            addCriterion("card_user_name not like", value, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardUserNameIn(List<String> values) {
            addCriterion("card_user_name in", values, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardUserNameNotIn(List<String> values) {
            addCriterion("card_user_name not in", values, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardUserNameBetween(String value1, String value2) {
            addCriterion("card_user_name between", value1, value2, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardUserNameNotBetween(String value1, String value2) {
            addCriterion("card_user_name not between", value1, value2, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNull() {
            addCriterion("id_card is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("id_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("id_card =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("id_card <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("id_card >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("id_card >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("id_card <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("id_card <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("id_card like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("id_card not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("id_card in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("id_card not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("id_card between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("id_card not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andCardNumberIsNull() {
            addCriterion("card_number is null");
            return (Criteria) this;
        }

        public Criteria andCardNumberIsNotNull() {
            addCriterion("card_number is not null");
            return (Criteria) this;
        }

        public Criteria andCardNumberEqualTo(String value) {
            addCriterion("card_number =", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotEqualTo(String value) {
            addCriterion("card_number <>", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberGreaterThan(String value) {
            addCriterion("card_number >", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberGreaterThanOrEqualTo(String value) {
            addCriterion("card_number >=", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLessThan(String value) {
            addCriterion("card_number <", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLessThanOrEqualTo(String value) {
            addCriterion("card_number <=", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLike(String value) {
            addCriterion("card_number like", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotLike(String value) {
            addCriterion("card_number not like", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberIn(List<String> values) {
            addCriterion("card_number in", values, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotIn(List<String> values) {
            addCriterion("card_number not in", values, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberBetween(String value1, String value2) {
            addCriterion("card_number between", value1, value2, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotBetween(String value1, String value2) {
            addCriterion("card_number not between", value1, value2, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardBankIsNull() {
            addCriterion("card_bank is null");
            return (Criteria) this;
        }

        public Criteria andCardBankIsNotNull() {
            addCriterion("card_bank is not null");
            return (Criteria) this;
        }

        public Criteria andCardBankEqualTo(String value) {
            addCriterion("card_bank =", value, "cardBank");
            return (Criteria) this;
        }

        public Criteria andCardBankNotEqualTo(String value) {
            addCriterion("card_bank <>", value, "cardBank");
            return (Criteria) this;
        }

        public Criteria andCardBankGreaterThan(String value) {
            addCriterion("card_bank >", value, "cardBank");
            return (Criteria) this;
        }

        public Criteria andCardBankGreaterThanOrEqualTo(String value) {
            addCriterion("card_bank >=", value, "cardBank");
            return (Criteria) this;
        }

        public Criteria andCardBankLessThan(String value) {
            addCriterion("card_bank <", value, "cardBank");
            return (Criteria) this;
        }

        public Criteria andCardBankLessThanOrEqualTo(String value) {
            addCriterion("card_bank <=", value, "cardBank");
            return (Criteria) this;
        }

        public Criteria andCardBankLike(String value) {
            addCriterion("card_bank like", value, "cardBank");
            return (Criteria) this;
        }

        public Criteria andCardBankNotLike(String value) {
            addCriterion("card_bank not like", value, "cardBank");
            return (Criteria) this;
        }

        public Criteria andCardBankIn(List<String> values) {
            addCriterion("card_bank in", values, "cardBank");
            return (Criteria) this;
        }

        public Criteria andCardBankNotIn(List<String> values) {
            addCriterion("card_bank not in", values, "cardBank");
            return (Criteria) this;
        }

        public Criteria andCardBankBetween(String value1, String value2) {
            addCriterion("card_bank between", value1, value2, "cardBank");
            return (Criteria) this;
        }

        public Criteria andCardBankNotBetween(String value1, String value2) {
            addCriterion("card_bank not between", value1, value2, "cardBank");
            return (Criteria) this;
        }

        public Criteria andPassportIdIsNull() {
            addCriterion("passport_id is null");
            return (Criteria) this;
        }

        public Criteria andPassportIdIsNotNull() {
            addCriterion("passport_id is not null");
            return (Criteria) this;
        }

        public Criteria andPassportIdEqualTo(String value) {
            addCriterion("passport_id =", value, "passportId");
            return (Criteria) this;
        }

        public Criteria andPassportIdNotEqualTo(String value) {
            addCriterion("passport_id <>", value, "passportId");
            return (Criteria) this;
        }

        public Criteria andPassportIdGreaterThan(String value) {
            addCriterion("passport_id >", value, "passportId");
            return (Criteria) this;
        }

        public Criteria andPassportIdGreaterThanOrEqualTo(String value) {
            addCriterion("passport_id >=", value, "passportId");
            return (Criteria) this;
        }

        public Criteria andPassportIdLessThan(String value) {
            addCriterion("passport_id <", value, "passportId");
            return (Criteria) this;
        }

        public Criteria andPassportIdLessThanOrEqualTo(String value) {
            addCriterion("passport_id <=", value, "passportId");
            return (Criteria) this;
        }

        public Criteria andPassportIdLike(String value) {
            addCriterion("passport_id like", value, "passportId");
            return (Criteria) this;
        }

        public Criteria andPassportIdNotLike(String value) {
            addCriterion("passport_id not like", value, "passportId");
            return (Criteria) this;
        }

        public Criteria andPassportIdIn(List<String> values) {
            addCriterion("passport_id in", values, "passportId");
            return (Criteria) this;
        }

        public Criteria andPassportIdNotIn(List<String> values) {
            addCriterion("passport_id not in", values, "passportId");
            return (Criteria) this;
        }

        public Criteria andPassportIdBetween(String value1, String value2) {
            addCriterion("passport_id between", value1, value2, "passportId");
            return (Criteria) this;
        }

        public Criteria andPassportIdNotBetween(String value1, String value2) {
            addCriterion("passport_id not between", value1, value2, "passportId");
            return (Criteria) this;
        }

        public Criteria andPlatformRebateIsNull() {
            addCriterion("platform_rebate is null");
            return (Criteria) this;
        }

        public Criteria andPlatformRebateIsNotNull() {
            addCriterion("platform_rebate is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformRebateEqualTo(BigDecimal value) {
            addCriterion("platform_rebate =", value, "platformRebate");
            return (Criteria) this;
        }

        public Criteria andPlatformRebateNotEqualTo(BigDecimal value) {
            addCriterion("platform_rebate <>", value, "platformRebate");
            return (Criteria) this;
        }

        public Criteria andPlatformRebateGreaterThan(BigDecimal value) {
            addCriterion("platform_rebate >", value, "platformRebate");
            return (Criteria) this;
        }

        public Criteria andPlatformRebateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_rebate >=", value, "platformRebate");
            return (Criteria) this;
        }

        public Criteria andPlatformRebateLessThan(BigDecimal value) {
            addCriterion("platform_rebate <", value, "platformRebate");
            return (Criteria) this;
        }

        public Criteria andPlatformRebateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_rebate <=", value, "platformRebate");
            return (Criteria) this;
        }

        public Criteria andPlatformRebateIn(List<BigDecimal> values) {
            addCriterion("platform_rebate in", values, "platformRebate");
            return (Criteria) this;
        }

        public Criteria andPlatformRebateNotIn(List<BigDecimal> values) {
            addCriterion("platform_rebate not in", values, "platformRebate");
            return (Criteria) this;
        }

        public Criteria andPlatformRebateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_rebate between", value1, value2, "platformRebate");
            return (Criteria) this;
        }

        public Criteria andPlatformRebateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_rebate not between", value1, value2, "platformRebate");
            return (Criteria) this;
        }
    }

    /**
     * t_doctor
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * t_doctor 2017-10-24
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}