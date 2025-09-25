package designpatterns.behavioral.templatemethod;
interface DataProcessor{
	void openFile(String filePath);
	void read();
	void process();
	void closeFile();
	
	default void execute(String filePath) {
		openFile(filePath);
		read();
		process();
		closeFile();
	}
}
class CSVDataProcessor implements DataProcessor{
	@Override
	public void openFile(String filePath) {
		System.out.println("Opening CSV file: " + filePath);
	}
	@Override
	public void read() {
		System.out.println("Reading data from CSV file");
	}
	@Override
	public void process() {
		System.out.println("Processing CSV data");
	}
	@Override
	public void closeFile() {
		System.out.println("Closing CSV file");
	}
}

class TextDataProcessor implements DataProcessor{
	@Override
	public void openFile(String filePath) {
		System.out.println("Opening Text file: " + filePath);
	}
	@Override
	public void read() {
		System.out.println("Reading data from Text file");
	}
	@Override
	public void process() {
		System.out.println("Processing Text data");
	}
	@Override
	public void closeFile() {
		System.out.println("Closing Text file");
	}
}

class JSONDataProcessor implements DataProcessor{
	@Override
	public void openFile(String filePath) {
		System.out.println("Opening JSON file: " + filePath);
	}
	@Override
	public void read() {
		System.out.println("Reading data from JSON file");
	}
	@Override
	public void process() {
		System.out.println("Processing JSON data");
	}
	@Override
	public void closeFile() {
		System.out.println("Closing JSON file");
	}
}

class XMLDataProcessor implements DataProcessor{
	@Override
	public void openFile(String filePath) {
		System.out.println("Opening XML file: " + filePath);
	}
	@Override
	public void read() {
		System.out.println("Reading data from XML file");
	}
	@Override
	public void process() {
		System.out.println("Processing XML data");
	}
	@Override
	public void closeFile() {
		System.out.println("Closing XML file");
	}
}


public class TemplateMethodExample {
	
	public static void main(String[] args) {
		DataProcessor csvProcessor = new CSVDataProcessor();
		csvProcessor.execute("data.csv");
		
		System.out.println();
		
		DataProcessor textProcessor = new TextDataProcessor();
		textProcessor.execute("data.txt");
		
		System.out.println();
		
		DataProcessor jsonProcessor = new JSONDataProcessor();
		jsonProcessor.execute("data.json");
		
		System.out.println();
		
		DataProcessor xmlProcessor = new XMLDataProcessor();
		xmlProcessor.execute("data.xml");
	}
}
