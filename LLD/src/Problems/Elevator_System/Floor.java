package Problems.Elevator_System;

import Problems.Elevator_System.Constants.Direction;

public class Floor {
    private final int floorNumber;
    private final ExternalButton upButton;
    private final ExternalButton downButton;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.upButton = new ExternalButton(Direction.UP);
        this.downButton = new ExternalButton(Direction.DOWN);
    }

    public void pressExternalButton(Direction direction) {
        if (direction == Direction.UP) {
            upButton.press(floorNumber);
        } else {
            downButton.press(floorNumber);
        }
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
