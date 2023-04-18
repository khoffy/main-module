package com.sagroup.avatarservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Avatar {
    @Id
    private long id;

    private String head;

    private String hair;


    private String eye;


    private String eyeBrow;


    private String hairColor;


    private String nose;


    private String mouth;


    private String ear;


    private String body;


    private String hat;


    private String topColor;


    private String hatColor;


}
