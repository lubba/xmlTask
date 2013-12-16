package parser;

import org.xml.sax.Attributes;
//import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;


public class MyHandler extends DefaultHandler {

    private int place;
    private Product product;
    private Object object;
    private Action action;
    private Param param;
    private Handler handler;
    private Classification classification;
    private Application application;
    private Executable executable;
    private Registry registry;
    private Stack<Rubric> rubricStack = new Stack<Rubric>();

    public Product getProduct() {
        return product;
    }

    public int getPlace() {
		return place;
	}

	public Object getObject() {
		return object;
	}

	public Action getAction() {
		return action;
	}

	public Param getParam() {
		return param;
	}

	public Handler getHandler() {
		return handler;
	}

	public Classification getClassification() {
		return classification;
	}

	public Application getApplication() {
		return application;
	}

	public Executable getExecutable() {
		return executable;
	}

	public Registry getRegistry() {
		return registry;
	}

	public Stack<Rubric> getRubricStack() {
		return rubricStack;
	}

	private void switchPlace(String s) {
        switch (s) {
            default:
                place = 0;
                break;
            case "id":
                place = 1;
                break;
            case "title":
                place = 2;
                break;
            case "copyright":
                place = 3;
                break;
            case "author":
                place = 4;
                break;
            case "date":
                place = 5;
                break;
            case "publishers":
                place = 6;
                break;
            case "educationaltype":
                place = 7;
                break;
            case "keyword":
                place = 8;
                break;
            case "duration":
                place = 9;
                break;
            case "class":
                place = 10;
                break;
            case "description":
                place = 11;
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {//throws SAXException {
        switch (qName) {
            case "product":
                product = new Product();
                break;
            case "action":
                action = new Action();
                action.name = attributes.getValue("name");
                action.handler = attributes.getValue("handler");
                break;
            case "application":
                application = new Application();
                break;
            case "object":
                object = new Object();
                break;
            case "classification":
                classification = new Classification();
                break;
            case "executable":
                executable = new Executable();
                executable.version = attributes.getValue("version");
                break;
            case "registry":
                registry = new Registry();
                registry.key = attributes.getValue("key");
                registry.value = attributes.getValue("value");
                break;
            case "userhandler":
            case "handler":
                handler = new Handler();
                handler.uuid=(attributes.getValue("uuid"));
                handler.name = (attributes.getValue("name"));
                break;
            case "param":
                param = new Param();
                param.name=(attributes.getValue("name"));
                param.value=(attributes.getValue("value"));
                break;
            case "rubric":
                Rubric r = new Rubric();
                r.id=(attributes.getValue("id"));
                r.name=(attributes.getValue("name"));
                rubricStack.push(r);
                break;
            default:
                switchPlace(qName);
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName){// throws SAXException {
        switch (qName) {
            case "product":
                break;
            case "action":
                object.action = (action);
                action = null;
                break;
            case "application":
                handler.application=(application);
                application = null;
                break;
            case "object":
                product.objects.add(object);
                object = null;
                break;
            case "classification":
                product.classification=(classification);
                classification = null;
                break;
            case "executable":
                application.executable=(executable);
                executable = null;
                break;
            case "registry":
                executable.registryKey=(registry);
                registry = null;
                break;
            case "userhandler":
                product.userHandler=(handler);
                handler = null;
                break;
            case "handler":
                product.handlers.add(handler);
                handler = null;
                break;
            case "param":
                if (action != null) {
                    action.params.add(param);
                } else {
                    application.params.add(param);
                }
                param = null;
                break;
            case "rubric":
                Rubric top = rubricStack.pop();
                if (rubricStack.isEmpty()) {
                    if (object != null) {
                        object.rubrics.add(top);
                    } else {
                        classification.rubric=(top);
                    }
                } else {
                    rubricStack.peek().rubrics.add(top);
                }
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length){// throws SAXException {
        String s = new String(ch, start, length);
        switch (place) {
            case 1:
                if (object != null) {
                    object.id=(s);
                } else {
                    product.id=(s);
                }
                break;
            case 2:
                if (object != null) {
                    object.title=(s);
                } else {
                    product.title=(s);
                }
                break;
            case 3:
                product.copyrights.add(s);
                break;
            case 4:
                if (object != null) {
                    object.authors.add(s);
                } else {
                    product.authors.add(s);
                }
                break;
            case 5:
                if (object != null) {
                    object.date=(Integer.parseInt(s));
                } else {
                    product.date=(Integer.parseInt(s));
                }
                break;
            case 6:
                if (object != null) {
                    object.publishers.add(s);
                } else {
                    product.publishers.add(s);
                }
                break;
            case 7:
                object.educationaltype=(s);
                break;
            case 8:
                object.keywords.add(s);
                break;
            case 9:
                object.duration=(Integer.parseInt(s));
                break;
            case 10:
                object.classes.add(Integer.parseInt(s));
                break;
            case 11:
                handler.description=(s);
        }
        place = 0;
    }
}
