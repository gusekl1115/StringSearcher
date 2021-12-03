import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringSearcher {
	private String word;
	private String fileName;
	
	// Constructor checks if the initial input argument is search, 
	// then saves the search-word and the filename in private attributes
	public StringSearcher(String input) {
		String[] inputs = input.split(" ");
		if (inputs[0].equalsIgnoreCase("search")) {
			word = inputs[1];
			fileName = inputs[2];
		} else {
			throw new Error("Invalid input arguments");
		}
	}
	
	//Search function that prints the lines containing the specified word
	public void search() throws FileNotFoundException {
		Scanner scan = new Scanner(new File(fileName));
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			if (line.contains(word)) {
				System.out.println(line);
			}
		}
	}
	
	// main method creates Stringsearcher object and executes the task
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringSearcher searcher = new StringSearcher(scan.nextLine());
		try {
			searcher.search();
		} catch (FileNotFoundException e) {
			scan.close();
			e.printStackTrace();
		}
		scan.close();
	}
}
