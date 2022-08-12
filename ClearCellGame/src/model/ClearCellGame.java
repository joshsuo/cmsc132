package model;

import java.util.Random;

/* This class must extend Game */
public class ClearCellGame extends Game
{
	private Random random;
	private int strat;
	private int score;

	public ClearCellGame(int maxRows, int maxCols, java.util.Random random, int strategy)
	{
		super(maxRows, maxCols);
		this.random = random;
		this.strat = strategy;
	}
	
	public boolean isGameOver()
	{
		for(int i = 0; i < this.getMaxCols(); i++)
		{
			if(this.board[this.getMaxRows()-1][i] != BoardCell.EMPTY)
			{
				return true;
			}
		}
		return false;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void nextAnimationStep()
	{
		if(!(isGameOver()))
		{
			for(int i = this.getMaxRows()-2; i >= 0; i--)
			{
				for(int j = 0; j < this.getMaxCols(); j++)
				{
					this.board[i+1][j] = this.board[i][j];
				}
				System.out.println();
				
			}
			for(int j = 0; j < this.getMaxCols(); j++)
			{
				this.setBoardCell(0, j, BoardCell.getNonEmptyRandomBoardCell(random));	
			}
			
		}
	}
	
	
	public void processCell(int rowIndex, int colIndex)
	{
		BoardCell color = getBoardCell(rowIndex, colIndex);
		
		setBoardCell(rowIndex, colIndex, BoardCell.EMPTY);
		score++;
		
		int row = rowIndex;
		int col = colIndex;
		
		//down
		processCellDirection(rowIndex, colIndex, 1, 0, color);
		
		//up
		processCellDirection(rowIndex, colIndex, -1, 0, color);
		
		//right
		processCellDirection(rowIndex, colIndex, 0, 1, color);
		
		//left
		processCellDirection(rowIndex, colIndex, 0, -1, color);
		
		//right up diagonal
		processCellDirection(rowIndex, colIndex, -1, 1, color);
		
		//right down diagonal
		processCellDirection(rowIndex, colIndex, 1, 1, color);
		
		//left up diagonal
		processCellDirection(rowIndex, colIndex, -1, -1, color);
		
		//left down diagonal
		processCellDirection(rowIndex, colIndex, 1, -1, color);
		
		//collapse rows
		collapse();
		
	}
	
	private void processCellDirection(int row, int col, int up, int right, BoardCell color)
	{
		row += up;
		col += right;
		
		while(row >= 0 && col >= 0 && row < getMaxRows() && col < getMaxCols()
				&& getBoardCell(row, col) == color)
		{
			setBoardCell(row, col, BoardCell.EMPTY);
			score++;
			row += up;
			col += right;
		}		
	}
	
	private void collapse()
	{
		boolean collapse;
		
		for(int i = 0; i < getMaxRows()-1; i++)
		{
			collapse = true;
			for(int j = 0; j < getMaxCols(); j++)
			{
				if(getBoardCell(i, j) != BoardCell.EMPTY)
				{
					collapse = false;
					break;
				}
			}
			
			if(collapse == true && i != getMaxRows()-1)
			{
				int numCollapse = 0;
				for(int j = i; j < getMaxRows(); j++)
				{
					if(isRowEmpty(j) == true && j != getMaxRows()-1)
					{
						numCollapse++;
					}
					else if(isRowEmpty(j) == false)
					{
						break;
					}
					
				}
				
				for(int k = 0; k < getMaxCols(); k++)
				{
					this.board[i][k] = this.board[i+numCollapse][k];
					this.board[i+numCollapse][k] = BoardCell.EMPTY;
				}
			}
			
		}
	}
	
	private boolean isRowEmpty(int row)
	{
		for(int i = 0; i < this.getMaxCols(); i++)
		{
			if(this.board[row][i] != BoardCell.EMPTY)
			{
				return false;
			}
		}
		return true;
	}
	
	
}