package onboarding;

import java.util.*;
import java.util.stream.Collectors;

class Recommend {
    private String name;
    private int score;

    public Recommend(String name, int score) {
        this.name = name;
        this.score = score;
    }
    // Getter
    public String getName() {
        return this.name;
    }
    public Integer getScore() {
        return this.score;
    }

    public void updateScore(int addScore) {
        this.score += addScore;
    }
}

public class Problem7 {
    // hashFriendshipScores 생성
    Hashtable<String, Recommend> hashPersonToRecommend = new Hashtable<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7 problem = new Problem7();
        /* personToRecommend: 추천 목록 생성  */
        List<String> personToRecommend  = flatten2DimStringList(friends);   // friends 배열 평탄화
        personToRecommend.addAll(visitors); // 방문자 추가
        personToRecommend = dropDuplicate(personToRecommend);   // 중복 제거
        personToRecommend.remove(user); // 친구 목록에서 user 제거
        List<String> directFriends = getDirectFriends(user, friends);
        for (String name : directFriends) {
            personToRecommend.remove(name); // user 이미 친구인 사람 목록에서 제거
        }

        /* hashFriendshipScores 에 Recommend 객체 추가 */
        for (String name : personToRecommend) {
            problem.updateFriend(name);
        }

        /* 함께 아는 친구( coFriend ) score 10점씩 추가 */
        List<String> coFriends = getCoFriends(user, friends, directFriends);
        for (String name : coFriends) {
            problem.updateScore(name, 10);
        }

        /* 방문자의 score 1점씩 추가 */
        for (String name : visitors) {
            if (!directFriends.contains(name)) {
                problem.updateScore(name, 1);
            }
        }

        /* 점수 내림차순, 이름 오름차순으로 정렬 */
        List<Recommend> friendList = new ArrayList(problem.hashPersonToRecommend.values());
        friendList.sort(Comparator
                .comparing(Recommend::getScore).reversed()     // 점수 내림차순
                .thenComparing(Recommend::getName));     // 이름 오름차순

        // 상위 5명 선택
        int top = Math.min(friendList.size(), 5);
        List<Recommend> topScoreRecommend = friendList.subList(0, top);

        // score 가 0인 사람 제외하고 friend name만 추출
        List<String> answer = topScoreRecommend.stream()
                                                .filter(r -> r.getScore()!=0)
                                                .map(r -> r.getName())
                                                .collect(Collectors.toList());
        return answer;
    }

    static List<String> flatten2DimStringList(List<List<String>> string2DimList) {
        List<String> flattenList = string2DimList.stream()
                                                .reduce(new ArrayList<>(), (x, y) -> {
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

    void updateFriend(String name) {
        Recommend recommend = new Recommend(name, 0);
        this.hashPersonToRecommend.put(name, recommend);
    }

    static List<String> getDirectFriends(String user, List<List<String>> friends) {
        List<String> directFriends = new ArrayList<>();
        for (List<String> f : friends) {
            if (f.get(0).equals(user)) {
                directFriends.add(f.get(1));
                continue;
            }
            if (f.get(1).equals(user)) {
                directFriends.add(f.get(0));
            }
        }
        return dropDuplicate(directFriends);    // 중복 제거
    }

    static List<String> getCoFriends(String user, List<List<String>> friends, List<String> directFriends) {
        return friends.stream()
                .filter(f -> !f.contains(user)) // 사용자와 직접 친구 제외
                .filter(f -> directFriends.contains(f.get(0)) || directFriends.contains(f.get(1)))  // 친구를 공유하고 있는 경우
                .map(f -> directFriends.contains(f.get(0)) ? f.get(1) : f.get(0))
                .collect(Collectors.toList());
    }

    void updateScore(String name, int score) {
        if (!this.hashPersonToRecommend.containsKey(name)) {
            System.out.println(this.hashPersonToRecommend.keySet());
            System.out.println(name + " is not in hashFriendshipScores");
        } else {
            this.hashPersonToRecommend.get(name).updateScore(score); // 이렇게만 끝내도 업데이트 잘 되는지 확인
        }
    }
}


