package org.swaroopwardhinee.models;

import java.util.Date;

public class ForgotPassword {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column forgot_password.id
     *
     * @mbggenerated Tue Aug 18 12:30:27 IST 2020
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column forgot_password.user_id
     *
     * @mbggenerated Tue Aug 18 12:30:27 IST 2020
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column forgot_password.token
     *
     * @mbggenerated Tue Aug 18 12:30:27 IST 2020
     */
    private String token;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column forgot_password.created_on
     *
     * @mbggenerated Tue Aug 18 12:30:27 IST 2020
     */
    private Date createdOn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column forgot_password.created_by
     *
     * @mbggenerated Tue Aug 18 12:30:27 IST 2020
     */
    private String createdBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column forgot_password.modified_on
     *
     * @mbggenerated Tue Aug 18 12:30:27 IST 2020
     */
    private Date modifiedOn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column forgot_password.modified_by
     *
     * @mbggenerated Tue Aug 18 12:30:27 IST 2020
     */
    private String modifiedBy;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column forgot_password.id
     *
     * @return the value of forgot_password.id
     *
     * @mbggenerated Tue Aug 18 12:30:27 IST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column forgot_password.id
     *
     * @param id the value for forgot_password.id
     *
     * @mbggenerated Tue Aug 18 12:30:27 IST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column forgot_password.user_id
     *
     * @return the value of forgot_password.user_id
     *
     * @mbggenerated Tue Aug 18 12:30:27 IST 2020
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column forgot_password.user_id
     *
     * @param userId the value for forgot_password.user_id
     *
     * @mbggenerated Tue Aug 18 12:30:27 IST 2020
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column forgot_password.token
     *
     * @return the value of forgot_password.token
     *
     * @mbggenerated Tue Aug 18 12:30:27 IST 2020
     */
    public String getToken() {
        return token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column forgot_password.token
     *
     * @param token the value for forgot_password.token
     *
     * @mbggenerated Tue Aug 18 12:30:27 IST 2020
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column forgot_password.created_on
     *
     * @return the value of forgot_password.created_on
     *
     * @mbggenerated Tue Aug 18 12:30:27 IST 2020
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column forgot_password.created_on
     *
     * @param createdOn the value for forgot_password.created_on
     *
     * @mbggenerated Tue Aug 18 12:30:27 IST 2020
     */
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column forgot_password.created_by
     *
     * @return the value of forgot_password.created_by
     *
     * @mbggenerated Tue Aug 18 12:30:27 IST 2020
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column forgot_password.created_by
     *
     * @param createdBy the value for forgot_password.created_by
     *
     * @mbggenerated Tue Aug 18 12:30:27 IST 2020
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column forgot_password.modified_on
     *
     * @return the value of forgot_password.modified_on
     *
     * @mbggenerated Tue Aug 18 12:30:27 IST 2020
     */
    public Date getModifiedOn() {
        return modifiedOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column forgot_password.modified_on
     *
     * @param modifiedOn the value for forgot_password.modified_on
     *
     * @mbggenerated Tue Aug 18 12:30:27 IST 2020
     */
    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column forgot_password.modified_by
     *
     * @return the value of forgot_password.modified_by
     *
     * @mbggenerated Tue Aug 18 12:30:27 IST 2020
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column forgot_password.modified_by
     *
     * @param modifiedBy the value for forgot_password.modified_by
     *
     * @mbggenerated Tue Aug 18 12:30:27 IST 2020
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy == null ? null : modifiedBy.trim();
    }
}