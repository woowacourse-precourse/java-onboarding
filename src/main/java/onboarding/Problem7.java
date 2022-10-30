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
        friendNames.addAll(visitors);
        friendNames = dropDuplicate(friendNames);   // 중복 제거
        friendNames.remove(user); // 친구 목록에서 user 제거

        /* hashFriendshipScores 에 Friends 객체 추가 */
        for (String name : friendNames) {
            problem.updateFriend(name);
        }

        // friends 를 순회하며 directFriends 와 함께 아는 친구( coFriend )에 대해 score 10점 추가
        List<String> directFriends = getDirectFriends(user, friends);
        List<String> coFriends = getCoFriends(user, friends, directFriends);
        for (String name : coFriends) {
            problem.updateScore(name, 10);
        }

        // visitors 를 순회하며 방문자의 score 1점씩 추가
        for (String name : visitors) {
            problem.updateScore(name, 1);
        }

        // hashFriendshipScores의 value 를 점수 내림차순, 이름 오름차순으로 정렬
        List<Friend> friendList = new ArrayList(problem.hashFriendshipScores.values());
        friendList.sort(Comparator
                .comparing(Friend::getScore).reversed()     // 점수 내림차순
                .thenComparing(Friend::getName));     // 이름 오름차순

        // 상위 5명 선택
        int top = Math.min(friendList.size(), 5);
        List<Friend> topScoreFriend = friendList.subList(0, top);

        // score 가 0인 사람 제외하고 friend name만 추출
        List<String> answer = new ArrayList<>();
        for (Friend f : topScoreFriend) {
            if (f.getScore()==0) {
                break;
            }
            answer.add(f.getName());
        }

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
                directFriends.add(f.get(0));
            }
        }
        return directFriends;
    }

    static List<String> getCoFriends(String user, List<List<String>> friends, List<String> directFriends) {
        List<String> coFriends = new ArrayList<>();
        for (List<String> f : friends) {
            for (String name : directFriends) {
                if (f.get(0).equals(name) & !f.get(1).equals(user)) {
                    coFriends.add(f.get(1));
                    continue;
                }
                if (f.get(1).equals(name) & !f.get(0).equals(user)) {
                    coFriends.add(f.get(0));
                }
            }
        }
        return coFriends;
    }

    void updateScore(String name, int score) {
        if (!this.hashFriendshipScores.containsKey(name)) {
            System.out.println(this.hashFriendshipScores.keySet());
            System.out.println(name + " is not in hashFriendshipScores");
        } else {
            this.hashFriendshipScores.get(name).updateScore(score); // 이렇게만 끝내도 업데이트 잘 되는지 확인
        }
    }
}


