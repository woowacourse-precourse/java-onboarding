package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> mFriends = findFriend(user, friends);

        List<List<String>> friendScore = countFriend(user, friends, mFriends);

        List<List<String>> visitScore = countVisit(visitors, mFriends);

        List<List<String>> scores = getScore(friendScore, visitScore);

        List<List<String>> score = sortByScore(scores);

        List<String> finalScore = sortByName(score);

        if (!finalScore.isEmpty())
            answer = finalScore;

        return answer;
    }

    public static List<String> findFriend(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0).equals(user)) {
                result.add(friends.get(i).get(1));
            }else if (friends.get(i).get(1).equals(user)) {
                result.add(friends.get(i).get(0));
            }
        }

        return result;
    }

    public static List<List<String>> countFriend(String user, List<List<String>> friends, List<String> mFriends) {
        int cnt = 0;

        List<String> g = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < mFriends.size(); i++) {
            // 있으면 넣지 않도록
            List<String> m = findFriend(mFriends.get(i), friends);
            for (int j = 0; j < m.size(); j++) {
                g.add(m.get(j));
            }
        }

        while (g.remove(user)) {}

        for (int i = 0; i < g.size(); i++) {
            cnt = 0;
            for (int j = 0 ; j < g.size(); j++) {
                if(g.get(i).equals(g.get(j))) {
                    cnt++;
                }
            }
            if (cnt > 1) {
                if (!result.contains(List.of(g.get(i), String.valueOf(cnt))))
                    result.add(List.of(g.get(i), String.valueOf(cnt * 10)));
            }
        }

        return result;
    }

    public static List<List<String>> countVisit(List<String> visitors, List<String> mFriends) {
        List<List<String>> result = new ArrayList<>();
        int cnt = 0;
        List<String> list = new ArrayList<>();

        for (int i = 0; i < visitors.size(); i++) {
            cnt = 0;
            for (int j = 0; j < mFriends.size(); j++) {
                if (visitors.get(i).equals(mFriends.get(j))) {
                    cnt++;
                }
            }
            if (cnt == 0) {
                list.add(visitors.get(i));
            }
        }

        for (int i = 0; i < list.size(); i++) {
            cnt = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    cnt++;
                }
            }
            if (cnt > 0) {
                if (!result.contains(List.of(list.get(i), String.valueOf(cnt))))
                    result.add(List.of(list.get(i), String.valueOf(cnt)));
            }
        }

        return result;
    }

    public static List<List<String>> getScore(List<List<String>> friendScore, List<List<String>> visitScore) {
        List<List<String>> list = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < friendScore.size(); i++) {
            list.add(friendScore.get(i));
        }

        for (int i = 0; i < visitScore.size(); i++) {
            int score = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).get(0).equals(visitScore.get(i).get(0))) {
                    score = Integer.parseInt(list.get(j).get(1)) + Integer.parseInt(visitScore.get(i).get(1));
                    result.add(List.of(list.get(j).get(0), String.valueOf(score)));
                }
            }
            if (score == 0)
                result.add(visitScore.get(i));
        }

        for (int i = 0; i < list.size(); i++) {
            int cnt = 0;
            for (int j = 0; j < result.size(); j++) {
                if (result.get(j).get(0).equals(list.get(i).get(0))) {
                    cnt++;
                }
            }
            if (cnt == 0)
                result.add(list.get(i));
        }

        return result;
    }

    public static List<List<String>> sortByScore(List<List<String>> scores) {
        List<List<String>> result = new ArrayList<>();

        result.addAll(scores);

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.size() - i - 1; j++) {
                if (Integer.parseInt(result.get(j).get(1)) < Integer.parseInt(result.get(j + 1).get(1))) {
                    List<String> tmp = result.get(j);
                    result.set(j, result.get(j + 1));
                    result.set(j + 1, tmp);
                }
            }
        }

        return result;
    }
    public static List<String> sortByName(List<List<String>> scores) {
        List<String> result = new ArrayList<>();
        List<List<String>> list = new ArrayList<>();

        list.addAll(scores);

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).get(1) == list.get(j + 1).get(1) && list.get(j).get(0).compareTo(list.get(j + 1).get(1)) > 0) {
                    List<String> tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            result.add(list.get(i).get(0));
        }

        return result;
    }
}
