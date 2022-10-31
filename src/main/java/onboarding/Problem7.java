package onboarding;


import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> friendMember = new ArrayList<>();
        HashMap<String,Integer> friendScore = new HashMap<>();


        friendMember = friendList(user, friendMember, friends);
        friendScore = calcBothFriend(user,friendScore,friendMember,friends);
        friendScore = calcVisited(friendScore,friendMember,visitors);

        List<Map.Entry<String, Integer>> sortlist = new LinkedList<>(friendScore.entrySet());
        sortlist.sort(Map.Entry.comparingByKey());
        sortlist.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int printValue=sortlist.size();
        if(sortlist.size()>5){
            printValue=5;
        }
        for(int i=0; i<printValue; i++){
            answer.add(sortlist.get(i).getKey());
        }


        return answer;
    }

    private static List friendList(String user, List<String> friendMember, List<List<String>> friends){
        for(int i=0; i<friends.size(); i++) {
            if (user.equals(friends.get(i).get(0))) {
                friendMember.add(friends.get(i).get(1));
            } else if (user.equals(friends.get(i).get(1))) {
                friendMember.add(friends.get(i).get(0));
            }
        }
        return friendMember;
    }
    private static HashMap calcBothFriend(String user,HashMap<String,Integer> friendScore, List<String> friendMember,  List<List<String>> friends){
        for(int i=0; i<friendMember.size(); i++){
            String userFriend = friendMember.get(i);
            for(int j=0; j<friends.size(); j++){
                String firstName = friends.get(j).get(0);
                String secondName = friends.get(j).get(1);
                if(firstName == user || secondName == user) continue;

                if(firstName.equals(userFriend) && friendMember.contains(firstName)){
                    int score = 0;
                    if(!friendScore.containsKey(secondName))
                        friendScore.put(secondName,0);
                    score += friendScore.get(secondName) + 10;
                    friendScore.put(secondName,score);
                }
                if(secondName.equals(userFriend) && friendMember.contains(secondName)){
                    int score = 0;
                    if(!friendScore.containsKey(firstName))
                        friendScore.put(firstName,0);
                    score += friendScore.get(firstName) + 10;
                    friendScore.put(firstName,score);
                }
            }
        }
        return friendScore;
    }


    private static HashMap calcVisited(HashMap<String,Integer> friendScore, List<String> friendMember, List<String> visitor){
        int score=0;
        for(int i=0; i<visitor.size(); i++) {
            if (!friendMember.contains(visitor.get(i))) {
                if(!friendScore.containsKey(visitor.get(i)))
                    friendScore.put(visitor.get(i),0);
                score = friendScore.get(visitor.get(i))+1;
                friendScore.put(visitor.get(i),score);
            }
        }
        return friendScore;
    }

}
