package com.jusun.first.domins;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class RoadDTO {
    public String
            streetName,
            streetIntroduction,
            gunLength,
            demandTime,
            startingPointName,
            startingPointAddress,
            startingPointNumberAddress,
            endPointName,
            endPointNameAddress,
            endPointnumberAddress,
            phoneNumber,
            managementAgencyName,
            baseDate,
            latitude,
            longitude,
            providerName;
}
