import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;


import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
import static praktikum.constants.Names.NAME_OF_INGREDIENT1;
import static praktikum.constants.Prices.PRICE_OF_INGREDIENT1;

@RunWith(Parameterized.class)
public class IngredientTests extends BaseTest{


    @Parameterized.Parameter
    public IngredientType ingredientType;

    @Parameterized.Parameters(name = "{index} Сценарий проверки с типом ингредиента: {0}.")
    public static Object[][] data() {
        return new Object[][] {
                { SAUCE },
                { FILLING }
        };
    }

    @Test
    public void createIngredientTest() {
        new Ingredient(ingredientType, NAME_OF_INGREDIENT1, PRICE_OF_INGREDIENT1);
    }


    @Test
    public void getNameIngredientTest() {
        Ingredient ingredient =  new Ingredient(ingredientType, NAME_OF_INGREDIENT1, PRICE_OF_INGREDIENT1);
        Assert.assertEquals(NAME_OF_INGREDIENT1, ingredient.getName());
    }

    @Test
    public void getPriceIngredientTest() {
        Ingredient ingredient =  new Ingredient(ingredientType, NAME_OF_INGREDIENT1, PRICE_OF_INGREDIENT1);
        Assert.assertEquals(PRICE_OF_INGREDIENT1, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void getTypeIngredientTest() {
        Ingredient ingredient =  new Ingredient(ingredientType, NAME_OF_INGREDIENT1, PRICE_OF_INGREDIENT1);
        Assert.assertEquals(ingredientType, ingredient.getType());
    }

}
