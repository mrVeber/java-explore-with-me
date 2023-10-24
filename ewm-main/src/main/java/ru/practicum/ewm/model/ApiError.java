package ru.practicum.ewm.model;

import lombok.Builder;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

import static ru.practicum.ewm.util.DateConstant.DATE_TIME_PATTERN;

@Data
@Builder
public class ApiError {
    private List<String> errors;
    private String message;
    private String reason;
    private String status;
    @JsonFormat(pattern = DATE_TIME_PATTERN)
    private LocalDateTime timestamp;
}
