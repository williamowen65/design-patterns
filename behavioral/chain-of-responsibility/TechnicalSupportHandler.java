public class TechnicalSupportHandler extends SupportHandler {
    @Override
    protected boolean canHandle(SupportRequest request) {
        return request.type() == SupportRequest.Type.TECHNICAL;
    }

    @Override
    protected void process(SupportRequest request) {
        System.out.println("Technical support handled: " + request.description());
    }
}
