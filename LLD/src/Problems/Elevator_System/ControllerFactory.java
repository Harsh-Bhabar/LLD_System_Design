package Problems.Elevator_System;

public class ControllerFactory {
    private static Controller controller;

    public static void initializeController(Controller newController) {
        if (controller == null) {
            controller = newController;
        }
    }

    public static Controller getController() {
        if (controller == null) {
            throw new IllegalStateException("Controller is not initialized. Call initializeController() first.");
        }
        return controller;
    }
}
