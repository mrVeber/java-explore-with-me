package ru.practicum.ewm.model;

import dto.ViewStatsDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ViewStatsMapper {
    public ViewStatsDTO toViewStatsDTO(ViewStats viewStats) {
        return ViewStatsDTO.builder()
                .app(viewStats.getApp())
                .uri(viewStats.getUri())
                .hits(viewStats.getHits())
                .build();
    }

    public ViewStats toViewStats(ViewStatsDTO viewStatsDTO) {
        return ViewStats.builder()
                .app(viewStatsDTO.getApp())
                .uri(viewStatsDTO.getUri())
                .hits(viewStatsDTO.getHits())
                .build();
    }
}
