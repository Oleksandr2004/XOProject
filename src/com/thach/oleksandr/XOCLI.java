package com.thach.oleksandr;

import com.thach.oleksandr.model.Field;
import com.thach.oleksandr.model.Figure;
import com.thach.oleksandr.model.Game;
import com.thach.oleksandr.model.Player;
import com.thach.oleksandr.view.ConsoleView;

public class XOCLI {

    public static void main(final String[] args) {
        final String name1 = "Sasha";
        final String name2 = "Pedro";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game gameXO = new Game(new Field(3), players, "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while (consoleView.move(gameXO)) {
            consoleView.show(gameXO);
        }
    }

}
