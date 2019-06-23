package com.thach.oleksandr.view;

import com.thach.oleksandr.controller.CurrentMoveController;
import com.thach.oleksandr.controller.MoveController;
import com.thach.oleksandr.controller.WinnerController;
import com.thach.oleksandr.model.Field;
import com.thach.oleksandr.model.Figure;
import com.thach.oleksandr.model.Game;
import com.thach.oleksandr.model.exceptions.InvalidPointException;
import com.thach.oleksandr.model.exceptions.PointAlreadyOccupiedException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();

    public void show(final Game game) {
        System.out.format("Game name: %s\n",  game.getName());
        final Field field = game.getField();
        for (int x = 0; x < field.getSize(); x++) {
            if (x != 0)
                printSeparator();
            printLine(field, x);
        }
    }

    public boolean move(final Game game) {
        final Field field = game.getField();
        final Figure winner = winnerController.getWinner(field);
        if (winner != null) {
            System.out.format("Winner is: %s", winner);
            return false;
        }
        final Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null) {
            System.out.println("No winner no moves left");
            return false;
        }
        System.out.format("Please enter move point for %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field, currentFigure, point);
        } catch (final InvalidPointException | PointAlreadyOccupiedException e) {
            System.out.println("Point is invalid!");
        }
        return true;
    }

    private Point askPoint() {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String coordinateName) {
        System.out.format("Please input coordinate %s", coordinateName);
        final Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("0_0 ololo");
            return askCoordinate(coordinateName);
        }
    }

    private void printLine(final Field field,
                           final int x) {
        for (int y = 0; y < field.getSize(); y++) {
            if (y != 0)
                System.out.print("|");
            System.out.print(" ");
            final Figure figure;
            try {
                figure = field.getFigure(new Point(y, x));
            } catch (InvalidPointException e) {
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");

            System.out.print(" ");
        }
        System.out.println();
    }

    private void printSeparator() {
        System.out.println("~~~~~~~~~~~~");
    }

}
