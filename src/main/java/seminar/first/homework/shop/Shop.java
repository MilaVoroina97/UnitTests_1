package seminar.first.homework.shop;

import java.util.*;

public class Shop {

    private List<Product> products;

    public Shop(){

        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void sortProductsByPrice(Comparator<Product> comparator) {

        if(!products.isEmpty()){
            int len = this.products.size();
            int j = 1;
            while(j > 0){
                j = 0; //каждый раз обнуляем счетчик для того, чтоб вновь пройтись по элементам и также при последнем проходе
                // была возможность выйти из самого верхнего цикла
                for(int k = 1; k < len; k++){
                    if(comparator.compare(products.get(k - 1),products.get(k)) > 0){

                        Product temp = products.get(k);
                        products.set(k,products.get(k - 1));
                        products.set(k - 1, temp);
                        j = k; //увеличиваем счетчик, в случае если удовлетворяется условие

                    }
                }
                len = j; //тем самым уменьшая каждый раз переменную длины
            }

        }
    }

    public void sortProductsByPrice2(Comparator<Product> comparator){

        if(!products.isEmpty()) {

            int i = 0;
            int len = products.size();
            boolean needSwap = true;
            while (i < len - 1 && needSwap) {
                needSwap = false;
                for (int j = 1; j < len - i; j++) {
                    if (comparator.compare(products.get(j - 1), products.get(j)) > 0) {
                        Product temp = products.get(j);
                        products.set(j, products.get(j - 1));
                        products.set(j - 1, temp);
                        needSwap = true;
                    }
                }

                if (!needSwap) {
                    break;
                }

                i++;
            }

        }else{

            throw new NullPointerException("There is no any products in that shop. ");

        }
    }


    public Product getMostExpensiveProduct(){

        Product mostExpensiveProduct = null;

        if(!products.isEmpty()){
            double maxPrice = Double.MIN_VALUE;
            for(Product product : products){

                if(product.getPrice() > maxPrice){

                    maxPrice = product.getPrice();
                    mostExpensiveProduct = product;
                }
            }
        }else{
            throw new NullPointerException("There are no any products in shop.");
        }
        return mostExpensiveProduct;
    }

    public int getProductCount(){

        return  this.products.size();
    }

    public int getProductCount2(){

        if(!products.isEmpty()){

            int count = 0;
            Iterator<Product> iterator = products.iterator();
            while ((iterator.hasNext())){
                iterator.next();
                count++;
            }
            return count;

        }

        return  0;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "products=" + products.toString() +
                '}';
    }
}
