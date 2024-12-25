package Problems.Elevator_System;

import Problems.Elevator_System.Constants.Direction;

public class ExternalButton {
    private final Direction direction;

    public ExternalButton(Direction direction) {
        this.direction = direction;
    }

    public void press(int floor) {
        System.out.println("External button " + direction + " pressed at floor " + floor);
        Request request = new Request(floor, direction);
        ControllerFactory.getController().handleRequest(request);
    }
}
