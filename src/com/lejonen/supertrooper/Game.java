package com.lejonen.supertrooper;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Game {

    public boolean running;
    //gjorde WIDTH och HEIGHT final
    public static final int WIDTH = 100;
    public static final int HEIGHT = 30;
    public static final int CEILING = 2;
    public static int fps = 0;

    Player player;
    Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));

    List<Creature> creatures;
    List<Shot> shots;
    //Game initieras.


    public Game() {

        this.running = true;

        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);

        player = new Player(WIDTH / 2, HEIGHT, 2);
    }


    //Start game.

    public void startGame() {

        creatures = new ArrayList<>();
        shots = new ArrayList<>();

        boolean RENDER_TIME = true;
        long initialTime = System.nanoTime();
        final double timeU = 1000000000 / 60; //Updates per second
        final double timeF = 1000000000 / 30; //FPS;
        double deltaU = 0, deltaF = 0;
        int frames = 0, ticks = 0;
        long timer = System.currentTimeMillis();


        //Ändra condition till life större än noll.
        while (player.life>0) {

            long currentTime = System.nanoTime();
            deltaU += (currentTime - initialTime) / timeU;
            deltaF += (currentTime - initialTime) / timeF;
            initialTime = currentTime;

            if (deltaU >= 1) {
                update();
                ticks++;
                deltaU--;
            }

            if (deltaF >= 1) {
                render();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                if (RENDER_TIME) {
                    System.out.println(String.format("UPS: %s, FPS: %s", ticks, frames));
                    fps = frames;
                    System.out.println("SCORE: " + player.score + "     LIFE: " + player.life);
                }
                frames = 0;
                ticks = 0;
                timer += 1000;
            }
        }
        System.out.println("Game over");
    }

    public void update() {


        handleInput();
        updateCreatures();
        updateShots();
        //Started collision method
        checkCollisions();


    }

    private void checkCollisions() {

        //Maybe shot and creature should both be part of a superclass Entity to streamline the code and remove duplication.

        //Remove shots that are outside screen.
        if (shots.size() > 0) {
            for (int i = shots.size()-1; i >= 0; i--) {
                if (shots.get(i).y < CEILING || shots.get(i).y > HEIGHT)
                    shots.remove(shots.get(i));
            }
        }

        //Remove creatures that are outside screen.
         if (creatures.size() > 0) {
            for (int i = creatures.size()-1; i >= 0; i--) {
                if (creatures.get(i).y > HEIGHT)
                    //Lägg till score minskas, alt life minskar när en ENEMY når botten av skärmen.
                    creatures.remove(creatures.get(i));
            }
        }


        //Check player collision with creatures
        if (creatures.size() > 0) {
            for (int i = creatures.size()-1; i>=0; i--) {
                if ((Math.abs(creatures.get(i).y - player.y) < 0.75) && ((Math.abs(creatures.get(i).x - player.x) < 1.5))) {
                    if (creatures.get(i) instanceof Enemy) {
                        --player.life;
                    }
                    else if (creatures.get(i) instanceof ExtraLife) {
                        ++player.life;
                    }
                    else if (creatures.get(i) instanceof PowerUp) {
                        player.score += 10;
                    }
                    creatures.remove(creatures.get(i));
                }
            }
        }

        //Check collision between shot and creature
        if (creatures.size() > 0 && shots.size() > 0) {

            for (int i = shots.size() - 1; i >= 0; i--) {

                int shotToRemove = -1;

                for (int j = creatures.size() - 1; j >= 0; j--) {
                    if (creatures.get(j) instanceof Enemy && Math.abs(shots.get(i).y - creatures.get(j).y) < 1 &&
                            Math.abs(shots.get(i).x - creatures.get(j).x) < 1) {

                        shotToRemove = i;
                        player.score += ((Enemy) creatures.get(j)).value;
                        creatures.remove(creatures.get(j));

                    }

                }

                if (shotToRemove >= 0)
                    shots.remove(shots.get(shotToRemove));
            }
        }

        // Check collision between





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
                creatures.add(new ExtraLife(Math.random() * WIDTH, CEILING));
            } else if (Math.random() > 0.95) {
                creatures.add(new PowerUp(Math.random() * WIDTH, CEILING));
            } else if (Math.random() > 0.80) {
                creatures.add(new FastEnemy(Math.random() * WIDTH, CEILING));
            } else {
                creatures.add(new SlowEnemy(Math.random() * WIDTH, CEILING));
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

        Draw.drawHeader(terminal, player);
        Draw.drawPlayer(terminal, player);

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
