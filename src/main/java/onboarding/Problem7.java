package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Problem7 {
    final static int friendA = 0;
    final static int friendB = 1;
    final static int friendshipPoint = 10;
    final static int visitPoint = 1;

    static String user;
    static Map<String, Integer> recommendationPoiont;


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static int notOperator(int friendAorB){
        if(friendAorB == friendA){
            return friendB;
        }
        else if(friendAorB == friendB){
            return friendA;
        }
        else{
            return -1;
        }
    }
}
