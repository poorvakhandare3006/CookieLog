package com.example.cookielog.repos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.cookielog.model.Cookie;

// Singleton Class
public class CookieLogRepository {

    private List<Cookie> cookies;

    private static volatile CookieLogRepository instance;

    // Private constructor to prevent instantiation from outside the class
    private CookieLogRepository() {
        // Initialization code (if needed)
    }

    // Public method to provide a global point of access to the instance
    public static CookieLogRepository getInstance() {
        if (instance == null) {
            synchronized (CookieLogRepository.class) {
                if (instance == null) {
                    instance = new CookieLogRepository();

                }
            }
        }
        return instance;
    }

    // Function to read cookies from File and set to instance Object
    public void setDataFromFile(String filename) {
        List<Cookie> cookies = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                Cookie cookie = new Cookie(parts[0], OffsetDateTime.parse(parts[1]));
                cookies.add(cookie);
            }
        } catch (IOException e) {
            // no such file exists
            e.printStackTrace();
        }
        this.cookies = cookies;
    }

    public List<Cookie> getCookies() {
        return this.cookies;
    }

}