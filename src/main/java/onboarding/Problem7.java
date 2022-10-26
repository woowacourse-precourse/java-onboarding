package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //친구 목록 맵
        Map<String, List<String>> friendsMap = new HashMap<>();
        //추천 친구 점수 맵
        Map<String, Integer> scoreMap = new HashMap<>();
        
        for (List<String> friend : friends) {
            //친구1
            String human1 = friend.get(0);
            //친구2
            String human2 = friend.get(1);

            // 친구1 의 친구2 추가
            List<String> list1 = new ArrayList<>();
            if(friendsMap.get(human1) != null) list1 = friendsMap.get(human1);
            list1.add(human2);
            friendsMap.put(human1, list1);

            // 친구2 의 친구1 추가
            List<String> list2 = new ArrayList<>();
            if(friendsMap.get(human2) != null) list2 = friendsMap.get(human2);
            list2.add(human1);
            friendsMap.put(human2, list2);
        }

        // 함께 아는 친구 점수 추가
        for (String name : friendsMap.get(user)) {
            for (String recommend : friendsMap.get(name)) {
                // 본인일 경우
                if(recommend.equals(user)) continue;
                // 이미 친구일 경우
                if(friendsMap.get(user).contains(recommend)) continue;

                // 10점 추가
                int score = 0;
                if(scoreMap.get(recommend) != null) score = scoreMap.get(recommend);
                scoreMap.put(recommend, score+10);
            }
        }

        // 타임 라인 방문한 횟수 점수 추가
        for (String visitor : visitors) {
            // 본인일 경우
            if(visitor.equals(user)) continue;
            // 이미 친구일 경우
            if(friendsMap.get(user).contains(visitor)) continue;

            // 1점 추가
            int score = 0;
            if(scoreMap.get(visitor) != null) score = scoreMap.get(visitor);
            scoreMap.put(visitor, score+1);
        }

        //점수가 기록된 맵의 키값들을 리스트로 변환
        List<String> answer = new ArrayList<>(scoreMap.keySet());

        //점수순으로 정렬 - 점수가 같을 경우 이름순으로 정렬
        answer.sort((o1, o2) ->  {
                if(scoreMap.get(o1).equals(scoreMap.get(o2))) return o1.compareTo(o2);
                return scoreMap.get(o2) - scoreMap.get(o1);
        });

        //추천 친구목록이 5명 초과일 때 5명으로 자름
        if(answer.size()>5) answer = answer.subList(0,5);

        return answer;
    }
}
