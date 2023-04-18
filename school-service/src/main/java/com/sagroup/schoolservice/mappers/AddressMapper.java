package com.sagroup.schoolservice.mappers;

import com.sagroup.schoolservice.dtos.AddressDto;
import com.sagroup.schoolservice.entities.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address addressDtoToAddress(AddressDto addressDto);
    AddressDto addressToAddressDto(Address address);
}
