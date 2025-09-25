package iofile;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileManipulationUserInteraction {
	
	public static void main(String[] args) {
		var reader = new Scanner(System.in);
		
		System.out.print("Input to add to file: ");
		String input = reader.nextLine();		
		System.out.println("You entered: "+input);
//		reader.close();
		
		var bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("Input to add to file using BufferedReader: ");
			String input2 = bufferedReader.readLine();
			System.out.println("You entered: "+input2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//bufferedReader.close();
				//reader.close();
			} catch (Exception e) {
				System.err.println("Exception closing readers: "+e.getMessage());
			}
		}
//		var reader2 = new BufferedReader(new InputStreamReader(System.in));
//		try(reader2){
//			System.out.print("Input to add to file using try-with-resources BufferedReader: ");
//			String input3 = reader2.readLine();
//			System.out.println("You entered: "+input3);
//		}
//		catch(Exception e) {
//			System.err.println("Exception closing BufferedReader: "+e.getMessage());
//		}

		// reader2.close(); //reader2 is already closed by try-with-resources
		
		try(var err= System.err){
			err.println("Using try-with-resources to manage System.err");
		}
		catch(Exception e) {
			System.err.println("Exception closing System.err: "+e.getMessage());
		}
		
		System.out.println("Before closing System.out");
		
//		try(var out= System.out){
//			out.println("Using try-with-resources to manage System.out");
//		}
//		catch(Exception e) {
//			System.err.println("Exception closing System.out: "+e.getMessage());
//		}
//		System.out.println("End of main");//unreachable code after closing System.out?
		
		Console console = System.console();
		if(console != null) {
			String userInput = console.readLine("Input using Console: ");
			console.printf("You entered: %s%n", userInput);
		} else {
			System.out.println("No console available");
		}
		
		if(console==null) {
			System.err.println("Console is null, likely running in an IDE that does not support console.");
		} else {
			char[] password = console.readPassword("Enter your password: ");
			console.printf("Your password is %d characters long. Minimum %d allowed ", password.length, 8);
		}
		
	}

}
