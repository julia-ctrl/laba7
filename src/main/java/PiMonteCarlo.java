import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
public class PiMonteCarlo {

    private AtomicInteger nAtomSuccess;
    private int nThrows;
    private double value;
    class MonteCarlo implements Runnable {
        @Override
        public void run() {
            double x = Math.random();
            double y = Math.random();
            if (x * x + y * y <= 1)
                nAtomSuccess.incrementAndGet();
        }
    }
    public PiMonteCarlo(int amountOfThreads) {
        this.nAtomSuccess = new AtomicInteger(0);
        this.nThrows = amountOfThreads;
        this.value = 0;
    }
    public double getPi() {
        int nProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newWorkStealingPool(nProcessors);
        for (int i = 1; i <= nThrows; i++) {
            Runnable worker = new MonteCarlo();
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        value = 4.0 * nAtomSuccess.get() / nThrows;
        System.out.println("Iteration : "+nAtomSuccess);
        return value;
    }
}
