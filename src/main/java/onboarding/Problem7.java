package onboarding;

import model.FriendAlgorithms;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        if (!friendsIdValidCheck(friends) || !idValidCheck(user) || !visitorsIdValidCheck(visitors))
            return List.of("아이디 에러");

        FriendAlgorithms friendAlgorithms = new FriendAlgorithms(user, friends, visitors);
        return friendAlgorithms.friendRecommend();
    }
    static boolean friendsIdValidCheck(List<List<String>> friends){
        for (List<String> friendship: friends) {
            for (String user: friendship) {
                if (!idValidCheck(user))
                    return false;
            }
        }
        return true;
    }
    static boolean visitorsIdValidCheck(List<String> visitors){
        for (String visitor: visitors) {
            if (!idValidCheck(visitor))
                return false;
        }
        return true;
    }

    static boolean idValidCheck(String user){
        Pattern pattern = Pattern.compile("^[a-z]+$");
        Matcher matcher = pattern.matcher(user);
        return matcher.find() && user.length() >= 1 && user.length() <= 31;
    }
}
