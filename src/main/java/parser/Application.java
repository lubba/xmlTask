
package parser;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public Executable executable;
    public List<Param> params = new ArrayList<Param>();
	@Override
	public String toString() {
		return "Application ["
				+ (executable != null ? "executable=" + executable + ", " : "")
				+ (params != null ? "params=" + params : "") + "]";
	}
}
