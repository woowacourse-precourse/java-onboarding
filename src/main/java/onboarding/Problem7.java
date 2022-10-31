package onboarding;

import java.util.*;

public class Problem7 {


    /**
     * 기능 정리
     * 1. friends정보를 가지고 HashMap<String,Set<String>을 사용하여 친구 관계 그래프 구현 후, user와 친구 관계인 node삭제 (후 user node 삭제 -> 삭제하면 안됨).
     * 2. 그리고 HashMap<String,Integer>을 사용하여 남은 node를 가지고 친 구관계 score 계산, visitors에 대해 score도 계산.
     * 4. HashMap<String,Integer>의 정보를 친구 정보 객체에 넣고 정렬시킨 객체 반환.
     */

    static Map<String, Set<String>> friendsGraph = new HashMap<>();
    static Map<String, Integer> friendsScore = new HashMap<>();

    static class UserInformation {
        String name;
        Integer score;

        public UserInformation(String name, Integer score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public Integer getScore() {
            return score;
        }
    }

    //1. 기능1
    static void setFriendsGraph(List<List<String>> friends, String mainUser) {

        for (int i = 0; i < friends.size(); i++) {

            String friendA = friends.get(i).get(0);
            String friendB = friends.get(i).get(1);

            Set<String> innerSetA = new HashSet<>();
            Set<String> innerSetB = new HashSet<>();


            if (!friendsGraph.containsKey(friendA)) {
                friendsGraph.put(friendA, innerSetA);
            }
            if (!friendsGraph.containsKey(friendB)) {
                friendsGraph.put(friendB, innerSetB);
            }

            friendsGraph.get(friendA).add(friendB); // map은 put , set은 add를 사용한다.
            friendsGraph.get(friendB).add(friendA);
        }

        friendsGraph.get(mainUser).forEach((removeFriends) -> {
            friendsGraph.remove(removeFriends);
        });
        
        /*
         friendsGraph.forEach((str,set)->{
            System.out.print(str + " : ");
            friendsGraph.get(str).forEach(s ->{
                System.out.print(s+ " ");
            });
            System.out.println();
        });
        * */


    }


    //2. 기능2
    static void setFriendsScore(List<String> visitors, String mainUser) {
        Set<String> minUserSet = friendsGraph.get(mainUser);
        friendsGraph.remove(mainUser);

        //친구관계 10점 계산
        friendsGraph.forEach((user, friends) -> {

            friendsScore.put(user, 0);

            int size = friends.size();
            int score = size * 10;

            friendsScore.put(user, friendsScore.get(user) + score);

        });

        //방문친구 1점 계산
        visitors.forEach((user) -> {
            if (!friendsScore.containsKey(user)) {
                friendsScore.put(user, 0);
            }
            friendsScore.put(user, friendsScore.get(user) + 1);

        });

        //mainUser와 친구관계인 사람 삭제
        minUserSet.forEach((user) -> {
            friendsScore.remove(user);
        });

    }

    //3. 기능3
    static List<String> getFriendRecommendation() {

        List<UserInformation> friendRecommendation = new ArrayList<>();

        friendsScore.forEach((name, score) -> {
            System.out.println(name + " "+ score);
            friendRecommendation.add(new UserInformation(name, score));
        });

        Collections.sort(friendRecommendation, (friendA, friendB) -> {
            if (friendA.getScore() != friendB.getScore()) {
                return friendB.getScore() - friendA.getScore();
            }
            return friendA.getName().compareTo(friendB.getName());
        });

        List<String> nameList = new ArrayList<>();

        for (int i = 0; i < friendRecommendation.size() && i < 5; i++) {
            nameList.add(friendRecommendation.get(i).getName());
        }

        return nameList;

    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        setFriendsGraph(friends,user);
        setFriendsScore(visitors,user);
        List<String> answer = getFriendRecommendation();
        return answer;
    }
}
