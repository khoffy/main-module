package com.sagroup.elementservice.Mapper;

import com.sagroup.elementservice.Domain.Element;
import com.sagroup.elementservice.Dto.ElementDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author ABDELBIF
 * @version 1.0
 * @created 6-Feb-2023 08:00:00 PM
 */

@Mapper(componentModel = "Spring")
public interface ElementMapper {
    public  Element elementFromElementDto(ElementDto elementDto);
    public ElementDto elementDtoFromElement(Element element);
}
