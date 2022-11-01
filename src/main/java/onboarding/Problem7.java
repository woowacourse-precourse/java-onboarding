package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> User_Friend_saveList(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();


        for (int i=0; i<friends.size(); i++) {
            if (friends.get(i).get(0).equals(user) && !userFriends.contains(friends.get(i).get(1))) {
                userFriends.add(friends.get(i).get(1));
            }

            if (friends.get(i).get(1).equals(user) && !userFriends.contains(friends.get(i).get(0))) {
                userFriends.add(friends.get(i).get(0));
            }
        }

        return userFriends;
    }

    public static HashMap<String, Integer> saveScoreByfriends(List<String> userFriends, List<List<String>> friends, String user) {
        HashMap<String, Integer> scores = new HashMap<>();


        for (int i=0; i<userFriends.size(); i++) {
            String userFriendName = userFriends.get(i);
            for (int j=0; j<friends.size(); j++) {
                if (friends.get(j).contains(user)) continue;
                if (friends.get(j).get(0).equals(userFriendName) && !userFriends.contains(friends.get(j).get(1))) {

                    Integer friendScore = scores.get(friends.get(j).get(1));
                    if (friendScore != null) {
                        friendScore += 10;
                        scores.put(friends.get(j).get(1), friendScore);
                    } else {
                        scores.put(friends.get(j).get(1), 10);
                    }
                }

                if (friends.get(j).get(1).equals(userFriendName) && !userFriends.contains(friends.get(j).get(0))) {

                    Integer friendScore = scores.get(friends.get(j).get(0));
                    if (friendScore != null) {
                        friendScore += 10;
                        scores.put(friends.get(j).get(0), friendScore);
                    } else {
                        scores.put(friends.get(j).get(0), 10);
                    }
                }
            }
        }

        return scores;
    }

    public static HashMap<String, Integer> saveScoreByVisitor(List<String> visitors, List<String> userFriends, HashMap<String, Integer> scores) {

        for (int i=0; i<visitors.size(); i++) {
            if (userFriends.contains(visitors.get(i))) continue;
            Integer friendScore = scores.get(visitors.get(i));
            if (friendScore != null) {
                friendScore++;
                scores.put(visitors.get(i), friendScore);
            } else {
                scores.put(visitors.get(i), 1);
            }
        }
        return scores;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
//        List<String> answer = new ArrayList<String>();
        HashMap<String, HashSet<String>> friendMapSet = new HashMap<String, HashSet<String>>();
        HashMap<String, Integer> friendScore = new HashMap<String, Integer>(); //최종 친구점수


        for(int i=0; i<friends.size(); i++){
            HashSet<String> myget_0 = friendMapSet.getOrDefault(friends.get(i).get(0), new HashSet<String>());
            HashSet<String> myget_1 = friendMapSet.getOrDefault(friends.get(i).get(1), new HashSet<String>());

            //친구 set 추가
            myget_0.add(friends.get(i).get(1));
            myget_1.add(friends.get(i).get(0));

            friendMapSet.put(friends.get(i).get(0),myget_0);
            friendMapSet.put(friends.get(i).get(1),myget_1);


        }

        for(int i=0; i<friendMapSet.size(); i++){


            Iterator<String> iter = friendMapSet.keySet().iterator();


            while(iter.hasNext()) {
                String key = iter.next();
                friendMapSet.get(key).retainAll(friendMapSet.get(user));

//점수계산.
                friendScore.put(key,friendMapSet.get(key).size()+Collections.frequency(visitors, key));

//                System.out.println(friendScore);
            }

//            friendScore.sort(Comparator.comparing(friendScore::getWeight).thenComparing(friendScore::getColor));

        }


        // List<String> answer = Collections.emptyList();
        List<String> answer = new ArrayList<>();
        List<String> userFriends;
        HashMap<String, Integer> scores;

        userFriends = User_Friend_saveList(user, friends);
        scores = saveScoreByfriends(userFriends, friends, user);
        scores = saveScoreByVisitor(visitors, userFriends, scores);

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(scores.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for(Map.Entry<String, Integer> entry : entryList){
            answer.add(entry.getKey());
        }
//
        return answer;
    }

}
