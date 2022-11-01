package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    // func : save people from user, friends, visitors and return it
    private static List<String> saveNames(String user, List<List<String>> friends, List<String> visitors){
       List<String> nameList = new ArrayList<>();

       // user input
        nameList.add(user);
       // friends input
        for (int i=0;i<friends.size();i++){
            for (int j=0;j<2;j++){
                String name = friends.get(i).get(j);
                // the name is not in nameList, add it
                if (!(nameList.contains(name)))
                    nameList.add(name);
            }
        }
        for (int i=0;i<visitors.size();i++){
            String name = visitors.get(i);
            if (!(nameList.contains(name)))
                nameList.add(name);
        }
        return nameList;
    }
    // func : calculate score by visit, return scoreboard
    private static List<Integer> visitScore(List<String> nameList, List<String> visitors, List<Integer> scoreboard){

        // plus visit score
        for (int i=0;i<visitors.size();i++){
            int idx = nameList.indexOf(visitors.get(i));
            scoreboard.set(idx, scoreboard.get(idx) + 1);
        }
        return scoreboard;
    }
    // func : calculate score by checking friendship
    // func : calculate score and return 5 recommends

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = saveNames(user,friends,visitors);
        List<Integer> scoreboard = new ArrayList<>();
        for (int i=0;i<6;i++)
            scoreboard.add(0);
        System.out.println(visitScore(answer, visitors, scoreboard));
        return answer;
    }
}
