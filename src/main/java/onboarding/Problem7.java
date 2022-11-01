package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, List<String>> friendList = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = getRecommendFriendList(user, friends, visitors);
        return answer;
    }

    public static List<String> getRecommendFriendList(String user,
                                                      List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> score = new HashMap<>();
        List<String> resList = new ArrayList<>();

        initFriendList(friends);

        // 사용자의 친구들 목록
        for (String userFriend : friendList.get(user)) {
            List<String> userFriendFriend = friendList.get(userFriend);
            for (int i = 0; i < userFriendFriend.size(); i++) {
                if (isFriend(user, userFriendFriend.get(i))) {
                    score.put(userFriendFriend.get(i), 0);
                    continue;
                }

                if (!userFriendFriend.get(i).equals(user)) {
                    score.put(userFriendFriend.get(i), !score.containsKey(userFriendFriend.get(i))
                            ? 10 : score.get(userFriendFriend.get(i)) + 10);
                }
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            //  사용자의 친구 중에서 방문자가 있을 경우 스킵
            if (friendList.get(user).contains(visitors.get(i))) {
                continue;
            }

            score.put(visitors.get(i), !score.containsKey(visitors.get(i))
                    ? 1 : score.get(visitors.get(i)) + 1);
        }

        return sortResult(score);
    }

    //  친구 관계 Map을 만들기 위한 메소드
    public static void initFriendList(List<List<String>> friends) {
        Set<String> userSet = new HashSet<>();
        List<String> userList;
        List<List<String>> userFriendList = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            userSet.addAll(friends.get(i));
        }

        userList = new ArrayList<>(userSet);

        for (int i = 0; i < userList.size(); i++) {
            Set<String> set = new HashSet<>();
            //  모든 행을 돌면서, 행 안의 모든 요소를 Set에 저장
            for (int j = 0; j < friends.size(); j++) {
                if (friends.get(j).contains(userList.get(i))) {
                    set.addAll(friends.get(j));
                }
            }
            //  user의 이름은 제거
            set.remove(userList.get(i));
            userFriendList.add(new ArrayList<>(set));
        }

        for (int i = 0; i < userList.size(); i++) {
            friendList.put(userList.get(i), userFriendList.get(i));
        }
    }

    public static boolean isFriend(String user, String target) {
        if (friendList.get(user).contains(target)) {
            return true;
        }

        return false;
    }

    public static List<String> sortResult(Map<String, Integer> score) {
        List<String> res = new ArrayList<>();
        int resListSize;

        for (Map.Entry<String, Integer> item : score.entrySet()) {
            res.add(item.getKey() + "_" + item.getValue());
        }

        res.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] s1Ary = s1.split("_");
                String[] s2Ary = s2.split("_");

                if (Integer.parseInt(s1Ary[1]) == Integer.parseInt(s2Ary[1])) {
                    //  점수가 동일할 경우 이름을 가지고 정렬
                    return s1Ary[0].compareTo(s2Ary[0]);
                } else {
                    //  내림차순으로 만들어주기 위해 -1 곱하기
                    return Integer.compare(Integer.parseInt(s1Ary[1]), Integer.parseInt(s2Ary[1])) * -1;
                }
            }
        });

        //  res의 사이즈가 5보다 작을 경우를 대비하여 Math.min으로 최소값 잡아주기
        resListSize = Math.min(res.size(), 5);
        for (int i = 0; i < resListSize; i++) {
            res.set(i, res.get(i).split("_")[0]);
        }

        return res.subList(0, resListSize);
    }
}
