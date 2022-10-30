package onboarding;

import java.util.*;
import java.util.Map.Entry;


public class Problem7 {
    public static void HashmapAdd(Map<String, List<String>> HashMap, String A_User, String B_User) {
        if (HashMap.containsKey(A_User)) {
            List<String> tmpUser = HashMap.get(A_User);
            tmpUser.add(B_User);
            HashMap.put(A_User, tmpUser);
        } else {
            List<String> tmpUser = new ArrayList<>();
            tmpUser.add(B_User);
            HashMap.put(A_User, tmpUser);
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 풀이 : n^2으로 시간초과가 나올 것 같으므로 HashMap을 이용하여 저장 후 Collections.sort 변형하여 사용
        // Collections.sort는 병합정렬+삽입정렬을 사용하여 O(nlogn)의 시간 복잡도를 가져서 사용하였습니다.
        // 주의점 1) user가 친구를 알고 있어야 점수 +10이 들어간다.
        List<String> answer = new ArrayList<>();
        Map<String, List<String>> KnowUser = new HashMap<>(); // 친구관계 해시맵
        Map<String, Integer> ScoreUser = new HashMap<>(); // 점수 해시맵

        // 1) 친구 관계를 HashMap형태로 만든다
        for (int i = 0; i < friends.size(); i++) {
            String A_User = friends.get(i).get(0);
            String B_User = friends.get(i).get(1);
            HashmapAdd(KnowUser,A_User,B_User);
            HashmapAdd(KnowUser,B_User,A_User);
        }
        // 1) user가 아는 친구 목록들을 1중 for문과 그 친구가 아는 친구를 2중 for문으로 돈다.
        for (String str : KnowUser.get(user)) {
            for (String know : KnowUser.get(str)) {
                if (user.equals(know)) continue; // 이미 알고 있는 친구면 제외
                if (ScoreUser.containsKey(know)) {
                    int tmpScore = ScoreUser.get(know);
                    ScoreUser.put(know, tmpScore + 10);
                } else ScoreUser.put(know, 10);
            }
        }
        // 2) 방문한 사람들에게 점수를 매긴다.
        for (String visitor : visitors) {
            if (KnowUser.get(user).contains(visitor)) continue; // 이미 알고 있는 친구는 제외
            if (ScoreUser.containsKey(visitor)) {
                int tmpScore = ScoreUser.get(visitor);
                ScoreUser.put(visitor, tmpScore + 1);
            } else ScoreUser.put(visitor, 1);
        }
        // 3) Entry를 사용하면 리스트에 User명과 점수를 가져올 수 있다.
        List<Entry<String,Integer>> UserList = new ArrayList<>(ScoreUser.entrySet());

        // 4) collect.sort를 오버라이드를 통하여 수정하였습니다.
        // 주의점 o1을 먼저 쓰면 오름차순, o2를 먼저쓰면 내림차순
        Collections.sort(UserList, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) { //값이 같을 때는 이름으로 오름차순 정렬
                    return o1.getKey().compareTo(o2.getKey());
                } // 값이 다를 때는 값으로 내림차순 정렬
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        // 5) 정렬된 값을 answer에 저장한다.
        for (Entry<String,Integer> entry : UserList) {
            answer.add(entry.getKey());
            if (answer.size()==5)  break;
        }
        return answer;
    }
}
