package seminarTwo.lection;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.ValueSource;
import seminar.first.homework.calculator.Calculator;
import seminar.two.lection.Cart;
import seminar.two.lection.Product;
import seminar.two.lection.Shop;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import seminar.two.lection.TestUserInterface;

public class ShopTest {


    /**
     * Создаем набор продуктов для магазина:
     *
     * @return список продуктов
     */
    public static List<Product> getStoreItems() {
        List<Product> products = new ArrayList<>();

        // Три массива Названия, Цены, Кол-во
        String[] productNames = {"bacon", "beef", "ham", "salmon", "carrot", "potato", "onion", "apple", "melon", "rice", "eggs", "yogurt"};
        Double[] productPrice = {170.00d, 250.00d, 200.00d, 150.00d, 15.00d, 30.00d, 20.00d, 59.00d, 88.00d, 100.00d, 80.00d, 55.00d};
        Integer[] stock = {10, 10, 10, 10, 10, 10, 10, 70, 13, 30, 40, 60};

        // Последовательно наполняем список продуктами
        for (int i = 0; i < productNames.length; i++) {
            products.add(new Product(i + 1, productNames[i], productPrice[i], stock[i]));
        }
        return products;
    }

    private ByteArrayOutputStream output = new ByteArrayOutputStream();


/*
            ID | Название  | Цена, р. | Кол-во в магазине, шт.
            1  | bacon     | 170.0    | 10
            2  | beef      | 250.0    | 10
            3  | ham       | 200.0    | 10
            4  | salmon    | 150.0    | 10
            5  | carrot    | 15.0     | 10
            6  | potato    | 30.0     | 10
            7  | onion     | 20.0     | 10
            8  | apple     | 59.0     | 70
            9  | melon     | 88.0     | 13
            10 | rice      | 100.0    | 30
            11 | eggs      | 80.0     | 40
            12 | yogurt    | 55.0     | 60
*/

    /**
     * 2.1. Нужно написать юнит-тест для проверки следующей <b>ситуации</b>:
     * Пользователь положил в корзину несколько продуктов разной стоимости
     * <br><b>Ожидаемый результат:</b>
     * Стоимость корзины посчиталась корректно
     */
    @Test
    void priceCartIsCorrectCalculated() {

        Shop shop = new Shop(getStoreItems());
        Cart cart = new Cart(shop);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(2);
        assertThat(cart.getTotalPrice()).isEqualTo(170+250);


    }

    /**
     * 2.2. Нужно написать юнит-тест для проверки следующей <b>ситуации</b>:
     * Пользователь положил в корзину несколько продуктов разной стоимости (несколько продуктов одного вида)
     * <br><b>Ожидаемый результат:</b>
     * Стоимость корзины посчиталась корректно
     */
    @Test
    void priceCartProductsSameTypeIsCorrectCalculated() {

        Shop shop = new Shop(getStoreItems());
        Cart cart = new Cart(shop);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(3);
        cart.addProductToCartByID(3);
        assertThat(cart.getTotalPrice()).isEqualTo(170 + 170 + 200 + 200);

    }

    /**
     * 2.3. Нужно написать юнит-тест для проверки следующей <b>ситуации</b>:
     * Пользователь удаляет товар из корзины
     * <br><b>Ожидаемый результат:</b>
     * Вызывается метод пересчета стоимости корзины, стоимость корзины меняется
     */
    @Test
    void whenChangingCartCostRecalculationIsCalled() {

        Shop shop = new Shop(getStoreItems());
        Cart cart = new Cart(shop);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(2);
        cart.addProductToCartByID(3);
        cart.addProductToCartByID(4);
        cart.removeProductByID(2);

        assertThat(cart.getTotalPrice()).isEqualTo(170 + 150 + 200);

    }

    /**
     * 2.4. Нужно написать юнит-тест для проверки следующей <b>ситуации</b>:
     * Пользователь кладет в корзину продукт в некотором количестве (не весь оставшийся)
     * <br><b>Ожидаемый результат:</b>
     * Количество товара в магазине уменьшается на число продуктов в корзине пользователя
     */
    @Test
    void quantityProductsStoreChanging() {
        Shop shop = new Shop(getStoreItems());
        Cart cart = new Cart(shop);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);

        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(8);
    }

    /**
     * 2.5. Нужно написать юнит-тест для проверки следующей <b>ситуации</b>:
     * Пользователь забрал последние оставшиеся продукты из магазина
     * <br><b>Ожидаемый результат:</b>
     * Больше такой продукт заказать нельзя, он не появляется на полке
     */
