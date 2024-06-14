package com.webbookingticket.fullstack.controller;

import com.webbookingticket.fullstack.dto.UserDto;
import com.webbookingticket.fullstack.model.Schedule;
import com.webbookingticket.fullstack.model.User;
import com.webbookingticket.fullstack.service.ScheduleService;
import com.webbookingticket.fullstack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private UserService userService;

    @PostMapping("/{movieId}")
    public ResponseEntity<List<Schedule>> getScheduleByMovieId(@PathVariable int movieId) {
        List<Schedule> schedules = scheduleService.getScheduleByMovieId(movieId);
        if (schedules != null && !schedules.isEmpty()) {
            return new ResponseEntity<>(schedules, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
