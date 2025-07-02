package com.docker;

import org.testng.IExecutionListener;

import java.io.IOException;

public class DockerSetupListener implements IExecutionListener {
    @Override
    public void onExecutionStart() {
        System.out.println("🔄 Starting Docker Grid before the test suite...");
        //bat file will popup
//        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "start start.bat");
        //headless bat file
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "start", "/B", "start.bat");
        builder.inheritIO(); // Optional: show output in console
        try {
            builder.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Thread.sleep(15000); // Wait for Grid to initialize
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("✅ Docker Grid started.");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("🛑 Stopping Docker Grid after the test suite...");
        //bat file will popup S
        //ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "start stop.bat");
        //bat file wont pop up
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "start", "/B", "start.bat");
        builder.inheritIO(); // Optional: show output in console
        try {
            builder.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Thread.sleep(5000); // Allow time for shutdown
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Optional: Kill all cmd windows (use with caution)
        try {
            new ProcessBuilder("cmd.exe", "/c", "taskkill /f /im cmd.exe").start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("✅ Docker Grid stopped and command prompts closed.");
    }
}
