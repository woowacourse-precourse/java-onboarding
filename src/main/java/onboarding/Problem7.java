package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class UsersInformation {
    private String user;
    private List<List<String>> friends;
    private List<String> usersFriends;
    private List<String> visitors;
    private List<String> recomendFriends;

    public void setUser(String name) {
        user = name;
    }

    public void setFriends(List<List<String>> list) {
        friends = list;
    }

    public void setVisitors(List<String> list) {
        visitors = list;
    }

    public String getUser() {
        return user;
    }

    public List<List<String>> getFriends() {
        return friends;
    }

    public List<String> getVisitors() {
        return visitors;
    }

    public List<String> getRecomendFriends() {
        return recomendFriends;
    }
}

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
