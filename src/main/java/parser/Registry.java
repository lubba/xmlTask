package parser;

public class Registry {
    public String key;
    public String value;
	@Override
	public String toString() {
		return "Registry [" + (key != null ? "key=" + key + ", " : "")
				+ (value != null ? "value=" + value : "") + "]";
	}

}
