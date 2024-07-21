import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTests extends BaseTest {

    public static final String NAME_OF_BUN = "Имя булочки1";
    public static final float PRICE_OF_BUN = 1.09f;



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
