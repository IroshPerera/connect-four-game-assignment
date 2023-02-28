package lk.ijse.dep.service;


public class AiPlayer extends Player {
    public AiPlayer(Board board) {
        this.board=board;
    }

    @Override
    public void movePiece(int col){

        col=minMax();
        board.updateMove(col, Piece.GREEN);
        board.getBoardUI().update(col, false);
        Winner winner = board.findWinner();
        if(winner.getWinningPiece().equals(Piece.BLUE)||winner.getWinningPiece().equals(Piece.GREEN)) {
            board.getBoardUI().notifyWinner(winner);
        }

    }


    private int minMax() {
        for (int i = 0; i < 6; i++) {
            if(board.isLegalMove(i)){
                int row = board.findNextAvailableSpot(i);
                board.updateMove(i,Piece.GREEN);
                if(board.findWinner().getWinningPiece().equals(Piece.GREEN)){
                    board.updateMove(i,row,Piece.EMPTY);
                    return i;
                }else{
                    board.updateMove(i,row,Piece.EMPTY);
                }
            }

        }for (int i = 0; i < 6; i++) {
            if(board.isLegalMove(i)){
                int row = board.findNextAvailableSpot(i);
                board.updateMove(i,Piece.BLUE);
                if(board.findWinner().getWinningPiece().equals(Piece.BLUE)){
                    board.updateMove(i,row,Piece.EMPTY);
                    return i;

                }else{
                    board.updateMove(i,row,Piece.EMPTY);
                }
            }

        }
        int num;
        do{
            num= (int) (Math.random() * 6);
        }while (!board.isLegalMove(num));

        return num;
    }


}