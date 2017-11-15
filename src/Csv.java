import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Csv {
	public static void readCsv(String file) {
		Path fichierCsv = Paths.get(file);
		try (Stream<String> linesFile = Files.lines(fichierCsv)) {
			linesFile.forEach(System.out::println);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		
	}
	
	public static void main(String [] args) {
			System.out.println(args[0]);
		Csv.readCsv(args[0]);
	}
}
