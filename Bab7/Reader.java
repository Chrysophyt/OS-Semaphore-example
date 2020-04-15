package Bab7;

public class Reader extends Thread{
    private Database server;
    private int readerNum;
    public Reader(int r, Database db) {
        readerNum = r;
        server = db;
    }

    public void run() {
        int c;
        while (true) {
            Database.waitDB();
            System.out.println("Reader-" + readerNum + " wants to read.");
            c = server.startRead();
            System.out.println("Reader-" + readerNum + " is reading. Reader Count = " + c);
            Database.waitDB();
            System.out.println("Reader-" + readerNum + " is done reading. ");
            c = server.stopRead();
        }
    }
}