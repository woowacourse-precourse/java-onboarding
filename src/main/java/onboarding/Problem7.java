package onboarding;

import java.util.*;

class Friend {
    private String name;
    private int score;

    // Getter
    public String getName() {
        return this.name;
    }
    public Integer getScore() {
        return this.score;
    }

    // Setter
    public void setName(String name){
        this.name = name;
    }
    public void setScore(int score){
        this.score = score;
    }
    public void updateScore(int addScore) {
        this.score += addScore;
    }
}

public class Problem7 {
    // hashFriendshipScores 생성
    Hashtable<String, Friend> hashFriendshipScores = new Hashtable<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7 problem = new Problem7();
        /* friendNames: 친구 목록 생성  */
        List<String> friendNames = flatten2DimStringList(friends);   // 배열 평탄화
        friendNames = dropDuplicate(friendNames);   // 중복 제거
        friendNames.remove(user); // 친구 목록에서 user 제거

        /* hashFriendshipScores 에 Friends 객체 추가 */
        for (String name : friendNames) {
            problem.updateFriend(name);
        }

        // scoreCoFriend : friends 를 순회하며 userFriend 와 함께 아는 친구에 대해 score 10점 추가
        List<String> directFriends = getDirectFriends(user, friends);
        for (String name : directFriends) {
            problem.updateScore(name, 10);
        }

        // scoreVisitor : visitors 를 순회하며 방문자의 score 1점씩 추가
        // hashFriendshipScores 를 점수 내림차순, 이름 오름차순으로 정렬
        // 상위 5명 선택
        // score 가 0인 사람 제외
        List<String> answer = Collections.emptyList();
        return answer;
    }

    static List<String> flatten2DimStringList(List<List<String>> string2DimList) {
        List<String> flattenList = string2DimList.stream().reduce(new ArrayList<>(), (x, y) -> {
            x.addAll(y);
            return x;
        });
        return flattenList;
    }

    static List<String> dropDuplicate(List<String> stringList) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(stringList);
        List<String> listWithoutDuplicates = new ArrayList<>(linkedHashSet);
        return listWithoutDuplicates;
    }

    void updateFriend(String friendName) {
        Friend friend = new Friend();
        friend.setName(friendName);
        friend.setScore(0);
        this.hashFriendshipScores.put(friendName, friend);
    }

    static List<String> getDirectFriends(String user, List<List<String>> friends) {
        List<String> directFriends = new ArrayList<>();
        for (List<String> f : friends) {
            if (f.get(0).equals(user)) {
                directFriends.add(f.get(1));
                continue;
            }
            if (f.get(1).equals(user)) {
                directFriends.add(f.get(1));
            }
        }
        return directFriends;
    }

    void updateScore(String name, int score) {
        Friend friend = this.hashFriendshipScores.get(name);
        friend.updateScore(score); // 이렇게만 끝내도 업데이트 잘 되는지 확인
    }
}


