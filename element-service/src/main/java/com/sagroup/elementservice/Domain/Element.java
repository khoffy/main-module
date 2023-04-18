package com.sagroup.elementservice.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author ABDELBIF
 * @version 1.0
 * @created 6-Feb-2023 08:00:00 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Element {

    @Id
    private String id;
    private double price;
    private ElementType elementType;

}
