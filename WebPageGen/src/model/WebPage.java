package model;

import java.util.ArrayList;

/**
 * Represents a web page. Web page elements are stored in an ArrayList of Element objects.
 * A title is associated with every page.
 * This class implements the Comparable interface. Pages will be compared based on the title.
 * @author joshsuo
 *
 */

public class WebPage implements Comparable<WebPage>
{
	private ArrayList<Element> list;
	private String title;
	private static boolean idEnable;
	
	public WebPage(String title)
	{
		this.title = title;
		this.list = new ArrayList<Element>();
	}
	
	public int addElement(Element element)
	{
		list.add(element);
		
		if(element instanceof TagElement)
		{
			return ((TagElement)element).getId();
		}
		else
		{
			return -1;
		}
	}
	
	public String getWebPageHTML(int indentation)
	{
		String result = "";
		String indent = " ".repeat(indentation);
		
		result += "<!doctype html>\n"
				+ "<html>\n"
				+ indent + "<head>\n"
				+ indent + indent + "<meta charset=\"utf-8\"/>\n"
				+ indent + indent + "<title>" + this.title + "</title>\n"
				+ indent + "</head>\n"
				+ indent + "<body>\n";
		
		for(Element elem : this.list)
		{
			result += elem.genHTML(indentation);
		}
		
		result += indent + "</body>\n"
				+ "</html>";
				
		return result;
	}
	
	public void writeToFile(java.lang.String filename, int indentation)
	{
		Utilities.writeToFile(filename, getWebPageHTML(indentation));
	}
	
	public Element findElem(int id)
	{
		for(Element elem : this.list)
		{
			if(((TagElement)elem).getId() == id)
				return elem;
		}
		return null;
	}
	
	public String stats()
	{
		int listCount = 0;
		int paraCount = 0;
		int tableCount = 0;
		double util = 0;
		double tableUtil = 0;
		
		String result = "";
		
		for(Element element : this.list)
		{
			if(element instanceof ListElement)
			{
				listCount++;
			}
			else if(element instanceof ParagraphElement)
			{
				paraCount++;
			}
			else if(element instanceof TableElement)
			{
				tableCount++;
				
				util += ((TableElement)element).getTableUtilization();
			}
		}
		
		tableUtil = (util / tableCount) * 100;
		
		result += "List Count: " + listCount + "\n";
		result += "Paragraph Count: " + paraCount + "\n";
		result += "Table Count: " + tableCount + "\n";
		result += "TableElement Utilization: " + tableUtil;
		
		return result;
	}
	
	@Override
	public int compareTo(WebPage webPage)
	{
		return (this.title.compareTo(webPage.title));
	}
	
	public static void enableId(boolean choice)
	{
		idEnable = choice;
	}

}
