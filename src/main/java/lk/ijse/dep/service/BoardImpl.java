package lk.ijse.dep.service;

public class BoardImpl implements Board{
    private Piece[][] pieces;
    private BoardUI boardUI;

    public  BoardImpl(){

    }
    public BoardImpl(BoardUI boardUI){
        setBoardUI(boardUI);
        this.pieces=new Piece[NUM_OF_COLS][NUM_OF_ROWS];

        //Initialize value to the 2D array
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < 5; j++) {
                pieces[i][j] = Piece.EMPTY;
            }
        }

    }

    private void setBoardUI(BoardUI boardUI) {
        this.boardUI=boardUI;
    }

    public Piece[][] getPieces() {
        return pieces;
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

        int empty =-1;
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            if(pieces[col][i].equals(Piece.EMPTY)){
                empty=i;
                break;
            }
        }
        return empty;
    }

    @Override
    public boolean isLegalMove(int col) {
        //checking whether there is a legal move

        boolean isLegal=true;
        int nextAvailableSpot = findNextAvailableSpot(col);
        if (nextAvailableSpot==-1){
            isLegal=false;
        }
        return isLegal;
    }

    @Override
    public boolean existLegalMove() {
        //Checking the empty space

        boolean existLegal=false;
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < 5; j++) {
                if (pieces[i][j].equals(Piece.EMPTY)) {
                    existLegal = true;
                    break;
                }
            }
        }
        return existLegal;
    }

    @Override
    public void updateMove(int col, Piece move) {

    }

    @Override
    public Winner findWinner() {
        return null;
    }


}
