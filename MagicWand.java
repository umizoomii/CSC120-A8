import java.util.ArrayList;

public class MagicWand {

    //adding the player's starting settings:
    int size = 10;
    ArrayList inventory = new ArrayList<String>();
    
    /**
     * Constructor for magic wand
     */
    public MagicWand() {
        System.out.println("You have created a magic wand");
    }

    /**
     * Grabs item and adds it to user's inventory
     * @param item
     */
    public void grab(String item) {
        System.out.println("You grabbed a " + item + "!");
        inventory.add(item);
        System.out.println("Inventory: " + inventory);
    }

    /**
     * Checks if user has item and drops it
     * @param item
     * @return
     */
    public String drop(String item) {
        if (inventory.contains(item)) {
            inventory.remove(item);
            System.out.println("You dropped " + item + "!");
        }
        else {
            System.out.println("You should probably grab this item before dropping it.");
        }
        System.out.println("Inventory: " + inventory);
        return item;
    }

    /**
     * Examines item
     * @param item
     */
    void examine(String item) {
        if (inventory.contains(item)) {
            System.out.println("Examining " + item + "... wow, it's shiny!");
        }
        else {
            System.out.println("You need to grab this item before you examine it...");
        }
    }

    /**
     * Checks if user has item and uses it to grow and adds gold to inventory
     * @param item
     */
    void use(String item) {
        if (inventory.contains(item)) {
            System.out.println("Using " + item);
            size += 15;
            inventory.add("GOLD COINS");
            System.out.println("Woah! It made you grow up to " + size + " jack-o-meters!");
            System.out.println("Inventory: " + inventory);
        }
        else {
            size -= 5;
            System.out.println("You shrank down to " + size + "for trying to use an item you don't have...");
        }
    }

    /**
     * Allows the user to walk any direction but West
     * @param direction
     * @return boolean
     */
    boolean walk(String direction) {
        if(direction == "West") {
            System.out.println("That direction is forbidden...try another one");
            return false;
        }
        else {
            System.out.println("You are currently walking " + direction);
            return true;
        }
    }

    /**
     * Allows the user to fly up to 100 zorklomiters at a time
     * @param x
     * @param y
     * @return boolean
     */
    boolean fly(int x, int y) {
        if(x + y >= 100) {
            System.out.println("You may only fly 100 zorklomiters at a time");
            return false;
        }
        else {
            System.out.println("You are currently flying " + (x + y) + "zorklomiters!");
            return true;
        }
    }

    /**
     * Shrinks the user down to 1 at the smallest
     * @return size
     */
    Number shrink() {  
        if(size > 1) {
            System.out.println("Woah! You're shrinking!");
            size -=1;
        }
        else {
            System.out.println("You're too small! You can't shrink anymore. Why don't you try growing?");
        }
        return size;
    }

    /**
     * Lets the user grow up to 14
     * @return size
     */
    Number grow() {
        if(size < 15) {
            System.out.println("You're growing...");
            size -=1;
        }
        else {
            System.out.println("Too big! You can't grow anymore unless you shrink first or use an item.");
        }
        return size;
    }

    /**
     * prints some ASCII art!
     */
    void rest() {
        System.out.println("[{-_-}] ZZZzz zz z...take a break...[{-_-}] ZZZzz zz z...");
    }
    
    /**
     * resets the user's size
     */
    void undo() {
        size = 10;
        System.out.println("You've gone back to normal size!");
    }


    /*main for testing */
    public static void main(String[] args) {
        MagicWand umizoomi = new MagicWand();
        umizoomi.grab("pebble");
        umizoomi.grab("lollipop");
        umizoomi.grab("umbrella");
        umizoomi.drop("pebble");
        umizoomi.examine("sand dollar");
        umizoomi.use("umbrella");
        umizoomi.rest();
    }
}


