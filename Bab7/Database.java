package Bab7;

public class Database {
    private int readerCount;
    Semaphore mutex;
    Semaphore db;
    private static final int NAP_TIME = 15;

    Database() {
        readerCount = 0;
        mutex = new Semaphore(1);
        db = new Semaphore(1);
    }

    public static void waitDB() {
        int sleepTime = (int) (NAP_TIME * Math.random());
        try {
            Thread.sleep(sleepTime * 1000);
        } catch (InterruptedException e) {
        }
    }

    public int startRead() {
        mutex.close();
        ++readerCount;
        if (readerCount == 1) {
            db.close();
        }
        mutex.open();
        return readerCount;
    }

    public int stopRead() {
        mutex.close();
        --readerCount;
        if(readerCount == 0) {
            db.open();
        }
        mutex.open();
        System.out.println("Reader count = " + readerCount);
        return readerCount;
    }

    public void startWrite() {
        db.close();
    }
    public void stopWrite(){
        db.open();
    }
}