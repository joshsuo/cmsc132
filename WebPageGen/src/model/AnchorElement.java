package model;

public class AnchorElement extends TagElement implements Element
{
	private String linkText;
	private String url;
	private String attributes;
	
	public AnchorElement(String url, String linkText, String attributes)
	{
		super("a", true, new TextElement(linkText), attributes);
		this.linkText = linkText;
		this.url = url;
		this.attributes = attributes;
	}
	
	public String getLinkText()
	{
		return this.linkText;
	}
	
	public String getUrlText()
	{
		return this.url;
	}
	
	public String genHTML(int indentation)
	{
		String result = " ".repeat(indentation);
		result += "<a " + (TagElement.idEnable == true ? "id=\"" + getStringId() + "\"" : "");
		result += "href=\"" + url + "\"";
		
		if(attributes != null)
		{
			result += " " + attributes;
		}
		result +=  ">";
		
		return result + linkText + "</a>";
		
	}
	
}
