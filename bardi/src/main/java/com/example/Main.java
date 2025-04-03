package com.example;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Bathroom menBathroom = new MenBathroom();
        Bathroom womenBathroom = new WomenBathroom();
        
        
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            User user;
            if (Math.random() < 0.5) {
                user = new User("Uomo " + i, true);
                threads.add((new UserThread(user, menBathroom)));
            } else {
                user = new User("Donna " + i, false);
                threads.add((new UserThread(user, womenBathroom)));
            }
        }
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Tutti gli utenti hanno usato il bagno.");
    }

}
