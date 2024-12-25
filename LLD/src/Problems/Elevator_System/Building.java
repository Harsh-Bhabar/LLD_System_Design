package Problems.Elevator_System;


import Problems.Elevator_System.Constants.Direction;

import java.util.*;
public class Building {
    private final List<Floor> floors;
    private final List<ElevatorCar> elevators;

    public Building(int numberOfFloors, int numberOfElevators) {
        floors = new ArrayList<>();
        elevators = new ArrayList<>();

        for (int i = 0; i < numberOfFloors; i++) {
            floors.add(new Floor(i));
        }

        for (int i = 0; i < numberOfElevators; i++) {
            elevators.add(new ElevatorCar(i));
        }

        Controller controller = new Controller(elevators);
        ControllerFactory.initializeController(controller); // Initialize the controller singleton
    }

    public void startSimulation() {
        // Simulate external button presses
        floors.get(2).pressExternalButton(Direction.UP);
        floors.get(5).pressExternalButton(Direction.DOWN);

        // Simulate elevator movement
        ControllerFactory.getController().processRequests();
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public List<ElevatorCar> getElevators() {
        return elevators;
    }
}