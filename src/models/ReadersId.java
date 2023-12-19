package models;

public class ReadersId {
    private static long id = 1;
    public static long ReaderId(){
        return id++;
    }
}
