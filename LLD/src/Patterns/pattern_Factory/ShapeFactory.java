package Patterns.pattern_Factory;

public class ShapeFactory {
    Shape getShape(String shape){
        switch (shape){
            case "circle":
                return new Circle();
            case "square":
                return new Square();
            default:
                return null;
        }
    }
}
