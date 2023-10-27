package seminar.first.homework.shop;

public class Product {

    private String name;

    private Double price;

    private Double amount;

    public Product(String name,Double price,Double amount){

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return  true;
        if(obj instanceof Product){

            Product product = (Product) obj;
            return product.name.equals(this.name) && product.price.equals(this.price);
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
