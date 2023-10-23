package ru.practicum.ewm.model.compilations.dto;

import lombok.*;
import ru.practicum.ewm.model.events.dto.EventShortDto;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Подборка событий
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompilationDto {

    @NotNull
    private Integer id;

    private Boolean pinned;

    private String title;

    private List<EventShortDto> events;
}
