package app.repository;

/** Класс, описывающий продукт
 *
 * @author Andrey Pomelov
 * @version 1.0-SNAPSHOT
 */
public class Product {

    /** Переменная, содержащая идентификатор продукта */
    private int id;
    /** Переменная, содержащая название продукта */
    private String title;
    /** Переменная, содержащая стоимость продукта */
    private double cost;

    /** Конструктор, заполняющий все поля экземпляра класса.
     * Используется для первоначального заполнения листа продуктов
     * в демонстрационных целях.
     * @param id идентификатор продукта
     * @param title название продукта
     * @param cost стоимость продукта
     */
    public Product(int id, String title, double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    /** Конструктор без параметров.
     * Используется для передачи экземпляра класса в модель.
     */
    public Product(){}

    /** Стандартные геттеры и сеттеры */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
