package Problems.Book_My_Show;

import Problems.Book_My_Show.ENUMS.PaymentStatus;
import Problems.Book_My_Show.ENUMS.PaymentType;

public class Payment {
    private int id;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;
    private int version; // For optimistic locking

    public Payment(int id, PaymentStatus paymentStatus, PaymentType paymentType) {
        this.id = id;
        this.paymentStatus = paymentStatus;
        this.paymentType = paymentType;
        this.version = 0; // Initialize version
    }

    // Public method to process payment
    public synchronized boolean processPayment() {
        int currentVersion = this.version; // Capture the current version
        // Simulate payment gateway processing
        boolean paymentGatewaySuccess = simulatePaymentGateway();

        if (paymentGatewaySuccess) {
            // Attempt to update payment status with optimistic locking
            return this.updatePaymentStatus(PaymentStatus.SUCCESS, currentVersion);
        } else {
            // Payment failed
            return this.updatePaymentStatus(PaymentStatus.FAILED, currentVersion);
        }
    }

    // Private method to simulate payment gateway processing
    private boolean simulatePaymentGateway() {
        // Simulate a random success or failure for the payment gateway
        return true;//Math.random() > 0.2; // 80% success rate
    }

    // Optimistic concurrency update
    public synchronized boolean updatePaymentStatus(PaymentStatus newStatus, int expectedVersion) {
        if (this.version != expectedVersion) {
            // Conflict detected
            System.out.println("Optimistic lock conflict detected for Payment ID: " + this.id);
            return false;
        }
        this.paymentStatus = newStatus;
        this.version++; // Increment version after successful update
        System.out.println("Payment ID: " + this.id + " updated to " + newStatus + " with version: " + this.version);
        return true;
    }

    // Getter methods for encapsulation
    public int getId() {
        return this.id;
    }

    public PaymentStatus getPaymentStatus() {
        return this.paymentStatus;
    }

    public PaymentType getPaymentType() {
        return this.paymentType;
    }

    public int getVersion() {
        return this.version;
    }
}
