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
    /*public void movePiece(int col) {
        col = this.predictColumn();
        this.board.updateMove(col, Piece.GREEN);
        this.board.getBoardUI().update(col, false);
        Winner winner = this.board.findWinner();
        if (winner.getWinningPiece() != Piece.EMPTY) {
            this.board.getBoardUI().notifyWinner(winner);
        } else if (!this.board.existLegalMove()) {
            this.board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
        }

    }

    private int predictColumn() {
        boolean isUserWinning = false;
        int tiedColumn = 0;

        int i;
        for(i = 0; i < 6; ++i) {
            if (this.board.isLegalMove(i)) {
                int row = this.board.findNextAvailableSpot(i);
                this.board.updateMove(i, Piece.GREEN);
                int heuristicVal = this.minimax(0, false);
                this.board.updateMove(i, row, Piece.EMPTY);
                if (heuristicVal == 1) {
                    return i;
                }

                if (heuristicVal == -1) {
                    isUserWinning = true;
                } else {
                    tiedColumn = i;
                }
            }
        }

        if (isUserWinning && this.board.isLegalMove(tiedColumn)) {
            return tiedColumn;
        } else {


            do {
                i = (int)(Math.random() * 6.0D);
            } while(!this.board.isLegalMove(i));

            return i;
        }
    }

    private int minimax(int depth, boolean maximizingPlayer) {
        Winner winner = this.board.findWinner();
        if (winner.getWinningPiece() == Piece.GREEN) {
            return 1;
        } else if (winner.getWinningPiece() == Piece.BLUE) {
            return -1;
        } else if (this.board.existLegalMove() && depth != 2) {
            int i;
            int row;
            int heuristicVal;
            if (!maximizingPlayer) {
                for(i = 0; i < 6; ++i) {
                    if (this.board.isLegalMove(i)) {
                        row = this.board.findNextAvailableSpot(i);
                        this.board.updateMove(i, Piece.BLUE);
                        heuristicVal = this.minimax(depth + 1, true);
                        this.board.updateMove(i, row, Piece.EMPTY);
                        if (heuristicVal == -1) {
                            return heuristicVal;
                        }
                    }
                }
            } else {
                for(i = 0; i < 6; ++i) {
                    if (this.board.isLegalMove(i)) {
                        row = this.board.findNextAvailableSpot(i);
                        this.board.updateMove(i, Piece.GREEN);
                        heuristicVal = this.minimax(depth + 1, false);
                        this.board.updateMove(i, row, Piece.EMPTY);
                        if (heuristicVal == 1) {
                            return heuristicVal;
                        }
                    }
                }
            }

            return 0;
        } else {
            return 0;
        }
    }*/

}