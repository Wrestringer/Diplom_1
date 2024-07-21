import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;


import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
import static praktikum.constants.Names.*;
import static praktikum.constants.Prices.*;

public class BurgerTests extends BaseTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient1;

    @Mock
    Ingredient ingredient2;


    @Test
    public void setBunTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        Assert.assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(ingredient1, burger.ingredients.get(0));
        Assert.assertEquals(ingredient2, burger.ingredients.get(1));
    }


    @Test
    public void getPriceTest() {
        //Создание стабов
        Mockito.when(bun.getPrice()).thenReturn(PRICE_OF_BUN);
        Mockito.when(ingredient1.getPrice()).thenReturn(PRICE_OF_INGREDIENT1);
        Mockito.when(ingredient2.getPrice()).thenReturn(PRICE_OF_INGREDIENT2);

        //Создание бургера и наполнение его
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        //Проверка подсчета конечной стоимости бургера
        float totalPrice = (PRICE_OF_BUN * 2) + PRICE_OF_INGREDIENT1 + PRICE_OF_INGREDIENT2;
        Assert.assertEquals(totalPrice, burger.getPrice(), 0.0f);

        //Проверка, что методы getPrice() вызывались для подсчета стоимости бургера
        Mockito.verify(bun).getPrice();
        Mockito.verify(ingredient1).getPrice();
        Mockito.verify(ingredient2).getPrice();
    }

    @Test
    public void getReceiptTest() {
        //Наполнение булочки данными
        Mockito.when(bun.getName()).thenReturn(NAME_OF_BUN);
        Mockito.when(bun.getPrice()).thenReturn(PRICE_OF_BUN);

        //Наполнени игридиента1 данными
        Mockito.when(ingredient1.getName()).thenReturn(NAME_OF_INGREDIENT1);
        Mockito.when(ingredient1.getType()).thenReturn(FILLING);
        Mockito.when(ingredient1.getPrice()).thenReturn(PRICE_OF_INGREDIENT1);

        //Наполнени игридиента2 данными
        Mockito.when(ingredient2.getName()).thenReturn(NAME_OF_INGREDIENT2);
        Mockito.when(ingredient2.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient2.getPrice()).thenReturn(PRICE_OF_INGREDIENT2);

        //Создание бургера и наполнение его
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        //Вызов метода getReceipt() и что он выводит не пустое значение
        Assert.assertNotNull(burger.getReceipt());

        //Проверка вызавов методов для булочки и ингридиентов
        Mockito.verify(bun, Mockito.times(2)).getName();

        Mockito.verify(ingredient1).getName();
        Mockito.verify(ingredient2).getName();

        Mockito.verify(ingredient1).getType();
        Mockito.verify(ingredient2).getType();

        //провека подсчета итоговой стоимости бургера
        float totalPrice = (PRICE_OF_BUN * 2) + PRICE_OF_INGREDIENT1 + PRICE_OF_INGREDIENT2;
        Assert.assertEquals(totalPrice, burger.getPrice(), 0.0f);


    }


}
