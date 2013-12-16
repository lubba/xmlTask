package parser;

import org.junit.Test;
import org.xml.sax.Attributes;
//import org.xml.sax.SAXException;

public class TestMyHandler {
	MyHandler handler = new MyHandler();
	
	@Test
	public void testStartElement(){
		String uri = "";
		String localName = "";
		String qName = ""; 
		Attributes attributes = new Attributes() {
			
			@Override
			public String getValue(String uri, String localName) {
				String s = "My value by uri: " + uri != null ? uri : ""
					+ " and by local name: " + localName != null ? localName : "";
				return s;
			}
			
			@Override
			public String getValue(String qName) {
				return "My value by qName: " + qName != null ? qName : "";
			}
			
			@Override
			public String getValue(int index) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getURI(int index) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getType(String uri, String localName) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getType(String qName) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getType(int index) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getQName(int index) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getLocalName(int index) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getLength() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getIndex(String uri, String localName) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getIndex(String qName) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		handler.startElement(uri, localName, qName, attributes);
	}
	@Test
	public void testEndElement(){
		String uri = "";
		String localName = ""; 
		String qName = "";
		handler.endElement(uri, localName, qName);
	}
	@Test
	public void testCharacters(){
		char[] ch = {'r','y','u','b','b','a'};
		int start = 0;
		int length = ch.length;
		handler.characters(ch, start, length);
	}
}
