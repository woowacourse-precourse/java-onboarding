package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        // 사용자의 친구 리스트 구하기
        List<String> userFriendsList = new ArrayList<>(); // 사용자 친구 리스트 저장할 리스트
        for(int i = 0; i < friends.size(); i++) {
            List<String> friendChk = new ArrayList<>(friends.get(i));
            // 친구 관계 정보에 사용자 이름이 있으면, 사용자 이름이랑 다른 아이디는 친구 아이디이므로, 사용자 친구 리스트에 추가
            if(friendChk.contains(user)) {
                friendChk.remove(user);
                userFriendsList.add(friendChk.get(0));
            }
        }

        // 친구의 친구일때의 추천 점수 구하기
        HashMap<String, Integer> friendScore = new HashMap<>();
        for(int i = 0; i < userFriendsList.size(); i++) {
            for (int j = 0; j < friends.size(); j++) {
                List<String> userFriendChk = new ArrayList<>(friends.get(j));
                // 친구 관계 정보에 사용자의 친구 아이디가 있으면, 사용자의 친구의 친구이므로
                if(userFriendChk.contains(userFriendsList.get(i))) {
                    userFriendChk.remove(userFriendsList.get(i));
                    // 친구의 친구일때의 추천 점수가 이미 저장되어 있다면 점수 업데이트
                    if(friendScore.containsKey(userFriendChk.get(0))) {
                        friendScore.replace(userFriendChk.get(0), friendScore.get(userFriendChk.get(0)) + 10);
                    }
                    else {
                        // 친구의 친구가 다시 자기 자신일때는 제외하고 친구 추천 점수 추가
                        if(!userFriendChk.contains(user)) {
                            friendScore.put(userFriendChk.get(0), 10);
                        }
                    }
                }
            }
        }

        // 타임라인에 방문한 사람의 추천 점수 구하기
        HashMap<String, Integer> visitorScore = new HashMap<>();
        for (int i = 0; i < visitors.size(); i++) {
            // 이미 친구인 경우에는 제외해야 친구 추천 점수가 올라가지 않음
            if(!userFriendsList.contains(visitors.get(i))) {
                if(visitorScore.containsKey(visitors.get(i))) {
                    visitorScore.replace(visitors.get(i), visitorScore.get(visitors.get(i)) + 1);
                }
                else {
                    visitorScore.put(visitors.get(i), 1);
                }
            }
        }

        // 추천 점수 합치기
        visitorScore.forEach((key,value) -> friendScore.merge(key, value, (v1, v2) -> v1 + v2));

        List<String> answer = new ArrayList<>(friendScore.keySet());
        // 추천 점수 먼저 이름순으로 정렬 후 점수가 높은 순으로 정렬하여 추천 점수가 같은 경우 이름 순으로 나오도록 함
        answer.sort(String::compareTo);
        answer.sort((v1, v2) -> (friendScore.get(v2).compareTo(friendScore.get(v1))));

        // 친구추천이 5명 초과한다면 5명까지만 추천해야하므로 리스트를 잘라줌
        if(answer.size() > 5) {
            answer.subList(0, 5);
        }

        return answer;
    }
}
