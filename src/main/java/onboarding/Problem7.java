package onboarding;

import java.util.*;

import static java.util.Collections.sort;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends_form, List<String> visitors) {

        List<String> answer = Collections.emptyList();
        List<String> friends_list = new ArrayList<>();
        List<List<String>> friends = new ArrayList<>(friends_form); // java.util.ArrayList와 java.util.arrays.ArrayList로 다르게 구현되어 있다.
        HashMap<String,Integer> friends_score = new LinkedHashMap<>(); // 순서를 보장

        findAlreadyFreinds(friends_list, user, friends);

        System.out.println(friends_form);
        System.out.println(friends);
        System.out.println(friends_list);
        sort(friends_list);
        calculateScore(friends_score,friends_list,friends);
        System.out.println(friends_score);
        return answer;
    }
    public static void findAlreadyFreinds(List<String> friends_list ,String user, List<List<String>> friends){

        for (int i=0;i<friends.size();i++)
        {
            if(friends.get(i).get(0).equals(user)) {
                friends_list.add(friends.get(i).get(1));
                // 이름들 목록에서 user 포함 리스트 제거
                friends.remove(i);

            }
            if(friends.get(i).get(1).equals(user)){
                friends_list.add(friends.get(i).get(0));
                friends.remove(i);
            };
        }
        friends_list.remove(user);
        // 동일한 친구관계가 주어지지는 않으므로 중복 처리 없이 반환
    }
    public static void calculateScore(HashMap<String, Integer> friends_score, List<String> friends_list, List<List<String>> friends){
        // check list
        for(int i = 0 ; i<friends_list.size();i++){
            friends_score.put(friends_list.get(i),0);
        }
        System.out.println(friends_score);
        //check left and right
        for (List<String> friend : friends) {
            if (friends_score.containsKey(friend.get(0))) {
                friends_score.put(friend.get(0), friends_score.get(friend.get(0)) + 10);
            } else if (friends_score.containsKey(friend.get(1))) {
                friends_score.put(friend.get(1), friends_score.get(friend.get(1)) + 10);
            }
        }

    }

}
