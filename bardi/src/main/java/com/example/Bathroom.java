package com.example;

import java.util.concurrent.Semaphore;

public class Bathroom {
    Constant constants = new Constant();
    private Semaphore semaphore = new Semaphore(constants.getMAX_NUMBER_OF_PEOPLE_PER_BATHROOM());

    public void enter(User user) {
        try {
            System.out.println(user.getName() + " sta cercando di entrare nel bagno...");
            semaphore.acquire(); // il bagno acquisisce una persona
            System.out.println(user.getName() + " è entrato nel bagno.");
            Thread.sleep((int) (Math.random() * 3000) + 1000); // tempo di utilizzo bagno
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void exit(User user) {
        System.out.println(user.getName() + " è uscito dal bagno.");
        semaphore.release(); // rilascia la persona dal bagno
    }
}
