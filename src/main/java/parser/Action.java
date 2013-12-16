package parser;

import java.util.ArrayList;
import java.util.List;

public class Action {
    
	public String name;
    public String handler;
    public List<Param> params = new ArrayList<Param>();
    @Override
	public String toString() {
		return "Action [" + (name != null ? "name=" + name + ", " : "")
				+ (handler != null ? "handler=" + handler + ", " : "")
				+ (params != null ? "params=" + params : "") + "]";
	}
}
