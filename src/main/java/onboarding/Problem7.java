package onboarding;

import java.util.*;

import static java.util.Collections.sort;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends_form, List<String> visitors) {

        List<String> answer = Collections.emptyList();
        List<String> friends_list = new ArrayList<>();
        List<List<String>> friends = new ArrayList<>(friends_form); // java.util.ArrayList와 java.util.arrays.ArrayList로 다르게 구현되어 있다.
        HashMap<String,Integer> friends_score = new LinkedHashMap<>(); // 순서를 보장

        friends = findAlreadyFreinds(friends_list, user, friends);
        sort(friends_list);
        System.out.println("EndFindAlready");

        System.out.println(friends_list);
        System.out.println(friends);

        calculateScore(friends_score,friends_list,friends);
        System.out.println("after calculate");
        System.out.println(friends_score);

        return answer;
    }
    public static List<List<String>> findAlreadyFreinds(List<String> friends_list ,String user, List<List<String>> friends)
    {
        for (int i =  0 ; i<friends.size();i++)
        {
            if(friends.get(i).get(0).equals(user)) {
                friends_list.add(friends.get(i).get(1)); // freinds inside there is
                // 이름들 목록에서 user 포함 리스트 제거
                friends.remove(friends.get(i));
            }
            if(friends.get(i).get(1).equals(user)){
                friends_list.add(friends.get(i).get(0));
                friends.remove(friends.get(i));
            };
        }
        // 동일한 친구관계가 주어지지는 않으므로 중복 처리 없이 반환
        friends_list.remove(user);
        return friends;
    }
    public static void calculateScore(HashMap<String, Integer> friends_score, List<String> friends_list, List<List<String>> friends){

        HashSet<String> already_set = new HashSet<>(friends_list);

        // 이미 친구 인 사람은 0 점 : 0점은 추천 x
        for (List<String> friend : friends) {
            if (!friends_score.containsKey(friend.get(0)))
            {
                friends_score.put(friend.get(0),0);
            }
            else if (!friends_score.containsKey(friend.get(1)))
            {
                friends_score.put(friend.get(1),0);
            }
        }

        // check name and add 10points for friends fo already friends
        for (List<String> friend : friends) {
            if (!already_set.contains(friend.get(0))) {
                friends_score.put(friend.get(1), friends_score.get(friend.get(1)) + 10);
            } else if (!already_set.contains(friend.get(1))) {
                friends_score.put(friend.get(0), friends_score.get(friend.get(0)) + 10);
            }
        }

    }

}
