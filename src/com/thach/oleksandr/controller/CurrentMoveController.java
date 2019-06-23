package com.thach.oleksandr.controller;

import com.thach.oleksandr.model.Field;
import com.thach.oleksandr.model.Figure;
import com.thach.oleksandr.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {
        int countFigure = 0;
        for (int y = 0; y < field.getSize(); y++) {
            try {
                countFigure += countFigureInTheRow(field, y);
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        if (countFigure == field.getSize() * field.getSize())
            return null;
        if (countFigure % 2 == 0)
            return Figure.X;
        return Figure.O;
    }

    private int countFigureInTheRow(final Field field, final int row) throws InvalidPointException {
        int countFigure = 0;
        for (int x = 0; x < field.getSize(); x++) {
                if (field.getFigure(new Point(x, row)) != null)
                    countFigure++;
        }
        return countFigure;
    }

}
