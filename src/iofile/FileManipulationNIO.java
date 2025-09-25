package iofile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileManipulationNIO {
	
	public static void main(String[] args) {
		Path src = Path.of("testdir/test.txt");
		Path dst = Path.of("testdir/test2.txt");
		
		//Files newBufferedReader
		//Files newBufferedWriter
		//Files write
		readFromF1ToF2(src,dst);

		
		readyFileNIOLines(src.toFile());
		//readFileNIOBytes(src);
		
		readFileLinesNIOLazily(src.toFile());
		
		// read and write file using NIO
		File f = Path.of("testdir/file7.txt").toFile();
		readAndWriteFileNIO(src.toFile(), f);
	}

	private static void readFromF1ToF2(Path src, Path dst) {
		try (var reader = Files.newBufferedReader(src);
				var writer = Files.newBufferedWriter(dst)) {
			String line;
			while ((line = reader.readLine()) != null) {
				writer.append(line);
				//writer.write(line);
				// For demonstration, print the first 10 characters of each line
				System.out.println("Writing line: " + line.substring(0, Math.min(10, line.length())) + "...");
				writer.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static void readAndWriteFileNIO(File src, File f) {
		System.out.println("Reading and writing file using NIO Files.readAllLines() and Files.write()");
		try {
			List<String> lines = Files.readAllLines(src.toPath());
			Files.write(f.toPath(), lines);
		} catch (IOException e) {
			System.out.println("IOException: "+e.getMessage());
		}
		
		try {
			Files.write(f.toPath(), List.of("New Line 1", "New Line 2"), java.nio.file.StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("IOException: "+e.getMessage());
		}
		
		System.out.println("READ AND Write line by line using NIO Files.write()");
		try {
			Files.lines(src.toPath()).forEach(line->{
				try {
					Files.write(f.toPath(), List.of(line), java.nio.file.StandardOpenOption.APPEND);
				} catch (IOException e) {
					System.out.println("IOException: "+e.getMessage());
				}
			});
		} catch (IOException e) {
			System.out.println("IOException: "+e.getMessage());
		}

		
	}



	private static void readFileLinesNIOLazily(File src) {
		System.out.println("Reading file using NIO Files.lines() lazily");
		try {
			Files.lines(src.toPath()).map(s->s.substring(0, s.length()/3)).forEach(System.out::println);
		} catch (IOException e) {
			System.out.println("IOException: "+e.getMessage());
		}
		
	}



	private static void readFileNIOBytes(File src) {
		System.out.println("Reading file using NIO Files.readAllBytes()");
		try {
			byte[] bytes = Files.readAllBytes(src.toPath());
			String content = new String(bytes);
			System.out.println(content);
		} catch (IOException e) {
			System.out.println("IOException: "+e.getMessage());
		}
	}



	private static void readyFileNIOLines(File src) {
		
		System.out.println("Reading first word from a file using NIO Files.readAllLines()");
		try {
			Files.readAllLines(src.toPath())
			.stream().map(s->s.split(" ")[0])
			.forEach(System.out::println);
			
		} catch (IOException e) {
			System.out.println("IOException: "+e.getMessage());
		}
		
	}

}
