package com.example.cookielog.service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.cookielog.model.Cookie;
import com.example.cookielog.repos.CookieLogRepository;

@Service
public class CookieLogService {

    public List<String> findMostActiveCookies(LocalDate date) {
        List<Cookie> cookies = CookieLogRepository.getInstance().getCookies();
        return getMostActiveCookies(cookies, date);
    }

    private List<String> getMostActiveCookies(List<Cookie> cookies, LocalDate date) {
        Map<String, Long> cookieCountMap = cookies.stream()
                .filter(cookie -> cookie.timestamp().toLocalDate().equals(date))
                .collect(Collectors.groupingBy(Cookie::cookie_id, Collectors.counting()));

        long maxCount = cookieCountMap.values().stream().max(Long::compare).orElse(0L);

        return cookieCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}