package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(); //반환용 리스트
        List<String> realFriends = new ArrayList<>(); //사용자와 이미 친구인 리스트
        List<String> withFriends = new ArrayList<>(); //친구의 친구 리스트(사용자와 친구X) -> +10점
        List<String> visitFriends = new ArrayList<>(); //방문자 리스트 -> +1점
        Map<String, Integer> friendScore = new HashMap<>(); //친구들의 추천 점수를 저장하는 맵 생성

        for (int i = 0; i < friends.size(); i++) {
            if (user.equals(friends.get(i).get(1))) {
                realFriends.add(friends.get(i).get(0));
            }
            if (user.equals(friends.get(i).get(0))) {
                realFriends.add(friends.get(i).get(1));
            }
        }

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < realFriends.size(); j++) {
                if (realFriends.get(j).equals(friends.get(i).get(0)) && !user.equals(friends.get(i).get(1))) {
                    if (!realFriends.contains(friends.get(i).get(1)))
                        withFriends.add(friends.get(i).get(1));
                }
                if (realFriends.get(j).equals(friends.get(i).get(1)) && !user.equals(friends.get(i).get(0))) {
                    if (!realFriends.contains(friends.get(i).get(0)))
                        withFriends.add(friends.get(i).get(0));
                }
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            if (!realFriends.contains(visitors.get(i))) {
                visitFriends.add(visitors.get(i));
            }
        }

        for (int i = 0; i < withFriends.size(); i++) {
            if (!friendScore.keySet().contains(withFriends.get(i))) {
                friendScore.put(withFriends.get(i), 10);
            } else {
                friendScore.put(withFriends.get(i), friendScore.get(withFriends.get(i)) + 10);
            }
        }
        //친구의 친구인 경우 +10점을 주는 것이다

        for (int i = 0; i < visitFriends.size(); i++) {
            if (!friendScore.keySet().contains(visitFriends.get(i))) {
                friendScore.put(visitFriends.get(i), 1);
            } else {
                friendScore.put(visitFriends.get(i), friendScore.get(visitFriends.get(i)) + 1);
            }
        }
        //방문자의 경우는 +1점

        List<String> sorts = new ArrayList<>();
        //나중에 같은 점수끼리 정렬용으로 사용하기 위해 빈 리스트 생성
        Map<List<String>, Integer> returnMap = new HashMap<>();
        //점수별로 정리해서 반환할 Map을 받기 위해 생성
        List<Map.Entry<String, Integer>> mapSort = new LinkedList<>(friendScore.entrySet());
        //현재 정렬이 안되어있는 추천친구들(Map)이기 때문에 리스트로 담기 위해 이렇게 생성

        Collections.sort(mapSort, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        int stop = 0;
        List<String> keep = new ArrayList<>();
        int size = 0;

        while (size < 5) {
            if (stop == mapSort.size()) {
                break;
            }
            returnMap = add(mapSort, sorts, stop);
            stop = returnMap.get(sorts);
            Iterator<List<String>> keys = returnMap.keySet().iterator();
            keep = keys.next();
            size += keep.size();

            for (int i = 0; i < keep.size(); i++) {
                answer.add(keep.get(i));
                if (answer.size() == 5) {
                    break;
                }
            }

            keep.clear();
        }
        return answer;
    }

    static Map<List<String>, Integer> add(List<Map.Entry<String,Integer>> sortMap, List<String> sorts, int stop) {
        Map<List<String >, Integer> sort = new HashMap<>();
        for (int i = 0; i < sortMap.size(); i++) {
            if (stop == sortMap.size())
                break;
            if (i > 0) {
                if (stop < sortMap.size() && sortMap.get(stop).getValue() != sortMap.get(stop - 1).getValue()) {
                    sort.put(sorts, stop);
                    break;
                } else {
                    sorts.add(sortMap.get(stop).getKey());
                    Collections.sort(sorts);
                    stop = stop + 1;
                }

            }
            else {
                sorts.add(sortMap.get(stop).getKey());
                stop = stop + 1;
            }
        }
        sort.put(sorts, stop);
        return sort;
    }
}