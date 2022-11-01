package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = execute(user, friends, visitors);
        return answer;
    }

    private static List<String> execute(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendshipList = getFriendShipList(user, friends);
        Map<String, Integer> friendshipPointMap = getFriendshipPointList(user, friends, friendshipList);

        Map<String, Integer> visitorPointMap = getVisitorPointList(visitors, friendshipList);
        Iterator<String> iter = visitorPointMap.keySet().iterator();
        while (iter.hasNext()) {
            String friend = iter.next();
            int friendPoint = 0;
            if (friendshipPointMap.get(friend) != null) {
                friendPoint = friendshipPointMap.get(friend);
            }
            friendshipPointMap.put(friend, friendPoint + visitorPointMap.get(friend));
        }
        List<String> resultList = new ArrayList<String>(friendshipPointMap.keySet());
        return resultList;
    }

    /**
     * 아는 친구의 수만큼 가산점 부여
     * 
     * @param user
     * @param friends
     * @return
     */
    private static Map<String, Integer> getFriendshipPointList(String user, List<List<String>> friends,
            List<String> friendshipList) {
        Map<String, Integer> friendshipPointList = new HashMap<String, Integer>();
        final int point = 10;

        // 사용자의 친구와 친구인 멤버목록을 구한다.
        for (int i = 0; i < friends.size(); i++) {
            boolean isFriend = false;
            String friend = "";
            String member = "";
            for (int j = 0; j < friends.get(i).size(); j++) {
                member = friends.get(i).get(j);
                friend = friends.get(i).get(1 - j);
                if (member.equals(user)) {
                    // 사용자와 이미 친구인 경우는 SKIP
                    continue;
                }
                if (friendshipList.contains(member) && friendshipList.contains(friend)) {
                    // 사용자와 둘 다 친구인 경우는 SKIP
                    continue;
                }
                if (friendshipList.contains(friend)) {
                    // 친구가 존재할 때, 멤버는 추천포인트 획인
                    isFriend = true;
                    break;
                }
            }
            if (isFriend) {
                int friendPoint = 0;
                if (friendshipPointList.get(member) != null) {
                    friendPoint = friendshipPointList.get(member);
                }
                friendshipPointList.put(member, friendPoint + point);
            }
        }

        return friendshipPointList;
    }

    /**
     * 방문한 횟수에 따른 가산점 부여
     * 
     * @param visitors
     * @return
     */
    private static Map<String, Integer> getVisitorPointList(List<String> visitors, List<String> friendshipList) {
        Map<String, Integer> visitorPointList = new HashMap<String, Integer>();
        final int point = 1;
        for (int i = 0; i < visitors.size(); i++) {
            String member = visitors.get(i);

            // 사용자와 이미 친구인 경우는 SKIP
            if (friendshipList.contains(member))
                continue;
            int friendPoint = 0;
            if (visitorPointList.get(member) != null) {
                friendPoint = visitorPointList.get(member);
            }
            visitorPointList.put(member, friendPoint + point);
        }
        return visitorPointList;
    }

    /**
     * 사용자와 친구 목록을 구한다.
     * 
     * @param user
     * @param friends
     * @return
     */
    private static List<String> getFriendShipList(String user, List<List<String>> friends) {
        List<String> friendshipList = new ArrayList<String>();
        for (int i = 0; i < friends.size(); i++) {
            boolean isFriend = false;
            String friend = "";
            String member = "";
            for (int j = 0; j < friends.get(i).size(); j++) {
                member = friends.get(i).get(j);
                friend = friends.get(i).get(1 - j);
                if (member.equals(user)) {
                    // 멤버가 사용자일때, 다른 멤버는 친구 목록에 추가
                    isFriend = true;
                }
            }
            if (isFriend) {
                friendshipList.add(friend);
            }
        }
        return friendshipList;
    }
}
