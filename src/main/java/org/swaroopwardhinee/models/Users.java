package org.swaroopwardhinee.models;

import java.util.Date;

public class Users {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.id
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.email
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.user_id
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.first_name
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    private String firstName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.middle_name
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    private String middleName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.last_name
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    private String lastName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.password
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.password_salt
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    private String passwordSalt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.is_active
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    private Boolean isActive;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.created_on
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    private Date createdOn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.created_by
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    private String createdBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.modified_on
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    private Date modifiedOn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.modified_by
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    private String modifiedBy;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.id
     *
     * @return the value of users.id
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.id
     *
     * @param id the value for users.id
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.email
     *
     * @return the value of users.email
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.email
     *
     * @param email the value for users.email
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.user_id
     *
     * @return the value of users.user_id
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.user_id
     *
     * @param userId the value for users.user_id
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.first_name
     *
     * @return the value of users.first_name
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.first_name
     *
     * @param firstName the value for users.first_name
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.middle_name
     *
     * @return the value of users.middle_name
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.middle_name
     *
     * @param middleName the value for users.middle_name
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName == null ? null : middleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.last_name
     *
     * @return the value of users.last_name
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.last_name
     *
     * @param lastName the value for users.last_name
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.password
     *
     * @return the value of users.password
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.password
     *
     * @param password the value for users.password
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.password_salt
     *
     * @return the value of users.password_salt
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public String getPasswordSalt() {
        return passwordSalt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.password_salt
     *
     * @param passwordSalt the value for users.password_salt
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt == null ? null : passwordSalt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.is_active
     *
     * @return the value of users.is_active
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.is_active
     *
     * @param isActive the value for users.is_active
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.created_on
     *
     * @return the value of users.created_on
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.created_on
     *
     * @param createdOn the value for users.created_on
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.created_by
     *
     * @return the value of users.created_by
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.created_by
     *
     * @param createdBy the value for users.created_by
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.modified_on
     *
     * @return the value of users.modified_on
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public Date getModifiedOn() {
        return modifiedOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.modified_on
     *
     * @param modifiedOn the value for users.modified_on
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
	public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.modified_by
     *
     * @return the value of users.modified_by
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.modified_by
     *
     * @param modifiedBy the value for users.modified_by
     *
     * @mbggenerated Mon Aug 17 12:21:09 IST 2020
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy == null ? null : modifiedBy.trim();
    }
}