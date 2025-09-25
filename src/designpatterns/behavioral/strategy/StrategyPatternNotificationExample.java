package designpatterns.behavioral.strategy;
interface NotificationStrategy {
	void sendNotification(String message);
}

class EmailNotification implements NotificationStrategy {
	@Override
	public void sendNotification(String message) {
		System.out.println("Sending Email Notification: " + message);
	}
}

class SMSNotification implements NotificationStrategy {
	@Override
	public void sendNotification(String message) {
		System.out.println("Sending SMS Notification: " + message);
	}
}

class PushNotification implements NotificationStrategy {
	@Override
	public void sendNotification(String message) {
		System.out.println("Sending Push Notification: " + message);
	}
}
class NotificationService {
	private NotificationStrategy strategy;

	public NotificationService(NotificationStrategy strategy) {
		this.strategy = strategy;
	}

	public void setStrategy(NotificationStrategy strategy) {
		this.strategy = strategy;
	}

	public void notify(String message) {
		strategy.sendNotification(message);
	}
}
public class StrategyPatternNotificationExample {
	public static void main(String[] args) {
		NotificationService notificationService = new NotificationService(new EmailNotification());
		notificationService.notify("Welcome to our service!");

		notificationService.setStrategy(new SMSNotification());
		notificationService.notify("Your order has been shipped!");

		notificationService.setStrategy(new PushNotification());
		notificationService.notify("You have a new message!");
	}

}
