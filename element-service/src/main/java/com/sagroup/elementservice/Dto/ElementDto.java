package com.sagroup.elementservice.Dto;

import com.sagroup.elementservice.Domain.ElementType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ABDELBIF
 * @version 1.0
 * @created 6-Feb-2023 08:00:00 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementDto {
    private String id;
    private double price;
    private ElementType elementType;
}
