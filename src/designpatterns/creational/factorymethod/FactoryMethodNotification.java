package designpatterns.creational.factorymethod;

interface Notification{
	void send();
}

class EmailNotification implements Notification{
	@Override
	public void send() {
		System.out.println("Sending Email Notification");
	}
}

class SMSNotification implements Notification{
	@Override
	public void send() {
		System.out.println("Sending SMS Notification");
	}
}

class PushNotification implements Notification{
	@Override
	public void send() {
		System.out.println("Sending Push Notification");
	}
}

abstract class NotificationFactory{
	public abstract Notification createNotification();
}


class EmailNotificationFactory extends NotificationFactory{
	@Override
	public Notification createNotification() {
		return new EmailNotification();
	}
}

class SMSNotificationFactory extends NotificationFactory{
	@Override
	public Notification createNotification() {
		return new SMSNotification();
	}
}


class PushNotificationFactory extends NotificationFactory{
	@Override
	public Notification createNotification() {
		return new PushNotification();
	}
}

public class FactoryMethodNotification {
	
	public static void main(String[] args) {
		NotificationFactory factory = new EmailNotificationFactory();
		Notification notification = factory.createNotification();
		notification.send();
		
		factory = new SMSNotificationFactory();
		notification = factory.createNotification();
		notification.send();
		
		factory = new PushNotificationFactory();
		notification = factory.createNotification();
		notification.send();
	}
}
