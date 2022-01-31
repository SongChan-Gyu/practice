package com.example.testing.jpa.Domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Account {

    @Id
    private String id;

    private String username;

    private String email;

    private GeoJsonPoint location;

}
