package designpatterns.structural.adapter;

class OldSystem {
	public String specificRequest() {
		return "Data from Old System";
	}
}

class NewSystem {
	public String request() {
		return "Data from New System";
	}
}

interface Target {
	String request();
}

class Adapter implements Target {
	private OldSystem oldSystem;

	public Adapter(OldSystem oldSystem) {
		this.oldSystem = oldSystem;
	}

	@Override
	public String request() {
		// Translate the request from the new system to the old system
		return oldSystem.specificRequest();
	}
}

// Real-world Adapter Pattern Example: Payment System Integration
class LegacyPaymentGateway {
    public String makePayment(double amount) {
        return "Paid $" + amount + " using Legacy Gateway";
    }
}

interface PaymentProcessor {
    String pay(double amount);
}

class PaymentAdapter implements PaymentProcessor {
    private LegacyPaymentGateway legacyGateway;

    public PaymentAdapter(LegacyPaymentGateway legacyGateway) {
        this.legacyGateway = legacyGateway;
    }

    @Override
    public String pay(double amount) {
        // Adapt the modern pay() call to the legacy makePayment()
        return legacyGateway.makePayment(amount);
    }
}

class ModernPaymentProcessor implements PaymentProcessor {
    @Override
    public String pay(double amount) {
        return "Paid $" + amount + " using Modern Processor";
    }
}

public class AdapterPatternExample {
	
	public static void main(String[] args) {
		OldSystem oldSystem = new OldSystem();
		Target adapter = new Adapter(oldSystem);

		// Client code works with the Target interface
		System.out.println(adapter.request());
		
		NewSystem newSystem = new NewSystem();
		System.out.println(newSystem.request());

        // Real-world Adapter Pattern usage: Payment System Integration
        LegacyPaymentGateway legacyGateway = new LegacyPaymentGateway();
        PaymentProcessor legacyAdapter = new PaymentAdapter(legacyGateway);
        System.out.println(legacyAdapter.pay(100.0));

        PaymentProcessor modernProcessor = new ModernPaymentProcessor();
        System.out.println(modernProcessor.pay(100.0));
	}

}