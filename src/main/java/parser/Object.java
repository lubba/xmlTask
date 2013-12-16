package parser;

import java.util.ArrayList;
import java.util.List;

public class Object {
    public String id;
    public String title;
    public List<String> authors = new ArrayList<String>();
    public int date;
    public List<String> publishers = new ArrayList<String>();
    public String educationaltype;
    public List<String> keywords = new ArrayList<String>();
    public List<Rubric> rubrics = new ArrayList<Rubric>();
    public int duration;
    public List<Integer> classes = new ArrayList<Integer>();
    public Action action;
	@Override
	public String toString() {
		return "Object ["
				+ (id != null ? "id=" + id + ", " : "")
				+ (title != null ? "title=" + title + ", " : "")
				+ (authors != null ? "authors=" + authors + ", " : "")
				+ "date="
				+ date
				+ ", "
				+ (publishers != null ? "publishers=" + publishers + ", " : "")
				+ (educationaltype != null ? "educationaltype="
						+ educationaltype + ", " : "")
				+ (keywords != null ? "keywords=" + keywords + ", " : "")
				+ (rubrics != null ? "rubrics=" + rubrics + ", " : "")
				+ "duration=" + duration + ", "
				+ (classes != null ? "classes=" + classes + ", " : "")
				+ (action != null ? "action=" + action : "") + "]";
	}
}
