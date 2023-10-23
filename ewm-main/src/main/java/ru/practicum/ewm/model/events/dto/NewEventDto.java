package ru.practicum.ewm.model.events.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import ru.practicum.ewm.model.location.LocationDto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class NewEventDto {
    @NotBlank
    @Size(max = 2000, min = 20)
    private String annotation;
    @NotNull
    private Integer category;
    @NotBlank
    @Size(max = 7000, min = 20)
    private String description;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eventDate;
    @NotNull
    private LocationDto location;
    @NotNull
    @Size(min = 3, max = 120)
    private String title;
    private boolean paid;
    @PositiveOrZero
    private int participantLimit = 0;
    private boolean requestModeration = true;
}
