package ru.practicum.ewm.controller.events;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.events.State;
import ru.practicum.ewm.model.events.dto.EventFullDto;
import ru.practicum.ewm.model.events.dto.UpdateEventAdminRequest;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Validated
@RestController
@RequestMapping("/admin/events")
public interface EventsAdminController {

    @GetMapping()
    List<EventFullDto> getEvents(
            @RequestParam(required = false) List<Integer> users,
            @RequestParam(required = false) List<Integer> categories,
            @RequestParam(required = false) List<State> states,
            @RequestParam(required = false) String rangeStart,
            @RequestParam(required = false) String rangeEnd,
            @PositiveOrZero @RequestParam(defaultValue = "0") Integer from,
            @Positive @RequestParam(defaultValue = "10") Integer size
    );

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("{eventId}")
    EventFullDto updateEvent(
            @Valid @RequestBody UpdateEventAdminRequest updateEventAdminRequest,
            @PathVariable Long eventId
    );
}
