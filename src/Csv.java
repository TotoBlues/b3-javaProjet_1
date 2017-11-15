import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Csv {
	private String csvPath;
	private String categorieFilter;
	private String etiquetteName;
	private String fichesName;
	public static void readCsv(String file) {
		Path fichierCsv = Paths.get(file); // file descriptor
		try (Stream<String> linesFile = Files.lines(fichierCsv)) {
			linesFile.forEach(item -> ParsingCsv.returnCsv(item));
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
