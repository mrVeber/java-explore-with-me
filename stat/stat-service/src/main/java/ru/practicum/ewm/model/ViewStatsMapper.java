package ru.practicum.ewm.model;

import dto.ViewStatsDTO;

public class ViewStatsMapper {
    public static ViewStatsDTO toViewStatsDTO(ViewStats viewStats) {
        return ViewStatsDTO.builder()
                .app(viewStats.getApp())
                .uri(viewStats.getUri())
                .hits(viewStats.getHits())
                .build();
    }

    public static ViewStats toViewStats(ViewStatsDTO viewStatsDTO) {
        return ViewStats.builder()
                .app(viewStatsDTO.getApp())
                .uri(viewStatsDTO.getUri())
                .hits(viewStatsDTO.getHits())
                .build();
    }
}
