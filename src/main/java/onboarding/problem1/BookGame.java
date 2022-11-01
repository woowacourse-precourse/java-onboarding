package onboarding.problem1;

import java.util.List;

public class BookGame {
    private User user1, user2;
    private int user1Score, user2Score;

    public BookGame(List<Integer> page1, List<Integer> page2){
        this.user1 = new User(page1);
        this.user2 = new User(page2);
    }

    private boolean checkValidation(){
        try{
            user1.checkPageValidation();
            user2.checkPageValidation();
            return true;
        } catch (PageException e) {
            return false;
        }
    }

    private void getUsersScore(){
        user1Score = user1.getUserScore();
        user2Score = user2.getUserScore();
    }
}
