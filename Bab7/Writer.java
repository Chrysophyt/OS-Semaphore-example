package Bab7;

public class Writer extends Thread {
    private Database server;
    private int writerNum;

    Writer(int r, Database db) {
        this.writerNum = r;
        this.server = db;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println("Writer-"+ writerNum+ "is Sleeping.");
            Database.waitDB();

            System.out.println("Writer-"+ writerNum+ "wants to write.");
            server.startWrite();

            System.out.println("Writer-"+ writerNum+ "writting.");
            Database.waitDB();

            System.out.println("Writer-"+ writerNum+ "is done writting.");
            server.stopWrite();
        }
    }
}