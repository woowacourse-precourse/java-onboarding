package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {

    private static class Friend {
        private int score;
        private String name;

        public Friend(int score, String name) {
            this.score = score;
            this.name = name;
        }

        public int getScore() {
            return score;
        }
        public String getName() {
            return name;
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    // target 과 일치하는 친구를 찾기 위한 함수
    // user 을 추가적으로 매개변수로 받는 이유는 user 자신은 탐색 대상이 아니므로 제외시키기 위해
    private static List<String> find(String target, String user, List<List<String>> friends) {
        List<String> find = new ArrayList<>();
        for(int i = 0; i<friends.size(); i++) {
            // target 과 일치 && 상대가 user 이 아닌 대상 -> user 자신은 친구 대상이 아니므로
            if(friends.get(i).get(0).equals(target) && !friends.get(i).get(1).equals(user)) {
                find.add(friends.get(i).get(1));
            }
            if(friends.get(i).get(1).equals(target) && !friends.get(i).get(0).equals(user)) {
                find.add(friends.get(i).get(0));
            }
        }

        return find;
    }

    // 중복 제거
    private static List<String> removeDuplication(List<String> list) {
        list = list.stream().distinct().collect(Collectors.toList());
        return list;
    }

    // 점수 부여
    private static List<Friend> updateScore(List<Friend> result, String friendName, int score) {
        for(int i = 0; i<result.size(); i++) {
            // result 객체의 이름과 friendsName 이름과 같으면, score 을 반영
            if(result.get(i).getName().equals(friendName)) {
                score += result.get(i).getScore();
                Friend friend = new Friend(score, result.get(i).getName());
                result.set(i, friend);
            }
        }

        return result;
    }

    // 정렬 : 점수가 가장 높은 순으로 정렬, 점수가 같으면 이름순으로 정렬
    private static List<Friend> sortList(List<Friend> result) {

        // 정렬 : 점수가 높은 순으로 하되, 점수가 같으면 이름 순으로 정렬
        Collections.sort(result, new Comparator<Friend>() {
            public int compare(Friend s1, Friend s2) {
                if(s1.getScore() < s2.getScore()) {
                    return 1;
                }
                if(s1.getScore() > s2.getScore()) {
                    return -1;
                }
                return s1.getName().compareTo(s2.getName());
            }
        });

        return result;

    }
}
