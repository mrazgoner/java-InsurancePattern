package com.settings;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 
 * a class that reads and writes to an XML Document
 * stored in a file. 
 * 
 * @author Michael
 *
 */
public class SettingsXMLFile implements SettingsFileProxy{

	private File file; 


	public SettingsXMLFile(String path) {

		file = new File(path);

	}

	
	public SettingsXMLFile(File file) {

		this.file = file;

	}

	/**
	 * updates the entire file with the contents of the Array list
	 * of settings
	 * 
	 * @param fields
	 */
	public void updateDocument(ArrayList<Setting> fields)
	{

		try {
			DocumentBuilderFactory dbFactory =
					DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			// root element
			Element rootElement = doc.createElement("Settings");
			doc.appendChild(rootElement);

			for(Setting field : fields) {

				Element name = doc.createElement(field.getName());
				name.appendChild(doc.createTextNode(field.getValue()));
				rootElement.appendChild(name);

			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);

			System.out.println("saving settings:");

			// Output to console for testing
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);
		} catch (Exception e) {
			System.out.println("failed writing to XML");
			e.printStackTrace();
		}

	}

	/**
	 * Reads the values stored in the XML file.
	 * 
	 * @param fields
	 * @return the same input Array List with updated values,
	 * 			if the XML is invalid returns null.
	 */
	public ArrayList<Setting> parseDocument(ArrayList<Setting> fields) {

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			System.out.println("Reading XML");
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			for(Setting field : fields) {
				NodeList nList = doc.getElementsByTagName(field.getName());
				if(nList.getLength()>0)
				{
					Node nNode = nList.item(0);
					field.setValue(nNode.getTextContent());
				}
			}
			
			return fields;


		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}// parseDocument



}	