//    @Test
//    void lastProductsDisappearFromStore() {
//        Shop shop = new Shop(getStoreItems());
//        Cart cart = new Cart(shop);
//
//        cart.addProductToCartByID(1);
//        cart.addProductToCartByID(1);
//        cart.addProductToCartByID(1);
//        cart.addProductToCartByID(1);
//        cart.addProductToCartByID(1);
//        cart.addProductToCartByID(1);
//        cart.addProductToCartByID(1);
//        cart.addProductToCartByID(1);
//        cart.addProductToCartByID(1);
//        cart.addProductToCartByID(1);
//
//
//        assertThatThrownBy(() -> cart.addProductToCartByID(1))
//                .isInstanceOf(IllegalStateException.class);
//    }

    @Test
    void lastProductsDisappearFromStoreTwo() {
        Shop shop = new Shop(getStoreItems());
        Cart cart = new Cart(shop);

        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);

        System.setOut(new PrintStream(output));
        cart.addProductToCartByID(1);
        final String cleanOutput = output.toString().replaceAll("\n", "").replaceAll("\r", "");
        String expected = "Этого товара нет в наличии";
        assertThat(expected).isEqualTo(cleanOutput);

    }


    /**
     * 2.6. Нужно написать юнит-тест для проверки следующей <b>ситуации</b>:
     * Пользователь удаляет продукт из корзины
     * <br><b>Ожидаемый результат:</b>
     * Количество продуктов этого типа на складе увеличивается на число удаленных из корзины продуктов
     */
    @Test
    void deletedProductIsReturnedToShop() {

        Shop shop = new Shop(getStoreItems());
        Cart cart = new Cart(shop);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.removeProductByID(1);

        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(8);

    }

    /**
     * 2.7. Нужно написать юнит-тест для проверки следующей <b>ситуации</b>:
     * Пользователь вводит неверный номер продукта
     * <br><b>Ожидаемый результат:</b>
     * Исключение типа RuntimeException и сообщение Не найден продукт с id
     * *Сделать тест параметризованным
     */

    /* Параметризированный тест нужен для:

    1. Тестирования множественных и граничных значений
    * */
    @ParameterizedTest
    @ValueSource(ints = {-1, 13})
    void incorrectProductSelectionCausesException(int number) {

        Shop shop = new Shop(getStoreItems());
        Cart cart = new Cart(shop);
        RuntimeException runtimeException = assertThrows(RuntimeException.class,() -> cart.addProductToCartByID(number));
        assertEquals(runtimeException.getMessage(), "Не найден продукт с id: " + number);
//        assertThatThrownBy(() -> cart.addProductToCartByID(number)).isInstanceOf(RuntimeException.class);
    }

    /**
     * 2.8. Нужно написать юнит-тест для проверки следующей <b>ситуации</b>:
     * Пользователь удаляет из корзины больше продуктов чем у него есть в корзине (удаляет продукты до того, как их добавить)
     * <br><b>Ожидаемый результат:</b> Исключение типа NoSuchFieldError и сообщение "В корзине не найден продукт с id"
     */
    @Test
    void incorrectProductRemoveCausesException() {
        Shop shop = new Shop(getStoreItems());
        Cart cart = new Cart(shop);
        assertThatThrownBy(() -> cart.removeProductByID(8)).isInstanceOf(RuntimeException.class).
                hasMessage("В корзине не найден продукт с id: 8");

    }

    /**
     * 2.9. Нужно восстановить тест
     */

    @Test
     void СломанныйТест() {
         Shop shop = new Shop(getStoreItems());
         Cart cart = new Cart(shop);

         cart.addProductToCartByID(2); // 250
         cart.addProductToCartByID(2); // 250
         assertThat(cart.getTotalPrice()).isEqualTo(250 + 250);

     }


    /**
     * 2.10. Нужно изменить тест по следующим критериям:
     * <br> 1. Отображаемое имя - "Advanced test for calculating TotalPrice"
     * <br> 2. Тест повторяется 10 раз
     * <br> 3. Установлен таймаут на выполнение теста 70 Миллисекунд (unit = TimeUnit.MILLISECONDS)
     * <br> 4. После проверки работоспособности теста, его нужно выключить
     */
    @Test
    @DisplayName("Advanced test for calculating TotalPrice")
    @RepeatedTest(10)
    @Timeout(value = 70,unit = TimeUnit.MILLISECONDS)
//    @Disabled
    void priceCartIsCorrectCalculatedExt() {
        Shop shop = new Shop(getStoreItems());
        Cart cart = new Cart(shop);
        cart.addProductToCartByID(2); // 250
        cart.addProductToCartByID(2); // 250
        assertThat(cart.getTotalPrice()).isEqualTo(250 + 250);


    }

    @Test
    void testUserMenu(){

        Shop shop = new Shop(getStoreItems());
        Cart cart = new Cart(shop);
        String testValue = "k";
        ByteArrayInputStream in = new ByteArrayInputStream(testValue.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream inputStream = System.in;
        System.setIn(in);
        System.setOut(new PrintStream(out));

        TestUserInterface userInterface = new TestUserInterface(shop);
        assertThat(userInterface.getUserInput()).isEqualTo("You need to enter only integer number");
        System.setIn(inputStream);
        System.setOut(null);

    }


}
