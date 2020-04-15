package Bab7;

public class WriterReaderProblem {
    private static final int NUM_OF_READERS = 3;
    private static final int NUM_OF_WRITERS = 2;
    public static void main(String args[]) {
        Database server = new Database();
        Reader[] readerArray = new Reader[NUM_OF_READERS];
        Writer[] writerArray = new Writer[NUM_OF_WRITERS];  
        for (int i = 0; i < NUM_OF_READERS; i++) {
            readerArray[i] = new Reader(i, server);
            readerArray[i].start();
        }
        for (int i = 0; i < NUM_OF_WRITERS; i++) {
            writerArray[i] = new Writer(i, server);
            writerArray[i].start();
        }
    }
}