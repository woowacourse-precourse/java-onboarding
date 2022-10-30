package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> user_friend = new ArrayList<String>();         //user와 직접적인 친구

        Map<String, Integer> algorithm = new HashMap<String, Integer>();    //사용자의 이름과 점수

        for(List<String> friends_i : friends){
            String sns_user_1 = friends_i.get(0);
            String sns_user_2 = friends_i.get(1);

            algorithm.put(sns_user_1, 0);       //sns 사용자를 전부 algorithm에 추가하고 점수는 0으로 초기화
            algorithm.put(sns_user_2, 0);

            String userfriend = choiceUser(friends_i, user);        //user와 친구인 사용자

            if(userfriend.equals("")){          //친구가 아닌 경우
                continue;
            }

            user_friend.add(userfriend);        //user와 친구인 사용자들 목록
        }

        for(List<String> friends_i : friends){
            for(String friend : user_friend){
                String ffriend = choiceUser(friends_i, friend);     //user의 친구와 친구인 사용자

                if(ffriend.equals("")){
                    continue;
                }

                int score = algorithm.get(ffriend);
                algorithm.put(ffriend, score + 10);
            }
        }

        return answer;
    }

    //user와 친구인 사람을 찾을 때 사용하는 함수
    public static String choiceUser(List<String> friends_i, String user) {
        String result = new String();

        if (friends_i.get(0).equals(user)) {
            result = friends_i.get(1);
        } else if (friends_i.get(1).equals(user)) {
            result = friends_i.get(0);
        }

        return result;
    }
}
