package parser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

public class LetsParse {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser;
		try {
			saxParser = saxParserFactory.newSAXParser();
			MyHandler handler = new MyHandler();
			saxParser.parse(new FileInputStream("D:\\XMLexample.xml"), handler);
	        Product p = handler.getProduct();
	        System.out.println(p);
	    } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} 
    }
}
