
public class Queen extends Piece{

	/** constructor for Queen */
	public Queen(int row, int column, int color) {
		super(row, column, color);
	}
	
	/** returns image file for Chess class */
	
	public String getImageFileName() {
		if (this.getColor() == Board.BLACK) {
			return "ChessPieces" + java.io.File.separator + "BlackQueen.png";
		} else {
			return "ChessPieces" + java.io.File.separator + "WhiteQueen.png";
		}
	}

	/** returns if a given move on the board is legal for the Queen to move to */
	
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
			
			int differentRow = destination.getRow() - getRow();
			int differentColumn = destination.getColumn() - getColumn();
			if (differentRow == differentColumn) {
				int loRow = Math.min(getRow(), destination.getRow());
				int loColumn = Math.min(getColumn(), destination.getColumn());
				int hiRow = Math.max(getRow(), destination.getRow());
				for (int r = loRow + 1, c = loColumn + 1; r < hiRow; r++, c++) {
					if (board.getPiece(new Location(r, c)) != null) {
						return false;
					}
				}
				return true;
			}
			
			if (differentRow == -differentColumn) {
				int loRow = Math.min(getRow(), destination.getRow());
				int loColumn = Math.min(getColumn(), destination.getColumn());
				int hiRow = Math.max(getRow(), destination.getRow());
				for (int r = hiRow - 1, c = loColumn + 1; r > loRow; r--, c++) {
					if (board.getPiece(new Location(r, c)) != null) {
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
