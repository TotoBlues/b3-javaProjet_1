import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public final class Param {
	private Csv fileCsv = new Csv();
	private String[] args = null;
	private Options options = new Options();

	public Param(String[] newArgs) {
		args = newArgs;

		options.addOption("h", false, "Pour afficher l’aide.");
		options.addOption("i", true, "Suivi du chemin du fichier CSV d'entrée.");
		options.addOption("categorie", true, "suivi du nom de la catégorie pour filtrer les produits");
		options.addOption("etiquette", true, "suivi du chemin du fichier PDF qui contiendra les étiquettes produit");
		options.addOption("fiche", true, "suivi du chemin du fichier PDF contenant les fiches produit");
		options.addOption("tva", true, "montant de la TVA à utiliser pour calculer le prix TTC (par défaut 20%)");
	}
	
	public Csv getFileCsv() {
		return fileCsv;
	}
	
	public void parserCmd() throws IOException {
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmd = parser.parse(options, args);
			
			if (cmd.hasOption("h"))
				help();
			if (cmd.hasOption("i")) {
				fileCsv.setCsvPath(cmd.getOptionValue("i"));
			}
			if (cmd.hasOption("categorie")) {
				fileCsv.setCategorieFilter("categorie");
			}
			if (cmd.hasOption("etiquette")) {
				fileCsv.setEtiquetteName("etiquette");
			}
			if (cmd.hasOption("fiche")) {
				fileCsv.setFicheName("fiche");
			}
			if (cmd.hasOption("tva")) {
				fileCsv.setTva(cmd.getOptionValue("tva"));
			}
			if (cmd.hasOption("etiquette") || cmd.hasOption("fiche")) {
				fileCsv.readCsv(fileCsv.getCsvPath());
				}
			else {
				errHelp("No file creation request");
			}

		} catch (ParseException e) {
			String s = "Failed to parse comand line properties" + e;
			errHelp(s);
		}
	}
	
	private void errHelp(String s) {
		System.err.println(s);
		help();
		System.exit(2);
	}
	
	private void help() {
		HelpFormatter formater = new HelpFormatter();
		
		formater.printHelp("java -­classpath <CLASSPATH> NomDeLaClasse <PARAMETRES>", options);
		System.exit(0);
	}
}