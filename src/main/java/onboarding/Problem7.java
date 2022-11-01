package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        /*
            old_friends : 현재 친구들
            new_friends : 새로 추가된 친구들
         */
        int user_length = user.length();
        int friends_length = friends.size();
        int visitors_length = visitors.size();
        char[] check_user = user.toCharArray();
        List<String> answer = new ArrayList<>();

        // 제한 사항 5 - 사용자 아이디는 알파벳 소문자로만 이루어져 있다.
        for (char x : check_user) {
            if (!Character.isLowerCase(x)) {
                answer = List.of("user 아이디가 소문자가 아닙니다.");
                return answer;
            }
        }
        // 제한 사항 1 - user는 길이가 1 이상 30 이하인 문자열이다.
        if (user_length < 1 || user_length > 30) {
            answer = List.of("user list의 길이가 이상합니다.");
            return answer;
        }
        // 제한 사항 2 - friends는 길이가 1 이상 10,000 이하인 리스트/배열이다.
        if (friends_length < 1 || friends_length > 10000) {
            answer = List.of("friends list의 길이가 이상합니다.");
            return answer;
        }

        HashSet<String> old_friends = new HashSet<>();
        HashMap<String, Integer> new_friends = new HashMap<>();

        // 기존 친구 확인
        for (int i = 0; i < friends_length; i++) {
            for (int j = 0; j < 2; j++) {
                String Me = friends.get(i).get(j);
                String Me2 = friends.get(i).get(1 - j);
                int friend_length= Me.length();
                // 제한 사항 3 - friends 아이디는 길이가 1 이상 30 이하인 문자열이다.
                if (friend_length < 1 || friend_length > 30) {
                    answer = List.of("friends 아이디의 길이가 이상합니다.");
                    return answer;
                }
                // 제한 사항 6 - 동일한 친구 관계가 중복해서 주어지지 않는다.
                if (Me.equals(Me2)) {
                    answer = List.of("동일한 친구가 중복되었습니다.");
                    return answer;
                }
                if (Me.equals(user)) {
                    old_friends.add(Me2);
                }
            }
        }
        // 사용자와 함께 아는 친구의 수 = 10점
        for(String x : old_friends){
            for (int i = 0; i < friends_length; i++) {
                for (int j = 0; j < 2; j++) {
                    String new_friend = friends.get(i).get(1-j);
                    if (x.equals(friends.get(i).get(j)) && !new_friend.equals(user) && !old_friends.contains(new_friend)) {
                        if(!new_friends.containsKey(new_friend)) {new_friends.put(new_friend,0);}
                            new_friends.put(new_friend, new_friends.get(new_friend) + 10);
                    }
                }
            }
        }
        // 제한 사항 4 - visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
        if (visitors_length > 10000) {
            answer = List.of("visitors 아이디의 길이가 이상합니다.");
            return answer;
        }
        // 사용자의 타임 라인에 방문한 횟수 = 1점
        for (String x : visitors) {
            if(!old_friends.contains(x)){
                if (!new_friends.containsKey(x)) new_friends.put(x, 0);
                new_friends.put(x, new_friends.get(x) + 1);
            }
        }

        // 추천 점수가 가장 높은 순으로 정렬, 같은 경우는 이름순으로 정렬한다.
        List<Map.Entry<String, Integer>> datas = new LinkedList<>(new_friends.entrySet());
        Collections.sort(datas, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });

        for (int i = 0; i < datas.size(); i++) {
            answer.add(datas.get(i).getKey());
        }

        return answer;
    }
}
