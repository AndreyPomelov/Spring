package demo;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Cart {

    private final ProductRepository productRepository;
    private final List<Product> cartList = new ArrayList<>();

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void showCart() {
        cartList.forEach(x -> System.out.printf
                        ("ID: %s, \tName: %s, \tPrice: %s\n", x.getId(), x.getName(), x.getPrice()));
    }

    public void addAllProducts() {
        cartList.addAll(productRepository.getAllProducts());
    }

    public void addProductByID(int id) {
        cartList.add(productRepository.getProductByID(id));
    }

    public void deleteProductByID(int id) {
        for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i).getId() == id) {
                cartList.remove(i);
                break;
            }
        }
    }

    public void emptyCart() {
        cartList.clear();
    }
}
