
public class Chess {

	/** handles interaction */
	
	public static final java.awt.Color DARK_GREEN = new java.awt.Color(0, 63, 0);
	public static final java.awt.Color BROWN = new java.awt.Color(139, 69, 19);
	public static final java.awt.Color LIGHT_BROWN = new java.awt.Color(222, 184, 135);
	private static final int ROWS = 8;
	private static final int COLUMNS = 8;
	private Board chessboard;
	private java.awt.Color[][] coloredSquares;

	public static void main(String[] args) {
		new Chess().run();
	}

	/** instance of Chess */
	
	public Chess() {
		StdDraw.setXscale(0, 8);
		StdDraw.setYscale(0, 8);
		chessboard = new Board();
		coloredSquares = new java.awt.Color[8][8];
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLUMNS; c++) {
				if (r % 2 == c % 2) {
					coloredSquares[r][c] = BROWN;
				} else {
					coloredSquares[r][c] = LIGHT_BROWN;
				}
			}
		}
	}

	/** draws board and pieces */
	
	public void draw() {
		// draw background
		StdDraw.clear(DARK_GREEN);
		// draw board
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLUMNS; c++) {
				StdDraw.setPenColor(coloredSquares[r][c]);
				StdDraw.filledSquare(c + 0.5, r + 0.5, 0.5);
				// draws pieces
				Piece p = chessboard.getPiece(new Location(r, c));
				if (p != null) {
					StdDraw.filledSquare(c + 0.5, r + 0.5, 0.4);
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.picture(c + 0.5, r + 0.5, p.getImageFileName(), 0.8, 0.8);
				}
			}
		}
		StdDraw.show(10);
	}

	/** plays the game */
	
	public void run() {
		draw();
		while (!chessboard.isGameOver()) {
			Location source;
			do {
				source = waitForClick();
			} while (source == null || !chessboard.isLegalSource(source));
			Location destination;
			do {
				destination = waitForClick();
			} while (!chessboard.isLegalMove(source, destination));
			chessboard.move(source, destination);
			draw();
		}
	}

	/** waits for user to click and returns location where they clicked */
	
	public Location waitForClick() {
		while (!StdDraw.mousePressed()) {
			// wait for mouse press
		}
		double x = StdDraw.mouseX();
		double y = StdDraw.mouseY();
		while (StdDraw.mousePressed()) {
			// wait for mouse release
		}
		Location result = new Location((int) y, (int) x);
		if (chessboard.isOnBoard(result)) {
			return result;
		}
		return null;
	}

}
