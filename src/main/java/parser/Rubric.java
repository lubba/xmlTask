package parser;

import java.util.ArrayList;
import java.util.List;

public class Rubric {
    public List<Rubric> rubrics = new ArrayList<Rubric>();
    public String id;
    public String name;
	@Override
	public String toString() {
		return "Rubric ["
				+ (rubrics != null ? "rubrics=" + rubrics + ", " : "")
				+ (id != null ? "id=" + id + ", " : "")
				+ (name != null ? "name=" + name : "") + "]";
	}
    
}
