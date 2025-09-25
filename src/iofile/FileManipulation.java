package iofile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileManipulation {
	
	public static void main(String[] args) {
		File src = Path.of("testdir/test.txt").toFile();
		File dst = Path.of("testdir/test2.txt").toFile();
		
		//BufferedReader FileReader
		//BufferedReader
		readFromF1ToF2(src,dst);
		
		//BufferedReader FileReader
		//PrintWriter FileWriter

		File dst2 = Path.of("testdir/test2file.txt").toFile();
		readFromF2ToF2(src,dst2);
		
		//BufferedInputStream FileInputStream
		//BufferedOutputStrea FileOutputStream
		//readAllBytes
		File dst3 = Path.of("testdir/testfile.txt").toFile();
		readFileAllBytes(src,dst3);
		
		//BufferedInputStream FileInputStream
		//BufferedOutputStrea FileOutputStream
		//read
		File dst4 = Path.of("testdir/testfile.txt").toFile();
		readFileByte(src,dst4);
		

		
		//BufferedInputStream FileInputStream
		//BufferedOutputStrea FileOutputStream
		//read
		File dst5 = Path.of("testdir/testfile5.txt").toFile();
		readFileByteWithBuffer(src,dst5);
		
		
		//ObjectInputStream FileInputStream
		//ObjectOutputStream FileOutputStream
		//Object Serialization
		File objFile = Path.of("testdir/objectfile.txt").toFile();
		
		fileObjectManipulation(objFile);
		
		
		//FIles NIO
		
	}



	



	private static void fileObjectManipulation(File objFile) {
		//create file if it does not exist
		System.out.println("File object does not exist: "+!objFile.exists());
		if(!objFile.exists()) {
			try {
				objFile.createNewFile();
			} catch (IOException e) {
				System.out.println("IOException: "+e.getMessage());
			}
		}
		
		List<ObjectClass> objects = List.of(
				new ObjectClass(1, "Object 1", 10.5, "Temp Data 1"),
				new ObjectClass(2, "Object 2", 20.5, "Temp Data 2"),
				new ObjectClass(3, "Object 3", 30.5, "Temp Data 3")
				);
		
		try(var writer = new ObjectOutputStream(new FileOutputStream(objFile))){
			for(ObjectClass obj: objects) {
				System.out.println("Writing object: "+obj);
				writer.writeObject(obj.toString());
				writer.flush();
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: "+e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException: "+e.getMessage());
		}
		
		
		//read object from file
//		try(var reader = new ObjectInputStream(new FileInputStream(objFile))){
//			ObjectClass obj;
//			while(true) {
//				try {
//					obj = (ObjectClass) reader.readObject();
//					System.out.println("Object read: "+obj);
//				} catch (ClassNotFoundException e) {
//					System.out.println("ClassNotFoundException: "+e.getMessage());
//				} catch (IOException e) {
//					System.out.println("End of file reached or IOException: "+e.getMessage());
//					break;
//				}
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println("FileNotFoundException: "+e.getMessage());
//		} catch (IOException e) {
//			System.out.println("IOException: "+e.getMessage());
//		}
		
		//read file as bytes
		try(var reader = new BufferedInputStream(new FileInputStream(objFile));){
			byte[] buffer = new byte[1024];
			int bytesRead;
			while((bytesRead = reader.read(buffer))!=-1) {
				System.out.println("Bytes read: "+bytesRead);
				String data = new String(buffer,0,bytesRead);
				System.out.println("Data read: "+data);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: "+e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException: "+e.getMessage());
		}
		
	}



	private static void readFileByteWithBuffer(File src, File dst) {
		//create file if it does not exist
		System.out.println("File does not exist: "+!dst.exists());
		if(!dst.exists()) {
			try {
				dst.createNewFile();
			} catch (IOException e) {
				System.out.println("IOException: "+e.getMessage());
			}
		}
		try(var reader = new BufferedInputStream(new FileInputStream(src));
				var writer = new BufferedOutputStream(new FileOutputStream(dst));){
			byte[] buffer = new byte[1024];
			int bytesRead;
			while((bytesRead = reader.read(buffer))!=-1) {
				writer.write(buffer,0,bytesRead);
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: "+e.getMessage());
			
		} catch (IOException e) {
			System.out.println("IOException: "+e.getMessage());
		}
	
	}



	private static void readFileByte(File src, File dst4) {
		try(var reader = new BufferedInputStream(new FileInputStream(src));
				var writer = new BufferedOutputStream(new FileOutputStream(dst4));){
			int byteData;
			while((byteData = reader.read())!=-1) {
				writer.write(byteData);
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: "+e.getMessage());
			
		} catch (IOException e) {
			System.out.println("IOException: "+e.getMessage());
		}
	}



	private static void readFileAllBytes(File src, File dst) {
		try(var reader = new BufferedInputStream(new FileInputStream(src));
				var writer= new BufferedOutputStream(new FileOutputStream(dst))){
			byte[] bytes = reader.readAllBytes();
			writer.write(bytes);
			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: "+e.getMessage());
			
		} catch (IOException e) {
			System.out.println("IOException: "+e.getMessage());
		}
		
		
	}

	private static void readFromF1ToF2(File src, File dst) {
		try (var reader = new BufferedReader(new FileReader(src));
				var writer = new BufferedWriter(new FileWriter(dst))) {
			String line="";
			while((line=reader.readLine())!=null) {
				writer.append(line);
				writer.append("\n");
				writer.newLine();
				writer.flush();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: "+e.getMessage());
			
		} catch (IOException e) {
			System.out.println("IOException: "+e.getMessage());
		}
		
	}
	


	private static void readFromF2ToF2(File src, File dst) {
			try(var reader = new BufferedReader(new FileReader(src));
					var writer = new PrintWriter(new FileWriter(dst))){
				String line ="";
				while((line=reader.readLine())!=null) {
					writer.println(line);
					writer.flush();
				}
			} catch(FileNotFoundException ex) {
				System.out.println("FileNotFoundException: "+ex.getMessage());
			} catch(IOException e) {
				System.out.println("IOException: "+e.getMessage());
			}
	}

}
