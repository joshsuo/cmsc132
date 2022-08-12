package model;

import java.util.ArrayList;

public class ListElement extends TagElement implements Element
{
	private ArrayList<Element> list;
	
	public ListElement(boolean ordered, String attributes)
	{
		super(ordered ? "ol" : "ul", true, null, attributes);
		list = new ArrayList<Element>();
	}
	
	public void addItem(Element item)
	{
		list.add(item);
	}
	
	@Override
	public String genHTML(int indentation)
	{
		String indent = " ".repeat(indentation);
		String result = "";
		
		result += indent + getStartTag();
		
		for(Element elem : list)
		{
			result += "<li>" + elem.genHTML(0) + "</li>";
		}
		
		result += indent + getEndTag();
		
		return result;
		
	}

}
