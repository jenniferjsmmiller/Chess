
public class Knight extends Piece {
	
	/** constructor for Knight */
	
	public Knight(int row, int column, int color) {
		super(row, column, color);
	}
	
	/** returns image file for Chess class */
	
	public String getImageFileName() {
		if (this.getColor() == Board.BLACK) {
			return "ChessPieces" + java.io.File.separator + "BlackKnight.png";
		} else {
			return "ChessPieces" + java.io.File.separator + "WhiteKnight.png";
		}
	}
	
	/** returns if a given move on the board is legal for the Knight to move to */
	
	public boolean isLegal(Location destination, Board board) {
		if (board.getPiece(destination) != null
				&& board.getPiece(destination).getColor() == getColor()) {
			return false;
		} else {
			int differentRow = Math.abs(destination.getRow() - getRow());
			int differentColumn = Math.abs(destination.getColumn() - getColumn());
			
			if (differentRow == 1 && differentColumn == 2) {
				return true;
			}
			
			if (differentRow == 2 && differentColumn == 1) {
				return true;
			}
		}
		return false;
	}
	
	public boolean canUpgrade(Location destination, Board board) {
		return false;
	}
}
