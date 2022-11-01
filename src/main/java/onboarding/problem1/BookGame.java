package onboarding.problem1;

import java.util.List;

public class BookGame {
    private User user1, user2;

    public BookGame(List<Integer> page1, List<Integer> page2){
        this.user1 = new User(page1);
        this.user2 = new User(page2);
    }
}
