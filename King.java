
public class King extends Piece {

	/** constructor for King */
	
	public King(int row, int column, int color) {
		super(row, column, color);
	}
	
	/** returns image file for Chess class */
	
	public String getImageFileName() {
		if (this.getColor() == Board.BLACK) {
			return "ChessPieces" + java.io.File.separator + "BlackKing.png";
		} else {
			return "ChessPieces" + java.io.File.separator + "WhiteKing.png";
		}
	}

	/** returns if a given move on the board is legal for the King to move to */
	
	public boolean isLegal(Location destination, Board board) {
		if (board.getPiece(destination) != null
				&& board.getPiece(destination).getColor() == getColor()
				&& !board.isLegalSource(new Location(this.getRow(), this.getColumn()))) {
			return false;
		} else {
			int differentRow = Math.abs(destination.getRow() - getRow());
			int differentColumn = Math.abs(destination.getColumn() - getColumn());
			
			if (differentRow == 0 && differentColumn == 1) {
				return true;
			}
			
			if (differentRow == 1 && differentColumn == 0) {
				return true;
			}
			
			if (differentRow == 1 && differentColumn == 1) {
				return true;
			}
		}
		return false;
	}
	
	public boolean canUpgrade(Location destination, Board board) {
		return false;
	}
}
