package onboarding;

import java.util.*;

public class Problem7 {
    static class User {
        List<String> friendList;
        boolean isFriendToUser;
        int visitCount;
        int score;

        public User() {
            this.friendList = new ArrayList<>();
            this.isFriendToUser = false;
            this.visitCount = 0;
            this.score = 0;
        }

        public void calcScore(HashMap<String, User> hashMap) {
            this.score = 0;

            // 사용자와 함께 아는 친구의 수 계산
            // 친구가 user와 아는 사이인가? isFriendToUser가 true인가?
            // A - B - C
            // 삼각관계 처리
            if (!this.isFriendToUser) {
                for (String friend : friendList) {

                    if (hashMap.get(friend).isFriendToUser) {
                        this.score += 10;
                    }
                }
                // 사용자의 타임 라인에 방문한 횟수 계산
                score += this.visitCount;
            }
        }

        @Override
        public String toString() {
            return "User{" +
                    "friendList=" + friendList +
                    ", isFriendToUser=" + isFriendToUser +
                    ", visitCount=" + visitCount +
                    ", score=" + score +
                    '}';
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        // 사용자와 함께 아는 친구의 수 = 10
        // 사용자의 타임 라인에 방문한 횟수 = 1

        // HashMap 으로 관리하자
        // <Key, Value> : <이름, 클래스>
        // 클래스
        // HashMap 해당 유저와 연결된 친구 목록 저장
        // boolean user와 연결되었는지
        // int 방문 횟수

        // Value에 따른 내림차순 정렬하기
        // 이름의 오름차순으로 정렬하기

        // 1. 친구 HashMap 만들기
        HashMap<String, User> hashMap = new HashMap<>();
        // 0부터 삽입
        for (int i = 0; i < friends.size(); i++) {
            String first = friends.get(i).get(0);
            String second = friends.get(i).get(1);

            // Key 가 없다면 삽입
            if (hashMap.get(first) == null) {
                hashMap.put(first, new User());
            }
            if (hashMap.get(second) == null) {
                hashMap.put(second, new User());
            }

            // 친구 데이터 삽입
            hashMap.get(first).friendList.add(second);
            hashMap.get(second).friendList.add(first);

            // user와 친구인지 확인
            if (first.equals(user)) {
                hashMap.get(second).isFriendToUser = true;
            } else if (second.equals(user)) {
                hashMap.get(first).isFriendToUser = true;
            }
        }

        // visitor 데이터 추가
        for (int i = 0; i < visitors.size(); i++) {
            String visitor = visitors.get(i);

            if (hashMap.get(visitor) == null) {
                hashMap.put(visitor, new User());
            }

            hashMap.get(visitor).visitCount++;
        }

        // 점수 계산하기
        for (String person : hashMap.keySet()) {
            hashMap.get(person).calcScore(hashMap);
        }

        // 정렬하기
        List<Map.Entry<String, User>> entryList = new LinkedList<>(hashMap.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, User>>() {
            @Override
            public int compare(Map.Entry<String, User> o1, Map.Entry<String, User> o2) {
                // 점수의 내림차순
                // 점수가 같다면 이름의 오름차순
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return o2.getValue().score - o1.getValue().score;
                }
            }
        });

        System.out.println(entryList);

        // 0이 아닌 상위 5개 추출
        int count = 0;
        for (int i = 0; i < entryList.size(); i++) {
            // 5명 뽑으면 종료
            if (count == 5) {
                break;
            }

            // 이미 친구면 추천하지 않음
            if (entryList.get(i).getValue().isFriendToUser) {
                continue;
            }

            // 점수가 0이면 추천하지 않음
            if (entryList.get(i).getValue().score == 0) {
                continue;
            }

            // user 제외
            if (entryList.get(i).getKey().equals(user)) {
                continue;
            }

            answer.add(entryList.get(i).getKey());
        }

        return answer;
    }

    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");
        Problem7.solution(user, friends, visitors);
    }
}
