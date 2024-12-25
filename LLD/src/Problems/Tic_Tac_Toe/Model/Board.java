package Problems.Tic_Tac_Toe.Model;

public class Board {
    int size;
    Piece[][] board;

    public Board(int size) {
        this.size = size;
        board = new Piece[size][size];
    }

    public boolean addPiece(int i, int j, Piece piece) {
        if (i < 0 || i >= size || j < 0 || j >= size || board[i][j] != null) {
            return false; // Invalid move
        }
        board[i][j] = piece;
        return true;
    }

    public boolean checkWinner(Piece piece) {
        // Check rows and columns
        for (int i = 0; i < size; i++) {
            if (isRowComplete(i, piece) || isColComplete(i, piece)) {
                return true;
            }
        }

        // Check diagonals
        return isPrimaryDiagonalComplete(piece) || isSecondaryDiagonalComplete(piece);
    }

    public boolean isRowComplete(int row, Piece piece) {
        for (int j = 0; j < size; j++) {
            if (board[row][j] == null || board[row][j].type != piece.type) {
                return false;
            }
        }
        return true;
    }

    public boolean isColComplete(int col, Piece piece) {
        for (int i = 0; i < size; i++) {
            if (board[i][col] == null || board[i][col].type != piece.type) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrimaryDiagonalComplete(Piece piece) {
        for (int i = 0; i < size; i++) {
            if (board[i][i] == null || board[i][i].type != piece.type) {
                return false;
            }
        }
        return true;
    }

    public boolean isSecondaryDiagonalComplete(Piece piece) {
        for (int i = 0; i < size; i++) {
            if (board[i][size - i - 1] == null || board[i][size - i - 1].type != piece.type) {
                return false;
            }
        }
        return true;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[i][j].type + " ");
                }
            }
            System.out.println();
        }
    }
}
