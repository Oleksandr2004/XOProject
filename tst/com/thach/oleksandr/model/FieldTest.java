package com.thach.oleksandr.model;

import com.thach.oleksandr.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void getSize() throws Exception {
        final int expectedValue = 3;

        final Field field = new Field(3);

        assertEquals(expectedValue, field.getSize());
    }

    @Test
    public void setFigure() throws Exception {
        final Point point = new Point(0, 0);
        final Figure inputFigure = Figure.X;
        final Field field = new Field(3);

        field.setFigure(point, inputFigure);

        final Figure actualValue = field.getFigure(point);

        assertEquals(inputFigure, actualValue);
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Point point = new Point(0, 0);
        final Field field = new Field(3);

        final Figure actualValue = field.getFigure(point);

        assertNull(actualValue);
    }

    @Test
    public void testGetFigureWhenXIsLessThenZero() throws Exception {
        final Point point = new Point(-1, 0);
        final Field field = new Field(3);
        final Figure inputFigure = Figure.X;
        try {
            field.setFigure(point, inputFigure);
            fail();
        } catch (InvalidPointException e) {}

    }
    @Test
    public void testGetFigureWhenYIsLessThenZero() throws Exception {
        final Point point = new Point(0, -1);
        final Field field = new Field(3);
        final Figure inputFigure = Figure.X;
        try {
            field.setFigure(point, inputFigure);
            fail();
        } catch (InvalidPointException e) {}

    }

    @Test
    public void testGetFigureWhenXIsMoreThenSize() throws Exception {
        final Field field = new Field(3);
        final Point point = new Point(field.getSize() + 1, 0);
        final Figure inputFigure = Figure.X;
        try {
            field.setFigure(point, inputFigure);
            fail();
        } catch (InvalidPointException e) {}

    }

    @Test
    public void testGetFigureWhenYIsMoreThenSize() throws Exception {
        final Field field = new Field(3);
        final Point point = new Point(0, field.getSize() + 1);
        final Figure inputFigure = Figure.X;
        try {
            field.setFigure(point, inputFigure);
            fail();
        } catch (InvalidPointException e) {}

    }
}