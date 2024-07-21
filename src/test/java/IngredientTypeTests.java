import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;


public class IngredientTypeTests extends BaseTest {

    @Test
    public void checkNotNullSauceEnumIngredientTypeTest() {
        Assert.assertNotNull(IngredientType.SAUCE);
    }

    @Test
    public void checkNotNullFilingEnumIngredientTypeTest() {
        Assert.assertNotNull(IngredientType.FILLING);
    }
}
