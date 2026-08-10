public class ChainDemo {
    public static void main(String[] args) {
        SupportHandler password = new PasswordResetHandler();
        SupportHandler technical = new TechnicalSupportHandler();
        SupportHandler billing = new BillingSupportHandler();

        password.setNext(technical).setNext(billing);

        password.handle(new SupportRequest(
                SupportRequest.Type.PASSWORD_RESET,
                "I forgot my password"));

        password.handle(new SupportRequest(
                SupportRequest.Type.TECHNICAL,
                "The app crashes when I upload a file"));

        password.handle(new SupportRequest(
                SupportRequest.Type.BILLING,
                "I was charged twice"));

        password.handle(new SupportRequest(
                SupportRequest.Type.OTHER,
                "I have a question that does not match any category"));
    }
}
