package de.tbag.gbd;

import de.tbag.gbd.cosmetic.ConsoleColors;

/**
 * @author Samuel Ratzel
 * @version 1.0
 * @since 01.03.24
 */

public class BigTexts {

    public void Loading(){
        System.out.println( ConsoleColors.GREEN_BOLD + " _________               ________  ________  ________     \n" +
                "|\\___   ___\\            |\\   __  \\|\\   __  \\|\\   ____\\    \n" +
                "\\|___ \\  \\_|____________\\ \\  \\|\\ /\\ \\  \\|\\  \\ \\  \\___|    \n" +
                "     \\ \\  \\|\\____________\\ \\   __  \\ \\   __  \\ \\  \\  ___  \n" +
                "      \\ \\  \\|____________|\\ \\  \\|\\  \\ \\  \\ \\  \\ \\  \\|\\  \\ \n" +
                "       \\ \\__\\              \\ \\_______\\ \\__\\ \\__\\ \\_______\\\n" +
                "        \\|__|               \\|_______|\\|__|\\|__|\\|_______|\n" +
                "                                                          \n" +
                "                                                          \n" +
                "                                                          " + ConsoleColors.RESET);
        System.out.println();
        System.out.println("A custom Text Based Adventure Game Lib by "+ ConsoleColors.CYAN_BOLD + "sratzel" + ConsoleColors.RESET + " and " + ConsoleColors.CYAN_BOLD + "lknappich" + ConsoleColors.RESET +"\n");

    }

    public void startBattle(){
        System.out.println(ConsoleColors.RED_BOLD);
        System.out.println(" _____       _        ____        _   _   _          \n" +
                "| ____|_ __ (_) ___  | __ )  __ _| |_| |_| | ___   _ \n" +
                "|  _| | '_ \\| |/ __| |  _ \\ / _` | __| __| |/ _ \\ (_)\n" +
                "| |___| |_) | | (__  | |_) | (_| | |_| |_| |  __/  _ \n" +
                "|_____| .__/|_|\\___| |____/ \\__,_|\\__|\\__|_|\\___| (_)\n" +
                "      |_|                                            \n");

        System.out.println(ConsoleColors.RESET);
    }

    public void shop(){
        System.out.println(ConsoleColors.PURPLE);
        System.out.println(" ____  _                 \n" +
                "/ ___|| |__   ___  _ __  \n" +
                "\\___ \\| '_ \\ / _ \\| '_ \\ \n" +
                " ___) | | | | (_) | |_) |\n" +
                "|____/|_| |_|\\___/| .__/ \n" +
                "                  |_|    ");
        System.out.println(ConsoleColors.RESET);

    }

}
