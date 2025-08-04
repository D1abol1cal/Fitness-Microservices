package com.fitness.activityservice.controller;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping("/track")
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest activity) {
        return ResponseEntity.ok(activityService.trackActivity(activity));
    }

    @GetMapping("/useractivities")
    public ResponseEntity<List<ActivityResponse>> getuserActivities(@RequestHeader("X-User-ID") String userId)
    {
        return ResponseEntity.ok(activityService.getUserActivities(userId));
    }
}
