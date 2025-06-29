package com.Listeners;

import org.testng.IExecutionListener;

public class ExecutionListeners implements IExecutionListener {
    @Override
    public void onExecutionStart() {
        System.out.println(">>> TestNG execution begins.");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println(">>> TestNG execution ends.");
    }

}
