package ru.practicum.ewm.controller.compilations;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.compilations.dto.CompilationDto;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Validated
@RestController
@RequestMapping("/compilations")
public interface CompilationsPublicController {

    @GetMapping
    List<CompilationDto> getCompilations(
            @RequestParam(required = false) Boolean pinned,
            @PositiveOrZero @RequestParam(defaultValue = "0") Integer from,
            @Positive @RequestParam(defaultValue = "10") Integer size
    );

    @GetMapping("{compId}")
    CompilationDto getCompilation(@Positive @PathVariable Integer compId);
}
