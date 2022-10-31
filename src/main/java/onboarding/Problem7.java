package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendWithUserList = new ArrayList<>();
        Map<String, Integer> friendWithUserDict = new HashMap<>();
        List<String> answer = new ArrayList<>();
        // 사용자와 친구인 유저의 이름 배열에 담기
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                if (friend.get(0).equals(user))
                    friendWithUserList.add(friend.get(1));
                else
                    friendWithUserList.add(friend.get(0));
            } else {
                friendWithUserDict.put(friend.get(0), 0);
                friendWithUserDict.put(friend.get(1), 0);
            }
        }

        for (String f : friendWithUserList)
            friendWithUserDict.remove(f);
        // 사용자와 함께 아는 친구의 이름 10점 주기
        friendWithUserDict.forEach((key, value) -> {
            for (List<String> friend : friends) {
                if (friend.contains(key))
                    friendWithUserDict.computeIfPresent(key, (k, v) -> v + 10);
            }
        });

        // 방문한 유저를 1점 주기 이미 값이 있다면 1점 추가
        for (String visit : visitors) {
            if (!friendWithUserList.contains(visit)) {
                friendWithUserDict.putIfAbsent(visit, 0);
                friendWithUserDict.computeIfPresent(visit, (k, v) -> v + 1);
            }
        }

        // 해쉬맵을 value값으로 내림차순 정렬 후 return
        List<Map.Entry<String,Integer>> checkArr = new ArrayList<>(friendWithUserDict.entrySet());
        checkArr.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> arr1, Map.Entry<String, Integer> arr2) {
                // 추천 점수가 같은 경우는 이름순으로 정렬
                if (arr1.getValue() == arr2.getValue()) {
                    return arr1.getKey().compareTo(arr2.getKey());
                }
                return arr2.getValue().compareTo(arr1.getValue());
            }
        });
        for (Map.Entry<String,Integer> entry : checkArr){
            answer.add(entry.getKey());
        }

        // 최대 5명을 return (다섯명이 넘어갈 경우 삭제)
        if(answer.size() > 5) {
            for(int i = 5; i < answer.size(); i++){
                answer.remove(i);
            }
        }

        return answer;
    }
}