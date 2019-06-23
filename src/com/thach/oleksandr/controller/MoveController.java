package com.thach.oleksandr.controller;

import com.thach.oleksandr.model.Field;
import com.thach.oleksandr.model.Figure;
import com.thach.oleksandr.model.exceptions.InvalidPointException;
import com.thach.oleksandr.model.exceptions.PointAlreadyOccupiedException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field,
                            final Figure figure,
                            final Point point) throws InvalidPointException,
                                                    PointAlreadyOccupiedException {

        if (field.getFigure(point) != null) {
            throw new PointAlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }

}
