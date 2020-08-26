package org.swaroopwardhinee.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.swaroopwardhinee.models.UserRoles;
import org.swaroopwardhinee.models.UserRolesExample;

public interface UserRolesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_roles
     *
     * @mbggenerated Mon Aug 17 12:19:40 IST 2020
     */
    int countByExample(UserRolesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_roles
     *
     * @mbggenerated Mon Aug 17 12:19:40 IST 2020
     */
    int deleteByExample(UserRolesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_roles
     *
     * @mbggenerated Mon Aug 17 12:19:40 IST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_roles
     *
     * @mbggenerated Mon Aug 17 12:19:40 IST 2020
     */
    int insert(UserRoles record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_roles
     *
     * @mbggenerated Mon Aug 17 12:19:40 IST 2020
     */
    int insertSelective(UserRoles record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_roles
     *
     * @mbggenerated Mon Aug 17 12:19:40 IST 2020
     */
    List<UserRoles> selectByExample(UserRolesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_roles
     *
     * @mbggenerated Mon Aug 17 12:19:40 IST 2020
     */
    UserRoles selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_roles
     *
     * @mbggenerated Mon Aug 17 12:19:40 IST 2020
     */
    int updateByExampleSelective(@Param("record") UserRoles record, @Param("example") UserRolesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_roles
     *
     * @mbggenerated Mon Aug 17 12:19:40 IST 2020
     */
    int updateByExample(@Param("record") UserRoles record, @Param("example") UserRolesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_roles
     *
     * @mbggenerated Mon Aug 17 12:19:40 IST 2020
     */
    int updateByPrimaryKeySelective(UserRoles record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_roles
     *
     * @mbggenerated Mon Aug 17 12:19:40 IST 2020
     */
    int updateByPrimaryKey(UserRoles record);
}