package org.example;

import com.FinalProject.Application.Application;
import com.FinalProject.WelcomeTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Main implements Runnable {

    @Autowired
    private WelcomeTask welcomeTask;
    public static void main(String[] args) throws Exception {
       A
    }

    @Override
    public void run() {
        System.out.println(welcomeTask);
    }
}