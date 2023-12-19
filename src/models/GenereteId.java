package models;

public class GenereteId {
    private static long counter = 1;
    public static long setId() {
        return counter++;
    }
}
