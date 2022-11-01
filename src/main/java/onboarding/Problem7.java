package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, HashSet<String>> mapByFriends = getMapByFriends(friends);
        HashMap<String, Integer> visitScores = getMapByVisitors(visitors);
        HashSet<String> myFriends = new HashSet<>();
        List<Friend> recommendScores = new ArrayList<>();
        List<String> answer = new ArrayList<>();

        if (mapByFriends.containsKey(user)) {
            myFriends = mapByFriends.get(user);
        }
        mapByFriends.remove(user);

        for (Map.Entry<String, HashSet<String>> entry : mapByFriends.entrySet()) {
            String name = entry.getKey();
            int score=0;

            if (myFriends.isEmpty() || myFriends.contains(name)) continue;

            for (String friend : entry.getValue()) {
                if (myFriends.contains(friend)) {
                    score += 10;
                }
            }

            if(visitScores.containsKey(name)) {
                score += visitScores.get(name);
            }
            if(score != 0) recommendScores.add(new Friend(name, score));
        }

        for(Map.Entry<String, Integer> entry : visitScores.entrySet()) {
            String name = entry.getKey();
            if (myFriends.contains(name)) continue;
            boolean exist=false;

            for(Friend friend: recommendScores) {
                if(friend.name.equals(name)) {
                    exist=true;
                    break;
                }
            }
            if(!exist && entry.getValue()!=0) recommendScores.add(new Friend(name, entry.getValue()));
        }

        Collections.sort(recommendScores, new Comparator<Friend>() {
            @Override
            public int compare(Friend o1, Friend o2) {

                if (o2.score - o1.score !=0) {
                    return o2.score - o1.score;
                }else {
                    return o1.name.compareTo(o2.name);
                }
            }
        });

        if (recommendScores.size() >= 5) {
            for(int i=0; i<5; i++) {
                answer.add(recommendScores.get(i).name);
            }
        }else{
            for(Friend friend : recommendScores) {
                answer.add(friend.name);
            }
        }

        return answer;
    }

    public static HashMap<String, HashSet<String>> getMapByFriends(List<List<String>> friends) {
        HashMap<String, HashSet<String>> friendMap = new HashMap<>();

        for (List<String> friend : friends) {
            HashSet<String> friendsSet;

            if (friendMap.containsKey(friend.get(0))) {
                friendsSet = friendMap.get(friend.get(0));
            } else {
                friendsSet = new HashSet<>();
            }

            friendsSet.add(friend.get(1));
            friendMap.put(friend.get(0), friendsSet);

            if (friendMap.containsKey(friend.get(1))) {
                friendsSet = friendMap.get(friend.get(1));
            } else {
                friendsSet = new HashSet<>();
            }

            friendsSet.add(friend.get(0));
            friendMap.put(friend.get(1), friendsSet);
        }

        return friendMap;
    }

    public static HashMap<String, Integer> getMapByVisitors(List<String> visitors) {
        HashMap<String, Integer> visitScore = new HashMap<>();
        for (String visitor : visitors) {
            visitScore.put(visitor, visitScore.getOrDefault(visitor, 0) + 1);
        }
        return visitScore;
    }

    static class Friend{
        String name;
        int score;

        Friend(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
