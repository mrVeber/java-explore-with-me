package ru.practicum.ewm.controller.categories;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.categories.dto.CategoryDto;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Validated
@RestController
@RequestMapping("/categories")
public interface CategoriesController {

    @GetMapping
    List<CategoryDto> getCategories(
            @PositiveOrZero @RequestParam(defaultValue = "0") Integer from,
            @Positive @RequestParam(defaultValue = "10") Integer size
    );

    @GetMapping("{catId}")
    CategoryDto getCategory(@Positive @PathVariable Integer catId);
}
