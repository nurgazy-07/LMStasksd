package models;

public class BookId {
    private static long counnt = 1;
    public  static long Id(){
        return counnt++;
    }

}
