package com.example.cookielog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.cookielog.service.CookieLogService;

import java.time.LocalDate;
import java.util.List;

@Controller
public class CookieLogController {

    @Autowired
    private CookieLogService cookieLogService;

    public List<String> findMostActiveCookies(LocalDate date) {
        return cookieLogService.findMostActiveCookies(date);
    }
}