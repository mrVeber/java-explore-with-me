package ru.practicum.ewm.controller.events;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.events.dto.*;
import ru.practicum.ewm.model.requests.dto.ParticipationRequestDto;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Validated
@RestController
@RequestMapping("/users/{userId}/events")
public interface EventsPrivateController {

    @GetMapping
    List<EventShortDto> getEvents(@Positive @PathVariable Long userId,
                                  @PositiveOrZero @RequestParam(defaultValue = "0") Integer from,
                                  @Positive @RequestParam(defaultValue = "10") Integer size
    );

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    EventFullDto setEvent(@Valid @RequestBody NewEventDto newEventDto,
                          @Positive @PathVariable Long userId
    );

    @GetMapping("{eventId}")
    EventFullDto getEvent(@Positive @PathVariable Long userId,
                          @Positive @PathVariable Long eventId);

    @PatchMapping("{eventId}")
    EventFullDto updateEvent(@Positive @PathVariable Long userId,
                             @Positive @PathVariable Long eventId,
                             @Valid @RequestBody UpdateEventUserRequest updateEventUserRequest);

    @GetMapping("{eventId}/requests")
    List<ParticipationRequestDto> getEventRequests(@PathVariable Long userId,
                                                   @PathVariable Long eventId);

    @PatchMapping("{eventId}/requests")
    EventRequestStatusUpdateResult updateEventStatusRequest(@RequestBody EventRequestStatusUpdateRequest eventRequestStatusUpdateRequest,
                                                            @PathVariable Long userId,
                                                            @PathVariable Long eventId);
}