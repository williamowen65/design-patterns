public class BillingSupportHandler extends SupportHandler {
    @Override
    protected boolean canHandle(SupportRequest request) {
        return request.type() == SupportRequest.Type.BILLING;
    }

    @Override
    protected void process(SupportRequest request) {
        System.out.println("Billing support handled: " + request.description());
    }
}
