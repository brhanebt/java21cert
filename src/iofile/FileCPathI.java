package iofile;

import java.io.File;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCPathI {
	
	public static void main(String[] args) {
		
		// get current file absolute path
		Path currentAbsolutePath = Paths.get("").toAbsolutePath();
		Path currentRelativePath = Paths.get("");
		
		System.out.println("currentAbsolutePath = " + currentAbsolutePath);
		System.out.println("currentRelativePath = " + currentRelativePath);
		
		Path p1 = Path.of("/java21cert/ReadMe.md");
		File f1 = p1.toFile();
		File f2 = new File("/java21cert/ReadMe.md");
		Path p2 = f2.toPath();
		Path correctFilePath = Paths.get(currentAbsolutePath.toString(), "ReadMe.md");
		
		System.out.println("f1.exists() = " + f1.exists());
		if(f1.exists() && f2.exists()) {
			System.out.println("f1 f2 exists");
			
			if(p1.equals(f1.toPath())) {
				System.out.println("p1 is equal to f1");	
			}
			
			
			if(f1.equals(f2)) {
				System.out.println("f1 is equal to f2");	
			}
		}
		
		Path dir = FileSystems.getDefault().getPath("/java21cert");
		
		System.out.println("dir = " + dir.toAbsolutePath());
		
		Path p4 = dir.resolve("ReadMe.md");
		
		System.out.println("Path dir.resolve(\"ReadMe.md\") = " + p4.toAbsolutePath());
		
		Path p5 = dir.resolve(Paths.get("ReadMe.md"));
		System.out.println("Path dir.resolve(Paths.get(\"ReadMe.md\")) = " + p5.toAbsolutePath());
		
		if(correctFilePath.toFile().exists()) {
			System.out.println("correctFilePath exists");
		}
		File f3 = new File("test.txt");
		if(f3.exists()) {
			System.out.println("f3 exists");
		}
		
		URI uri = p1.toUri();
		
		Path p6 = new File("testdir").mkdir()
				? Paths.get("testdir").toAbsolutePath() 
				: Paths.get("").toAbsolutePath();
		System.out.println("p6 = " + p6);
		
		try {
			Files.createDirectories(p6.resolve("subdir1/subdir2"));
			Files.createFile(p6.resolve("testdir/test2file.txt"));
			System.out.println("Created directories: " + p6.resolve("subdir1/subdir2"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		File f4 = new File("testdir/test2.txt");
		try {
			if (f4.createNewFile()) {
				System.out.println("f4 file created");
			} else {
				System.out.println("f4 file already exists");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}