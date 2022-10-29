package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private final String name;
    private final List<List<String>> friends;
    private final List<String> visitors;

    private final List<String> relationships = new ArrayList<String>();

    private final Map<String, Integer> SCORES_BY_USERS = new HashMap<String, Integer>();

    public User(String name, List<List<String>> friends, List<String> visitors) {
        this.name = name;
        this.friends = friends;
        this.visitors = visitors;
    }
}
