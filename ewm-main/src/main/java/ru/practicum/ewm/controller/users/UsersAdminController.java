package ru.practicum.ewm.controller.users;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.users.dto.NewUserRequest;
import ru.practicum.ewm.model.users.dto.UserDto;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Validated
@RestController
@RequestMapping("/admin/users")
public interface UsersAdminController {

    @GetMapping()
    List<UserDto> getUsers(@RequestParam(required = false) List<Long> ids,
                           @PositiveOrZero @RequestParam(defaultValue = "0") Integer from,
                           @Positive @RequestParam(defaultValue = "10") Integer size);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UserDto setUser(@RequestBody @Valid NewUserRequest newUserRequest);

    @DeleteMapping("{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUser(@PathVariable Long userId);
}
