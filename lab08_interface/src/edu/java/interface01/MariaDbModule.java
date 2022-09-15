package edu.java.interface01;

public class MariaDbModule implements DatabaseModule {

    @Override
    public int read() {
        System.out.println("Maria DB read()");
        return 0;
    }

    @Override
    public int creat(int intVal, String strVal) {
        System.out.println("Maria DB creat("+ intVal + ", "+ strVal +")");
        return 0;
    }

}
