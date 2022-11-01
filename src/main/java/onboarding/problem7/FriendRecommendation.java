package onboarding.problem7;

import java.util.List;

public class FriendRecommendation {
    private String user;
    private List<List<String>> friends;
    private List<String> visitors;
    
    public FriendRecommendation(String user, List<List<String>> friends, List<String> visitors){
        this.user = user;
        this.friends = friends;
        this.visitors = visitors;
    }
}
