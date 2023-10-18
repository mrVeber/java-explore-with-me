package ru.practicum.ewm.service;

import dto.EndpointHitDTO;
import dto.ViewStatsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.EndpointHitMapper;
import ru.practicum.ewm.repository.StatRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatServiceImpl implements StatService {
    private final StatRepository repository;

    @Override
    public EndpointHitDTO save(EndpointHitDTO endpointHitDTO) {
        repository.save(EndpointHitMapper.toEndpointHit(endpointHitDTO));
        return endpointHitDTO;
    }

    @Override
    public List<ViewStatsDTO> getStat(LocalDateTime start,
                                      LocalDateTime end,
                                      List<String> uris,
                                      boolean unique) {
        return repository.getStats(start, end, uris, unique);
    }
}
