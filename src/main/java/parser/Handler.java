package parser;


public class Handler {
    public String uuid;
    public String name;
    public String description;
    public Application application;
	@Override
	public String toString() {
		return "Handler ["
				+ (uuid != null ? "uuid=" + uuid + ", " : "")
				+ (name != null ? "name=" + name + ", " : "")
				+ (description != null ? "description=" + description + ", "
						: "")
				+ (application != null ? "application=" + application : "")
				+ "]";
	}

}
