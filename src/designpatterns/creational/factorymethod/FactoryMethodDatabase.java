package designpatterns.creational.factorymethod;

interface iDatabase{
	void connect();
}

class MySQLDatabase implements iDatabase{
	@Override
	public void connect() {
		System.out.println("Connecting to MySQL Database");
	}
}

class PostgreSQLDatabase implements iDatabase{
	@Override
	public void connect() {
		System.out.println("Connecting to PostgreSQL Database");
	}
}

class OracleDatabase implements iDatabase{
	@Override
	public void connect() {
		System.out.println("Connecting to Oracle Database");
	}
}

class MSSQLDatabase implements iDatabase{
	@Override
	public void connect() {
		System.out.println("Connecting to MS SQL Database");
	}
}


abstract class DatabaseFactory{
	public abstract iDatabase createDatabase();
}


class MySQLDatabaseFactory extends DatabaseFactory{
	@Override
	public iDatabase createDatabase() {
		return new MySQLDatabase();
	}
}

class PostgreSQLDatabaseFactory extends DatabaseFactory{
	@Override
	public iDatabase createDatabase() {
		return new PostgreSQLDatabase();
	}
}

class OracleDatabaseFactory extends DatabaseFactory{
	@Override
	public iDatabase createDatabase() {
		return new OracleDatabase();
	}
}

class MSSQLDatabaseFactory extends DatabaseFactory{
	@Override
	public iDatabase createDatabase() {
		return new MSSQLDatabase();
	}
}

public class FactoryMethodDatabase {
	
	public static void main(String[] args) {
		DatabaseFactory factory = new MySQLDatabaseFactory();
		iDatabase database = factory.createDatabase();
		database.connect();
		
		factory = new PostgreSQLDatabaseFactory();
		database = factory.createDatabase();
		database.connect();
		
		factory = new OracleDatabaseFactory();
		database = factory.createDatabase();
		database.connect();
		
		factory = new MSSQLDatabaseFactory();
		database = factory.createDatabase();
		database.connect();
	}

}
