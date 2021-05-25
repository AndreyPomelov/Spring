package demo;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private final List<Product> productList;

    public ProductRepository(List<Product> productList) {
        this.productList = productList;
    }

    @PostConstruct
    private void addProducts() {
        productList.add(new Product(1, "Lexus UX 200", 2550000));
        productList.add(new Product(2, "Lexus NX 200", 3150000));
        productList.add(new Product(3, "Lexus RX 350", 4850000));
        productList.add(new Product(4, "Lexus LX 570", 8700000));
        productList.add(new Product(5, "Lexus GX 460", 5550000));
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public Product getProductByID(int id) {
        List<Product> list = productList.stream()
                .filter(x -> x.getId() == id)
                .limit(1)
                .collect(Collectors.toList());
        return list.get(0);
    }
}
