package lk.ijse.dep.service;

public interface BoardUI {
    //Abstract methods
    public void update(int col, boolean isHuman);
    public void notifyWinner(Winner winner);
}
