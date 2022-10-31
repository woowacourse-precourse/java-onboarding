package onboarding;

import java.util.*;

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

    private static void addVisitScore(String s, String user) {
        int sc;
        List<String> userFriends = friendsMap.get(user);

        if (s == user || ((userFriends != null) && userFriends.contains(s)))
            return ;
        if (!score.containsKey(s))
            sc = 1;
        else
            sc = score.get(s) + 1;
        score.put(s, sc);
    }

    private static void addFriendsScore(String s, String user) {
        List<String> friendsList = friendsMap.get(s);
        List<String> userFriends = friendsMap.get(user);

        for (int i = 0; i < friendsList.size(); i++) {
            String name = friendsList.get(i);
            if (name == user || userFriends.contains(name))
                continue;
            int sc = score.get(name);
            score.put(name, sc + 10);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++)
            addFriends(friends.get(i));

        if (friendsMap.containsKey(user)) {
            List<String> friendsList = friendsMap.get(user);

            for (int i = 0; i < friendsList.size(); i++)
                addFriendsScore(friendsList.get(i), user);
        }

            for (int i = 0; i < visitors.size(); i++)
                addVisitScore(visitors.get(i), user);

        List<String> keySet = new ArrayList<>(score.keySet());

        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int ret = score.get(o2).compareTo(score.get(o1));

                if (ret == 0)
                    return o1.compareTo(o2);
                return ret;
            }
        });

        System.out.println("score = " + score);

        for (int i = 0; i < 5; i++){
            String name = keySet.get(i);
            if (score.get(name) == 0)
                return answer;
            answer.add(name);
        }

        return answer;
    }
}
