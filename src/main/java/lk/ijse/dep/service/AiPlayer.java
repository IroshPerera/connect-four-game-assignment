package lk.ijse.dep.service;

import java.util.Random;

public class AiPlayer extends Player{

    public AiPlayer(Board newBoard) {
    this.board=newBoard;
    }
    @Override
    public void movePiece(int col){
        Random random =new Random();
        int num;
        boolean legalMove;
        do {

            num = random.nextInt(6);
            legalMove= board.isLegalMove(num);

        }while (!legalMove);

        if (legalMove){
            board.updateMove(num, Piece.GREEN);
            board.getBoardUI().update(num, false);
            board.findWinner();

        }
    }
}
