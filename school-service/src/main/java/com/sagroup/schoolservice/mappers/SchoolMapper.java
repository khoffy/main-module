package com.sagroup.schoolservice.mappers;

import com.sagroup.schoolservice.dtos.SchoolDto;
import com.sagroup.schoolservice.entities.School;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchoolMapper {
    School schoolDtoToSchool(SchoolDto schoolDto);

    SchoolDto schoolToSchoolDto(School school);
}
