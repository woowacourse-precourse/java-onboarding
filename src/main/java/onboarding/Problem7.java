package onboarding;

import java.util.*;

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

    public static List<String> orgainze(String user, List<List<String>> friends, List<String> visitors) {
        memberList.clear();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < friends.get(i).size(); j++) {
                memberList.add(friends.get(i).get(j));
            }
        }
        for(int i=0; i<visitors.size(); i++){
            memberList.add(visitors.get(i));
        }
        Set<String> set = new HashSet<String>(memberList);
        List<String> newlist = new ArrayList<String>(set);
        newlist.remove(user);
        Collections.sort(newlist);
        return newlist;
    }
}
