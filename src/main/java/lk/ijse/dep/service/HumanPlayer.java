package lk.ijse.dep.service;

public class HumanPlayer extends Player{

    public HumanPlayer(Board newBoard) {

        this.board=newBoard;
    }
    @Override
    public void movePiece(int col) {
        if (board.isLegalMove(col)) {
            board.updateMove(col, Piece.BLUE);
            board.getBoardUI().update(col, true);
            Winner winner = board.findWinner();
            if(winner.getWinningPiece().equals(Piece.BLUE)||winner.getWinningPiece().equals(Piece.GREEN)) {
                board.getBoardUI().notifyWinner(winner);
            }

        }

        }


}
