package onboarding;

import javax.swing.*;
import java.util.*;
import java.util.logging.Handler;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, List<String>> friendInfo = makeFriendInfo(friends);
        //System.out.println(friendInfo);
        HashMap<String, Integer> score = calTogether(user,friendInfo);
        /*System.out.println(score);*/
        calVisit(visitors, score);

        // 4. 상위 5명 추출
        for (Map.Entry<String, Integer> s : score.entrySet()) {
            String name = s.getKey();
            Integer value = s.getValue();
            if (!Objects.equals(name, user) && !friendInfo.get(user).contains(name)) {
                answer.add(name);
            }
            if (answer.size() >= 5) {
                break;
            }
        }
        return answer;
    }
    // 1. HashMap에 유저마다 친구정보 저장
    public static HashMap<String, List<String>> makeFriendInfo(List<List<String>> friends) {
        HashMap<String, List<String>> friendInfo = new HashMap<>();
        for (List<String> friend : friends) {
            String userA = friend.get(0);
            String userB = friend.get(1);
            toHash(friendInfo, userA, userB);
            toHash(friendInfo, userB, userA);
        }
        return friendInfo;
    }
    
    // 1-1. HashMap에 유저가 있다면 연장, 없다면 추가
    private static void toHash(HashMap<String, List<String>> friendInfo, String userA, String userB) {
        if (!friendInfo.containsKey(userA)) {
            friendInfo.put(userA, new ArrayList<String>(List.of(userB)));
        } else {
            List<String> originInfo = friendInfo.get(userA);
            originInfo.add(userB);
            friendInfo.replace(userA, originInfo);
        }
    }

    // 2. 함께 아는 친구 점수 계산
    public static HashMap<String, Integer> calTogether(String user, HashMap<String, List<String>> friendInfo) {
        HashMap<String, Integer> calTogether = new HashMap<>();
        Set<String> Users = friendInfo.keySet();
        for (String f : friendInfo.get(user)) {
            for (String u : Users) {
                if (friendInfo.get(u).contains(f)) {
                    if (!calTogether.containsKey(u)) {
                        calTogether.put(u, 10);
                    } else {
                        Integer originCount = calTogether.get(u);
                        calTogether.replace(u, originCount + 10);
                    }
                }
            }
        }
        return calTogether;
    }

    // 3. 방문한 횟수 점수 계산
    private static void calVisit(List<String> visitors ,HashMap<String, Integer> score) {
        for (String visitor : visitors) {
            if (!score.containsKey(visitor)) {
                score.put(visitor, 1);
            } else {
                Integer originScore = score.get(visitor);
                score.replace(visitor, originScore + 1);
            }
        }
    }
}
