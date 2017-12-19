package com.doctorwork.union.module.invitation.bean;

import java.util.ArrayList;
import java.util.List;

public class InvitationCriteria {
    /**
     * t_invitation
     */
    protected String orderByClause;

    /**
     * t_invitation
     */
    protected boolean distinct;

    /**
     * t_invitation
     */
    protected List<Criteria> oredCriteria;

    public InvitationCriteria() {
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
     * t_invitation 2017-10-24
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

        public Criteria andClinicIdIsNull() {
            addCriterion("clinic_id is null");
            return (Criteria) this;
        }

        public Criteria andClinicIdIsNotNull() {
            addCriterion("clinic_id is not null");
            return (Criteria) this;
        }

        public Criteria andClinicIdEqualTo(String value) {
            addCriterion("clinic_id =", value, "clinicId");
            return (Criteria) this;
        }

        public Criteria andClinicIdNotEqualTo(String value) {
            addCriterion("clinic_id <>", value, "clinicId");
            return (Criteria) this;
        }

        public Criteria andClinicIdGreaterThan(String value) {
            addCriterion("clinic_id >", value, "clinicId");
            return (Criteria) this;
        }

        public Criteria andClinicIdGreaterThanOrEqualTo(String value) {
            addCriterion("clinic_id >=", value, "clinicId");
            return (Criteria) this;
        }

        public Criteria andClinicIdLessThan(String value) {
            addCriterion("clinic_id <", value, "clinicId");
            return (Criteria) this;
        }

        public Criteria andClinicIdLessThanOrEqualTo(String value) {
            addCriterion("clinic_id <=", value, "clinicId");
            return (Criteria) this;
        }

        public Criteria andClinicIdLike(String value) {
            addCriterion("clinic_id like", value, "clinicId");
            return (Criteria) this;
        }

        public Criteria andClinicIdNotLike(String value) {
            addCriterion("clinic_id not like", value, "clinicId");
            return (Criteria) this;
        }

        public Criteria andClinicIdIn(List<String> values) {
            addCriterion("clinic_id in", values, "clinicId");
            return (Criteria) this;
        }

        public Criteria andClinicIdNotIn(List<String> values) {
            addCriterion("clinic_id not in", values, "clinicId");
            return (Criteria) this;
        }

        public Criteria andClinicIdBetween(String value1, String value2) {
            addCriterion("clinic_id between", value1, value2, "clinicId");
            return (Criteria) this;
        }

        public Criteria andClinicIdNotBetween(String value1, String value2) {
            addCriterion("clinic_id not between", value1, value2, "clinicId");
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

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(Long value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(Long value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(Long value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(Long value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(Long value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<Long> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<Long> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(Long value1, Long value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(Long value1, Long value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(Integer value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Integer value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Integer value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Integer value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Integer> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Integer> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andInvitationStatusIsNull() {
            addCriterion("invitation_status is null");
            return (Criteria) this;
        }

        public Criteria andInvitationStatusIsNotNull() {
            addCriterion("invitation_status is not null");
            return (Criteria) this;
        }

        public Criteria andInvitationStatusEqualTo(Integer value) {
            addCriterion("invitation_status =", value, "invitationStatus");
            return (Criteria) this;
        }

        public Criteria andInvitationStatusNotEqualTo(Integer value) {
            addCriterion("invitation_status <>", value, "invitationStatus");
            return (Criteria) this;
        }

        public Criteria andInvitationStatusGreaterThan(Integer value) {
            addCriterion("invitation_status >", value, "invitationStatus");
            return (Criteria) this;
        }

        public Criteria andInvitationStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("invitation_status >=", value, "invitationStatus");
            return (Criteria) this;
        }

        public Criteria andInvitationStatusLessThan(Integer value) {
            addCriterion("invitation_status <", value, "invitationStatus");
            return (Criteria) this;
        }

        public Criteria andInvitationStatusLessThanOrEqualTo(Integer value) {
            addCriterion("invitation_status <=", value, "invitationStatus");
            return (Criteria) this;
        }

        public Criteria andInvitationStatusIn(List<Integer> values) {
            addCriterion("invitation_status in", values, "invitationStatus");
            return (Criteria) this;
        }

        public Criteria andInvitationStatusNotIn(List<Integer> values) {
            addCriterion("invitation_status not in", values, "invitationStatus");
            return (Criteria) this;
        }

        public Criteria andInvitationStatusBetween(Integer value1, Integer value2) {
            addCriterion("invitation_status between", value1, value2, "invitationStatus");
            return (Criteria) this;
        }

        public Criteria andInvitationStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("invitation_status not between", value1, value2, "invitationStatus");
            return (Criteria) this;
        }

        public Criteria andPayMethodIsNull() {
            addCriterion("pay_method is null");
            return (Criteria) this;
        }

        public Criteria andPayMethodIsNotNull() {
            addCriterion("pay_method is not null");
            return (Criteria) this;
        }

        public Criteria andPayMethodEqualTo(Integer value) {
            addCriterion("pay_method =", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotEqualTo(Integer value) {
            addCriterion("pay_method <>", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThan(Integer value) {
            addCriterion("pay_method >", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_method >=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThan(Integer value) {
            addCriterion("pay_method <", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThanOrEqualTo(Integer value) {
            addCriterion("pay_method <=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodIn(List<Integer> values) {
            addCriterion("pay_method in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotIn(List<Integer> values) {
            addCriterion("pay_method not in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodBetween(Integer value1, Integer value2) {
            addCriterion("pay_method between", value1, value2, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_method not between", value1, value2, "payMethod");
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

        public Criteria andOnePriceIsNull() {
            addCriterion("one_price is null");
            return (Criteria) this;
        }

        public Criteria andOnePriceIsNotNull() {
            addCriterion("one_price is not null");
            return (Criteria) this;
        }

        public Criteria andOnePriceEqualTo(Long value) {
            addCriterion("one_price =", value, "onePrice");
            return (Criteria) this;
        }

        public Criteria andOnePriceNotEqualTo(Long value) {
            addCriterion("one_price <>", value, "onePrice");
            return (Criteria) this;
        }

        public Criteria andOnePriceGreaterThan(Long value) {
            addCriterion("one_price >", value, "onePrice");
            return (Criteria) this;
        }

        public Criteria andOnePriceGreaterThanOrEqualTo(Long value) {
            addCriterion("one_price >=", value, "onePrice");
            return (Criteria) this;
        }

        public Criteria andOnePriceLessThan(Long value) {
            addCriterion("one_price <", value, "onePrice");
            return (Criteria) this;
        }

        public Criteria andOnePriceLessThanOrEqualTo(Long value) {
            addCriterion("one_price <=", value, "onePrice");
            return (Criteria) this;
        }

        public Criteria andOnePriceIn(List<Long> values) {
            addCriterion("one_price in", values, "onePrice");
            return (Criteria) this;
        }

        public Criteria andOnePriceNotIn(List<Long> values) {
            addCriterion("one_price not in", values, "onePrice");
            return (Criteria) this;
        }

        public Criteria andOnePriceBetween(Long value1, Long value2) {
            addCriterion("one_price between", value1, value2, "onePrice");
            return (Criteria) this;
        }

        public Criteria andOnePriceNotBetween(Long value1, Long value2) {
            addCriterion("one_price not between", value1, value2, "onePrice");
            return (Criteria) this;
        }

        public Criteria andRemindSendStatusIsNull() {
            addCriterion("remind_send_status is null");
            return (Criteria) this;
        }

        public Criteria andRemindSendStatusIsNotNull() {
            addCriterion("remind_send_status is not null");
            return (Criteria) this;
        }

        public Criteria andRemindSendStatusEqualTo(Integer value) {
            addCriterion("remind_send_status =", value, "remindSendStatus");
            return (Criteria) this;
        }

        public Criteria andRemindSendStatusNotEqualTo(Integer value) {
            addCriterion("remind_send_status <>", value, "remindSendStatus");
            return (Criteria) this;
        }

        public Criteria andRemindSendStatusGreaterThan(Integer value) {
            addCriterion("remind_send_status >", value, "remindSendStatus");
            return (Criteria) this;
        }

        public Criteria andRemindSendStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("remind_send_status >=", value, "remindSendStatus");
            return (Criteria) this;
        }

        public Criteria andRemindSendStatusLessThan(Integer value) {
            addCriterion("remind_send_status <", value, "remindSendStatus");
            return (Criteria) this;
        }

        public Criteria andRemindSendStatusLessThanOrEqualTo(Integer value) {
            addCriterion("remind_send_status <=", value, "remindSendStatus");
            return (Criteria) this;
        }

        public Criteria andRemindSendStatusIn(List<Integer> values) {
            addCriterion("remind_send_status in", values, "remindSendStatus");
            return (Criteria) this;
        }

        public Criteria andRemindSendStatusNotIn(List<Integer> values) {
            addCriterion("remind_send_status not in", values, "remindSendStatus");
            return (Criteria) this;
        }

        public Criteria andRemindSendStatusBetween(Integer value1, Integer value2) {
            addCriterion("remind_send_status between", value1, value2, "remindSendStatus");
            return (Criteria) this;
        }

        public Criteria andRemindSendStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("remind_send_status not between", value1, value2, "remindSendStatus");
            return (Criteria) this;
        }

        public Criteria andRemindSendCountIsNull() {
            addCriterion("remind_send_count is null");
            return (Criteria) this;
        }

        public Criteria andRemindSendCountIsNotNull() {
            addCriterion("remind_send_count is not null");
            return (Criteria) this;
        }

        public Criteria andRemindSendCountEqualTo(Integer value) {
            addCriterion("remind_send_count =", value, "remindSendCount");
            return (Criteria) this;
        }

        public Criteria andRemindSendCountNotEqualTo(Integer value) {
            addCriterion("remind_send_count <>", value, "remindSendCount");
            return (Criteria) this;
        }

        public Criteria andRemindSendCountGreaterThan(Integer value) {
            addCriterion("remind_send_count >", value, "remindSendCount");
            return (Criteria) this;
        }

        public Criteria andRemindSendCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("remind_send_count >=", value, "remindSendCount");
            return (Criteria) this;
        }

        public Criteria andRemindSendCountLessThan(Integer value) {
            addCriterion("remind_send_count <", value, "remindSendCount");
            return (Criteria) this;
        }

        public Criteria andRemindSendCountLessThanOrEqualTo(Integer value) {
            addCriterion("remind_send_count <=", value, "remindSendCount");
            return (Criteria) this;
        }

        public Criteria andRemindSendCountIn(List<Integer> values) {
            addCriterion("remind_send_count in", values, "remindSendCount");
            return (Criteria) this;
        }

        public Criteria andRemindSendCountNotIn(List<Integer> values) {
            addCriterion("remind_send_count not in", values, "remindSendCount");
            return (Criteria) this;
        }

        public Criteria andRemindSendCountBetween(Integer value1, Integer value2) {
            addCriterion("remind_send_count between", value1, value2, "remindSendCount");
            return (Criteria) this;
        }

        public Criteria andRemindSendCountNotBetween(Integer value1, Integer value2) {
            addCriterion("remind_send_count not between", value1, value2, "remindSendCount");
            return (Criteria) this;
        }

        public Criteria andRemindLastTimeIsNull() {
            addCriterion("remind_last_time is null");
            return (Criteria) this;
        }

        public Criteria andRemindLastTimeIsNotNull() {
            addCriterion("remind_last_time is not null");
            return (Criteria) this;
        }

        public Criteria andRemindLastTimeEqualTo(Long value) {
            addCriterion("remind_last_time =", value, "remindLastTime");
            return (Criteria) this;
        }

        public Criteria andRemindLastTimeNotEqualTo(Long value) {
            addCriterion("remind_last_time <>", value, "remindLastTime");
            return (Criteria) this;
        }

        public Criteria andRemindLastTimeGreaterThan(Long value) {
            addCriterion("remind_last_time >", value, "remindLastTime");
            return (Criteria) this;
        }

        public Criteria andRemindLastTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("remind_last_time >=", value, "remindLastTime");
            return (Criteria) this;
        }

        public Criteria andRemindLastTimeLessThan(Long value) {
            addCriterion("remind_last_time <", value, "remindLastTime");
            return (Criteria) this;
        }

        public Criteria andRemindLastTimeLessThanOrEqualTo(Long value) {
            addCriterion("remind_last_time <=", value, "remindLastTime");
            return (Criteria) this;
        }

        public Criteria andRemindLastTimeIn(List<Long> values) {
            addCriterion("remind_last_time in", values, "remindLastTime");
            return (Criteria) this;
        }

        public Criteria andRemindLastTimeNotIn(List<Long> values) {
            addCriterion("remind_last_time not in", values, "remindLastTime");
            return (Criteria) this;
        }

        public Criteria andRemindLastTimeBetween(Long value1, Long value2) {
            addCriterion("remind_last_time between", value1, value2, "remindLastTime");
            return (Criteria) this;
        }

        public Criteria andRemindLastTimeNotBetween(Long value1, Long value2) {
            addCriterion("remind_last_time not between", value1, value2, "remindLastTime");
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

        public Criteria andPassortIdIsNull() {
            addCriterion("passort_id is null");
            return (Criteria) this;
        }

        public Criteria andPassortIdIsNotNull() {
            addCriterion("passort_id is not null");
            return (Criteria) this;
        }

        public Criteria andPassortIdEqualTo(String value) {
            addCriterion("passort_id =", value, "passortId");
            return (Criteria) this;
        }

        public Criteria andPassortIdNotEqualTo(String value) {
            addCriterion("passort_id <>", value, "passortId");
            return (Criteria) this;
        }

        public Criteria andPassortIdGreaterThan(String value) {
            addCriterion("passort_id >", value, "passortId");
            return (Criteria) this;
        }

        public Criteria andPassortIdGreaterThanOrEqualTo(String value) {
            addCriterion("passort_id >=", value, "passortId");
            return (Criteria) this;
        }

        public Criteria andPassortIdLessThan(String value) {
            addCriterion("passort_id <", value, "passortId");
            return (Criteria) this;
        }

        public Criteria andPassortIdLessThanOrEqualTo(String value) {
            addCriterion("passort_id <=", value, "passortId");
            return (Criteria) this;
        }

        public Criteria andPassortIdLike(String value) {
            addCriterion("passort_id like", value, "passortId");
            return (Criteria) this;
        }

        public Criteria andPassortIdNotLike(String value) {
            addCriterion("passort_id not like", value, "passortId");
            return (Criteria) this;
        }

        public Criteria andPassortIdIn(List<String> values) {
            addCriterion("passort_id in", values, "passortId");
            return (Criteria) this;
        }

        public Criteria andPassortIdNotIn(List<String> values) {
            addCriterion("passort_id not in", values, "passortId");
            return (Criteria) this;
        }

        public Criteria andPassortIdBetween(String value1, String value2) {
            addCriterion("passort_id between", value1, value2, "passortId");
            return (Criteria) this;
        }

        public Criteria andPassortIdNotBetween(String value1, String value2) {
            addCriterion("passort_id not between", value1, value2, "passortId");
            return (Criteria) this;
        }
    }

    /**
     * t_invitation
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * t_invitation 2017-10-24
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