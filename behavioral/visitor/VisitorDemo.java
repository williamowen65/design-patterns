import java.util.List;

public class VisitorDemo {
    public static void main(String[] args) {
        List<Shape> shapes = List.of(
                new Circle(2),
                new Rectangle(3, 4));

        DrawingVisitor drawingVisitor = new DrawingVisitor();
        AreaVisitor areaVisitor = new AreaVisitor();

        for (Shape shape : shapes) {
            shape.accept(drawingVisitor);
            shape.accept(areaVisitor);
        }

        System.out.printf("Total area: %.2f%n", areaVisitor.getTotalArea());
    }
}
