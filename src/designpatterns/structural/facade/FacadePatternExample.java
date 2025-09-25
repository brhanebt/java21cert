package designpatterns.structural.facade;

class AuthenticationService {
	public boolean authenticate(String username, String password) {
		// Simulate authentication logic
		System.out.println("Authenticating user: " + username);
		return "user".equals(username) && "pass".equals(password);
	}
}

class AccountService{
	public void checkFunds(String accountId, double amount) {
		// Simulate fund checking logic
		System.out.println("Checking funds for account: " + accountId + " for amount: " + amount);
	}
	
	public void debit(String accountId, double amount) {
		// Simulate debit logic
		System.out.println("Debiting amount: " + amount + " from account: " + accountId);
	}
	
	public void credit(String accountId, double amount) {
		// Simulate credit logic
		System.out.println("Crediting amount: " + amount + " to account: " + accountId);
	}
}


class NotificationService {
	public void sendNotification(String userId, String message) {
		// Simulate notification logic
		System.out.println("Sending notification to user: " + userId + " with message: " + message);
	}
}

class BankingFacade {
	private AuthenticationService authService;
	private AccountService accountService;
	private NotificationService notificationService;

	public BankingFacade() {
		this.authService = new AuthenticationService();
		this.accountService = new AccountService();
		this.notificationService = new NotificationService();
	}

	public void transferFunds(String username, String password, String fromAccount, String toAccount, double amount) {
		if (authService.authenticate(username, password)) {
			accountService.checkFunds(fromAccount, amount);
			accountService.debit(fromAccount, amount);
			accountService.credit(toAccount, amount);
			notificationService.sendNotification(username, "Transfer of $" + amount + " from " + fromAccount + " to " + toAccount + " completed.");
		} else {
			System.out.println("Authentication failed for user: " + username);
		}
	}
}



public class FacadePatternExample {
	
	public static void main(String[] args) {
		BankingFacade bankingFacade = new BankingFacade();
		bankingFacade.transferFunds("user", "pass", "ACC123","ACC456", 500.00);
		bankingFacade.transferFunds("user", "wrongpass", "ACC123","ACC456", 500.00);
		
		
	}

}
