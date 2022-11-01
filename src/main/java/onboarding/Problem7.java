package onboarding;

import java.util.*;

/**
 * 기능 목록
 * 1. 함께 아는 친구들 처리. -> [user 의 친구를 먼저 찾고, 친구의 친구를 찾아서 등록 해줘야 한다.]
 * 2. 타임 라인 방문한 친구들 처리
 * 3. 점수를 매겨서,
 * 4. 순서대로 list 에 넣어주기.
 */
//사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors가 매개변수로 주어질 때,
// 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return 하도록 solution 메서드를 완성하라.
// 이때 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬한다.

//- 사용자와 함께 아는 친구의 수 = 10점
//- 사용자의 타임 라인에 방문한 횟수 = 1점

//- user는 길이가 1 이상 30 이하인 문자열이다.
//- friends는 길이가 1 이상 10,000 이하인 리스트/배열이다.
//- friends의 각 원소는 길이가 2인 리스트/배열로 [아이디 A, 아이디 B] 순으로 들어있다.
//  - A와 B는 친구라는 의미이다.
//  - 아이디는 길이가 1 이상 30 이하인 문자열이다.
//- visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
//- 사용자 아이디는 알파벳 소문자로만 이루어져 있다.
//- 동일한 친구 관계가 중복해서 주어지지 않는다.
//- 추천할 친구가 없는 경우는 주어지지 않는다.
public class Problem7 {

    public static Map<String, Integer> algorithmCandidate = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        return answer;
    }

    public void addCandidateFriends(String user, List<List<String>> friends) throws Exception {
        List<String> userFriends = findUserFriends(user, friends);
        for (String userFriend : userFriends) {
            List<String> list = findUserFriends(userFriend, friends);
            addCandidateIterList(list, 10);
        }
    }



    private List<String> findUserFriends(String user, List<List<String>> list) throws Exception {
        List<String> friends = new ArrayList<>();
        for (List<String> friendList : list) {
            if (checkUserFriend(user, friendList)) {
                friends.add(getUserFriend(user, friendList));
            }
        }
        return friends;
    }

    private String getUserFriend(String user, List<String> list) throws Exception {
        for (String name : list) {
            if (!(user.equals(name))) {
                return name;
            }
        }
        throw new Exception("친구목록을 확인해주세요.");
    }

    private boolean checkUserFriend(String user, List<String> list) {
        for (String name : list) {
            if (user.equals(name)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private boolean checkMapIfExist(String name) {
        if (algorithmCandidate.containsKey(name)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private void addCandidateIterList(List<String> list, int score) {
        for (String s : list) {
            if (checkMapIfExist(s)) {
                algorithmCandidate.replace(s, algorithmCandidate.get(s), algorithmCandidate.get(s) + score);
            }
            algorithmCandidate.put(s, score);
        }
    }
}
