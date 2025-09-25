package designpatterns.structural.proxy;

interface Service{
	void request();
}

class ProtectedService implements Service{

	@Override
	public void request() {
		System.out.println("Protected Service request processed.");
	}
	
}

class ServiceProxy implements Service{
	private ProtectedService protectedService;
	private String userRole;
	
	public ServiceProxy(String userRole) {
		this.userRole = userRole;
		this.protectedService = new ProtectedService();
	}

	@Override
	public void request() {
		if("ADMIN".equals(userRole)) {
			protectedService.request();
		}else {
			System.out.println("Access Denied: You do not have permission to access this service.");
		}
	}
	
}

public class ProxyPatternExample {
	public static void main(String[] args) {
		Service adminService = new ServiceProxy("ADMIN");
		adminService.request(); // Should succeed

		Service userService = new ServiceProxy("USER");
		userService.request(); // Should be denied
	}
}
