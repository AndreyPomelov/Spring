package demo;

import demo.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // Получаем экземпляр корзины из контекста
        Cart cart = context.getBean(Cart.class);
        // Добавляем в корзину все доступные продукты
        cart.addAllProducts();
        // Добавляем в корзину ещё один продукт по его ИД
        cart.addProductByID(1);
        // Удаляем из корзины продукт по его ИД
        cart.deleteProductByID(3);
        // Выводим содержимое корзины в консоль
        cart.showCart();
        // Следующая строка выводит пустую корзину, т.к. корзина создаётся новая при каждом запросе.
        context.getBean(Cart.class).showCart();
    }
}
