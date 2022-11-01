package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    /* checkUserFriend: 사용자와 친구인 사람 목록 만드는 함수 */
    public static List<String> checkUserFriend(List<List<String>> friends, String user){
        List<String> userFriends = new ArrayList<>();

        for(int i=0; i<friends.size(); i++){
            List<String> relation = friends.get(i);
            if(relation.get(0).equals(user)){ //사용자와 친구인 사람이 있다면 친구인 사람 저장
                userFriends.add(relation.get(1));
            } else if (relation.get(1).equals(user)) {
                userFriends.add(relation.get(0));
            }
        }

        return userFriends;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userFriends = new ArrayList<>();
        HashMap<String, Integer> recommendScore = new HashMap<>();

        userFriends = checkUserFriend(friends, user);

        //사용자의 친구와 친구인 경우 10점 추가
        for(int i=0; i<friends.size(); i++){
            String people1 = friends.get(i).get(0);
            String people2 = friends.get(i).get(1);

            if(people1.equals(user) | people2.equals(user)){ //사용자와 친구라면 건너뜀
                continue;
            }

            if(userFriends.contains(people1)){
                recommendScore.put(people2, recommendScore.getOrDefault(people2,0)+10);
            } else if (userFriends.contains(people2)) {
                recommendScore.put(people1, recommendScore.getOrDefault(people1,0)+10);
            }
        }

        return answer;
    }
}