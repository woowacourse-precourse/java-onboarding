package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//-----기능-----
// 1. friends 배열 돌면서 친구 관계 정리 (HashMap)
// 2. 만들어진 hash 돌면서 아는 친구 점수 정리
// 3. visitor 돌면서 방문 점수 정리
// 4. 점수 순으로 정렬

public class Problem7 {

    private static HashMap<String, List<String>> friendsMap = new HashMap<>();
    private static HashMap<String, Integer> score = new HashMap<>();

    private static void addFriends(List<String> strings) {

        List<String> flist;
        if (friendsMap.containsKey(strings.get(0)))
            flist = friendsMap.get(strings.get(0));
        else {
            flist = new ArrayList<>();
            score.put(strings.get(0), 0);
        }

        flist.add(strings.get(1));
        friendsMap.put(strings.get(0), flist);

        if (friendsMap.containsKey(strings.get(1)))
            flist = friendsMap.get(strings.get(1));
        else {
            flist = new ArrayList<>();
            score.put(strings.get(1), 0);
        }
        flist.add(strings.get(0));
        friendsMap.put(strings.get(1), flist);
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        for (int i = 0; i < friends.size(); i++)
            addFriends(friends.get(i));

        System.out.println(friendsMap);

        getFriendsScore(user);

        System.out.println("score = " + score);

        return answer;
    }

    private static void getFriendsScore(String user) {
        List<String> friendsList = friendsMap.get(user);

        for (int i = 0; i < friendsList.size(); i++)
            addFriendsScore(friendsList.get(i), user);
    }

    private static void addFriendsScore(String s, String user) {
        List<String> friendsList = friendsMap.get(s);
        List<String> userFriends = friendsMap.get(user);

        for (int i = 0; i < friendsList.size(); i++) {
            String name = friendsList.get(i);
            if (name == "mrko" || userFriends.contains(name))
                continue;
            int sc = score.get(name);
            score.put(name, sc + 10);
        }
    }
}
