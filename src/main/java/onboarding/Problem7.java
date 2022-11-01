package onboarding;
import java.util.*;
//코드 참고함
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();
        List<String> user_friend = new ArrayList<String>();

        Map<String, Integer> algorithm = new HashMap<String, Integer>();    //유저명 + 점수
        for(List<String> friends_i : friends){
            String sns_user_1 = friends_i.get(0);
            String sns_user_2 = friends_i.get(1);
            algorithm.put(sns_user_1, 0);       //기본값 0 설정
            algorithm.put(sns_user_2, 0);
            String userfriend = choiceUser(friends_i, user);        //유저와 친구 구별
            if(userfriend.equals("")){          //친구X
                continue;
            }
            user_friend.add(userfriend);        //유저친구 목록
        }
        for(List<String> friends_i : friends){
            for(String friend : user_friend){
                String ffriend = choiceUser(friends_i, friend);     //친구의 친구 = ffriend
                if(ffriend.equals("")){
                    continue;
                }
                int score = algorithm.get(ffriend);
                algorithm.put(ffriend, score + 10);
            }
        }
        for(String visitor : visitors){
            if(algorithm.containsKey(visitor)){     //+1
                int score = algorithm.get(visitor);
                algorithm.put(visitor, score + 1);
            } else
                algorithm.put(visitor, 1);          //1

        }
        algorithm.remove(user);             //유저과 유저친구 제거
        for(String friend : user_friend)
            algorithm.remove(friend);

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(algorithm.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int ct = 0;     //ct=카운트
        for(String key : algorithm.keySet()){
            if(ct==5)
                break;
            answer.add(key);
            ct++;
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