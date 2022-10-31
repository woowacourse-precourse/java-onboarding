package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, Integer> scoreRecord = initialSettings(user,friends,visitors);

        Statusbyfriends(friends, user, scoreRecord);
        scoreRecord.remove(user);

        statusByVisitors(visitors,scoreRecord);
        for(int g=0; g < returnDirectFriends(friends,user).size(); g++) {
            scoreRecord.remove(returnDirectFriends(friends,user).get(g));
        }

        return sortedResult(scoreRecord);
    }

    public static Map<String, Integer>  initialSettings(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> scoreRecord = new HashMap<>();
        HashSet<String> people_set = new HashSet<>();
        for(int i=0; i<friends.size();i++) {
            for(int j=0; j<2; j++){
                people_set.add(friends.get(i).get(j));
            }
        }
        for(int k=0; k<visitors.size();k++){
            people_set.add(visitors.get(k));
//            System.out.println(people_set);
        }



        List<String> people =List.copyOf(people_set);
        System.out.println("People List: " + people);
        //초기 점수 세팅(이름: 0점)
        for(int i=0; i<people.size(); i++) {
            scoreRecord.put(people.get(i),0);
        }
        System.out.println(scoreRecord);
        return scoreRecord;
    }

    public static ArrayList<String> returnDirectFriends(List<List<String>> friends, String user){
        ArrayList<String> direct_friends = new ArrayList<>();
        for(int i=0; i<friends.size(); i++){
            for(int j=0; j<2; j++) {
                if (friends.get(i).get(j).equals(user)){
                    if(j==0) direct_friends.add(friends.get(i).get(1));
                    else direct_friends.add(friends.get(i).get(0));
                }
            }
        }
        return direct_friends;
    }
    public static void Statusbyfriends(List<List<String>> friends, String user, Map<String, Integer> scoreRecord) {
        ArrayList<String> direct_friends = returnDirectFriends(friends,user);
        //2번 거친 친구 구하기
        for(int i=0; i<friends.size(); i++) {
            for(int k=0; k<2; k++) {
                for(int j=0; j<direct_friends.size(); j++) {
                    if(friends.get(i).get(k) == direct_friends.get(j)) {
                        if(k==0) scoreRecord.put(friends.get(i).get(k+1), scoreRecord.get(friends.get(i).get(k+1))+10);
                        else scoreRecord.put(friends.get(i).get(k-1), scoreRecord.get(friends.get(i).get(k-1))+10);
                    }
                }
            }
        }
    }
    public static void statusByVisitors(List<String> visitors, Map<String, Integer> scoreRecord) {

        for(int i=0; i<visitors.size();i++) {
            System.out.println(scoreRecord);
            scoreRecord.put(visitors.get(i), scoreRecord.get(visitors.get(i))+1);
        }
    }

    public static List<String> sortedResult(Map<String, Integer> scoreRecord) {
        List<String > result = new ArrayList<>();

        List<String> keySet = new ArrayList<>(scoreRecord.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return scoreRecord.get(o2).compareTo(scoreRecord.get(o1));
            }
        });
        int prev;
        for (String key : keySet) {

            System.out.print("Key : " + key);
            System.out.println(", Val : " + scoreRecord.get(key));
            result.add(key);

        }

    return result;
    }
}
