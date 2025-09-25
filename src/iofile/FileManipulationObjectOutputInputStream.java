package iofile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileManipulationObjectOutputInputStream {
	
	public static void main(String[] args) {
		
		List<ObjectClass> objects = List.of(
				new ObjectClass(1, "Object1", 10.5, "Temp1"),
				new ObjectClass(2, "Object2", 20.5, "Temp2"),
				new ObjectClass(3, "Object3", 30.5, "Temp3")
				);
		File objFile = new File("testdir/objects.txt");
		saveToFile(objects, objFile);
		
		readFromFile(objFile);
		
		
	}
	
	private static void readFromFile(File objFile) {
		
		//try(var reader = new ObjectInputStream(new FileInputStream(objFile))){
		try(var reader = new ObjectInputStream(new BufferedInputStream(new FileInputStream(objFile)))){//preffered way for buffering and performance
			ObjectClass obj;
			List<ObjectClass> objects = new ArrayList<>();
			while(true) {
				try {
					obj = (ObjectClass) reader.readObject();
					objects.add(obj);
					System.out.println("Object read: "+obj);
				} catch (ClassNotFoundException e) {
					System.err.println("ClassNotFoundException: "+e.getMessage());
				} catch (IOException e) {
					// End of file reached
					break;
				}
			}
			
		} catch (IOException e) {
			System.out.println("IOException: "+e.getMessage());
		}
				
	}

	static void saveToFile(List<ObjectClass> objects, File file) {
		try (ObjectOutputStream obfs = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
			for (ObjectClass obj : objects) {
				obfs.writeObject(obj);
			}
			System.out.println("Objects have been serialized to " + file.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("IOException: " + e.getMessage());
		}
	}

}
