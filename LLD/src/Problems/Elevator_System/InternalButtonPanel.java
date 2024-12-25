package Problems.Elevator_System;

import java.util.*;

public class InternalButtonPanel {
    private final Set<Integer> pressedButtons;

    public InternalButtonPanel() {
        this.pressedButtons = new HashSet<>();
    }

    public void pressButton(int floor) {
        pressedButtons.add(floor);
        System.out.println("Button for floor " + floor + " pressed.");
    }

    public Set<Integer> getPressedButtons() {
        return pressedButtons;
    }
}
