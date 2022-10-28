package onboarding;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

/*
 * 여기서 친구 사이를 알아 놓는다
 * 친구가 아닌 사람을 배열에 모아 놓는다
 * 그 사람들의 점수를 know_with_user_score 함수에 넣어서 점수 알아오고
 * visitor 점수를 알기 위해 visitor_score 함수에 넣고 온다
 */

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, Integer> score_board = new HashMap<>(friends.size()); // 점수 저장
        List<List<String>> friends_friends = new ArrayList<>(); //친구들의 친구들

        // 친구의 친구들을 구함
        for(List<String> friends_list : friends){
            if(friends_list.contains(user)){
                friends_friends.add(friends_list); //user도 포함
            }
        }

        // 친구의 친구들 중에서 추천 점수 +10 해줄 사람들을 구함
        for(List<String> recommend_friend : friends_friends){
            for(int i = 0; i < recommend_friend.size(); i++){
                if(!recommend_friend.contains(user) && !recommend_friend.contains(recommend_friend.get(i))){
                    score_board.put(recommend_friend.get(i), score_board.get("recommend_friend.get(i))" + 10));
                }
            }
        }

        for(String s : visitors){
            score_board.put(s, score_board.get(s) + 1);
        }

        System.out.println(score_board);

        List<String> KeyList = new ArrayList<>(score_board.keySet());
        System.out.println(KeyList);

        return KeyList;

    }

}
