package com.ty;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXML {

	public static void main(String[] args) {
		System.out.println("Main Method Starts");
		File xmlFile = new File("src/StudentDetails.xml");
		System.out.println(xmlFile.exists());
		
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbFactory.newDocumentBuilder();
			Document doc = builder.parse(xmlFile);
			System.out.println(doc);
			//get root element
			String name = doc.getDocumentElement().getNodeName();
			System.out.println(name);
			
			NodeList stdNodeList = doc.getElementsByTagName("student");
			System.out.println("No of Students = "+stdNodeList.getLength());
			
			for(int i = 0;i<stdNodeList.getLength();i++) {
				Node studentNode = stdNodeList.item(i);
				System.out.println(studentNode.getNodeName());
				Element studentElement = (Element) studentNode;
				Node firstName =  studentElement.getElementsByTagName("firstName").item(0);
				System.out.println("First Name = "+firstName.getTextContent());
				
				Node lastName =  studentElement.getElementsByTagName("lastName").item(0);
				System.out.println("Last Name = "+lastName.getTextContent());
				
				Node rollnumber =  studentElement.getElementsByTagName("rollnumber").item(0);
				System.out.println("Roll Number = "+rollnumber.getTextContent());
				/*NodeList childNodes = studentNode.getChildNodes();
				for(int j=0;j<childNodes.getLength();j++) {
					Node child = childNodes.item(j);
					System.out.println(child.getNodeName()+"\t"+child.getTextContent());
				}*/
				
			}
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main Method Ends");
	}

}
