package Project.Payments;

public enum PaymentMethod {
    PHYSICAL("Physical"),
    EWALLET("E-Wallet"),
    CARD("Card"),
    BANKTRANSFER("Bank Transfer");

    private String PaymentMethod;

    PaymentMethod(String PaymentMethod) {this.PaymentMethod = PaymentMethod;}

    public String getPaymentMethod() {
        return PaymentMethod;
    }
}
