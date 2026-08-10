public class FlyweightDemo {
    public static void main(String[] args) {
        Forest forest = new Forest();

        forest.plantTree(10, 20, "Oak", "green", "rough-bark.png");
        forest.plantTree(15, 25, "Oak", "green", "rough-bark.png");
        forest.plantTree(40, 50, "Oak", "green", "rough-bark.png");
        forest.plantTree(60, 70, "Pine", "dark-green", "pine-bark.png");
        forest.plantTree(65, 75, "Pine", "dark-green", "pine-bark.png");

        forest.draw();

        System.out.println();
        System.out.println("Tree objects: " + forest.getTreeCount());
        System.out.println("Shared TreeType objects: " + TreeTypeFactory.getTypeCount());
    }
}
