package seminar.first.homework.shop;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {

private SortType sortType;

public ProductComparator(SortType sortType){

    this.sortType = sortType;

}
    @Override
    public int compare(Product o1, Product o2) {

        int res = sortType == SortType.Ascending ? o1.getPrice().compareTo(o2.getPrice()) :
                o2.getPrice().compareTo(o1.getPrice());

        if(res == 0){

            return sortType == SortType.Ascending ? CharSequence.compare(o1.getName(),o2.getName()) :
                    CharSequence.compare(o2.getName(),o1.getName());
        }else{
            return  res;
        }
    }
}
