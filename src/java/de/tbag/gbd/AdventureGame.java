package de.tbag.gbd;

import java.util.Arrays;
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
        return scanner.nextLine().trim().toLowerCase();}
        catch(Exception e){
            return "error";
        }
    }

    public String richtungsOptionen(String... options){
        String input;
        boolean isValidOption;


        do{
            show("Du kannst nach: " + String.join(", ", options));
            input = ask("Wohin willst du gehen");
            isValidOption = Arrays.asList(options).contains(input);
            if(!isValidOption){
                show("Falsche Eingabe, bitte versuche es noch einmal.");
            }
        } while (!isValidOption);

        return input;
    }

    public String antwortMöglichkeiten(String... options){
        String input;
        boolean isValiOption;

        do{
            show("Du hast folgende Antowrtmöglichkeiten: " + String.join(", ", options));
            input = ask("Was willst du machen?");
            isValiOption = Arrays.asList(options).contains(input);
            if(!isValiOption){
                show("Falsche Eingabe, bitte versuche es noch einmal.");
            }
        } while (!isValiOption);

        return input;
    }


    public void wait(int seconds) throws InterruptedException {
        int millisec = seconds*1000;
        Thread.sleep(millisec);

    }

}
