package org.polik.springmongo.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Polik on 5/31/2022
 */
@Data
@Builder
public class Address {
    private String country;
    private String city;
    private String postCode;
}
