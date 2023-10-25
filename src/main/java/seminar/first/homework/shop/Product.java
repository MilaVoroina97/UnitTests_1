package seminar.first.homework.shop;

public class Product {

    private String name;

    private Integer price;

    private Integer amount;

    public Product(String name,Integer price,Integer amount){

        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return  true;
        if(obj instanceof Product){

            Product product = (Product) obj;
            return product.name.equals(this.name) && product.price == this.price;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
