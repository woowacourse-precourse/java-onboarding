package onboarding;

import java.util.*;
import java.util.Map.Entry;

/*
 * 함께 아는 친구의 수 - 10점
 * 사용자의 타임라이넹 방문한 횟수 - 1점
 *
 * 사용자 user, 친구 관계 정보 friends, 방문기록 visitors
 * 점수 높은순 5명 반환, 0점은 리턴하지 않는다.
 *
 * [A,B] A와 B는 친구이며, 중복해서 주어지지 않고, 추천할 친구가 없는 경우 주어지지 않는다.
 *
 * user의 친구는 return하지 않아도 됨.
 *
 * 1. 전체 인원을 hashmap에 담음.
 * 2. 유저와 친구인 사람을 set을 사용하여 추린다.
 * 3. set을 반복하면서 친구의 친구인 사람들에게 점수 부여
 * 4. visitors 점수 부여
 * 5. 유저, 유저와 친구인 사람들을 hashmap에서 삭제
 * 6. List에 담아서 정렬
 * 7. 출력
 *
 */
public class Problem7 {

    class User {
        String name;
        int score;

        public User() {
        }

        public User(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7 p = new Problem7();

        Map<String, Integer> score = p.initScore(friends);
        Set<String> userSFriend = p.userSFriendInit(user, friends);
        p.addScoreLinkFriend(friends, score, userSFriend);
        p.addScoreVisitors(score, visitors);
        p.deleteUserAndUserSFriend(score, userSFriend);

        // user 객체에 담기
        List<User> forSortList = p.forSortResult(score);
        forSortList.sort(Comparator.comparing(User::getScore).reversed().thenComparing(User::getName));
        List<String> answer = p.returnResult(forSortList);

        for (User s : forSortList) {
            System.out.println(s.getName() + s.getScore());
        }
        return answer;
    }

    // 유저랑 친구인 사람들은 Set으로 초기화
    public Set<String> userSFriendInit(String user, List<List<String>> friends) {
        Set<String> userSFriend = new HashSet<>();

        for (List<String> friendArr : friends) {
            String friendA = friendArr.get(0);
            String friendB = friendArr.get(1);
            if (friendA.equals(user) || friendB.equals(user)) {
                userSFriend.addAll(friendArr);
            }
        }
        return userSFriend;
    }


    // 모든 유저를 HashMap을 사용하여 name, value로 초기화한다.
    public Map<String, Integer> initScore(List<List<String>> friends) {
        Map<String, Integer> initScore = new HashMap<>();
        for (List<String> friendArr : friends) {
            for (String friend : friendArr) {
                initScore.put(friend, 0);
            }
        }
        return initScore;
    }

    // 함께 아는 친구 점수 추가

    public void addScoreLinkFriend(List<List<String>> friends, Map<String, Integer> score, Set<String> userSFriend) {
        // 친구의 친구의 점수를 올려야하는 상황이므로
        // 친구의 친구를 저장하고, 리스트에서 친구가 있을때, 해시맵에 저장
        for (String friend : userSFriend) {
            for (List<String> friendArr : friends) {
                String friendA = friendArr.get(0);
                String friendB = friendArr.get(1);

                if (friendA.equals(friend)) {
                    score.put(friendB, score.get(friendB) + 10);
                } else if (friendB.equals(friend)) {
                    score.put(friendA, score.get(friendA) + 10);
                }
            }
        }
    }

    // visitors 점수 추가
    public void addScoreVisitors(Map<String, Integer> score, List<String> visitors) {
        for (String visitor : visitors) {
            if (score.get(visitor) != null) {
                score.put(visitor, score.get(visitor) + 1);
            } else {
                score.put(visitor, score.getOrDefault(visitor, 0) + 1);
            }
        }
    }

    // 사용자, 사용자 친구들 삭제
    public void deleteUserAndUserSFriend(Map<String, Integer> score, Set<String> userSFriend) {
        for (String friend : userSFriend) {
            score.remove(friend);
        }
    }

    // return
    public List<User> forSortResult(Map<String, Integer> score) {
        List<User> answer = new ArrayList<>();

        for (Entry<String, Integer> entrySet : score.entrySet()) {
            if (entrySet.getValue() > 0) {
                User user = new User(entrySet.getKey(), entrySet.getValue());
                answer.add(user);
            }
        }

        return answer;
    }

    public List<String> returnResult(List<User> forSortList) {
        List<String> answer = new ArrayList<>();
        for (User s : forSortList) {
            answer.add(s.getName());
            if (answer.size() > 5) {
                break;
            }
        }
        return answer;
    }


}
