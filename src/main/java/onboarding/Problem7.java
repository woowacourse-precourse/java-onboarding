package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = new ArrayList<>();

        /* 이미 친구인 사람들은 최종 result 에서 제외.*/
        /* 1. user와 친구인 사람 friendsList 만들기 */
        List<String> friendsList = new ArrayList<>();

        /* 2. user와 친구인사람 friendsList에 담기*/
        for(int i = 0; i < friends.size(); i++){
            int index = friends.get(i).indexOf(user);
            if(index != -1){
                if(index == 0)
                    friendsList.add(friends.get(i).get(1));
                else
                    friendsList.add(friends.get(i).get(0));
            }
        }

        /* 3. user의 친구인 사람과 친구인 사람을 조회 후,  Map<친구이름,점수> 담기 */
        Map<String,Integer> resultMap = new HashMap<>();
        for(int i = 0; i < friendsList.size(); i++){
            String search = friendsList.get(i);
            for(int j = 0; j < friends.size(); j++){
                int index = friends.get(j).indexOf(search);
                if(index != -1){
                    if(index == 0) {
                        int value = 0;
                        if (resultMap.containsKey(search)) {
                            value = resultMap.get(friends.get(j).get(1));
                        }
                        resultMap.put(friends.get(j).get(1), 10 + value);
                    }
                    else{
                        int value = 0;
                        if (resultMap.containsKey(search)) {
                            value = resultMap.get(friends.get(j).get(1));
                        }
                        resultMap.put(friends.get(j).get(0), 10 + value);
                    }
                }
            }
        }
        /* 4. visitor를 Map<친구이름,점수>에 담기*/
        for(int i = 0; i < visitors.size(); i++){
            String visitor = visitors.get(i);
            int value = 0;
            if(resultMap.containsKey(visitor)){
                value = resultMap.get(visitor);
            }
            resultMap.put(visitor, 1 + value);
        }

        /* 5. friendsList에 있는 친구들 Map에서 제외하기*/
        for(int i = 0; i < friendsList.size(); i++ ){
            resultMap.remove(friendsList.get(i));
        }
        resultMap.remove(user);

        /* 6. Map 정렬하여 answerList에 담기*/
        List<String> keySet = new ArrayList<>(resultMap.keySet());
        keySet.sort((o1, o2) -> resultMap.get(o2).compareTo(resultMap.get(o1)));

        if(keySet.size() > 5){
            for(int i = 0; i < 5; i++){
                answer.add(keySet.get(i));
            }
        }else{
            for(String key : keySet){
                answer.add(key);
            }
        }

        return answer;
    }
}
