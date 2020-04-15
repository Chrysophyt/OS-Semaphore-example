package Bab7;

public final class Semaphore {
    private int value;
    Semaphore() {
        value = 0;
    }
    Semaphore(int v){
        this.value = v;
    }
    public synchronized void close() {
        while (value<=0) {
            try{
                wait();
            } catch (InterruptedException e) { }
        }
        value--;
    }
    public synchronized void open() {
        ++value;
        notify();
    }
}