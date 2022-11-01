package onboarding;

import java.util.*;

class Recommendation {
    String user;
    List<List<String>> friends;
    List<String> visitors;
    HashMap<String, Integer> users;

    public Recommendation(String user, List<List<String>> friends, List<String> visitors) {
        this.user = user;
        this.friends = friends;
        this.visitors = visitors;
        this.users = new HashMap<>();
    }

}
