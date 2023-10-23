package ru.practicum.ewm.controller.categories;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.categories.dto.CategoryDto;
import ru.practicum.ewm.model.categories.dto.NewCategoryDto;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/admin/categories")
public interface CategoriesAdminController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CategoryDto setCategory(@Valid @RequestBody NewCategoryDto newCategoryDto);

    @DeleteMapping("{catId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCategory(@Positive @PathVariable Integer catId);

    @PatchMapping("{catId}")
    CategoryDto updateCategory(@RequestBody @Valid CategoryDto categoryDto,
                               @Positive @PathVariable Integer catId);
}
