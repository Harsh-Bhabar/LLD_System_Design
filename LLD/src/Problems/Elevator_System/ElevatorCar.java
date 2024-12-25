package Problems.Elevator_System;

import Problems.Elevator_System.Constants.Direction;
import Problems.Elevator_System.Constants.ElevatorStatus;

public class ElevatorCar {
    private final int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorStatus status;
    private final InternalButtonPanel buttonPanel;
    private final Doors doors;

    public ElevatorCar(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.status = ElevatorStatus.IDLE;
        this.buttonPanel = new InternalButtonPanel();
        this.doors = new Doors();
    }

    public void moveToFloor(int floor) {
        System.out.println("Elevator " + id + " moving to floor " + floor);
        currentFloor = floor;
        status = ElevatorStatus.ACTIVE;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public ElevatorStatus getStatus() {
        return status;
    }

    public InternalButtonPanel getButtonPanel() {
        return buttonPanel;
    }
}