package com.liuyl.date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 * @author tear-smart
 * @date 2019-02-02
 */
@Data
@NoArgsConstructor
public class TimeBean {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime nowTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate nowDate;
}
