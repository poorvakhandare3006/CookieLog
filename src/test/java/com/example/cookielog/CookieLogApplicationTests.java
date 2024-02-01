package com.example.cookielog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.cookielog.controller.CookieLogController;
import com.example.cookielog.repos.CookieLogRepository;
import com.example.cookielog.service.CookieLogService;

@SpringBootTest
class CookieLogApplicationTests {

    @Mock
    private BufferedReader bufferedReader;

    @InjectMocks
    private CookieLogService cookieLogService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetMostActiveCookies() throws IOException {
        String filename = "src/test/resources/test_log.csv";
        LocalDate date = LocalDate.parse("2018-12-09");
        List<String> expectedCookies = List.of("Cookie1");
        // Test the service method
        CookieLogRepository cookieLogRepository = CookieLogRepository.getInstance();
        cookieLogRepository.setDataFromFile(filename);
        List<String> result = cookieLogService.findMostActiveCookies(date);
        // Assert the result
        assertEquals(expectedCookies, result);
        assertEquals(result.size(), 1);
    }

    @Test
    void testGetMostActiveCookiesNoMatchingDate() throws IOException {
        String filename = "src/test/resources/test_log.csv";
        LocalDate date = LocalDate.parse("2018-12-10");
        List<String> expectedCookies = List.of();
        // Test the service method
        CookieLogRepository cookieLogRepository = CookieLogRepository.getInstance();
        cookieLogRepository.setDataFromFile(filename);
        List<String> result = cookieLogService.findMostActiveCookies(date);
        // Assert the result
        assertEquals(expectedCookies, result);
        assertEquals(result.size(), 0);
    }

    @Test
    void testGetMostActiveCookiesEmptyFile() throws IOException {
        String filename = "src/test/resources/empty_test_log.csv";
        LocalDate date = LocalDate.parse("2018-12-09");
        List<String> expectedCookies = List.of();
        // Test the service method
        CookieLogRepository cookieLogRepository = CookieLogRepository.getInstance();
        cookieLogRepository.setDataFromFile(filename);
        List<String> result = cookieLogService.findMostActiveCookies(date);
        // Assert the result
        assertEquals(expectedCookies, result);
        assertEquals(result.size(), 0);
    }

}