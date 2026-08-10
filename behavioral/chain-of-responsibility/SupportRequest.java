public record SupportRequest(Type type, String description) {
    public enum Type {
        PASSWORD_RESET,
        TECHNICAL,
        BILLING,
        OTHER
    }
}
