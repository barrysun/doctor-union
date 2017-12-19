package com.doctorwork.union.module.withdrawals.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WithdrawalsCriteria {
    /**
     * t_withdrawals
     */
    protected String orderByClause;

    /**
     * t_withdrawals
     */
    protected boolean distinct;

    /**
     * t_withdrawals
     */
    protected List<Criteria> oredCriteria;

    public WithdrawalsCriteria() {
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
     * t_withdrawals 2017-10-24
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

        public Criteria andWithdrawalsDateIsNull() {
            addCriterion("withdrawals_date is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsDateIsNotNull() {
            addCriterion("withdrawals_date is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsDateEqualTo(Long value) {
            addCriterion("withdrawals_date =", value, "withdrawalsDate");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsDateNotEqualTo(Long value) {
            addCriterion("withdrawals_date <>", value, "withdrawalsDate");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsDateGreaterThan(Long value) {
            addCriterion("withdrawals_date >", value, "withdrawalsDate");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsDateGreaterThanOrEqualTo(Long value) {
            addCriterion("withdrawals_date >=", value, "withdrawalsDate");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsDateLessThan(Long value) {
            addCriterion("withdrawals_date <", value, "withdrawalsDate");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsDateLessThanOrEqualTo(Long value) {
            addCriterion("withdrawals_date <=", value, "withdrawalsDate");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsDateIn(List<Long> values) {
            addCriterion("withdrawals_date in", values, "withdrawalsDate");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsDateNotIn(List<Long> values) {
            addCriterion("withdrawals_date not in", values, "withdrawalsDate");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsDateBetween(Long value1, Long value2) {
            addCriterion("withdrawals_date between", value1, value2, "withdrawalsDate");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsDateNotBetween(Long value1, Long value2) {
            addCriterion("withdrawals_date not between", value1, value2, "withdrawalsDate");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsMoneyIsNull() {
            addCriterion("withdrawals_money is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsMoneyIsNotNull() {
            addCriterion("withdrawals_money is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsMoneyEqualTo(BigDecimal value) {
            addCriterion("withdrawals_money =", value, "withdrawalsMoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsMoneyNotEqualTo(BigDecimal value) {
            addCriterion("withdrawals_money <>", value, "withdrawalsMoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsMoneyGreaterThan(BigDecimal value) {
            addCriterion("withdrawals_money >", value, "withdrawalsMoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("withdrawals_money >=", value, "withdrawalsMoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsMoneyLessThan(BigDecimal value) {
            addCriterion("withdrawals_money <", value, "withdrawalsMoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("withdrawals_money <=", value, "withdrawalsMoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsMoneyIn(List<BigDecimal> values) {
            addCriterion("withdrawals_money in", values, "withdrawalsMoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsMoneyNotIn(List<BigDecimal> values) {
            addCriterion("withdrawals_money not in", values, "withdrawalsMoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withdrawals_money between", value1, value2, "withdrawalsMoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withdrawals_money not between", value1, value2, "withdrawalsMoney");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyIsNull() {
            addCriterion("service_money is null");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyIsNotNull() {
            addCriterion("service_money is not null");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyEqualTo(BigDecimal value) {
            addCriterion("service_money =", value, "serviceMoney");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyNotEqualTo(BigDecimal value) {
            addCriterion("service_money <>", value, "serviceMoney");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyGreaterThan(BigDecimal value) {
            addCriterion("service_money >", value, "serviceMoney");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("service_money >=", value, "serviceMoney");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyLessThan(BigDecimal value) {
            addCriterion("service_money <", value, "serviceMoney");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("service_money <=", value, "serviceMoney");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyIn(List<BigDecimal> values) {
            addCriterion("service_money in", values, "serviceMoney");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyNotIn(List<BigDecimal> values) {
            addCriterion("service_money not in", values, "serviceMoney");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_money between", value1, value2, "serviceMoney");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_money not between", value1, value2, "serviceMoney");
            return (Criteria) this;
        }

        public Criteria andPersonalIncomeTaxMoneyIsNull() {
            addCriterion("personal_income_tax_money is null");
            return (Criteria) this;
        }

        public Criteria andPersonalIncomeTaxMoneyIsNotNull() {
            addCriterion("personal_income_tax_money is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalIncomeTaxMoneyEqualTo(BigDecimal value) {
            addCriterion("personal_income_tax_money =", value, "personalIncomeTaxMoney");
            return (Criteria) this;
        }

        public Criteria andPersonalIncomeTaxMoneyNotEqualTo(BigDecimal value) {
            addCriterion("personal_income_tax_money <>", value, "personalIncomeTaxMoney");
            return (Criteria) this;
        }

        public Criteria andPersonalIncomeTaxMoneyGreaterThan(BigDecimal value) {
            addCriterion("personal_income_tax_money >", value, "personalIncomeTaxMoney");
            return (Criteria) this;
        }

        public Criteria andPersonalIncomeTaxMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("personal_income_tax_money >=", value, "personalIncomeTaxMoney");
            return (Criteria) this;
        }

        public Criteria andPersonalIncomeTaxMoneyLessThan(BigDecimal value) {
            addCriterion("personal_income_tax_money <", value, "personalIncomeTaxMoney");
            return (Criteria) this;
        }

        public Criteria andPersonalIncomeTaxMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("personal_income_tax_money <=", value, "personalIncomeTaxMoney");
            return (Criteria) this;
        }

        public Criteria andPersonalIncomeTaxMoneyIn(List<BigDecimal> values) {
            addCriterion("personal_income_tax_money in", values, "personalIncomeTaxMoney");
            return (Criteria) this;
        }

        public Criteria andPersonalIncomeTaxMoneyNotIn(List<BigDecimal> values) {
            addCriterion("personal_income_tax_money not in", values, "personalIncomeTaxMoney");
            return (Criteria) this;
        }

        public Criteria andPersonalIncomeTaxMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("personal_income_tax_money between", value1, value2, "personalIncomeTaxMoney");
            return (Criteria) this;
        }

        public Criteria andPersonalIncomeTaxMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("personal_income_tax_money not between", value1, value2, "personalIncomeTaxMoney");
            return (Criteria) this;
        }

        public Criteria andArrivalMoneyIsNull() {
            addCriterion("arrival_money is null");
            return (Criteria) this;
        }

        public Criteria andArrivalMoneyIsNotNull() {
            addCriterion("arrival_money is not null");
            return (Criteria) this;
        }

        public Criteria andArrivalMoneyEqualTo(BigDecimal value) {
            addCriterion("arrival_money =", value, "arrivalMoney");
            return (Criteria) this;
        }

        public Criteria andArrivalMoneyNotEqualTo(BigDecimal value) {
            addCriterion("arrival_money <>", value, "arrivalMoney");
            return (Criteria) this;
        }

        public Criteria andArrivalMoneyGreaterThan(BigDecimal value) {
            addCriterion("arrival_money >", value, "arrivalMoney");
            return (Criteria) this;
        }

        public Criteria andArrivalMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("arrival_money >=", value, "arrivalMoney");
            return (Criteria) this;
        }

        public Criteria andArrivalMoneyLessThan(BigDecimal value) {
            addCriterion("arrival_money <", value, "arrivalMoney");
            return (Criteria) this;
        }

        public Criteria andArrivalMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("arrival_money <=", value, "arrivalMoney");
            return (Criteria) this;
        }

        public Criteria andArrivalMoneyIn(List<BigDecimal> values) {
            addCriterion("arrival_money in", values, "arrivalMoney");
            return (Criteria) this;
        }

        public Criteria andArrivalMoneyNotIn(List<BigDecimal> values) {
            addCriterion("arrival_money not in", values, "arrivalMoney");
            return (Criteria) this;
        }

        public Criteria andArrivalMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("arrival_money between", value1, value2, "arrivalMoney");
            return (Criteria) this;
        }

        public Criteria andArrivalMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("arrival_money not between", value1, value2, "arrivalMoney");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(BigDecimal value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(BigDecimal value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(BigDecimal value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(BigDecimal value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<BigDecimal> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<BigDecimal> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
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

        public Criteria andDoctorIdIsNull() {
            addCriterion("doctor_id is null");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIsNotNull() {
            addCriterion("doctor_id is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorIdEqualTo(String value) {
            addCriterion("doctor_id =", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotEqualTo(String value) {
            addCriterion("doctor_id <>", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdGreaterThan(String value) {
            addCriterion("doctor_id >", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_id >=", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLessThan(String value) {
            addCriterion("doctor_id <", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLessThanOrEqualTo(String value) {
            addCriterion("doctor_id <=", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLike(String value) {
            addCriterion("doctor_id like", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotLike(String value) {
            addCriterion("doctor_id not like", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIn(List<String> values) {
            addCriterion("doctor_id in", values, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotIn(List<String> values) {
            addCriterion("doctor_id not in", values, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdBetween(String value1, String value2) {
            addCriterion("doctor_id between", value1, value2, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotBetween(String value1, String value2) {
            addCriterion("doctor_id not between", value1, value2, "doctorId");
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

        public Criteria andModifyUserNameIsNull() {
            addCriterion("modify_user_name is null");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameIsNotNull() {
            addCriterion("modify_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameEqualTo(String value) {
            addCriterion("modify_user_name =", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameNotEqualTo(String value) {
            addCriterion("modify_user_name <>", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameGreaterThan(String value) {
            addCriterion("modify_user_name >", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("modify_user_name >=", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameLessThan(String value) {
            addCriterion("modify_user_name <", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameLessThanOrEqualTo(String value) {
            addCriterion("modify_user_name <=", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameLike(String value) {
            addCriterion("modify_user_name like", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameNotLike(String value) {
            addCriterion("modify_user_name not like", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameIn(List<String> values) {
            addCriterion("modify_user_name in", values, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameNotIn(List<String> values) {
            addCriterion("modify_user_name not in", values, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameBetween(String value1, String value2) {
            addCriterion("modify_user_name between", value1, value2, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameNotBetween(String value1, String value2) {
            addCriterion("modify_user_name not between", value1, value2, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNull() {
            addCriterion("serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberEqualTo(String value) {
            addCriterion("serial_number =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(String value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(String value) {
            addCriterion("serial_number >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(String value) {
            addCriterion("serial_number <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLike(String value) {
            addCriterion("serial_number like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotLike(String value) {
            addCriterion("serial_number not like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<String> values) {
            addCriterion("serial_number in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<String> values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(String value1, String value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(String value1, String value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andCheckBatchIsNull() {
            addCriterion("check_batch is null");
            return (Criteria) this;
        }

        public Criteria andCheckBatchIsNotNull() {
            addCriterion("check_batch is not null");
            return (Criteria) this;
        }

        public Criteria andCheckBatchEqualTo(String value) {
            addCriterion("check_batch =", value, "checkBatch");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNotEqualTo(String value) {
            addCriterion("check_batch <>", value, "checkBatch");
            return (Criteria) this;
        }

        public Criteria andCheckBatchGreaterThan(String value) {
            addCriterion("check_batch >", value, "checkBatch");
            return (Criteria) this;
        }

        public Criteria andCheckBatchGreaterThanOrEqualTo(String value) {
            addCriterion("check_batch >=", value, "checkBatch");
            return (Criteria) this;
        }

        public Criteria andCheckBatchLessThan(String value) {
            addCriterion("check_batch <", value, "checkBatch");
            return (Criteria) this;
        }

        public Criteria andCheckBatchLessThanOrEqualTo(String value) {
            addCriterion("check_batch <=", value, "checkBatch");
            return (Criteria) this;
        }

        public Criteria andCheckBatchLike(String value) {
            addCriterion("check_batch like", value, "checkBatch");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNotLike(String value) {
            addCriterion("check_batch not like", value, "checkBatch");
            return (Criteria) this;
        }

        public Criteria andCheckBatchIn(List<String> values) {
            addCriterion("check_batch in", values, "checkBatch");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNotIn(List<String> values) {
            addCriterion("check_batch not in", values, "checkBatch");
            return (Criteria) this;
        }

        public Criteria andCheckBatchBetween(String value1, String value2) {
            addCriterion("check_batch between", value1, value2, "checkBatch");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNotBetween(String value1, String value2) {
            addCriterion("check_batch not between", value1, value2, "checkBatch");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }
    }

    /**
     * t_withdrawals
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * t_withdrawals 2017-10-24
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