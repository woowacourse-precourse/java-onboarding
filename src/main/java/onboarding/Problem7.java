package onboarding;

import java.util.*;

public class Problem7 {
    private static String checkAlreadyFriends(String user, List<String> relation){
        String output;
        if (relation.get(0).equals(user)){
            output = relation.get(1);
            return output;
        }
        if (relation.get(1).equals(user)){
            output = relation.get(0);
            return output;
        }
        output = "";
        return output;
    }
    private static List<String> findAlreadyFriends(String user, List<List<String>> friends){
        List<String> output = new ArrayList<>();
        int length = friends.size();
        String temp;
        for(int i = 0; i < length; i++){
            temp = checkAlreadyFriends(user, friends.get(i));
            if(!temp.equals("") && !output.contains(temp)){
                output.add(temp);
            }
        }
        return output;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //List<String> answer = Collections.emptyList();
        HashMap<String, Integer> scores = new HashMap<>();
        List<String> alreadyFriends = findAlreadyFriends(user, friends);
        int friendCount = alreadyFriends.size();
        int tempScore;
        String temp;
        //friends와 관련하여 각 user의 점수 구하기
        int length = friends.size();
        for (int i = 0; i < length ;i++){
            for (int j = 0; j < friendCount; j++){
                temp = checkAlreadyFriends(alreadyFriends.get(j), friends.get(i));
                if(!temp.equals("") && !temp.equals(user)) {
                    if (!temp.equals(user) && !scores.containsKey(temp)) {
                        scores.put(temp, 10);
                    }else{
                        tempScore = scores.get(temp);
                        tempScore += 10;
                        scores.put(temp, tempScore);
                    }
                }
            }
        }//함수로 빼는 방법 생각하기
        //visitors와 관련하여 각 user의 점수 구하기
        int visitorsSize = visitors.size();
        for (int i = 0; i < visitorsSize; i++){
            if(!alreadyFriends.contains(visitors.get(i))) {//조건 수정하기
                if (!scores.containsKey(visitors.get(i))) {
                    scores.put(visitors.get(i), 1);
                } else {
                    tempScore = scores.get(visitors.get(i));
                    tempScore += 1;
                    scores.put(visitors.get(i), tempScore);
                }
            }
        }
        List<String> answer = new ArrayList<>(scores.keySet());
        answer.sort(Comparator.naturalOrder());
        answer.sort((s1, s2) -> scores.get(s2) - scores.get(s1));

        if(answer.size() > 5){
            answer = answer.subList(0, 5);
        }
        return answer;
    }
}
