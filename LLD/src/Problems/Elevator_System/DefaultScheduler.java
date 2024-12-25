package Problems.Elevator_System;

import java.util.List;

public class DefaultScheduler implements SchedulingAlgorithm {
    private final List<ElevatorCar> elevators;

    public DefaultScheduler(List<ElevatorCar> elevators) {
        this.elevators = elevators;
    }

    @Override
    public void assignRequest(Request request) {
        // Assign to the nearest elevator
        ElevatorCar selectedElevator = elevators.get(0);
        int minDistance = Math.abs(selectedElevator.getCurrentFloor() - request.getFloor());

        for (ElevatorCar elevator : elevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - request.getFloor());
            if (distance < minDistance) {
                selectedElevator = elevator;
                minDistance = distance;
            }
        }

        selectedElevator.moveToFloor(request.getFloor());
    }
}