public class Main {
    public static void main(String[] args) {
        int amountOfThreads=100000;
        PiMonteCarlo PiVal = new PiMonteCarlo(amountOfThreads);
        long startTime = System.currentTimeMillis();
        double value = PiVal.getPi();
        long stopTime = System.currentTimeMillis();
        System.out.println("Pi is:" + value);
        System.out.println("Threads: "+ amountOfThreads);
        System.out.println("Time Duration: " + (stopTime - startTime) + "ms");
    }
}
