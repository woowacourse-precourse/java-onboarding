package onboarding;

import java.util.*;

public class Problem7 {

    static List<String> findUserFriends(String u, List<List<String>> f) {
        List<String> userFriend = new ArrayList<>();
        for(List<String> friend : f) {
            int idx = friend.indexOf(u);
            if(idx != -1) {
                userFriend.add(friend.get((idx+1) % 2));
            }
        }
        return userFriend;
    }

    static boolean checkValid(String u, String u1, String u2, List<String> f, List<String> uf) {
        if(f.contains(u)) {
            return false;
        }
        if((uf.contains(u1) && uf.contains(u2) || !uf.contains(u1) && !uf.contains(u2))) {
            return false;
        }
        return true;
    }

    static Map<String, Integer> checkScore(Map<String, Integer> us, String snsf, String type) {
        if(us.containsKey(snsf)) {
            us.put(snsf, us.get(snsf) + (type.equals("FRIENDS") ? 10 : 1));
        } else {
            us.put(snsf, (type.equals("FRIENDS") ? 10 : 1));
        }
        return us;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(Collections.emptyList());
        Map<String, Integer> userScore = new TreeMap<>(); // 미리 알파벳 순으로 정렬되도록 저장한다.

        List<String> userFriends = findUserFriends(user, friends);

        // user와 간접적으로 친구인 사람들 점수 증가.
        for(List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);

            if(!checkValid(user, user1, user2, friend, userFriends)) {
                continue;
            }

            String snsFriend = userFriends.contains(user1) ? user2 : user1;
            userScore = checkScore(userScore, snsFriend, "FRIENDS");
        }

        // 직접적 친구 + user 제외 user의 타임라인에 방문한 사람들 1씩 증가.
        for(String name : visitors) {
            if(userFriends.contains(name) || user.equals(name)) {
                continue;
            }
            userScore = checkScore(userScore, name, "VISIT");
        }

        // value 값을 기준으로 내림차순 정렬
        List<Map.Entry<String, Integer>> userScore2 = new ArrayList<>(userScore.entrySet());

        Collections.sort(userScore2, (obj1, obj2) -> obj2.getValue().compareTo(obj1.getValue()));
        // 내림차순 정렬 end

        // 최대 5명까지 저장.
        for(Map.Entry<String, Integer> entry : userScore2.subList(0, Math.min(5, userScore2.size()))) {
            answer.add(entry.getKey());
        }

        return answer;
    }
}
