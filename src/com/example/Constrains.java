package com.example;

public class Constrains {
    private static Constrains constrains = null;
    public static final int X = 400;
    public static final int Y = 100;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    private Constrains() {

    }

    public static Constrains getConstrains() {
        if (constrains == null) {
            return new Constrains();
        }

        return constrains;
    }
}