package lk.ijse.dep.service;

public interface BoardUI {
    //Abstract methods
    void update(int col, boolean isHuman);
    void notifyWinner(Winner winner);
}
