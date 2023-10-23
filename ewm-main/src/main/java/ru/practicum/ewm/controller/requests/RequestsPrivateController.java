package ru.practicum.ewm.controller.requests;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.requests.dto.ParticipationRequestDto;

import javax.validation.constraints.Positive;
import java.util.List;

@Validated
@RestController
@RequestMapping("users/{userId}/requests")
public interface RequestsPrivateController {

    @GetMapping()
    List<ParticipationRequestDto> getRequest(@PathVariable Long userId);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ParticipationRequestDto setRequest(
            @Positive @RequestParam Long eventId,
            @Positive @PathVariable Long userId);

    @PatchMapping("/{requestId}/cancel")
    ParticipationRequestDto updateRequest(@PathVariable Long userId, @PathVariable Long requestId);
}
