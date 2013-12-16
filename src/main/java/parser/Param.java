package parser;

public class Param {
    public String name;
    public String value;
	@Override
	public String toString() {
		return "Param [" + (name != null ? "name=" + name + ", " : "")
				+ (value != null ? "value=" + value : "") + "]";
	}
}
