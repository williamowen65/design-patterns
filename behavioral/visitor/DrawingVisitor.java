public class DrawingVisitor implements ShapeVisitor {
    @Override
    public void visit(Circle circle) {
        System.out.println("Drawing a circle with radius " + circle.getRadius());
    }

    @Override
    public void visit(Rectangle rectangle) {
        System.out.println("Drawing a " + rectangle.getWidth() + " x "
                + rectangle.getHeight() + " rectangle");
    }
}
