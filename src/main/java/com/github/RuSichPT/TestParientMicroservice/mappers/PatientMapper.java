package com.github.RuSichPT.TestParientMicroservice.mappers;

import com.github.RuSichPT.TestParientMicroservice.entities.Patient;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PatientMapper {
    @Insert("INSERT INTO \"patient\" " +
            "(ID, FIRST_NAME, MID_NAME, LAST_NAME, GENDER_ID, BIRTHDAY, PHONE, EMAIL, ADDRESS) " +
            "VALUES " +
            "( NEXTVAL('patient_seq'), #{firstName}, #{midName}, #{lastName}, #{genderId}, #{birthday}, #{phone}, #{email}, #{address} );")
    void insert(Patient patient);

    @Select("SELECT * FROM \"patient\" WHERE ID = #{id};")
    Patient selectById(int id);

    @Select("SELECT * FROM \"patient\" WHERE FIRST_NAME = #{firstName} AND MID_NAME = #{midName} AND LAST_NAME = #{lastName};")
    Patient selectByName(String firstName, String midName, String lastName);
    @Update("UPDATE \"patient\" " +
            "SET " +
            "FIRST_NAME = #{firstName}, " +
            "MID_NAME = #{midName}, " +
            "LAST_NAME = #{lastName}, " +
            "GENDER_ID = #{genderId}," +
            "BIRTHDAY = #{birthday}, " +
            "PHONE = #{phone}, " +
            "EMAIL = #{email}, " +
            "ADDRESS = #{address} " +
            "WHERE ID = #{id}")
    void update(Patient patient);

    @Delete("DELETE FROM \"patient\" WHERE ID = #{id};")
    void delete(int id);
}
