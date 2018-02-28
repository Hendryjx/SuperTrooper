package com.lejonen.supertrooper;

import com.googlecode.lanterna.terminal.Terminal;

public class Draw {

    public void drawPlayer(Terminal terminal, Player player){

        // kontroll om flytt får ske
        int x = (int) player.x;
        int y = (int) player.y;

        terminal.moveCursor(x - 1, y);
        terminal.putCharacter('=');

        terminal.moveCursor(x, y);
        terminal.putCharacter('=');

        terminal.moveCursor(x + 1, y);
        terminal.putCharacter('=');

        //Skicka in terminal, den som skall anropa draw måste ha tillgång till terminalen redan.
        //Skicka in positioner för Player, Shot, Creature, Collision(?).
    }

    public void drawShot(Terminal terminal, Shot shot){

        int x = (int) shot.x;
        int y = (int) shot.y;

        terminal.moveCursor(x, y);
        terminal.putCharacter(shot.character);

        //Skicka in terminal, den som skall anropa draw måste ha tillgång till terminalen redan.
        //Skicka in positioner för Player, Shot, Creature, Collision(?).
    }

    public void drawCreature(Terminal terminal, Creature creature){

        int x = (int) creature.x;
        int y = (int) creature.y;

        terminal.moveCursor(x, y);
        terminal.putCharacter(creature.character);

        //Skicka in terminal, den som skall anropa draw måste ha tillgång till terminalen redan.
        //Skicka in positioner för Player, Shot, Creature, Collision(?).
    }
}
