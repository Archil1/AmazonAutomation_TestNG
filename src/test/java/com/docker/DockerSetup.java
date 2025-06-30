package com.docker;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class DockerSetup {

    @BeforeSuite
    public void startDockerGrid() throws IOException, InterruptedException {
        System.out.println("🚀 Starting Docker Grid...");

        // If the batch file is in the project root
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "start", "start-grid.bat");

        // If the batch file is outside the project, provide full path
        // ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "start", "C:\\path\\to\\start-docker-grid.bat");

        builder.inheritIO(); // Optional: show output in the console
        Process process = builder.start();

        // Wait for the Grid to initialize (adjust if needed)
        Thread.sleep(15000);

        System.out.println("✅ Docker Grid startup triggered.");

//        System.out.println("🚀 Starting Docker Grid...");
//
//        // If the batch file is in the project root
//        Runtime.getRuntime().exec("cmd /c start start-docker-grid.bat");
//
//        // If the batch file is outside the project, provide full path
//        // Runtime.getRuntime().exec("cmd /c start C:\\path\\to\\start-docker-grid.bat");
//
//        Thread.sleep(15000); // Wait for Grid to be ready


    }

    @AfterSuite
    public void stopDockerGrid() throws IOException, InterruptedException {
        System.out.println("🛑 Stopping Docker Grid...");

        // If the batch file is in the project root
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "start", "stop-grid.bat");

        // If the batch file is outside the project, provide full path
        // ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "start", "C:\\path\\to\\stop-docker-grid.bat");

        builder.inheritIO(); // Optional: show output in the console
        Process process = builder.start();

        // Wait a few seconds to allow containers to shut down
        Thread.sleep(5000);

        // Optional: Close all command prompts opened by batch files
        new ProcessBuilder("taskkill", "/f", "/im", "cmd.exe").start();

        System.out.println("✅ Docker Grid shutdown triggered.");


//        System.out.println("🛑 Stopping Docker Grid...");
//
//        // If the batch file is in the project root
////        Runtime.getRuntime().exec("cmd /c start stop-docker-grid.bat");
//
//        // If the batch file is outside the project, provide full path
//        // Runtime.getRuntime().exec("cmd /c start C:\\path\\to\\stop-docker-grid.bat");
//
//        Thread.sleep(5000); // Allow time for shutdown
//
//        // Optional: Close all command prompts opened by batch files
//        Runtime.getRuntime().exec("taskkill /f /im cmd.exe");

    }

}
