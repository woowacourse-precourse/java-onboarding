package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        return answer;
    }
    static HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();

    static void addScore(String name, int score) {
        if(scoreMap.get(name)==null) {
            scoreMap.put(name, score);
        } else {
            scoreMap.put(name, scoreMap.get(name)+score);
        }
    }
    public static Set<String> getFriendsOfUser(String user, List<List<String>> friends) {
        Set<String> setFriendsOfUser = new HashSet<String>();
        for(int i=0; i<=friends.size()-1; i++) {
            if(friends.get(i).get(0).equals(user)) {
                setFriendsOfUser.add(friends.get(i).get(1));
            } else if(friends.get(i).get(1).equals(user)) {
                setFriendsOfUser.add(friends.get(i).get(0));
            }
        }
        return setFriendsOfUser;
    }
    public static void getFriendsOfFriends(Set<String> setFriendsOfUser,List<List<String>> friends){
        for(String name : setFriendsOfUser) {
            for(int i=0; i<=friends.size()-1; i++) {
                if(friends.get(i).get(0).equals(name)) {
                    addScore(friends.get(i).get(1),10);
                } else if(friends.get(i).get(1).equals(name)) {
                    addScore(friends.get(i).get(0),10);
                }
            }
        }
    }

    public static void getVisitors(List<String> visitors){
        for(String name : visitors) {
            addScore(name, 1);
        }
    }

    public static void deleteNameFromMap(String user, Set<String> getFriendsOfUser ){
        ArrayList<String> deleteNames = new ArrayList<String>();
        deleteNames.add(user);
        for(String key : getFriendsOfUser){
            deleteNames.add(key);
        }

        for(String name : deleteNames) {
            scoreMap.remove(name);
        }
    }
    public static List<String> sortName(HashMap<String,Integer> scores) {
        List<String> scoreList = new ArrayList(scores.keySet());
        List<String> name = new ArrayList<>();
        List<Integer> score = new ArrayList<>();

        scoreList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return scores.get(o2).compareTo(scores.get(o1));
            }
        });


        for (String key : scoreList) {
            score.add(scores.get(key));
            name.add(key);
        }

        return name;
    }

}
