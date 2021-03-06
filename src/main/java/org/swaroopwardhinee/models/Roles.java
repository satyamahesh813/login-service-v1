package org.swaroopwardhinee.models;

import java.util.Date;

public class Roles {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roles.id
     *
     * @mbggenerated Mon Aug 17 12:19:14 IST 2020
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roles.name
     *
     * @mbggenerated Mon Aug 17 12:19:14 IST 2020
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roles.description
     *
     * @mbggenerated Mon Aug 17 12:19:14 IST 2020
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roles.created_on
     *
     * @mbggenerated Mon Aug 17 12:19:14 IST 2020
     */
    private Date createdOn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roles.created_by
     *
     * @mbggenerated Mon Aug 17 12:19:14 IST 2020
     */
    private String createdBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roles.modified_on
     *
     * @mbggenerated Mon Aug 17 12:19:14 IST 2020
     */
    private Date modifiedOn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roles.modified_by
     *
     * @mbggenerated Mon Aug 17 12:19:14 IST 2020
     */
    private String modifiedBy;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roles.id
     *
     * @return the value of roles.id
     *
     * @mbggenerated Mon Aug 17 12:19:14 IST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roles.id
     *
     * @param id the value for roles.id
     *
     * @mbggenerated Mon Aug 17 12:19:14 IST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roles.name
     *
     * @return the value of roles.name
     *
     * @mbggenerated Mon Aug 17 12:19:14 IST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roles.name
     *
     * @param name the value for roles.name
     *
     * @mbggenerated Mon Aug 17 12:19:14 IST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roles.description
     *
     * @return the value of roles.description
     *
     * @mbggenerated Mon Aug 17 12:19:14 IST 2020
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roles.description
     *
     * @param description the value for roles.description
     *
     * @mbggenerated Mon Aug 17 12:19:14 IST 2020
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roles.created_on
     *
     * @return the value of roles.created_on
     *
     * @mbggenerated Mon Aug 17 12:19:14 IST 2020
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roles.created_on
     *
     * @param createdOn the value for roles.created_on
     *
     * @mbggenerated Mon Aug 17 12:19:14 IST 2020
     */
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roles.created_by
     *
     * @return the value of roles.created_by
     *
     * @mbggenerated Mon Aug 17 12:19:14 IST 2020
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roles.created_by
     *
     * @param createdBy the value for roles.created_by
     *
     * @mbggenerated Mon Aug 17 12:19:14 IST 2020
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roles.modified_on
     *
     * @return the value of roles.modified_on
     *
     * @mbggenerated Mon Aug 17 12:19:14 IST 2020
     */
    public Date getModifiedOn() {
        return modifiedOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roles.modified_on
     *
     * @param modifiedOn the value for roles.modified_on
     *
     * @mbggenerated Mon Aug 17 12:19:14 IST 2020
     */
    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roles.modified_by
     *
     * @return the value of roles.modified_by
     *
     * @mbggenerated Mon Aug 17 12:19:14 IST 2020
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roles.modified_by
     *
     * @param modifiedBy the value for roles.modified_by
     *
     * @mbggenerated Mon Aug 17 12:19:14 IST 2020
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy == null ? null : modifiedBy.trim();
    }
}