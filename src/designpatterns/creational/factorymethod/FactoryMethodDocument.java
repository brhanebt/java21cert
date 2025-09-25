package designpatterns.creational.factorymethod;


interface Document {
	void open();
	void save();
	void read();
	void close();
}


class WordDocument implements Document {
	@Override
	public void open() {
		System.out.println("Opening Word Document");
	}

	@Override
	public void save() {
		System.out.println("Saving Word Document");
	}

	@Override
	public void read() {
		System.out.println("Reading Word Document");
	}

	@Override
	public void close() {
		System.out.println("Closing Word Document");
	}
}


class PDFDocument implements Document {
	@Override
	public void open() {
		System.out.println("Opening PDF Document");
	}

	@Override
	public void save() {
		System.out.println("Saving PDF Document");
	}

	@Override
	public void read() {
		System.out.println("Reading PDF Document");
	}

	@Override
	public void close() {
		System.out.println("Closing PDF Document");
	}
}


class TextDocument implements Document {
	@Override
	public void open() {
		System.out.println("Opening Text Document");
	}

	@Override
	public void save() {
		System.out.println("Saving Text Document");
	}

	@Override
	public void read() {
		System.out.println("Reading Text Document");
	}

	@Override
	public void close() {
		System.out.println("Closing Text Document");
	}
}


class CSVDocument implements Document {
	@Override
	public void open() {
		System.out.println("Opening CSV Document");
	}

	@Override
	public void save() {
		System.out.println("Saving CSV Document");
	}

	@Override
	public void read() {
		System.out.println("Reading CSV Document");
	}

	@Override
	public void close() {
		System.out.println("Closing CSV Document");
	}
}


abstract class DocumentFactory {
	public abstract Document createDocument();
}

class WordDocumentFactory extends DocumentFactory {
	@Override
	public Document createDocument() {
		return new WordDocument();
	}
}

class PDFDocumentFactory extends DocumentFactory {
	@Override
	public Document createDocument() {
		return new PDFDocument();
	}
}

class TextDocumentFactory extends DocumentFactory {
	@Override
	public Document createDocument() {
		return new TextDocument();
	}
}

class CSVDocumentFactory extends DocumentFactory {
	@Override
	public Document createDocument() {
		return new CSVDocument();
	}
}






public class FactoryMethodDocument {
	
	public static void main(String[] args) {
		DocumentFactory factory = new WordDocumentFactory();
		Document document = factory.createDocument();
		document.open();
		document.read();
		document.save();
		document.close();

		factory = new PDFDocumentFactory();
		document = factory.createDocument();
		document.open();
		document.read();
		document.save();
		document.close();

		factory = new TextDocumentFactory();
		document = factory.createDocument();
		document.open();
		document.read();
		document.save();
		document.close();

		factory = new CSVDocumentFactory();
		document = factory.createDocument();
		document.open();
		document.read();
		document.save();
		document.close();
	}

}
