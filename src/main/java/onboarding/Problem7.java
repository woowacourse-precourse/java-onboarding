package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    private static List<String> memberList = new ArrayList<>();
    private static List<Integer> scoreList = new ArrayList<>();
    private static List<String> friendsList = new ArrayList<>();
    private static String member =new String();
    private static int memberScore =0;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return rankMemberList(user, friends, visitors);
    }
}
