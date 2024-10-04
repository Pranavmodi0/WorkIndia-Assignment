package com.example.railway_management.utils;

import java.util.UUID;

public class TokenUtil {
    public static String generateToken() {
        return UUID.randomUUID().toString();
    }
}
