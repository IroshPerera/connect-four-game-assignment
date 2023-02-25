package lk.ijse.dep.service;

public class BoardImpl implements Board{
    private Piece[][] pieces;
    private BoardUI boardUI;

    public  BoardImpl(){

    }
    public BoardImpl(BoardUI boardUI){
        setBoardUI(boardUI);
        this.pieces=new Piece[NUM_OF_COLS][NUM_OF_ROWS];

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
        return 0;
    }

    @Override
    public boolean isLegalMove(int col) {
        return false;
    }

    @Override
    public boolean existLegalMove() {
        return false;
    }

    @Override
    public void updateMove(int col, Piece move) {

    }

    @Override
    public Winner findWinner() {
        return null;
    }


}
