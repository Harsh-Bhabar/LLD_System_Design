package Problems.Elevator_System;

import java.util.*;

public class Controller {
    private final SchedulingAlgorithm scheduler;
    private final PriorityQueue<Request> requestQueue;

    public Controller(List<ElevatorCar> elevators) {
        this.scheduler = new DefaultScheduler(elevators);
        this.requestQueue = new PriorityQueue<>((r1, r2) -> r1.getFloor() - r2.getFloor());
    }

    public void handleRequest(Request request) {
        requestQueue.offer(request);
    }

    public void processRequests() {
        while (!requestQueue.isEmpty()) {
            Request request = requestQueue.poll();
            scheduler.assignRequest(request);
        }
    }
}