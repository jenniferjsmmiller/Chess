import java.util.ArrayList;

public abstract class Piece {

	private ArrayList<Location> moves;
	private Location location;
	private final int color;

	/** constructor for Piece */
	
	public Piece(int row, int column, int color) {
		this.location = new Location(row, column);
		this.color = color;
	}

	/** checks for possible moves a given piece can make */
	
	public ArrayList<Location> possibleMoves(Board board) {
		moves = new ArrayList<Location>();
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				if (this.isLegal(new Location(r, c), board)) {
					moves.add(new Location(r, c));
				}
			}
		}
		return moves;
	}

	/** ensures that each piece will have an isLegal method */
	public abstract boolean isLegal(Location location, Board board);
	
	/** returns whether or not particular piece can upgrade */
	public abstract boolean canUpgrade(Location destination, Board board);

	/** ensures that each piece will have a getImageFileName method */
	public abstract String getImageFileName();

	/** returns location (row/column coordinates of piece) */
	public Location getLocation() {
		return location;
	}

	/** sets location (row/column coordinates of piece) */
	public void setLocation(Location location) {
		this.location = location;
	}

	/** returns color of piece */
	public int getColor() {
		return color;
	}

	/** returns row */
	public int getRow() {
		return location.getRow();
	}

	/** returns column */
	public int getColumn() {
		return location.getColumn();
	}

}
