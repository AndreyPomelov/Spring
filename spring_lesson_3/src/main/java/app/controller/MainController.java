package app.controller;

import app.repository.Product;
import app.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

/** Класс-контролллер
 *
 * @author Andrey Pomelov
 * @version 1.0-SNAPSHOT
 */
@Controller
@RequestMapping("/")
public class MainController {

    /** Ссылка на хранилище продуктов */
    private final ProductRepository productRepository;
    /** Ссылка на список продуктов, получаемый из хранилища */
    private final List<Product> productList;

    /** Конструктор
     *
     * @param productRepository хранилище продуктов
     * @see ProductRepository
     */
    public MainController(ProductRepository productRepository) {
        this.productRepository = productRepository;
        productList = productRepository.getAllProducts();
    }

    /** Метод, принимающий гет-запрос по корневому пути
     *
     * @param model модель, в которую передаётся список продуктов
     * @return имя страницы, передаваемой клиенту
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("products", productList);
        return "index";
    }

    /** Метод, принимающий гет-запрос перехода на страницу
     *
     * с формой для добавления продукта в список
     * @param model модель, в которую передаётся пустой объект
     *              для заполнения его полей через форму
     * @return имя страницы с формой
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add";
    }

    /** Метод, принимающий пост-запрос с данными из заполненной формы
     *
     * @param product экземпляр класса Product с заполненными полями
     * @see Product
     * @return имя страницы с формой
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String save(Product product) {
        productList.add(product);
        return "add";
    }


}
