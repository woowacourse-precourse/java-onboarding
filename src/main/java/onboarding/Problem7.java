package onboarding;

import java.util.*;

public class Problem7 {
    public static HashMap<String, ArrayList<String>> createFriendship(List<List<String>> friends) {
        HashMap<String, ArrayList<String>> hs = new HashMap<>();

        for (int i=0; i<friends.size(); i++) {  //친구들과의 연관관계를 HashMap으로 설정
            String friend_1=friends.get(i).get(0), friend_2=friends.get(i).get(1);
            if (!hs.containsKey(friend_1)) {    //키가 없다면 생성
                ArrayList<String> tmp = new ArrayList<>();
                hs.put(friend_1,tmp);
            }
            if (!hs.containsKey(friend_2)) {
                ArrayList<String> tmp = new ArrayList<>();
                hs.put(friend_2,tmp);
            }
            hs.get(friend_1).add(friend_2);
            hs.get(friend_2).add(friend_1);
        }
        return hs;
    }

    public static HashMap<String, Integer> increaseFriendNeighbor(String user, HashMap<String, ArrayList<String>> hs) {
        HashMap<String, Integer> ans = new HashMap<>();

        for (String key : hs.get(user)) {   //자신의 친구가 아닌 친구 중, 추천 친구 점수 덧셈
            for (String k : hs.get(key)) {
                if (!hs.get(user).contains(k) & !k.equals(user)) {  //자신과 자신의 친구일 경우 제외
                    ans.put(k, ans.getOrDefault(k,0)+10);
                }
            }
        }
        return ans;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, ArrayList<String>> hs = createFriendship(friends);
        HashMap<String, Integer> ans = increaseFriendNeighbor(user, hs);

        for (int i=0; i<friends.size(); i++) {  //친구들과의 연관관계를 HashMap으로 설정
            String friend_1=friends.get(i).get(0), friend_2=friends.get(i).get(1);
            if (!hs.containsKey(friend_1)) {    //키가 없다면 생성
                ArrayList<String> tmp = new ArrayList<>();
                hs.put(friend_1,tmp);
            }
            if (!hs.containsKey(friend_2)) {
                ArrayList<String> tmp = new ArrayList<>();
                hs.put(friend_2,tmp);
            }
            hs.get(friend_1).add(friend_2);
            hs.get(friend_2).add(friend_1);
        }
        for (String key : hs.get(user)) {   //자신의 친구가 아닌 친구 중, 추천 친구 점수 덧셈
            for (String k : hs.get(key)) {
                if (!hs.get(user).contains(k) & !k.equals(user)) {  //자신과 자신의 친구일 경우 제외
                    ans.put(k, ans.getOrDefault(k,0)+10);
                }
            }
        }
        for (String key : visitors) {   //방문자 점수 덧셈
            if (!hs.get(user).contains(key)) {
                ans.put(key, ans.getOrDefault(key, 0) + 1);
            }
        }

        List<String> tmp_answer = new ArrayList<>(ans.keySet());
        List<String> answer = new ArrayList<>();

        Collections.sort(tmp_answer,(s1,s2)-> {     //친구 점수 및 이름순으로 정렬
            return ans.get(s2)!=ans.get(s1) ? ans.get(s2) - ans.get(s1) : s1.compareTo(s2);
        });

        for (int i=0; i<tmp_answer.size() & i<5; i++) { //최대 5명의 친구 추천
            answer.add(tmp_answer.get(i));
        }

        return answer;
    }
}
