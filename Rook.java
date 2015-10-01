public class Rook extends Piece {

	/** constructor for Rook */
	
	public Rook(int row, int column, int color) {
		super(row, column, color);
	}

	/** returns image file for Chess class */
	
	public String getImageFileName() {
		if (this.getColor() == Board.BLACK) {
			return "ChessPieces" + java.io.File.separator + "BlackRook.png";
		} else {
			return "ChessPieces" + java.io.File.separator + "WhiteRook.png";
		}
	}

	/** returns if a given move on the board is legal for the Rook to move to */
	
	public boolean isLegal(Location destination, Board board) {
		if (board.getPiece(destination) != null
				&& board.getPiece(destination).getColor() == getColor()) {
			return false;
		} else {
			if (destination.getRow() == getRow()) {
				int lo = Math.min(getColumn(), destination.getColumn());
				int hi = Math.max(getColumn(), destination.getColumn());
				for (int c = lo + 1; c < hi; c++) {
					if (board.getPiece(new Location(getRow(), c)) != null) {
						return false;
					} 
				}
				return true;
			}
			
			
			if (destination.getColumn() == getColumn()) {
				int lo = Math.min(getRow(), destination.getRow());
				int hi = Math.max(getRow(), destination.getRow());
				for (int r = lo + 1; r < hi; r++) {
					if (board.getPiece(new Location(r, getColumn())) != null) {
						return false;
					} 
				}
				return true;
			}
		}
		return false;
	}
	
	public boolean canUpgrade(Location destination, Board board) {
		return false;
	}
}