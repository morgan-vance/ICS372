package ourClasses;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
//import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * SiteJson handles importing and exporting of data to file.
 */
public class SiteReader {

	public static void exportFile() throws IOException {
		AllSites.activeSites.add(new Sites("12345"));
        AllSites.activeSites.add(new Sites("12555"));
        AllSites.activeSites.add(new Sites("12549"));
        AllSites.activeSites.add(new Sites("12550"));
        
        //Add readings to sites
        AllSites.activeSites.get(0).addAReading("One", "465","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Two", "466","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Three", "467","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Four", "468","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Five", "469","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "470","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "471","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "472","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "473","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "474","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "475","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "476","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "465","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "466","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "467","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "468","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "469","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "470","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "471","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "472","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "473","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "474","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "475","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "476","12345","humidity","900",78.00,"15154694451");
        /* AllSites.activeSites.get(1).addAReading("Eastern USA Study", "400","12555","temperature","910",122.00,"15154694451");
        AllSites.activeSites.get(1).addAReading("Eastern USA Study", "430","12556","temperature","911",123.00,"15153546944");
        AllSites.activeSites.get(2).addAReading("Midwest USA Study", "465","12549","temperature","930",122.00,"1515354694451");
        AllSites.activeSites.get(2).addAReading("Midwest USA Study", "465","12548","temperature","940",122.00,"151535469451");
        AllSites.activeSites.get(2).addAReading("Midwest USA Study", "465","12547","temperature","950",122.00,"151535694451");
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "500","12345","humidity","900",78.00,"15154694451");
        AllSites.activeSites.get(1).addAReading("Eastern USA Study", "501","12555","temperature","910",122.00,"15154694451");
        AllSites.activeSites.get(1).addAReading("Eastern USA Study", "502","12556","temperature","911",123.00,"15153546944");
        AllSites.activeSites.get(3).addAReading("Midwest USA Study", "503","12549","temperature","930",122.00,"1515354694451");
        AllSites.activeSites.get(3).addAReading("Midwest USA Study", "504","12548","temperature","940",122.00,"151535469451");
        AllSites.activeSites.get(3).addAReading("Midwest USA Study", "505","12547","temperature","950",122.00,"151535694451");
        */
        System.out.println(AllSites.activeSites.get(0));
        
		// The name of the file that is produced
		try (FileWriter file = new FileWriter("Site Collection Results.json")) {
			// this needs to be our array list
			file.write(AllSites.activeSites.toString());
			file.flush();
			// Message that appears once the data is saved to directory
			JOptionPane.showMessageDialog(null, "Please check your project directory folder for results", "Json Export",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void importFile() throws FileNotFoundException, IOException, ParseException, ParserConfigurationException, SAXException, org.json.simple.parser.ParseException {

		JFileChooser jfc = new JFileChooser();
		// filter to only select .xml or .json files
		FileNameExtensionFilter filter = new FileNameExtensionFilter(".json and .xml", "xml", "json");
		jfc.setFileFilter(filter);

		int returnValue = jfc.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			java.io.File inputFile = jfc.getSelectedFile();
			String fileType = inputFile.getName();
			fileType = fileType.substring(fileType.length() - 3);
			if (fileType.contains("son")) {
			JSONParser parser = new JSONParser();

			Object obj = parser.parse(new FileReader(inputFile));

			JSONArray jsonObjectIn = (JSONArray) obj;
			JSONObject jsonObject = (JSONObject) jsonObjectIn.get(0);
			System.out.println(jsonObject);

			JSONArray site_reading = (JSONArray) jsonObjectIn;
			Iterator<?> i = site_reading.iterator();
			//print file to console
			while (i.hasNext()) {
				System.out.println(i.next());
			}
			}
			if (fileType.contains("xml")) {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse(inputFile);
				parseWholeXML(doc.getDocumentElement());
			}
		} else {
			// Error message if the user closes JFileChooser without selecting anything
			JOptionPane.showMessageDialog(null, "No File Selected", "ERROR", JOptionPane.INFORMATION_MESSAGE);
		}
		}
	
	private static void parseWholeXML(Node startingNode)
	{
		NodeList childNodes = startingNode.getChildNodes();
		for(int i=0; i<childNodes.getLength(); i++)
		{
			Node childNode = childNodes.item(i);
			if(childNode.getNodeType() == Node.ELEMENT_NODE)
			{
				parseWholeXML(childNode);
			}
			else
			{
				// trim() is used to ignore new lines and spaces elements.
				if(!childNode.getTextContent().trim().isEmpty())
				{
					System.out.println(childNode.getTextContent());
				}
			}
		}
	}
	
	private static void getRootElementXML(Document doc)
	{
		System.out.println(doc.getDocumentElement().getNodeName());
	}
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, ParserConfigurationException, SAXException, org.json.simple.parser.ParseException {

		
		importFile();
	}

	
	private static void getRootElement(Document doc)
	{
		System.out.println(doc.getDocumentElement().getNodeName());
	}
	
}