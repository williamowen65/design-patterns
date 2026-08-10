public class TemplateMethodDemo {
    public static void main(String[] args) {
        Beverage coffee = new Coffee();
        Beverage tea = new Tea();

        System.out.println("Making coffee:");
        coffee.prepare();

        System.out.println("\nMaking tea:");
        tea.prepare();
    }
}
