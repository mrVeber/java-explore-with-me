package ru.practicum.ewm.controller.compilations;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.compilations.dto.CompilationDto;
import ru.practicum.ewm.model.compilations.dto.NewCompilationDto;
import ru.practicum.ewm.model.compilations.dto.UpdateCompilationRequest;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/admin/compilations")
public interface CompilationsAdminController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CompilationDto setCompilation(@Valid @RequestBody NewCompilationDto newCompilationDto);

    @DeleteMapping("{compId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCompilation(@Positive @PathVariable Integer compId);

    @PatchMapping("{compId}")
    CompilationDto updateCompilation(
            @Valid @RequestBody UpdateCompilationRequest updateCompilationRequest,
            @PathVariable Integer compId);
}
