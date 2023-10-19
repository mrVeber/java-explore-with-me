package ru.practicum.ewm.controller;

import dto.EndpointHitDTO;
import dto.ViewStatsDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.service.StatService;

import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
public class StatController {
    private final StatService service;

    @PostMapping("/hit")
    public EndpointHitDTO save(@RequestBody EndpointHitDTO endpointHitDTO) {
        return service.save(endpointHitDTO);
    }

    @GetMapping("/stats")
    public List<ViewStatsDTO> getStat(
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end,
            @RequestParam(required = false) List<String> uris,
            @RequestParam(defaultValue = "false") boolean unique
    ) {
        return service.getStat(start, end, uris, unique);
    }
}
