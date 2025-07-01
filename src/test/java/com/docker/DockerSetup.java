package com.docker;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DockerSetup {
    
    @BeforeSuite
    public void startDockerGrid() throws IOException, InterruptedException {
        System.out.println("🔄 Starting Docker Grid before the test suite...");
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "start start.bat");
        builder.inheritIO(); // Optional: show output in console
        builder.start();
        Thread.sleep(15000); // Wait for Grid to initialize
        System.out.println("✅ Docker Grid started.");
    }

    @AfterSuite
    public void stopDockerGrid() throws IOException, InterruptedException {
        System.out.println("🛑 Stopping Docker Grid after the test suite...");
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "start stop.bat");
        builder.inheritIO(); // Optional: show output in console
        builder.start();
        Thread.sleep(5000); // Allow time for shutdown

        // Optional: Kill all cmd windows (use with caution)
        new ProcessBuilder("cmd.exe", "/c", "taskkill /f /im cmd.exe").start();
        System.out.println("✅ Docker Grid stopped and command prompts closed.");
    }
}



