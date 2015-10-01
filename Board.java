
public class Board {

	public final static int BLACK = 0;
	public final static int WHITE = 1;
	private static int ROWS = 8;
	private static int COLUMNS = 8;
	private int currentPlayer;
	private Piece[][] board;

	/** constructor for Board, places pieces, ensures WHITE moves first */
	
	public Board() {
		board = new Piece[ROWS][COLUMNS];

		board[0][0] = new Rook(0, 0, WHITE);
		board[0][1] = new Knight(0, 1, WHITE);
		board[0][2] = new Bishop(0, 2, WHITE);
		board[0][3] = new King(0, 3, WHITE);
		board[0][4] = new Queen(0, 4, WHITE);
		board[0][5] = new Bishop(0, 5, WHITE);
		board[0][6] = new Knight(0, 6, WHITE);
		board[0][7] = new Rook(0, 7, WHITE);

		board[7][0] = new Rook(7, 0, BLACK);
		board[7][1] = new Knight(7, 1, BLACK);
		board[7][2] = new Bishop(7, 2, BLACK);
		board[7][3] = new King(7, 3, BLACK);
		board[7][4] = new Queen(7, 4, BLACK);
		board[7][5] = new Bishop(7, 5, BLACK);
		board[7][6] = new Knight(7, 6, BLACK);
		board[7][7] = new Rook(7, 7, BLACK);

		for (int c = 0; c < 8; c++) {
			board[1][c] = new Pawn(1, c, WHITE);
			board[6][c] = new Pawn(6, c, BLACK);
		}
		currentPlayer = WHITE;
	}

	/** get current player, BLACK or WHITE */
	
	public int getCurrentPlayer() {
		return currentPlayer;
	}

	/** instance of Board */
	
	public Piece[][] getBoard() {
		return board;
	}

	/** returns piece at a given location */
	
	public Piece getPiece(Location location) {
		return board[location.getRow()][location.getColumn()];
	}

	/** adds a piece to a new location */
	
	public void addPiece(Piece piece, int row, int column) {
		board[row][column] = piece;
	}

	/** removes a piece (aka if it gets captured or upgraded) */
	
	public void removePiece(int row, int column) {
		board[row][column] = null;
	}
	
//	public void upgradePiece(Piece piece, Location destination) {
//		Location destination = 
//		if (piece.canUpgrade())
//		
//	}

	/** returns true if game is over (i.e. checkmate or stalemate) */
	
	public boolean isGameOver() {
		return false;
	}

	/** returns true if player can move from source */
	
	public boolean isLegalSource(Location source) {
		Piece piece = board[source.getRow()][source.getColumn()];
		if ((isOnBoard(source)) && (getPiece(source) != null) 
				&& (getCurrentPlayer() == getPiece(source).getColor())
				&& piece.possibleMoves(this).size() > 0)  {
			return true;
		}
		return false;
	}

	/** returns true if legal to move from source to destination */
	
	public boolean isLegalMove(Location source, Location destination) {
		if (isOnBoard(source) && isOnBoard(destination) 
				&& getPiece(source).isLegal(destination, this)) {
			return true;
		} else {
			return false;
		}	
	}

	/** moves piece from source to destination */
	
	public void move(Location source, Location destination) {
		Piece piece = getPiece(source);
		removePiece(source.getRow(), source.getColumn());
		addPiece(piece, destination.getRow(), destination.getColumn());
		piece.setLocation(destination);
		togglePlayer();
	}

	/** determines if the location is on the board */
	
	public boolean isOnBoard(Location location) {
		return location.getRow() >= 0 && location.getRow() < ROWS
				&& location.getColumn() >= 0 && location.getColumn() < COLUMNS;
	}

	/** toggles between WHITE and BLACK */
	
	public void togglePlayer() {
		if (currentPlayer == WHITE) {
			currentPlayer = BLACK;
		} else {
			currentPlayer = WHITE;
		}
	}
	
	public boolean isCheck() {
		return false;
	}

	/** will check if there is a checkmate or not */
	
	public boolean isCheckmate() {
		return true;
	}

	/** will check for a stalemate */
	
	public boolean isDraw() {
		return false;
	}
}


