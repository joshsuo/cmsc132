package model;

import java.util.ArrayList;

public class ParagraphElement extends TagElement implements Element
{
	private ArrayList<Element> list;
	
	public ParagraphElement(String attributes)
	{
		super("p", true, null, attributes);
		list = new ArrayList<Element>();
	}
	
	public void addItem(Element item)
	{
		list.add(item);
	}
	
	@Override
	public String genHTML(int indentation)
	{
		String result = " ".repeat(indentation);
		
		result += getStartTag();
		
		for(Element elem : list)
		{
			result += elem.genHTML(indentation) + "\n";
		}
		
		result += getEndTag();
		
		return result;
		
	}

}
