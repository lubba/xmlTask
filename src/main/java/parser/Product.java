package parser;

import java.util.ArrayList;
import java.util.List;

public class Product {
    public String id;
    public String title;
    public List<String> copyrights = new ArrayList<String>();
    public List<String> authors = new ArrayList<String>();
    public int date;
    public List<String> publishers = new ArrayList<String>();
    public List<Object> objects = new ArrayList<Object>();
    public Classification classification;
    public Handler userHandler;
    public List<Handler> handlers = new ArrayList<Handler>();
	
    @Override
	public String toString() {
		return "Product ["
				+ (id != null ? "id=" + id + ", " : "")
				+ (title != null ? "title=" + title + ", " : "")
				+ (copyrights != null ? "copyrights=" + copyrights + ", " : "")
				+ (authors != null ? "authors=" + authors + ", " : "")
				+ "date="+ date + ", "
				+ (publishers != null ? "publishers=" + publishers + ", " : "")
				+ (objects != null ? "objects=" + objects + ", " : "")
				+ (classification != null ? "classification=" + classification + ", " : "")
				+ (userHandler != null ? "userHandler=" + userHandler + ", " : "")
				+ (handlers != null ? "handlers=" + handlers : "") + "]";
	}
}
