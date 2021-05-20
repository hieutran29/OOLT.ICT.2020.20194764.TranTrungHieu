package hust.soict.globalict.aims;

public class MemoryDaemon implements Runnable {
    long memoryUsed = 0;
    @Override
    public void run() {
        Runtime runTime = Runtime.getRuntime();
        long used;
        while(true) {
            used = runTime.totalMemory() - runTime.freeMemory();
            if(used != memoryUsed) {
                System.out.println("\tMemory Used = " + used);
                memoryUsed = used;
            }
        }
    }
    
}
