package onboarding;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Problem7 {
    /**
     [기능목록]
     1. 친구 관계 정보에서 이미 친구인 경우 제거하기
     2. 타임 라인 방문 기록에서 이미 친구인 경우 제거하기
     3. 사용자와 함께 아는 친구인 경우 해쉬맵에 10점 추가하기
     4. 사용자의 타임 라인에 방문한 경우 해쉬맵에 1점 추가하기
     5. 점수가 가장 높은 순으로 정렬하고 추천 점수가 같은 경우 이름순으로 정렬하기
     6. 최대 5명만 추천하고, 추천 점수가 0점인 경우 추천하지 않게 처리하기
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        friends = new CopyOnWriteArrayList<>(friends);
        visitors = new CopyOnWriteArrayList<>(visitors);
        List<String> userFriends = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        // 1. 친구 관계 정보에서 이미 친구인 경우 제거하기
        for(List<String> list : friends) {
            if(list.get(0).equals(user)) { // 친구리스트 중 0번째 이름이 사용자 이름일 경우
                userFriends.add(list.get(1)); // 1번째 이름을 사용자 친구 리스트에 저장 (0번째는 사용자 이름이므로)
                friends.remove(list); // 함께 아는 친구의 수를 고려할 때 필요 없는 리스트이므로 삭제
            } else if(list.get(1).equals(user)) { // 친구리스트 중 1번째 이름이 사용자 이름인 경우
                userFriends.add(list.get(0)); // 0번째 이름을 사용자 친구 리스트에 저장 (1번째는 사용자 이름이므로)
                friends.remove(list); // 함께 아는 친구의 수를 고려할 때 필요 없는 리스트이므로 삭제
            }
        }

        // 2. 타임 라인 방문 기록에서 이미 친구인 경우 제거하기
        for(String v : visitors) {
            for(String uf : userFriends) {
                if(v.equals(uf)) { // 방문자와 사용자의 친구일 경우
                    visitors.remove(v); // 타임라인에 방문한 횟수를 고려할 필요가 없으므로 삭제
                }
            }
        }

        // 3. 사용자와 함께 아는 친구인 경우 해쉬맵에 10점 추가하기
        for(List<String> list : friends) {
            for(String uf : userFriends) {
                if(list.get(0).equals(uf)) { // 사용자와 함께 아는 친구가 친구 리스트의 0번째인 경우
                    map.put(list.get(1), map.getOrDefault(list.get(1), 0) + 10); // 함께 아는 친구가 해쉬맵에 없으면 0을 리턴 + 10을 해서 해쉬맵에 저장
                } else if(list.get(1).equals(uf)) {
                    map.put(list.get(0), map.getOrDefault(list.get(0), 0) + 10);
                }
            }
        }

        // 4. 사용자의 타임 라인에 방문한 경우 해쉬맵에 1점 추가하기
        for(String v : visitors) { // 앞에서 친구인 경우는 제거했기 때문에 바로 해쉬맵에 +1 점해서 넣어주기
            map.put(v, map.getOrDefault(v, 0) + 1);
        }

        // 5. 점수가 가장 높은 순으로 정렬하고 추천 점수가 같은 경우 이름순으로 정렬하기
        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        // 비교함수 Comparator를 사용하여 내림차순으로 정렬 (점수 기준으로)
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int num = o2.getValue().compareTo(o1.getValue());
                if(num != 0) {
                    return num;
                } else { // 추천 점수가 같은 경우 이름순으로 정렬하기 위함
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });

        // 6. 최대 5명만 추천하고, 추천 점수가 0점인 경우 추천하지 않게 처리하기
        for(Map.Entry<String, Integer> entry : entries) {
            if(answer.size() >= 5) {
                break; // 최대 5명만 추천하기 위해
            }
            if(entry.getValue() > 0) { // 추천 점수가 0점인 경우 추천하지 않게 하기 위함
                answer.add(entry.getKey());
            }
        }

        return answer;
    }
}
