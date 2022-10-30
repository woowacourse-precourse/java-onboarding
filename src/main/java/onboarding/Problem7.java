package onboarding;

import java.util.Collections;
import java.util.List;

class scoreConstant{
    static final int friendsFriendScore = 10;
    static final int visitorScore = 1;
}
class usersInformation{
    private static String user;
    private static List<List<String>> friends;
    private static List<String> visitors;
    public static void setUser(String name) {
        user = name;
    }
    public static void setFriends(List<List<String>> list) {
        friends = list;
    }
    public static void setVisitors(List<String> list) {
        visitors = list;
    }
    public static String getUser() {
        return user;
    }
    public static List<List<String>> getFriends() {
        return friends;
    }
    public static List<String> getVisitors() {
        return visitors;
    }
}
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
