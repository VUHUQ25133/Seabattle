package GameMidTerm;
import java.util.Arrays;
//Ship.java
public class Ship {
    private ShipType type;
    public boolean[] shipParts;

    public Ship(ShipType type) {
        this.type = type;
        this.shipParts = new boolean[type.getSize()];
        Arrays.fill(shipParts, false);
    }

    public ShipType getType() {
        return type;
    }

    public boolean isSunk() {
        for (boolean part : shipParts) {
            if (!part) {
                return false;
            }
        }
        return true;
    }

    public void hit() {
        for (int i = 0; i < shipParts.length; i++) {
            if (!shipParts[i]) {
                shipParts[i] = true;
                return;
            }
        }
    }
}