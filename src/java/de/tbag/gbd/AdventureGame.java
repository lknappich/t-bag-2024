package de.tbag.gbd;

import java.util.Scanner;

/**
 * @author Samuel Ratzel | Lukas Knappich
 * @version 1.0
 * @since 28.02.24
 */

public class AdventureGame {
    private Scanner scanner;

    public AdventureGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void show(String message) {
        System.out.println(message);
    }
    public String ask(String question) {
        try{
        System.out.print(question + " ");
        return scanner.nextLine();}
        catch(Exception e){
            return "error";
        }
    }
    public void wait(int seconds) throws InterruptedException {
        int millisec = seconds*1000;
        Thread.sleep(millisec);

    }

}
