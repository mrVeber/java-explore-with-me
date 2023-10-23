package ru.practicum.ewm.model.events.dto;

import lombok.*;
import ru.practicum.ewm.model.requests.RequestStatus;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventRequestStatusUpdateRequest {
    private List<Long> requestIds;
    private RequestStatus status;
}
