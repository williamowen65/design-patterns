public class InterpreterDemo {
    public static void main(String[] args) {
        // Represents: (10 + 5) - 3
        Expression expression = new SubtractExpression(
                new AddExpression(
                        new NumberExpression(10),
                        new NumberExpression(5)),
                new NumberExpression(3));

        System.out.println("(10 + 5) - 3 = " + expression.interpret());
    }
}
