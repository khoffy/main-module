package com.sagroup.elementservice.service;


import com.sagroup.elementservice.Domain.Element;
import com.sagroup.elementservice.Dto.ElementDto;

/**
 * @author ABDELBIF
 * @version 1.0
 * @created 6-Feb-2023 09:00:00 PM
 */

public interface ElementService {
    public ElementDto addElement(ElementDto elementDto);

    public void removeElement(String id);

    public ElementDto updateElement(String id, ElementDto elementDto);

    public ElementDto viewElement(String id);

}
