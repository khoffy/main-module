package com.sagroup.schoolservice.services;

import com.sagroup.schoolservice.dtos.SchoolDto;
import com.sagroup.schoolservice.entities.Address;
import com.sagroup.schoolservice.entities.Contact;
import com.sagroup.schoolservice.entities.School;
import com.sagroup.schoolservice.mappers.AddressMapper;
import com.sagroup.schoolservice.mappers.ContactMapper;
import com.sagroup.schoolservice.mappers.SchoolMapper;
import com.sagroup.schoolservice.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SchoolService {

    private SchoolMapper schoolMapper;

    private ContactMapper contactMapper;
    private AddressMapper addressMapper;
    private SchoolRepository schoolRepository;

    public SchoolDto add(SchoolDto schoolDto) {
        School school = schoolMapper.schoolDtoToSchool(schoolDto);
        School response = schoolRepository.save(school);
        return schoolMapper.schoolToSchoolDto(response);
    }

    public SchoolDto update(SchoolDto schoolDto) {
        School school = schoolRepository.findById(schoolDto.getId()).get();
        school.setName(school.getName());
        school.setAddress(addressMapper.addressDtoToAddress(schoolDto.getAddress()));
        school.setContact(contactMapper.contactDtoToContact(schoolDto.getContact()));
        return schoolMapper.schoolToSchoolDto(schoolRepository.save(school));
    }

    public void delete(String schoolId) {
        schoolRepository.deleteById(schoolId);
    }

    public List<SchoolDto> getAllSchool() {
        List<SchoolDto> lists = new ArrayList<>();
        schoolRepository.findAll().forEach(school -> {
            lists.add(schoolMapper.schoolToSchoolDto(school));
        });
        return lists;
    }

    public SchoolDto getById(String schoolId) {
        School school = schoolRepository.findById(schoolId).get();
        return schoolMapper.schoolToSchoolDto(school);
    }

    @Autowired
    public void setSchoolRepository(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Autowired
    public void setSchoolMapper(SchoolMapper schoolMapper) {
        this.schoolMapper = schoolMapper;
    }

    @Autowired
    public void setAddressMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }


    @Autowired
    public void setContactMapper(ContactMapper contactMapper) {
        this.contactMapper = contactMapper;
    }
}
