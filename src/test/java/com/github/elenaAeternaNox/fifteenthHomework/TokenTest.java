package com.github.elenaAeternaNox.fifteenthHomework;

import com.github.elenaAeternaNox.fifteenthHomework.apiConfig.ApiConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenTest {

    @Test
    public void checkLocalToken() {
        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
        assertEquals(apiConfig.token(), "rksdrke4i386wericfyhtbtdF^rg|Tu76RGFVu&gRF^YG&%RGvftu");
    }

    @Test
    public void checkRemoteToken() throws Exception {
        String token = "rksH&HNK&YUil(*&*(89Tu76RGFVu&gRF^YG&%RGvftu";
        Path properties = Paths.get("C:\\windows\\temp\\token.properties");

        Files.write(properties, token.getBytes(StandardCharsets.UTF_8));

        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
        assertEquals(apiConfig.token(), "rksdrke4i386wericfyhtbtdF^rg|Tu76RGFVu&gRF^YG&%RGvftu");

        Files.delete(properties);
    }
}
