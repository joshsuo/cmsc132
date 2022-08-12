package enumeratedTypes;

import java.awt.Color;
import java.util.Random;

/**
 * This enumerate type represents a board cell. A board cell has a color (based
 * on Color class) and a name (e.g., "R")
 */

public enum BoardCell {
	/* Defining possible types of cells (must appear first) */
	RED(Color.RED, "R"), GREEN(Color.GREEN, "G"), BLUE(Color.BLUE, "B"), YELLOW(
			Color.YELLOW, "Y"), EMPTY(Color.WHITE, ".");

	private final Color color;
	private final String name;
	private static int totalColors = BoardCell.values().length;

	/* needs private constructor */
	private BoardCell(Color color, String name) {
		this.color = color;
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public String getName() {
		return name;
	}

	public static int getTotalColors() {
		return totalColors;
	}

	/**
	 * Generates a random BoardCell using the specified Random object.
	 * 
	 * @param random
	 * @return random BoardCell
	 */

	public static BoardCell getNonEmptyRandomBoardCell(Random random) {
		int target = random.nextInt(totalColors);
		for (BoardCell boardCell : BoardCell.values()) {
			if (boardCell == BoardCell.EMPTY) {
				return BoardCell.RED;
			}
			
			if (target == boardCell.ordinal()) {
				return boardCell;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println("Total Colors: " + BoardCell.getTotalColors());
		System.out.print("Listing of all cells: ");
		for (BoardCell cell : BoardCell.values())
			System.out.print(" " + cell);
		System.out.println();

		/* Some comparisons */
		BoardCell a = BoardCell.RED;
		BoardCell b = BoardCell.RED;
		if (a.equals(b)) {
			System.out.println("a and b same cell when using equals");
		}
		
		if (a == b) {
			System.out.println("a and b same cell when using ==");
		}
		
		System.out.println("Random values");
		long seed = 2L;
		Random random = new Random(seed); /* What if we use new Random() ? */
		for (int i = 1; i <= 4; i++) {
			BoardCell randomCell = BoardCell.getNonEmptyRandomBoardCell(random);
			System.out.println(randomCell);
		}
	}
}