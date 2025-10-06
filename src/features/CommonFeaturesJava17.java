package features;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

sealed interface Shape permits Circle, Rectangle, Square{
	public double area();
	
}
non-sealed class Circle implements Shape{
	double radius;
	public Circle(double radius) {
		this.radius=radius;
	}
	@Override
	public double area() {
		return Math.PI * radius * radius;
	}
	
}
non-sealed class Rectangle implements Shape{
	double width;
	double height;
	public Rectangle(double width, double height) {
		this.width=width;
		this.height=height;
	}
	@Override
	public double area() {
		return width*height;
	}
	
	
}
non-sealed class Square implements Shape{
	double width;
	public Square(double width) {
		this.width=width;
	}

	@Override
	public double area() {
		return width*width;
	}
	
}

sealed interface Vehicle permits Car, Motorbike, Bicycle{
	double getMaxSpeed();
}
final class Car implements Vehicle{
	private final String model;
	private final String make;
	private final double maxSpeed;
	

	public Car(String model, String make, double maxSpeed) {
		super();
		this.model = model;
		this.make = make;
		this.maxSpeed = maxSpeed;
	}

	@Override
	public double getMaxSpeed() {
		return 120;
	}
	
}

record Motorbike(String brand, double maxSpeed) implements Vehicle{

	@Override
	public double getMaxSpeed() {
		return maxSpeed;
	}
}

record Bicycle(String brand, double maxSpeed) implements Vehicle{

	@Override
	public double getMaxSpeed() {
		return 30;
	}
	
}

public class CommonFeaturesJava17 {
	
	public static void main(String[] args) {
		
		//sealed, non-sealed to control inheritance sealed, non-sealed, final
		System.out.println("new Car(Toyota,Rav4,135): "+getVehicleInfo(new Car("Toyota","Rav4",135)));
		System.out.println("new Motorbike(Toyota,125): "+getVehicleInfo(new Motorbike("Toyota",125)));
		System.out.println("new Bicycle(Toyota,35): "+getVehicleInfo(new Bicycle("Toyota",35)));
		
		//Enhanced random generator
		var random1 = RandomGenerator.of("L32X64MixRandom");
		random1.ints(2, 0,100)
		.forEach(System.out::println);
		
		RandomGenerator.SplittableGenerator splittableRng = 
				RandomGeneratorFactory.<RandomGenerator.SplittableGenerator>of("L64X128MixRandom").create();
		splittableRng.splits(2)
		.parallel()
		.forEach(rng->{
			System.out.println(Thread.currentThread().getName()+" : "+ rng.nextInt());
		});
		splittableRng.splits(4)
		.parallel()
		.forEach(rng->{
			System.out.println(Thread.currentThread().getName()+" : "+ rng.nextInt());
		});
		
		
	}
	
	private static String getVehicleInfo(Vehicle vehicle) {
		return switch(vehicle) {
			case Car car-> "Car max speed ->"+ car.getMaxSpeed();
			case Motorbike mb-> "Motorbike max speed ->" + mb.getMaxSpeed();
			case Bicycle bc-> "Bike max speed ->"+ bc.getMaxSpeed();
		};
	}

}
