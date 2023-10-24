package ru.practicum.ewm.service;

import dto.EndpointHitDto;
import dto.ViewStats;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.ewm.model.EndpointHit;
import ru.practicum.ewm.model.EndpointHitMapper;
import ru.practicum.ewm.repository.StatsRepository;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StatsService {
    private final StatsRepository statsRepository;

    public EndpointHitDto saveHit(EndpointHitDto hit) {
        EndpointHit endpointHit = statsRepository.save(EndpointHitMapper.toEndpointHit(hit));
        return EndpointHitMapper.toEndpointHitDto(endpointHit);
    }

    @Transactional(readOnly = true)
    public List<ViewStats> getStats(LocalDateTime start, LocalDateTime end, List<String> uris, Boolean unique) {
        if (start.isAfter(end)) {
            throw new DateTimeException("Wrong timestamp.");
        }
        if (unique) {
            if (uris != null) {
                return statsRepository.findHitsWithUniqueIpWithUris(uris, start, end);
            }
            return statsRepository.findHitsWithUniqueIpWithoutUris(start, end);
        } else {
            if (uris != null) {
                return statsRepository.findAllHitsWithUris(uris, start, end);
            }
            return statsRepository.findAllHitsWithoutUris(start, end);
        }
    }
}
