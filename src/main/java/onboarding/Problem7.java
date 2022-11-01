package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        /*
            old_friends : 현재 친구들
            new_friends : 새로 추가된 친구들
         */
        List<String> answer = new ArrayList<>();
        List<String> old_friend = new ArrayList<>();
        HashMap<String, Integer> new_friend = new HashMap<>();
        int user_length = user.length();
        int friends_length = friends.size();
        int visitors_length = visitors.size();
        char[] check_user = user.toCharArray();


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

        // 제한 사항 4 - visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
        if (visitors_length > 10000) {
            answer = List.of("visitors 아이디의 길이가 이상합니다.");
            return answer;
        }

        // 제한 사항 5 - 사용자 아이디는 알파벳 소문자로만 이루어져 있다.
        for (char x : check_user) {
            if (!Character.isLowerCase(x)) {
                answer = List.of("user 아이디가 소문자가 아닙니다.");
                return answer;
            }
        }

        // 기존 친구 확인
        for (List<String> two_friend : friends) {
            if (two_friend.contains(user)) {
                old_friend.addAll(two_friend);
            }
        }
        old_friend.remove(user);


        for (List<String> two_friend : friends) {
            String friend_a = two_friend.get(0);
            String friend_b = two_friend.get(1);

            // 제한 사항 3 - friends 아이디는 길이가 1 이상 30 이하인 문자열이다.
            if (friend_a.length() < 1 || friend_a.length() > 30 || friend_b.length() < 1 || friend_b.length() > 30) {
                answer = List.of("friends 아이디의 길이가 이상합니다.");
                return answer;
            }
            // 제한 사항 6 - 동일한 친구 관계가 중복해서 주어지지 않는다.
            if (friend_a.equals(friend_b)) {
                answer = List.of("동일한 친구가 중복되었습니다.");
                return answer;
            }
            if (friend_a.equals(user) || friend_b.equals(user)) continue;
            // 사용자와 함께 아는 친구의 수 = 10점
            if (old_friend.contains(friend_a)) {
                if (new_friend.containsKey(friend_b)) {
                    new_friend.put(friend_b, new_friend.get(friend_b) + 10);
                } else new_friend.put(friend_b, 10);
            }

            if (old_friend.contains(friend_b)) {
                if (new_friend.containsKey(friend_a)) {
                    new_friend.put(friend_a, new_friend.get(friend_a) + 10);
                } else new_friend.put(friend_a, 10);
            }
        }

        // 사용자의 타임 라인에 방문한 횟수 = 1점
        for (String visitor : visitors) {
            if (new_friend.containsKey(visitor)) {
                new_friend.put(visitor, new_friend.get(visitor) + 1);
            } else new_friend.put(visitor, 1);
        }


        // 추천 점수가 가장 높은 순으로 정렬, 같은 경우는 이름순으로 정렬한다.=
        List<Map.Entry<String, Integer>> datas = new ArrayList<Map.Entry<String, Integer>>(new_friend.entrySet());
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
        answer.removeAll(old_friend);
        return answer;
    }
}

