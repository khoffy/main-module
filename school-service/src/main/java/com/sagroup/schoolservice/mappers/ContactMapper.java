package com.sagroup.schoolservice.mappers;

import com.sagroup.schoolservice.dtos.ContactDto;
import com.sagroup.schoolservice.entities.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    Contact contactDtoToContact(ContactDto contactDto);

    ContactDto contactToContactDto(Contact contact);
}
