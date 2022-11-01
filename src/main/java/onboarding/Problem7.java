package onboarding;

import org.jetbrains.annotations.NotNull;

import javax.swing.text.html.parser.Entity;
import java.sql.Array;
import java.util.*;

public class Problem7 {

    private static class Score implements Comparable<Score> {
        private String name;
        private int score;

        public Score(String name_, int score_) {
            name = name_;
            score = score_;
        }

        public int getScore() {
            return score;
        }

        public String getName() {
            return name;
        }
        @Override
        public int compareTo(Score o) {
            if (this.score < o.getScore()) {
                return 1;
            } else if (this.score > o.getScore()) {
                return -1;
            }
            else {
                return this.getName().compareTo(o.getName());
            }
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();

        List<String> friendsCheck = new ArrayList<String>();
        HashMap<String, Integer> friendsScore = new HashMap<>();
        HashMap<String, Boolean> alreadyFriends = new HashMap<String, Boolean>();

        // user와 친구인 사람 찾기
        for(int friendsIterator = 0; friendsIterator < friends.size(); friendsIterator++){
            if (friends.get(friendsIterator).get(0) == user){
                friendsCheck.add(friends.get(friendsIterator).get(1));
                alreadyFriends.put(friends.get(friendsIterator).get(1), true);
            }

            else if (friends.get(friendsIterator).get(1) == user){
                friendsCheck.add(friends.get(friendsIterator).get(0));
                alreadyFriends.put(friends.get(friendsIterator).get(0), true);
            }
        }
        alreadyFriends.put(user, true);

        // user의 친구의 친구 중 user와 친분 없는 사람 찾기
        for(int friendsIterator = 0; friendsIterator < friends.size(); friendsIterator++){
            if(friends.get(friendsIterator).get(0) != user && friends.get(friendsIterator).get(1) != user){
                for(int checkFriendsIterator = 0; checkFriendsIterator < friendsCheck.size(); checkFriendsIterator++){
                    if(friends.get(friendsIterator).get(0) == friendsCheck.get(checkFriendsIterator) &&
                            (!alreadyFriends.containsKey(friends.get(friendsIterator).get(1)) || alreadyFriends.get(friends.get(friendsIterator).get(1)) == false)){
                        int currentScore = 0;
                        if(friendsScore.containsKey(friends.get(friendsIterator).get(1))) currentScore = friendsScore.get(friends.get(friendsIterator).get(1));
                        friendsScore.put(friends.get(friendsIterator).get(1), currentScore + 10);
                        System.out.println(friendsScore.get(friends.get(friendsIterator).get(1)));
                    }

                    else if(friends.get(friendsIterator).get(1) == friendsCheck.get(checkFriendsIterator) &&
                            (!alreadyFriends.containsKey(friends.get(friendsIterator).get(1)) || alreadyFriends.get(friends.get(friendsIterator).get(0)) == false)){
                        int currentScore = 0;
                        if(friendsScore.containsKey(friends.get(friendsIterator).get(0))) currentScore = friendsScore.get(friends.get(friendsIterator).get(0));
                        friendsScore.put(friends.get(friendsIterator).get(0), currentScore + 10);
                        System.out.println(friendsScore.get(friends.get(friendsIterator).get(0)));
                    }
                }
            }
        }

        // user의 sns 방문자 중 user와 친분 없는 사람 찾기
        for(int visitorIterator = 0; visitorIterator < visitors.size(); visitorIterator++){
            boolean flag = true;
            for(int checkFriendsIterator = 0; checkFriendsIterator < friendsCheck.size(); checkFriendsIterator++){
                if(visitors.get(visitorIterator) == friendsCheck.get(checkFriendsIterator)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                int currentScore = 0;
                if(friendsScore.containsKey(visitors.get(visitorIterator))) currentScore = friendsScore.get(visitors.get(visitorIterator));
                friendsScore.put(visitors.get(visitorIterator), currentScore + 1);
            }
        }

        // 정렬
        List<Score> scoreList = new ArrayList<Score>();
        friendsScore.forEach( (key, value) -> {
            scoreList.add(new Score(key, value));
        });

        Collections.sort(scoreList);
        for(int scoreListIterator = 0; scoreListIterator < scoreList.size() && scoreListIterator < 5; scoreListIterator++) answer.add(scoreList.get(scoreListIterator).getName());
        return answer;
    }

    public static void main(String args[]) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");
        System.out.println(solution(user, friends, visitors));
    }
}
