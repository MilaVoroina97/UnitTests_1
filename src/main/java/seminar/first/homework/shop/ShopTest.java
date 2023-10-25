package seminar.first.homework.shop;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShopTest {

    public static void main(String[] args) {
        Product product = new Product("apple",100,90);
        Product product2 = new Product("banana",8,6);
        Product product3 = new Product("bread",57,65);
        Product product4 = new Product("lime",3,86);
        Product product5 = new Product("milk",32,900);

        Shop shop = new Shop();
        shop.addProduct(product);
        shop.addProduct(product2);
        shop.addProduct(product3);
        shop.addProduct(product4);
        shop.addProduct(product5);

//         List<Product> temp = shop.sortProductsByPrice(new ProductComparator(SortType.Ascending));

//        Collections.sort(shop.getProducts(), new ProductComparator(SortType.Ascending));

        shop.sortProductsByPrice2(new ProductComparator(SortType.Ascending));
        System.out.println(shop.getProducts().toString());



    }

}