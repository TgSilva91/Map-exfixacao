package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> candidates = new HashMap<>();
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
				String line = br.readLine();
				
				while(line != null) {
					String[] fields = line.split(";");
					String name = fields[0];
					int votes = Integer.parseInt(fields[1]);
					
					if(candidates.containsKey(name)) {
						int votesCount = candidates.get(name);
						candidates.put(name, votes + votesCount);
					}
					else {
						candidates.put(name, votes);
					}
					
					line = br.readLine();
						
				}
			
			}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		for(String key : candidates.keySet()) {
			System.out.println(key + ": " + candidates.get(key));
		}
		
		sc.close();
	}

}
