package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {
    public static class Friend {
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
        // 예외처리
        checkUserLength(user);
        checkFriendsLength(friends);
        checkID(friends);
        checkVisitors(visitors);

        // 0. 필요한 변수 생성
        List<Friend> result = new ArrayList<>(); // 최종 결과를 담아놓는 Friend 타입의 리스트
        List<String> friends10 = new ArrayList<>(); // user 의 친구의 친구들을 담아놓는 리스트
        List<String> friends1; // 방문자들 담아놓는 리스트
        List<String> userFriends; // user 의 친구들 목록 담아놓는 리스트
        List<String> answer = new ArrayList<>(); // 최종 결과에서 이름만 받아서 답을 담는 리스트

        // 1. 현재 user 와 친구인 사람들 찾음.
        userFriends = find(user, user, friends);

        // 2. 위의 현재 user 와 친구인 사람들의 친구인 사람들 찾고, 목록에 생성
        for(int i = 0; i<userFriends.size(); i++) {
            List<String> f = find(userFriends.get(i), user, friends);
            for(int j = 0; j<f.size(); j++) {
                friends10.add(f.get(j));
            }
        }

        // 2. 위의 현재 user 와 친구인 사람들 중복 제거
        friends10 = removeDuplication(friends10);
        // 3. 점수 10 점 친구들을 result 에 추가
        for(int i = 0; i<friends10.size(); i++) {
            Friend friend = new Friend(0, friends10.get(i));
            result.add(friend);
        }

        // 4. visitors 목록 중복 제거
        friends1 = removeDuplication(visitors);
        // 5. result 에 반영
        for(int i = 0; i<friends1.size(); i++) {
            // 이미 result 목록에 있을 10점 친구는 제외 && 이미 친구로 등록된 애들도 제외
            if(!friends10.contains(friends1.get(i)) && !userFriends.contains(friends1.get(i))) {
                Friend friend = new Friend(0, friends1.get(i));
                result.add(friend);
            }
        }

        // 6. friends 점수 부여
        // 10 점 부여
        for(int i = 0; i<friends10.size(); i++) {
            result = updateScore(result, friends10.get(i), 10);
        }
        // 1 점 부여
        for(int i = 0; i<visitors.size(); i++) {
            result = updateScore(result, visitors.get(i), 1);
        }

        // 7. 정렬
        result = sortList(result);

        // 8. answer 에 result 의 이름만 담아서 리턴
        for(int i = 0; i<result.size(); i++) {
            answer.add(result.get(i).getName());
        }


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

    // 예외처리
    private static void checkUserLength(String user) throws IllegalArgumentException {
        if(!(user.length() >= 1 && user.length() <= 30)) {
            throw new IllegalArgumentException("user 은 길이가 1 이상 30 이하인 문자열입니다.");
        }
    }

    private static void checkFriendsLength(List<List<String>> friends) throws IllegalArgumentException {
        if(!(friends.size() >= 1 && friends.size() <= 10_000)) {
            throw new IllegalArgumentException("friends 의 길이는 1 이상 10,000 이하이어야 합니다.");
        }
    }
    // ID 관련 제한 사항 : 아이디 길이, 알파벳 소문자만
    private static void checkID(List<List<String>> friends) throws IllegalArgumentException {
        for(int i = 0; i<friends.size(); i++) {
            boolean alpha = !(friends.get(i).get(0).matches("^[a-z]*$") && friends.get(i).get(1).matches("^[a-z]*$"));
            boolean length = !((friends.get(i).get(0).length() >= 1 && friends.get(i).get(0).length() <= 30) &&
                    (friends.get(i).get(1).length() >= 1 && friends.get(i).get(1).length() <= 30));
            if(alpha) {
                throw new IllegalArgumentException("ID 값은 알파벳 소문자만 가능합니다.");
            }
            if(length) {
                throw new IllegalArgumentException("ID 글자수는 1 이상 30 이하여야 합니다.");
            }
        }
    }
    // visitors 길이 제한 사항
    private static void checkVisitors(List<String> visitors) throws IllegalArgumentException {
        if(!(visitors.size() <= 10_000)) {
            throw new IllegalArgumentException("visitors 의 수는 0 이상 10,000 이하여야 합니다.");
        }
    }


}