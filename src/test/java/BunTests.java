import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

import static praktikum.constants.Names.NAME_OF_BUN;
import static praktikum.constants.Prices.PRICE_OF_BUN;

public class BunTests extends BaseTest {


    @Test
    public void createBunTest() {
        new Bun(NAME_OF_BUN, PRICE_OF_BUN);
    }


    @Test
    public void getNameBunTest() {
        Bun bun = new Bun(NAME_OF_BUN, PRICE_OF_BUN);
        Assert.assertEquals(NAME_OF_BUN, bun.getName());
    }

    @Test
    public void getPriceBunTest() {
        Bun bun = new Bun(NAME_OF_BUN, PRICE_OF_BUN);
        Assert.assertEquals(PRICE_OF_BUN, bun.getPrice(), 0.0f);
    }
}
