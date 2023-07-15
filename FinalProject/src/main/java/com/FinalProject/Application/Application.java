package com.FinalProject.Application;


import com.FinalProject.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan("com.FinalProject")
@EnableAsync
public class Application implements CommandLineRunner{
    @Autowired
    ITransactionService transactionService;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    IEmailSender emailSender;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
          //Application.main(args);
        categoryService.addCategory(001, "car");

        Category car = categoryService.getCategory(001);


        transactionService.addTransaction(123,"Transaction1",90.00, car);
        transactionService.addTransaction(124,"Transaction2",100.00, car);


        Transaction transaction1 = transactionService.getTransaction(123);
        Transaction transaction2 = transactionService.getTransaction(124);

        System.out.println("Transaction: " + transaction1);
        emailSender.sendEmail();


    }

}

