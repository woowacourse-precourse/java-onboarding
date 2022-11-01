package onboarding;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> friendsScore= new HashMap<>();
        List<FriendScore> friendsScoreSorted= new ArrayList<>();
        HashMap<String, List<String>> friendsMap= new HashMap<>();

        for(int i = 0 ; i < friends.size() ; i++){
            List<String> nowSet =friends.get(i);
            if(friendsMap.containsKey(nowSet.get(0)))
                friendsMap.get(nowSet.get(0)).add(nowSet.get(1));
            else
                friendsMap.put(nowSet.get(0), new ArrayList<>(List.of(nowSet.get(1))));
            if(friendsMap.containsKey(nowSet.get(1)))
                friendsMap.get(nowSet.get(1)).add(nowSet.get(0));
            else
                friendsMap.put(nowSet.get(1), new ArrayList<>(List.of(nowSet.get(0))));
        }

        for(String friendName : friendsMap.get(user)){
            for(String friendFriendName : friendsMap.get(friendName)) {
                if(friendFriendName != user) {
                    if (friendsScore.containsKey(friendFriendName)) {
                        friendsScore.put(friendFriendName, friendsScore.get(friendFriendName) + 10);
                    } else
                        friendsScore.put(friendFriendName, 10);
                }
            }
        }

        for(String v : visitors){
            if(!friendsMap.get(user).contains(v)) {
                if (friendsScore.containsKey(v)) {
                    friendsScore.put(v, friendsScore.get(v) + 1);
                } else
                    friendsScore.put(v, 1);
            }
        }

        for(String name : friendsScore.keySet()){
            friendsScoreSorted.add(new FriendScore(name, friendsScore.get(name)));
        }

        Collections.sort(friendsScoreSorted);

        for(int i = 0 ; i < 5 && i < friendsScoreSorted.size() ; i ++){
            answer.add(friendsScoreSorted.get(i).name);
        }

        return answer;
    }

    private static class FriendScore implements Comparable<FriendScore> {
        private String name;
        private int score;
        public FriendScore(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(@NotNull FriendScore friendScore) {
            return friendScore.score - this.score;
        }

    }
}
