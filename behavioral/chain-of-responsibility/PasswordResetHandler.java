public class PasswordResetHandler extends SupportHandler {
    @Override
    protected boolean canHandle(SupportRequest request) {
        return request.type() == SupportRequest.Type.PASSWORD_RESET;
    }

    @Override
    protected void process(SupportRequest request) {
        System.out.println("Password team handled: " + request.description());
    }
}
