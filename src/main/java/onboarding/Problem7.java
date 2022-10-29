package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String,Integer> userScores = initFriends(user,friends);
        //add visitor count
        for (String s : visitors) {
            if (userScores.get(s) == null) {
                userScores.put(s,1);
            }
            else if (userScores.get(s) != -1) {
                userScores.put(s,userScores.get(s)+1);
            }
        }
        //hashmap to arraylist > sort
        return answer;
    }

    public static HashMap<String,Integer> initFriends(String user, List<List<String>> friends) {
        HashMap<String,Integer> userScores = new HashMap<>();
        for (List i : friends) {
            if (i.get(0)==user) {
                if (userScores.get(i.get(1))!=null) {
                    userScores.put(i.get(1).toString(),-1);
                }
            }
            if (i.get(1)==user) {
                if (userScores.get(i.get(0))!=null) {
                    userScores.put(i.get(0).toString(),-1);
                }
            }
            if (i.get(0)!=user && i.get(1)!=user) {
                if (userScores.get(i.get(0))==null) {
                    userScores.put(i.get(0).toString(),0);
                }
                if (userScores.get(i.get(1))==null) {
                    userScores.put(i.get(1).toString(),0);
                }
                if (userScores.get(i.get(0))!=null) {
                    userScores.put(i.get(0).toString(),
                            userScores.get(i.get(0))+10);
                }
                if (userScores.get(i.get(1))!=null) {
                    userScores.put(i.get(1).toString(),
                            userScores.get(i.get(1))+10);
                }
            }
        }
        return userScores;
    }
}
