import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //Method to set up the store and items
    public static Item[] setupStore(){
        Item[] store = new Item[5];
        store[0] = new Item("Milk", 2.50);
        store[1] = new Item("Bread", 1.50);
        store[2] = new Item("Eggs", 3.00);
        store[3] = new Item("Water", 2.00);
        store[4] = new Item("Meat", 4.00);
        return store;
    }
    //Method to create a cart from the command line
    public static ArrayList<Item> createCart(String[] input){
        Item[] store = setupStore();
        ArrayList<Item> cart = new ArrayList<>();
        try{
            for(String user : input){
                int itemIndex = Integer.parseInt(user);//edit for loop
                if(itemIndex >= 0 && itemIndex < store.length){
                    cart.add(store[itemIndex]);
                }
            }
        }catch(NumberFormatException e){
            System.out.println(e + " is not a valid integer");
        }
        if(cart.isEmpty()){
            System.out.println("No valid input in cart");
        }
        return cart;
    }
    //Method to print reciet in order
    public static void printReceiptInOrder(ArrayList<Item> cart){
        double subtotal = 0;
        double salestax = subtotal * 0.05;
        double total = subtotal + salestax;
        System.out.println("Receipt");
        System.out.println("==========================");
        //loop that iterates through the list to print the receipt
        for(Item item : cart){
            System.out.println(item);
            subtotal += item.getItemPrice();
        }
        System.out.println("==========================");
        System.out.println("(a) Subtotal: " + subtotal);
        System.out.println("(b) Sales Tax: 5%");
        System.out.println("(c) Total: " + total);
    }
    //Method to empy the cart in reverse order
    public static void emptyCartReverseOrder(ArrayList<Item> cart){
        System.out.println("Removing all items from the cart in \"Last In First Out\" order");
        while(!cart.isEmpty()){
            Item lastItem = cart.remove(cart.size() - 1);
            System.out.println("Removing: " + lastItem.getItemName());
        }
        System.out.println("Cart has been emptied.");
    }
    public static void main(String[] args){
        ArrayList<Item> cart = createCart(args);
        if(!cart.isEmpty()){
            printReceiptInOrder(cart);
            emptyCartReverseOrder(cart);
        }
    }
}
