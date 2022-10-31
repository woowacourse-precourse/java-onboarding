package onboarding;

import java.util.*;

/*
문제 설명
친구 추천 알고리즘을 위한 규칙
- 사용자와 함께 아는 친구의 수 = 10점
- 사용자의 타임 라인에 방문환 횟수 = 1점

친구 추천 규칙에 따라 점수가 높은 순으로 정렬하여 최대 5명을 반환하도록 한다.
추천 점수가 0점일 경우 추천하지 않으며, 점수가 같은 경우는 이름순으로 정렬한다.

user: 사용자 아이디 문자열
friends: 각 원소가 길이 2인 친구 관계 정보 리스트. [아이디 A, 아이디 B] -> A와 B는 친구
visitors: 사용자 타임 라인 방문 기록
*/

/*
기능 목록
- 점수를 세기 위한 친구 HashSet 구성하기.
- 친구 목록 HashSet을 통해 점수를 0으로 일단 초기화하기.
- 사용자와 함께 아는 친구 그룹 구성하기.
- 함께 아는 친구들 점수 내기.
- 타임 라인 방문 기록을 통해 점수 내기.
- 함께 아는 친구를 통해 낸 점수와 타임 라인에 방문한 횟수를 통해 낸 점수 합치기.
- 점수 내림차순으로 정렬하여 최대 5명 뽑기.
- 추천 점수가 같은 경우 이름순으로 정렬하기.
- 추천 점수가 0점인 경우 추천하지 않기.
*/

public class Problem7 {
    // 사용자가 어떤 그룹에 속하는지 찾기 위한 메서드이다.
    public static String find_friend(HashMap<String, String> friends_unioned, String group) {

        String parent = friends_unioned.get(group);

        // 자기 자신이 루트 노드(속한 그룹)이 아닌 경우, 루트 노드를 찾을 때까지 재귀적으로 호출한다.
        if (!(parent.equals(group))) {
            friends_unioned.put(group, find_friend(friends_unioned, parent));
        }
        return parent;
    }

    // friends 리스트에 있는 사용자들을 같은 그룹으로 묶어준다.
    public static void union_friend(HashMap<String, String> friends_unioned, String user1, String user2) {
        user1 = find_friend(friends_unioned, user1);
        user2 = find_friend(friends_unioned, user2);

        // 알파벳 순으로 비교했을 때 더 작은 유저의 이름을 parent로 삼는다.
        if (user1.compareTo(user2) < 0) {
            friends_unioned.put(user2, user1);
        }
        else {
            friends_unioned.put(user1, user2);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        // 친구 목록을 중복되지 않도록 구성해준다.
        HashSet<String> friends_set = new HashSet<>();

        for (List<String> friend: friends) {
            for (int i = 0; i < 2; i++) {
                if (!(friend.get(i).equals(user))) {
                    friends_set.add(friend.get(i));
                }
            }
        }

        // friends_set에 방문자 목록도 추가해준다.
        for (String visitor : visitors) {
            friends_set.add(visitor);
        }

        // 추천 점수를 세기 위한 HashMap을 구성해준다.
        HashMap<String, Integer> friends_score = new HashMap<>();

        // 초기 구성을 0으로 초기화해준다.
        for (String friend : friends_set) {
            friends_score.put(friend, 0);
        }

        // 서로 아는 친구 목록을 구성하기 위한 HashMap을 구성해준다.
        // 그룹은 일단 자기 자신으로 초기화해준다.
        HashMap<String, String> friends_unioned = new HashMap<>() {{
            put(user, user);
        }};

        for (String friend : friends_set) {
            friends_unioned.put(friend, friend);
        }

        // 서로 친구인 사용자들을 같은 그룹으로 묶어준다.
        for (List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);

            union_friend(friends_unioned, user1, user2);
        }

        // 함께 아는 친구 목록에 10점을 준다.
        String group = friends_unioned.get(user);

        for (String key : friends_score.keySet()) {
            String key_group = friends_unioned.get(key);

            if (key_group.equals(group)) {
                friends_score.put(key, 10);
            }
        }

        // 방문한 횟수에 따라 1점씩 더해준다.
        for (String visitor : visitors) {
            friends_score.put(visitor, friends_score.get(visitor) + 1);
        }

        // user와 이미 친구인 경우에는 친구 추천 목록에 넣을 필요가 없기 때문에, 점수를 0으로 바꿔준다.
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) {
                friends_score.put(friend.get(1), 0);
            }
            else if (friend.get(1).equals(user)) {
                friends_score.put(friend.get(0), 0);
            }
        }

        List<String> keySet_list = new ArrayList<>(friends_score.keySet());
        Collections.sort(keySet_list);

        Collections.sort(keySet_list, (o1, o2) -> (friends_score.get(o2).compareTo(friends_score.get(o1))));
        for(String key : keySet_list) {
            if (friends_score.get(key) == 0 || answer.size() == 5) {
                break;
            }

            answer.add(key);
        }

        return answer;
    }
}
