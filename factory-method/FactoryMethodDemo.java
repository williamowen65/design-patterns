public class FactoryMethodDemo {
    public static void main(String[] args) {
        NotificationCreator emailCreator = new EmailNotificationCreator();
        emailCreator.notifyUser("Your order has shipped.");

        NotificationCreator smsCreator = new SmsNotificationCreator();
        smsCreator.notifyUser("Your verification code is 123456.");
    }
}
