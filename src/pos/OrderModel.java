package pos;

import java.util.ArrayList;
import java.util.List;

public class OrderModel {

    static String[] pizzaMenu = {
            "HAWAIIAN MADNESS",
            "PEPPERONI SORPRESA",
            "CHICKEN HAWAIIAN",
            "BACON SAUSAGE BONANZA",
            "BARBECUE BEEF & MUSHROOM"
    };

    private static OrderModel instance;

    static int pizzaPrice = 38;

    static String hawName = "";
    static int hawQuantity = 0;
    static int hawPrice = 0;

    static String pepName = "";
    static int pepQuantity = 0;
    static int pepPrice = 0;

    static String chickenName = "";
    static int chickenQuantity = 0;
    static int chickenPrice = 0;

    static String baconName = "";
    static int baconQuantity = 0;
    static int baconPrice = 0;

    static String bbqName = "";
    static int bbqQuantity = 0;
    static int bbqPrice = 0;

    private OrderModel () {

    }

    public static OrderModel getInstance() {
        if (instance == null) {
            instance = new OrderModel();
        }
        return instance;
    }

    public void setHaw(int quantity) {
        hawName = pizzaMenu[0];
        hawQuantity = quantity;
        hawPrice = pizzaPrice * quantity;
    }

    public void setPep(int quantity) {
        pepName = pizzaMenu[1];
        pepQuantity = quantity;
        pepPrice = pizzaPrice * quantity;
    }

    public void setChicken(int quantity) {
        chickenName = pizzaMenu[2];
        chickenQuantity = quantity;
        chickenPrice = pizzaPrice * quantity;
    }

    public void setBacon(int quantity) {
        baconName = pizzaMenu[3];
        baconQuantity = quantity;
        baconPrice = pizzaPrice * quantity;
    }

    public void setBBQ(int quantity) {
        bbqName = pizzaMenu[4];
        bbqQuantity = quantity;
        bbqPrice = pizzaPrice * quantity;
    }

    public List<Orders> getOrders() {

        List<Orders> ordersList = new ArrayList<>();

        if (hawPrice != 0) {
            ordersList.add(new Orders(hawName, hawQuantity, hawPrice));
        }

        if (pepPrice != 0) {
            ordersList.add(new Orders(pepName, pepQuantity, pepPrice));
        }

        if (chickenPrice != 0) {
            ordersList.add(new Orders(chickenName, chickenQuantity, chickenPrice));
        }

        if (baconPrice != 0) {
            ordersList.add(new Orders(baconName, baconQuantity, baconPrice));
        }

        if (bbqPrice != 0) {
            ordersList.add(new Orders(bbqName, bbqQuantity, bbqPrice));
        }

        return ordersList.isEmpty() ? new ArrayList<>() : ordersList;
    }

    public int getTotalPrice() {
        int totalPrice;

        totalPrice = hawPrice + pepPrice + chickenPrice + baconPrice + bbqPrice;

        return totalPrice;
    }

    public static void clear() {
        hawPrice = 0;
        pepPrice = 0;
        chickenPrice = 0;
        baconPrice = 0;
        bbqPrice = 0;
    }
}
