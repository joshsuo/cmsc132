package model;

public class TagElement implements Element
{
	private String tagName;
	private boolean endTag;
	private Element content;
	private String attributes;
	private static int id = 1;
	private int uniqueId;
	protected static boolean idEnable;
	
	public TagElement(String tagName, boolean endTag, Element content, String attributes)
	{
		this.tagName = tagName;
		this.endTag = endTag;
		this.content = content;
		this.attributes = attributes;
		this.uniqueId = id++;
	}
	
	public int getId()
	{
		return uniqueId;
	}
	
	public String getStringId()
	{
		return this.tagName + this.uniqueId;
	}
	
	public String getStartTag()
	{	
		String result = "<" + tagName;
		
		if(idEnable)
		{
			result += " id=\"" + getStringId() + "\"";
		}
		
		if(attributes != null)
			result += " " + attributes;
		
		result += ">\n";
		
		return result;
		
	}
	
	public String getEndTag()
	{
		if(this.endTag)
		{
			return "</" + this.tagName + ">\n"; 
		}
		else
		{
			return "";
		}
	}
	
	public void setAttributes(String attributes)
	{
		this.attributes = attributes;
	}
	
	
	public static void resetIds()
	{
		id = 1;
	}
	
	public static void enableId(boolean choice)
	{
		idEnable = choice;
	}

	
	
	@Override
	public String genHTML(int indentation)
	{
		String indent = " ".repeat(indentation);
		
		return indent + getStartTag() + 
				(content != null ? content.genHTML(0) : "") 
				+ indent + getEndTag();
	}

}
