package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
        List<String> answer = null;
        HashSet<String> alreadyFriends = CheckAlreadyFriend(user, friends); // 이미 친구인 목>
        ArrayList<String> nicknames = new ArrayList<>();


        System.out.print(alreadyFriends);
        //int[] scores = new int[nicknames.length];
//
//        for (String nickname : nicknames)
//            System.out.println(nickname);
        return answer;
    }

    public static HashSet<String> CheckAlreadyFriend(String user, List<List<String>> friends) {
        HashSet<String> checker = new HashSet<>();
        for (List<String> i : friends) {
            if (user.equals(i.get(0))) {
                checker.add(i.get(1));
            } else if (user.equals(i.get(1))) {
                checker.add(i.get(0));
            }
        }
        return checker;
    }
}
//    public static ArrayList<String> RecommendFriends(String user, List<List<String>> friends, List<String> visitors) {
//        LinkedHashSet<String> nameList = new LinkedHashSet<>();
//    }
//    public static HashSet<String> CheckAlreadyFriend(String user, List<List<String>> friend){
//        for(int i = 0; i < friends.size(); i ++ ){
//
//        }
//    }
//    public static String[] MakeNameBoard(String user, List<List<String>> friends, List<String> visitors, HashSet<String> alreadyFriends){
//        LinkedHashSet<String> nameBoard = new LinkedHashSet<>();
//        for(int i = 0; i < friends.size(); i ++ ){
//            String name0 = friends.get(i).get(0);
//            String name1 = friends.get(i).get(1);
//            if(!(user.equals(name0)) && !(user.equals(name1))) {
//                nameBoard.add(name0);
//                nameBoard.add(name1);
//            }
//        }
//
//        for(int i = 0; i < visitors.size(); i ++ ){
//            if(!(user.equals(visitors.get(i)))){
//                nameBoard.add(visitors.get(i));
//            }
//        }
//        return nameBoard.toArray(new String[0]);
//    }

