package com.example.cookielog.model;

import java.time.OffsetDateTime;
import java.util.Objects;

public record Cookie(
        String cookie_id,
        OffsetDateTime timestamp) {

    public Cookie {
        Objects.requireNonNull(cookie_id);
        Objects.requireNonNull(timestamp);
    }
}