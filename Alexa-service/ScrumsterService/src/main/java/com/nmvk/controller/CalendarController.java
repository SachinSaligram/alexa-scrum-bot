package com.nmvk.controller;


import com.atlassian.jira.rest.client.api.JiraRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.http.client.HttpClient;
import redis.clients.jedis.Jedis;

import java.time.LocalDate;
import java.util.Random;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    private Jedis jedis;

    @RequestMapping(value = "/{date}", method = RequestMethod.POST)
    public ResponseEntity<String> setMeeting(@PathVariable("date") String date) throws Exception {
        String[] slots = {"9:30 AM","10:30 AM","14:00 PM", "16:00 PM", "12:00 PM"};
        int index = new Random().nextInt(slots.length );

        if (index < slots.length) {
            jedis.sadd(LocalDate.now().toString(), "<a href='#' class='list-group-item list-group-item-action'> <h4 class='list-group-item-heading'><i class='fa fa-calendar-check-o' aria-hidden='true'></i> Meeting Scheduled</h4> <p class='list-group-item-text'>Meeting scheduled on " + date + " " + slots[index] + "</p> </a>");
            return ResponseEntity.ok("Successfully scheduled meeting on " + date + " " + slots[index]);
        }

        return ResponseEntity.ok("Could not schedule meeting on " + date);

     }



    }
