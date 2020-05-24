import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PiMonteCarloTest {


    int amountOfThreads=100000;
    PiMonteCarlo PiVal = new PiMonteCarlo(amountOfThreads);



    @Test
    public void getPi() {
        double pi = PiVal.getPi();
        Assert.assertEquals(3,(int)pi);
    }
}