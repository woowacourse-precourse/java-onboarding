package onboarding;

import java.util.*;

public class Problem7 {
    public static boolean checkParameter(String user, List<List<String>> friends, List<String> visitors) {
        //user는 길이가 1 이상 30 이하인 문자열이다.
        if(user.length() < 1 || user.length() > 30) {
            return false;
        }

        //friends는 길이가 1 이상 10,000 이하인 리스트/배열이다.
        if(friends.size() < 1 || friends.size() > 10000) {
            return false;
        }

        //visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
        if(visitors.size() > 10000) {
            return false;
        }

        return true;
    }



    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        if(!checkParameter(user, friends, visitors)) {
            return answer;
        }

    }
}
