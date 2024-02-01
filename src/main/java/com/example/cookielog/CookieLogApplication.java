package com.example.cookielog;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cookielog.controller.CookieLogController;
import com.example.cookielog.repos.CookieLogRepository;

@SpringBootApplication
public class CookieLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(CookieLogApplication.class, args);
    }

    @Autowired
    CookieLogController cookieLogController;

    public CommandLineRunner commandLineRunner() {
        return args -> {
            String filename = null;
            LocalDate date = null;

            for (int i = 0; i < args.length; i++) {

                switch (args[i]) {
                    case "-f":
                        filename = args[++i];
                        break;
                    case "-d":
                        date = LocalDate.parse(args[++i]);
                        break;
                    default:
                        System.out.println("Invalid command. Usage: -f <filename> -d <date>");
                        return;
                }
            }

            if (filename == null || date == null) {
                System.out.println("Invalid command. Usage: -f <filename> -d <date>");
                return;
            }
            System.out.println("----------------------------------------");
            System.out.println("Most Active Cookies for " + date + ":");
            
            // Set filename to store cookies in Singleton Object
            CookieLogRepository cookieLogRepository = CookieLogRepository.getInstance();
            cookieLogRepository.setDataFromFile(filename);


            // Find most active cookies for given date
            cookieLogController.findMostActiveCookies(date).forEach(System.out::println);
            System.out.println("----------------------------------------");

        };
    }

}