package designpatterns.creational.singleton;

class SingletonEager {
	private static final SingletonEager instance = new SingletonEager();
	
	private SingletonEager() {
		// private constructor to prevent instantiation
	}
	
	public static SingletonEager getInstance() {
		return instance;
	}
}

class SingletonLazy {
	private static SingletonLazy instance;
	
	private SingletonLazy() {
		// private constructor to prevent instantiation
	}
	
	public static SingletonLazy getInstance() {
		if(instance == null) {
			instance = new SingletonLazy();
		}
		return instance;
	}
}

class SingletonLazyThreadSafe {
	private static SingletonLazyThreadSafe instance;
	
	private SingletonLazyThreadSafe() {
		// private constructor to prevent instantiation
	}
	
	public static synchronized SingletonLazyThreadSafe getInstance() {
		if(instance == null) {
			instance = new SingletonLazyThreadSafe();
		}
		return instance;
	}
}

class SigletonLazySynchronizedBlock { // also known as Double-Checked Locking
	//why is it known as double-checked locking? 
	// because we are checking if instance is null twice, once before entering the synchronized block and once inside the synchronized block.
	// why is it important to check again inside the synchronized block?
	// because multiple threads can enter the first if block at the same time, but only one thread can enter the synchronized block at a time.
	private static SigletonLazySynchronizedBlock instance;
	
	private SigletonLazySynchronizedBlock() {
		// private constructor to prevent instantiation
	}
	
	public static SigletonLazySynchronizedBlock getInstance() {
		if(instance == null) {
			synchronized (SigletonLazySynchronizedBlock.class) {
				if(instance == null) {
					instance = new SigletonLazySynchronizedBlock();
				}
			}
		}
		return instance;
	}
}

public class SingletonGenericExamples {
	
	public static void main(String[] args) {
		
		// Eager Initialization is the simplest method to create a singleton class.
		// is used when the singleton class is lightweight and does not consume much memory.
		//
		SingletonEager singleton1 = SingletonEager.getInstance();
		SingletonEager singleton2 = SingletonEager.getInstance();
		
		System.out.println("singleton1 == singleton2: "+(singleton1 == singleton2)); // true
		
		// Lazy Initialization is used when the singleton class is heavyweight and consumes a lot of memory.
		SingletonLazy singleton3 = SingletonLazy.getInstance();
		SingletonLazy singleton4 = SingletonLazy.getInstance();
		System.out.println("singleton3 == singleton4: "+(singleton3 == singleton4)); // true
		
		// Lazy Initialization with synchronized method is used when the singleton class is heavyweight and consumes a lot of memory.
		SingletonLazyThreadSafe singleton5 = SingletonLazyThreadSafe.getInstance();
		SingletonLazyThreadSafe singleton6 = SingletonLazyThreadSafe.getInstance();
		System.out.println("singleton5 == singleton6: "+(singleton5 == singleton6)); // true
		
		// Lazy Initialization with synchronized block is used when the singleton class is heavyweight and consumes a lot of memory.
		SigletonLazySynchronizedBlock singleton7 = SigletonLazySynchronizedBlock.getInstance();
		SigletonLazySynchronizedBlock singleton8 = SigletonLazySynchronizedBlock.getInstance();
		System.out.println("singleton7 == singleton8: "+(singleton7 == singleton8)); // true
		
		
		
	}

}
