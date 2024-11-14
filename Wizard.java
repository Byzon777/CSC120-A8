/**
 * Represents a wizard character inspired by the Harry Potter series.
 * This wizard can interact with magical items, move in directions, grow or shrink,
 * and perform other magical activities.
 */
public class Wizard implements Contract {

    // The current item that the wizard is holding
    private String currentItem;

    // The wizard's current position (x, y)
    private int posX;
    private int posY;

    // The wizard's size scale (1 = normal size, < 1 = shrunken, > 1 = grown)
    private double size;

    // The wizard's knowledge level and health
    private int knowledgeLevel;
    private int health;

    /**
     * Constructs a new Wizard instance with a default position and size.
     */
    public Wizard() {
        this.currentItem = null;
        this.posX = 0;
        this.posY = 0;
        this.size = 1.0;
    }

    /**
     * Picks up an item and holds it.
     * 
     * @param item The name of the item to grab.
     */
    @Override
    public void grab(String item) {
        this.currentItem = item;
        System.out.println("Wizard has grabbed " + item + ".");
    }

    /**
     * Drops the current item if holding one.
     * 
     * @param item The name of the item to drop.
     * @return The name of the item that was dropped, or null if no item was held.
     */
    @Override
    public String drop(String item) {
        if (this.currentItem != null && this.currentItem.equals(item)) {
            String droppedItem = this.currentItem;
            this.currentItem = null;
            System.out.println("Wizard has dropped " + item + ".");
            return droppedItem;
        } else {
            System.out.println("Wizard is not holding " + item + ".");
            return null;
        }
    }

    /**
     * Examines an item closely, describing it.
     * 
     * @param item The name of the item to examine.
     */
    @Override
    public void examine(String item) {
        System.out.println("Wizard examines " + item + " closely. It looks magical!");
    }

    /**
     * Uses an item if it's currently held.
     * 
     * @param item The name of the item to use.
     */
    @Override
    public void use(String item) {
        if (this.currentItem != null && this.currentItem.equals(item)) {
            System.out.println("Wizard uses " + item + ". A spell is cast!");
        } else {
            System.out.println("Wizard doesn't have " + item + " to use.");
        }
    }

    /**
     * Walks in a specified direction.
     * 
     * @param direction The direction to walk ("north", "south", "east", "west").
     * @return true if the wizard moves successfully; false otherwise.
     */
    @Override
    public boolean walk(String direction) {
        switch (direction.toLowerCase()) {
            case "north": posY += 1; break;
            case "south": posY -= 1; break;
            case "east": posX += 1; break;
            case "west": posX -= 1; break;
            default:
                System.out.println("Invalid direction! Use north, south, east, or west.");
                return false;
        }
        System.out.println("Wizard walks " + direction + " to (" + posX + ", " + posY + ").");
        return true;
    }

    /**
     * Flies to a specified coordinate (x, y).
     * 
     * @param x The x-coordinate to fly to.
     * @param y The y-coordinate to fly to.
     * @return true if the wizard flies successfully; false otherwise.
     */
    @Override
    public boolean fly(int x, int y) {
        posX = x;
        posY = y;
        System.out.println("Wizard flies to (" + posX + ", " + posY + ").");
        return true;
    }

    /**
     * Shrinks the wizard's size by half.
     * 
     * @return The new size of the wizard after shrinking.
     */
    @Override
    public Number shrink() {
        size /= 2;
        System.out.println("Wizard shrinks to size " + size + ".");
        return size;
    }

    /**
     * Grows the wizard's size by a factor of 2.
     * 
     * @return The new size of the wizard after growing.
     */
    @Override
    public Number grow() {
        size *= 2;
        System.out.println("Wizard grows to size " + size + ".");
        return size;
    }

    /**
     * Rests to regain strength.
     */
    @Override
    public void rest() {
        health += 10;
        if (health > 100) health = 100;  // Cap health at 100
        System.out.println("Wizard rests to regain strength.");
    }

    /**
     * Undoes the last action. (Placeholder for undo functionality.)
     */
    @Override
    public void undo() {
        System.out.println("Wizard attempts to undo the last action.");
    }


    /**
     * Attacks with the currently held item, if possible.
     * 
     * @param item The name of the item to use in the attack.
     */
    public void attack(String item) {
        if (this.currentItem != null && this.currentItem.equals(item)) {
            System.out.println("Wizard attacks with " + item + "! A powerful spell is cast.");
        } else {
            System.out.println("Wizard doesn't have " + item + " to attack with.");
        }
    }


    /**
     * Increases the wizard's knowledge level, representing learning.
     * 
     * @return The new knowledge level after learning.
     */
    public Number learn() {
        knowledgeLevel += 1;
        System.out.println("Wizard learns something new! Knowledge level is now " + knowledgeLevel + ".");
        return knowledgeLevel;
    }


    /**
     * Allows the wizard to eat, which restores health.
     * 
     * @return The new health level after eating.
     */
    public Number eat() {
        health += 10;
        if (health > 100) health = 100;  // Cap health at 100
        System.out.println("Wizard eats and regains health. Health is now " + health + ".");
        return health;
    }
}
