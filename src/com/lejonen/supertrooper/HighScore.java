package com.lejonen.supertrooper;

import com.googlecode.lanterna.terminal.Terminal;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.*;

public class HighScore {


    public static String[] highScores = new String[10];

    public static void checkScore(Terminal terminal, Player player) {

//        String[] highScores = new String[10];
        String line = "";
//        int score = 159;

        for (int i = 0; i < highScores.length; i++) {
            highScores[i] = "";
        }

        try {
            FileReader fileReader = new FileReader("highscores.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for (int i = 0; i < highScores.length; i++) {
                highScores[i] = bufferedReader.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (player.score > Integer.parseInt(highScores[highScores.length - 1].substring(0, 3))) {
            String name = Draw.getAndDrawName(terminal);
            line = String.format("%03d,%s", player.score, name.toUpperCase());
            if (player.score > 999)
                player.score = 999;
            addScoreToHighScores(highScores, player.score, line);
        } else {
        }
    }

    public static void addScoreToHighScores(String[] highScores, int score, String line) {

        System.out.println("inside add method");
        int[] highScoresInts = new int[highScores.length];
        String tempNewHighScore = line;
        int newHighScoreIndex = -1;

        //Make array of ints from the scores in highscores String array.
        for (int i = 0; i < highScores.length; i++) {
            highScoresInts[i] = Integer.parseInt(highScores[i].substring(0, 3));
        }

        //Find index to replace with player.score
        for (int i = highScoresInts.length - 1; i >= 0; i--) {
            if (score > highScoresInts[i])
                newHighScoreIndex = i;
        }

        //Move scores lower than player.score down the list of highscores
        for (int i = highScores.length - 1; i > newHighScoreIndex; i--) {
            highScores[i] = highScores[i - 1];
        }

        System.out.println(newHighScoreIndex);
        //Write new highscore to highscores String array
        highScores[newHighScoreIndex] = tempNewHighScore;

        //Print to console
        for (int i = 0; i < highScores.length; i++) {
            System.out.println(highScores[i]);
        }


        //Print new String array to highscores.txt file
        try {
            FileWriter fileWriter = new FileWriter("highscores.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (int i = 0; i < highScores.length; i++) {
                writer.write(highScores[i] + "\r\n");
            }
            writer.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < highScores.length; i++) {

        }

    }


}




