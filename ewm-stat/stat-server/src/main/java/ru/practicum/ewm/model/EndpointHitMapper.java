package ru.practicum.ewm.model;

import dto.EndpointHitDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EndpointHitMapper {
    public EndpointHit toEndpointHit(EndpointHitDto hit) {
        return new EndpointHit(
                hit.getApp(),
                hit.getUri(),
                hit.getIp(),
                hit.getTimestamp()
        );
    }

    public EndpointHitDto toEndpointHitDto(EndpointHit hit) {
        return new EndpointHitDto(
                hit.getApp(),
                hit.getUri(),
                hit.getIp(),
                hit.getTimestamp()
        );
    }
}
