package onboarding;

import java.util.*;

/*
* 1. user의 친구 목록을 구해야 한다. (이미 친구면 추천할 이유가 없기 때문)
* 2. 목록을 통해 친구의 친구인 원소를 찾아 반환한다.
* 3. 방문자 리스트와 친구의 친구 리스트를 통해 가중치를 얻을 구하도록 Recommend 객체를 생성한다
* 4. 객체를 통해 리스트를 만들고 가중치를 더해 정렬한다.
* 5. 사이즈가 5인 친구 추천 리스트를 반환한다.
* */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> findUserFriends(String user, List<List<String>> friends) {
        List<String> findFriendList = new ArrayList<>(); // user의 친구를 담을 리스트(동일한 친구가 중복되지 않기 때문에 리스트)

        for (int i = 0; i < friends.size(); i++) { // 친구 목록 리스트 순회
            for (int j = 0; j < friends.get(i).size(); j++) { // 친구 리스트 순회
                if (friends.get(i).get(j).equals(user)) { // 리스트에서 user가 발견되면
                    if (j == 0) { // user가 0번 인덱스에 있으면
                        findFriendList.add(friends.get(i).get(1)); // 1번 인덱스를 set에 삽입
                    } else { // 아니면 (user가 1번 인덱스에 있는 경우)
                        findFriendList.add(friends.get(i).get(0)); // 0번 인덱스를 set에 삽입
                    }
                }
            }
        }
        return findFriendList;
    }

    public static List<String> knowEachOtherScoreOfFriends(List<List<String>> friends, List<String> findFriendList, String user) {
        List<String> eachOtherList = new ArrayList<>(); // 친구의 친구를 담을 리스트 생성

        for (int i = 0; i < findFriendList.size(); i++) { // user의 친구가 담긴 리스트 (findUserFriends()의 결과)
            for (int j = 0; j < friends.size(); j++) { // 친구 목록 리스트 순회
                for (int k = 0; k < friends.get(j).size(); k++) { // 친구 리스트 순회
                    if (friends.get(j).get(k).equals(findFriendList.get(i))) {
                        if (k == 0) { // findFriendList(i)가 0번 인덱스에 있으면
                            eachOtherList.add(friends.get(j).get(1)); // 1번 인덱스를 set에 삽입
                        } else { // 아니면 (findFriendList(i)가 1번 인덱스에 있는 경우)
                            eachOtherList.add(friends.get(j).get(0)); // 0번 인덱스를 set에 삽입
                        }
                    }
                }
            }
        }
        eachOtherList.removeAll(Collections.singleton(user)); // 리스트에 user가 들어가기 때문에 user 제외
        return eachOtherList;
    }
}
