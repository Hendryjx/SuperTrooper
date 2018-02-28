package com.lejonen.supertrooper;

public class Game {

    public boolean running;

    //Game initieras.



    public Game() {

        this.running = true;



    }


    //Start game.

    public void startGame() {


//        boolean RENDER_TIME = true;
        long initialTime = System.nanoTime();
        final double timeU = 1000000000 / 60; //Updates per second
        final double timeF = 1000000000 / 30; //FPS;
        double deltaU = 0, deltaF = 0;
        int frames = 0, ticks = 0;
        long timer = System.currentTimeMillis();

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


        public void render(){

            Draw.drawPlayer(player);
            Draw.drawCreature();
            Draw.drawShot();


        }

    }

    //Input behöver hanteras.
    //gameLoop --> handleInput, updateObjects, draw.
    //Kontroll om gameLoopen skall köras igen.

    //gameLoop måste räkna ut NÄR den skall kalla metoderna.

    //Gameobjekt som har variablerna level och score.
}
