package app.repository;

import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** Класс-хранилище списка продуктов
 *
 * @author Andrey Pomelov
 * @version 1.0-SNAPSHOT
 */
@Repository
public class ProductRepository {

    /** Переменная, содержащая ссылку на список продуктов */
    private final List<Product> productList = new ArrayList<>();

    /** Метод, вызываемый автоматически при развёртывании приложения.
     * Заполняет список продуктов первоначальными данными в демонстрационных целях.
     */
    @PostConstruct
    public void init() {
        productList.add(new Product(1, "Honda Civic", 2000000));
        productList.add(new Product(2, "Honda CR-V", 2800000));
        productList.add(new Product(3, "Honda Pilot", 4100000));
    }

    /** Метод, возвращающий список всех продуктов.
     *
     * @see Product
     * @return список продуктов
     */
    public List<Product> getAllProducts() {
        return new ArrayList<>(productList);
    }

    /** Метод, возвращающий продукт по его идентификатору.
     * Не используется. Присутстует, потому что есть в задании.
     *
     * @see Product
     * @param id идентификатор продукта
     * @return найденный по идентификатору продукт
     */
    public Product getProduct(int id) {
        List<Product> list = productList.stream()
                .filter(x -> x.getId() == id)
                .limit(1)
                .collect(Collectors.toList());
        return list.get(0);
    }
}
