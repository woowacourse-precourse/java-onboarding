package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 레벨 2의 팀 프로젝트 미션으로 SNS(Social Networking Service)를 만들고자 하는 팀이 있다.<p>
 * 팀에 속한 크루 중 평소 알고리즘에 관심이 많은 미스터코는 친구 추천 알고리즘을 구현하고자 아래와 같은 규칙을 세웠다.<p>
 * <br/>
 * - 사용자와 함께 아는 친구의 수 = 10점<p>
 * - 사용자의 타임 라인에 방문한 횟수 = 1점<p>
 * <br/>
 * 사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors가 매개변수로 주어질 때,
 * 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return 하도록 solution 메서드를 완성하라.<p>
 * 이때 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬한다.<p>
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> scoreBoard = new HashMap<>();
        List<String> myFriends = new ArrayList<>();

        // 내 친구들 구하기
        // myFriends 에는 내 친구들의 목록이 담김
        for (int i = 0; i < friends.size(); i++) {
            String firstFriend = friends.get(i).get(0);
            String secondFriend = friends.get(i).get(1);
            if (user == friends.get(i).get(0)) {
                myFriends.add(firstFriend);
            } else if (user == secondFriend) {
                myFriends.add(friends.get(i).get(0));
            }
        }

        // 함께 아는 친구들에 대해서 점수 부여하기
        for (int i = 0; i < friends.size(); i++) {
            String firstFriend = friends.get(i).get(0);
            String secondFriend = friends.get(i).get(1);
            // 본인에게는 점수를 부여할 수 없으므로 패스
            if (user == firstFriend || user == secondFriend) {
                continue;
            }
            // 1번 친구가 내 친구이고, 2번 친구가 내 친구가 아닐 때에, 2번 친구에 점수 10점 부여
            if (myFriends.contains(firstFriend) && !myFriends.contains(secondFriend)) {
                if (scoreBoard.containsKey(secondFriend)) {
                    int score = scoreBoard.get(secondFriend);
                    score = score + 10;
                    scoreBoard.replace(secondFriend, score);
                }
                scoreBoard.put(secondFriend, 10);
                // 2번 친구가 내 친구이고, 1번 친구가 내 친구가 아닐 때에, 2번 친구에 점수 10점 부여
            } else if (myFriends.contains(secondFriend) && !myFriends.contains(firstFriend)) {
                if (scoreBoard.containsKey(firstFriend)) {
                    int score = scoreBoard.get(firstFriend);
                    score = score + 10;
                    scoreBoard.replace(firstFriend, score);
                }
                scoreBoard.put(firstFriend, 10);
            }
        }

        // 타임라인 방문 횟수에 따라 점수 부여하기
        for (int j = 0; j < visitors.size(); j++) {
            if (myFriends.contains(visitors.get(j))) {
                continue;
            }
            if (scoreBoard.containsKey(visitors.get(j))) {
                int score = scoreBoard.get(visitors.get(j));
                score = score + 1;
                scoreBoard.replace(visitors.get(j), score);
            }
            scoreBoard.put(visitors.get(j), 1);
        }

        List<String> answer = new ArrayList<>(scoreBoard.keySet());
        return answer;
    }
}
