package lk.ijse.dep.service;

public class BoardImpl implements Board {
    private Piece[][] pieces;
    private BoardUI boardUI;

    public BoardImpl() {
    }

    public BoardImpl(BoardUI boardUI) {
        setBoardUI(boardUI);
        this.pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];

        //Initialize value to the 2D array
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < NUM_OF_ROWS; j++) {
                pieces[i][j] = Piece.EMPTY;
            }
        }

    }

    private void setBoardUI(BoardUI boardUI) {
        this.boardUI = boardUI;
    }


    public void setPieces(Piece[][] pieces) {
        this.pieces = pieces;
    }

    public BoardUI getBoardUI() {
        return boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {
        //Checking the empty space in a specific column

        int empty = -1;
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            if (pieces[col][i].equals(Piece.EMPTY)) {
                empty = i;
                break;
            }
        }
        return empty;
    }

    @Override
    public boolean isLegalMove(int col) {
        //checking whether there is a legal move

        boolean isLegal = true;
        int nextAvailableSpot = findNextAvailableSpot(col);
        if (nextAvailableSpot == -1) {
            isLegal = false;
        }
        return isLegal;
    }

    @Override
    public boolean existLegalMove() {
        //Checking the empty space

        boolean existLegal = false;
        for (Piece[] piece : pieces) {
            for (int j = 0; j < NUM_OF_ROWS; j++) {
                if (piece[j].equals(Piece.EMPTY)) {
                    existLegal = true;
                    break;
                }
            }
        }
        return existLegal;
    }

    @Override
    public void updateMove(int col, Piece move) {
        int nextAvailableSpot = findNextAvailableSpot(col);
        if (nextAvailableSpot != -1) {
            pieces[col][nextAvailableSpot] = move;
        }
    }

    @Override
    public void updateMove(int col, int row, Piece move) {
            pieces[col][row] = move;
    }

    @Override
    public Winner findWinner() {

        if(!existLegalMove()){
            getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
        }

        for (int i = 0; i < NUM_OF_COLS; i++) {
            if (pieces[i][1].equals(Piece.BLUE) & pieces[i][2].equals(Piece.BLUE) & pieces[i][3].equals(Piece.BLUE)) {
                if (pieces[i][0].equals(Piece.BLUE)) {
                    return new Winner(Piece.BLUE, i, 0, i, 3);

                } else if (pieces[i][4].equals(Piece.BLUE)) {
                    return new Winner(Piece.BLUE, i, 1, i, 4);
                }
            } else if (pieces[i][1].equals(Piece.GREEN) & pieces[i][2].equals(Piece.GREEN) & pieces[i][3].equals(Piece.GREEN)) {
                if (pieces[i][0].equals(Piece.GREEN)) {
                    return new Winner(Piece.GREEN, i, 0, i, 3);

                } else if (pieces[i][4].equals(Piece.GREEN)) {
                    return new Winner(Piece.GREEN, i, 1, i, 4);
                }
            }
        }

            for (int j = 0; j < NUM_OF_ROWS; j++) {
                if(pieces[2][j].equals(Piece.BLUE) & pieces[3][j].equals(Piece.BLUE)) {
                    if (pieces[0][j].equals(Piece.BLUE) & pieces[1][j].equals(Piece.BLUE)) {
                        return new Winner(Piece.BLUE, 0, j, 3, j);
                    } else if (pieces[1][j].equals(Piece.BLUE) & pieces[4][j].equals(Piece.BLUE)) {
                        return new Winner(Piece.BLUE, 1, j, 4, j);
                    } else if (pieces[4][j].equals(Piece.BLUE) & pieces[5][j].equals(Piece.BLUE)) {
                        return new Winner(Piece.BLUE, 2, j, 5, j);
                    }
                }else if (pieces[2][j].equals(Piece.GREEN) & pieces[3][j].equals(Piece.GREEN))
                    if (pieces[0][j].equals(Piece.GREEN) & pieces[1][j].equals(Piece.GREEN)) {
                        return new Winner(Piece.GREEN, 0, j, 3, j);
                    } else if (pieces[1][j].equals(Piece.GREEN) & pieces[4][j].equals(Piece.GREEN)) {
                        return new Winner(Piece.GREEN, 1, j, 4, j);
                    } else if (pieces[4][j].equals(Piece.GREEN) & pieces[5][j].equals(Piece.GREEN)) {
                        return new Winner(Piece.GREEN, 2, j, 5, j);
                    }
        }

        return new Winner(Piece.EMPTY);
    }
}
