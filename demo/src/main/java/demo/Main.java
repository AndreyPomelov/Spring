package demo;

import demo.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class Main {

    private Cart cart;
    private final CartFactory cartFactory;
    private final ProductRepository repository;
    private BufferedReader in;

    public Main(Cart cart, CartFactory cartFactory, ProductRepository repository) {
        this.cart = cart;
        this.cartFactory = cartFactory;
        this.repository = repository;
    }

    // Метод, выводящий базовую информацию в консоль
    private void showInfo() {
        // Показываем прайс-лист
        System.out.println("\nПрайс-лист:");
        repository.getAllProducts().forEach(x -> System.out.printf
                ("ID: %s, \tName: %s, \tPrice: %s\n", x.getId(), x.getName(), x.getPrice()));
        // Показываем текущую корзину
        System.out.println("\nВаша заказ:");
        cart.showCart();
        // Показываем пользовательское меню
        System.out.println("\nВыберите действие:\n" +
                "1. Добавить товар в корзину по ID\n" +
                "2. Удалить товар из корзины по ID\n" +
                "3. Добавить все товары в корзину\n" +
                "4. Очистить корзину\n" +
                "5. Выход");
    }

    // Метод, обрабатывающий выбор пользователя в меню
    private void inputHandler(int input) {
        try {
            switch (input) {
                case (1):
                    // Ввод ID товара и его добавление в корзину
                    System.out.println("\nВведите ID товара");
                    input = Integer.parseInt(in.readLine());
                    cart.addProductByID(input);
                    break;
                case (2):
                    // Ввод ID товара и его удаление из корзины
                    System.out.println("\nВведите ID товара");
                    input = Integer.parseInt(in.readLine());
                    cart.deleteProductByID(input);
                    break;
                case (3):
                    // Добавление в корзину всех товаров
                    cart.addAllProducts();
                    break;
                case (4):
                    // Очистка корзины
                    cart.emptyCart();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void start() {
        cart = cartFactory.getCart();
        in = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                // Выводим в консоль информацию (прайс, корзина, меню)
                showInfo();
                int input;
                do {
                    // Пользователь вводит выбранный пункт меню
                    input = Integer.parseInt(in.readLine());
                } while (input < 1 || input > 5);
                // Выход из приложения, если пользователь выбрал выход
                if (input == 5) break;
                // Вызов метода, обрабатывающего ввод пользователя
                inputHandler(input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    }
}
