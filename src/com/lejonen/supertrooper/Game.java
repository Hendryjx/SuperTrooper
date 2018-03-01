package com.lejonen.supertrooper;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Game {

    public boolean running;
    //gjorde width och height final
    final int width = 100;
    final int height = 30;
    Player player;
    Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));

    List<Creature> creatures;
    List<Shot> shots;
    //Game initieras.


    public Game() {

        this.running = true;

        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);

        player = new Player(width / 2, height, 2);
    }


    //Start game.

    public void startGame() {

        creatures = new ArrayList<>();
        shots = new ArrayList<>();

//        boolean RENDER_TIME = true;
        long initialTime = System.nanoTime();
        final double timeU = 1000000000 / 60; //Updates per second
        final double timeF = 1000000000 / 30; //FPS;
        double deltaU = 0, deltaF = 0;
        //int frames = 0, ticks = 0;
        //long timer = System.currentTimeMillis();


        //Ändra condition till life större än noll.
        while (this.running) {

            long currentTime = System.nanoTime();
            deltaU += (currentTime - initialTime) / timeU;
            deltaF += (currentTime - initialTime) / timeF;
            initialTime = currentTime;

            if (deltaU >= 1) {
                update();
//                ticks++;
                deltaU--;
            }

            if (deltaF >= 1) {
                render();
//                frames++;
                deltaF--;
            }

//            if (System.currentTimeMillis() - timer > 1000) {
//                if (RENDER_TIME) {
//                    System.out.println(String.format("UPS: %s, FPS: %s", ticks, frames));
//                }
//                frames = 0;
//                ticks = 0;
//                timer += 1000;
        }
    }

    public void update() {


        handleInput();
        updateCreatures();
        updateShots();
        //Started collision method
        checkCollisions();


    }

    private void checkCollisions() {

        if (shots.size() > 0) {
            for (int i = shots.size()-1; i >= 0; i--) {
                if (shots.get(i).y < 0 || shots.get(i).y > height)
                    shots.remove(shots.get(i));
            }
        }
         if (creatures.size() > 0) {
            for (int i = creatures.size()-1; i >= 0; i--) {
                if (creatures.get(i).y > height)
                    //Lägg till score minskas, alt life minskar när en ENEMY når botten av skärmen.
                    creatures.remove(creatures.get(i));
            }
        }

        //Lägg till collisions mellan spelare och creatures, skott och creatures och spelare och skott.
        //Öka score om spelaren träffar fiende, öka life om hjärta plockas upp etc.

    }

    public void handleInput() {

        Key key = terminal.readInput();

        if (key == null)
            return;
        switch (key.getCharacter()) {
            case 'L':
                player.moveLeft();
                break;
            case 'R':
                player.moveRight();
                break;
            case ' ':
                player.shoot(shots);
                break;
            default:
                return;
        }
    }

    public void updateCreatures() {

// Extracted creature spawn method.
        checkForNewCreatures();


        for (Creature creature : creatures) {
            Creature.moveCreature(creature);
        }
    }



    // Finns bättre sätt att göra detta, och vi är inte hundra procent överens om vilken vi väljer.
    private void checkForNewCreatures() {
        if (Math.random() < (1.00 / 120)) {
            if (Math.random() > 0.95) {
                creatures.add(new ExtraLife(Math.random() * width, 0));
            } else if (Math.random() > 0.95) {
                creatures.add(new PowerUp(Math.random() * width, 0));
            } else if (Math.random() > 0.80) {
                creatures.add(new FastEnemy(Math.random() * width, 0));
            } else {
                creatures.add(new SlowEnemy(Math.random() * width, 0));
                System.out.println("slow enemy");
            }
        }
    }

    public void updateShots() {

        for (Shot shot : shots) {
            Shot.moveShot(shot);
        }
    }


    //render-metoden bör flyttas till draw-klassen för tydlighet och sammanhang, typ Draw.render eller nåt.
    public void render() {

        terminal.clearScreen();

        Draw.drawPlayer(terminal, this.player);

        for (Creature creature : creatures) {
            Draw.drawCreature(terminal, creature);
        }

        for (Shot shot : shots) {
            Draw.drawShot(terminal, shot);
        }


    }

}

//Input behöver hanteras.
//gameLoop --> handleInput, updateObjects, draw.
//Kontroll om gameLoopen skall köras igen.

//gameLoop måste räkna ut NÄR den skall kalla metoderna.

//Gameobjekt som har variablerna level och score.
