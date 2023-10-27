package seminar.first.homework.shop;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShopTest {


        /* Тест №1 : проверка ожидаемого количества созданных объектов в списке объектов класса Shop:
        * */
        @Test
        public void testCountObjects(){

                Shop shop = new Shop();
                shop.addProduct(new Product("apple",500.0,60.0));
                shop.addProduct(new Product("banana",179.0,55.4));
                shop.addProduct(new Product("bread",50.5,80.0));
                shop.addProduct(new Product("fish",900.0,4.0));
                shop.addProduct(new Product("milk",80.3,6.0));
                assertThat(shop.getProductCount2()).isEqualTo(5);
        }

        /* Тест №2 : проверка, что содержимое корзины с продуктами соответствует ожидаемому:
         *
         * */

        @Test
        public void testProductBasket(){

                Shop shop = new Shop();
                shop.addProduct(new Product("apple",500.0,60.0));
                shop.addProduct(new Product("banana",179.0,55.4));
                shop.addProduct(new Product("bread",50.5,80.0));
                shop.addProduct(new Product("fish",900.0,4.0));
                shop.addProduct(new Product("milk",80.3,6.0));
                List<Product> expectedBusket = new ArrayList<>();
                expectedBusket.add(new Product("apple",500.0,60.0));
                expectedBusket.add(new Product("banana",179.0,55.4));
                expectedBusket.add(new Product("bread",50.5,80.0));
                expectedBusket.add(new Product("fish",900.0,4.0));
                expectedBusket.add(new Product("milk",80.3,6.0));
                assertEquals(expectedBusket,shop.getProducts());
        }

        /* Тест №3:проверка метода поиска самого дорогого продука на соответствие:
        * */
        @Test
        public void testMostExpensiveProduct(){

                Shop shop = new Shop();
                shop.addProduct(new Product("apple",500.0,60.0));
                shop.addProduct(new Product("banana",179.0,55.4));
                shop.addProduct(new Product("bread",50.5,80.0));
                shop.addProduct(new Product("fish",900.0,4.0));
                shop.addProduct(new Product("milk",80.3,6.0));
                assertThat(shop.getMostExpensiveProduct()).isEqualTo(new Product("fish",900.0,4.0));

        }

        /* Тест №4: Провека на обработку исключения, при условии, что список продуктов пуст:
        * */

        @Test
        public void testMostExpensiveProductEmptyList(){
                Shop shop = new Shop();
                assertThatThrownBy(shop::getMostExpensiveProduct).isInstanceOf(NullPointerException.class).
                        hasMessage("There are no any products in shop.");
        }

        /* Тест №5: Проверка метода сортировки продуктов по цене на соответствие:
        * */

        @Test
        public void testSortedProducts(){

                Shop shop = new Shop();
                shop.addProduct(new Product("apple",500.0,60.0));
                shop.addProduct(new Product("banana",179.0,55.4));
                shop.addProduct(new Product("bread",50.5,80.0));
                shop.addProduct(new Product("fish",900.0,4.0));
                shop.addProduct(new Product("milk",80.3,6.0));
                shop.sortProductsByPrice2(new ProductComparator(SortType.Descending));
                List<Product> expectedBusket = new ArrayList<>();
                expectedBusket.add(new Product("fish",900.0,4.0));
                expectedBusket.add(new Product("apple",500.0,60.0));
                expectedBusket.add(new Product("banana",179.0,55.4));
                expectedBusket.add(new Product("milk",80.3,6.0));
                expectedBusket.add(new Product("bread",50.5,80.0));
                assertThat(shop.getProducts()).isEqualTo(expectedBusket);

        }

        /* Тест №6: проверка на обработку исключения метода сортировки продуктов по цене при условии, что список
        продуктов пуст:
        * */

        @Test
        public void testSortedProductsEmptyList(){

                Shop shop = new Shop();
                assertThatThrownBy(() -> shop.sortProductsByPrice2(new ProductComparator(SortType.Ascending))).
                        isInstanceOf(NullPointerException.class).hasMessage("There is no any products in that shop. ");

        }




}
