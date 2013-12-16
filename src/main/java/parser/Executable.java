package parser;

public class Executable {
    public String version;
    public Registry registryKey;
	@Override
	public String toString() {
		return "Executable ["
				+ (version != null ? "version=" + version + ", " : "")
				+ (registryKey != null ? "registryKey=" + registryKey : "")
				+ "]";
	}
}
