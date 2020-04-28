package br.com.tokenlab.treinamentotesteunitario.dto;

import lombok.Data;

@Data
public class LocationDTO {
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private String countryName;
    private String countryCode;
    private String countryRegionName;
}