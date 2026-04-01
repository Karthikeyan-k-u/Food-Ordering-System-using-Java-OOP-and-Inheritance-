import java.util.*;

// =======================
// Parent Class
// =======================
abstract class FoodItem {
    protected String name;
    protected double basePrice;

    public FoodItem(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    // Abstract method
    public abstract double calculatePrice();

    // Getter method (best practice)
    public String getName() {
        return name;
    }

    public void display() {
        System.out.println(name + " - Rs." + calculatePrice());
    }
}

// =======================
// Child Classes
// =======================
class VegItem extends FoodItem {
    public VegItem(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculatePrice() {
        return basePrice;
    }
}

class NonVegItem extends FoodItem {
    public NonVegItem(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculatePrice() {
        return basePrice + 50;
    }
}

class Dessert extends FoodItem {
    public Dessert(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculatePrice() {
        return basePrice + 20;
    }
}

// =======================
// Order Class
// =======================
class Order {
    private List<FoodItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    // ✅ Updated method
    public void addItem(FoodItem item) {
        items.add(item);
        System.out.println(item.getName() + " added to order! Price: Rs." + item.calculatePrice());
    }

    public void showOrder() {
        double total = 0;
        System.out.println("\n--- Order Details ---");

        for (FoodItem item : items) {
            item.display();
            total += item.calculatePrice();
        }

        System.out.println("Total Bill: Rs." + total);
    }
}

// =======================
// Main Class
// =======================
public class Fulllength2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Order order = new Order();

        while (true) {
            System.out.println("\n HOTEL SRI BHAVAN MENU");
            System.out.println("===== FOOD MENU =====");
            System.out.println("1. Veg Item");
            System.out.println("2. Non-Veg Item");
            System.out.println("3. Dessert");
            System.out.println("4. Show Order");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    order.addItem(new VegItem("Paneer Curry", 200));
                    break;

                case 2:
                    order.addItem(new NonVegItem("Chicken Biryani", 250));
                    break;

                case 3:
                    order.addItem(new Dessert("Ice Cream", 100));
                    break;

                case 4:
                    order.showOrder();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}