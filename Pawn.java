public class Pawn extends Piece {

	public boolean hasMoved;
	public boolean enPassant = false;

	/** constructor for Pawn */
	public Pawn(int row, int column, int color) {
		super(row, column, color);
		this.hasMoved = false;
	}

	/** returns image file for Chess class */
	
	public String getImageFileName() {
		if (this.getColor() == Board.BLACK) {
			return "ChessPieces" + java.io.File.separator + "BlackPawn.png";
		} else {
			return "ChessPieces" + java.io.File.separator + "WhitePawn.png";
		}
	}

	/** returns if a given move on the board is legal for the Pawn to move to */
	
	public boolean isLegal(Location destination, Board board) {
		if (board.getPiece(destination) != null
				&& board.getPiece(destination).getColor() == getColor()) {
			return false;
		} else {

			if (this.getColor() == Board.WHITE) {
				if (this.getRow() > destination.getRow()) {
					return false;
				}
			} else if (this.getColor() == Board.BLACK) {
				if (this.getRow() < destination.getRow()) {
					return false;
				}
			}

			if (this.getColumn() == destination.getColumn()) {
				if (this.getColor() == Board.WHITE) {
					if (board.getPiece(new Location(getRow() + 1, getColumn())) != null) {
						return false;
					}
				} else if (this.getColor() == Board.BLACK) {
					if (board.getPiece(new Location(getRow() - 1, getColumn())) != null) {
						return false;
					}
				}

				int differentRow = Math.abs(destination.getRow() - this.getRow());

				if (differentRow > 2) {
					return false;
				} else if (differentRow == 2) {
					if (hasMoved) {
						return false;
					}

					if (this.getColor() == Board.WHITE) {
						if (board.getPiece(new Location(this.getRow() + 2, this
								.getColumn())) != null) {
							return false;
						}
					} else if (this.getColor() == Board.BLACK) {
						if (board.getPiece(new Location(this.getRow() - 2, this
								.getColumn())) != null) {
							return false;
						}
					}
				}
				
				if (destination.getColumn() + 1 < 8) {
					if (board.getPiece(new Location(destination.getRow(), destination.getColumn() + 1)) != null) {
						 if(board.getPiece(new Location(destination.getRow(), destination.getColumn() + 1)).getClass().isInstance(new Pawn(this.getRow(), this.getColumn(), Board.WHITE))){
	                            enPassant = true;
	                        }
					}
				} else if (destination.getColumn() - 1 > 0) {
					if (board.getPiece(new Location(destination.getRow(), destination.getColumn() - 1)) != null) {
						 if(board.getPiece(new Location(destination.getRow(), destination.getColumn() - 1)).getClass().isInstance(new Pawn(this.getRow(), this.getColumn(), Board.WHITE))){
	                            enPassant = true;
						 }
					}	 
				}

			} else {

				int differentRow = Math.abs(destination.getRow() - this.getRow());
				int differentColumn = Math.abs(destination.getColumn() - this.getColumn());
				
				if (differentColumn != 1 || differentRow != 1) {
					return false;
				}
				
				if (board.getPiece(destination) == null) {
					return false;
				}
			}
			return true;
		}
	}
	
	public boolean canUpgrade(Location destination, Board board) {
		if (!isLegal(destination, board)) {
			return false;
		} else {
			if (this.getColor() == Board.WHITE) {
				for (int c = 0; c < 8; c++) {
					if (destination.getRow() == 7) {
						return true;
					}
				}
			}
			
			if (this.getColor() == Board.BLACK) {
				for (int c = 0; c < 8; c++) {
					if (destination.getRow() == 0) {
						return true;
					}
				}
			}
		}
		return false;
	}

}