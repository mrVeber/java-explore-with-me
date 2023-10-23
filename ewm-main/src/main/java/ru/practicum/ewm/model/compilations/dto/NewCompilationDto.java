package ru.practicum.ewm.model.compilations.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewCompilationDto {

    private List<Long> events;

    private boolean pinned;

    @NotBlank
    @Size(max = 50)
    private String title;
}
