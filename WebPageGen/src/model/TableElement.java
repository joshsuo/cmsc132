package model;

public class TableElement extends TagElement implements Element
{
	private Element[][] array;
	private String attributes;
	private int rows;
	private int cols;
	
	public TableElement(int rows, int cols, String attributes)
	{
		super("table", true, null, attributes);
		this.array = new Element[rows][cols];
		this.attributes = attributes;
		this.rows = rows;
		this.cols = cols;
	}
	
	public void addItem(int rowIndex, int colIndex, Element item)
	{
		array[rowIndex][colIndex] = item;
	}
	
	public double getTableUtilization()
	{
		int used = 0;
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				if(array[i][j] != null)
				{
					used++;
				}
			}
		}
		
		return (double) used / (rows * cols);
	}


	@Override
	public String genHTML(int indentation)
	{
		String indent = " ".repeat(indentation);
		String result = indent;
		
		result += getStartTag();
		
		for(int i = 0; i < rows; i++)
		{
			result += indent + indent + "<tr>";
			for(int j = 0; j < cols; j++)
			{
				result += "<td>" + (array[i][j] != null ? array[i][j].genHTML(0) : "") + "</td>";
			}
			result += "</tr>\n";
		}
		
		result += indent + getEndTag();
		
		return result;
		
	}

}
