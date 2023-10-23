package ru.practicum.ewm.controller.events;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.events.dto.EventFullDto;
import ru.practicum.ewm.model.events.dto.EventShortDto;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Validated
@RestController
@RequestMapping("/events")
public interface EventsPublicController {

    @GetMapping()
    List<EventShortDto> getEvents(
            @RequestParam(required = false) String text,
            @RequestParam(required = false) List<Integer> categories,
            @RequestParam(required = false) Boolean paid,
            @RequestParam(required = false) String rangeStart,
            @RequestParam(required = false) String rangeEnd,
            @RequestParam(required = false) String sort,
            @RequestParam(defaultValue = "false") Boolean onlyAvailable,
            @PositiveOrZero @RequestParam(defaultValue = "0") Integer from,
            @Positive @RequestParam(defaultValue = "10") Integer size,
            HttpServletRequest request
    );

    @GetMapping("{eventId}")
    EventFullDto getEvent(@PathVariable Long eventId,
                          HttpServletRequest request);
}
