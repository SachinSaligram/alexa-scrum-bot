package com.nmvk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.time.LocalDate;
import java.util.Set;

/**
 * Created by raghav on 11/5/2017.
 */
@RestController
@RequestMapping("/data")
public class LogController {

    @Autowired
    Jedis jedis;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Set<String>> data() {
        return ResponseEntity.ok(jedis.smembers(LocalDate.now().toString()));
    }
}
