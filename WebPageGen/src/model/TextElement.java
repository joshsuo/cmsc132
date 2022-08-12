package model;

public class TextElement implements Element
{
	private String text;
	
	public TextElement(String text)
	{
		this.text = text;
	}
	
	
	
	@Override
	public String genHTML(int indentation)
	{
		String indent = " ".repeat(indentation);
		
		return indent + this.text;
	}

}
