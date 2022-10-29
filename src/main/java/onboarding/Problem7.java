package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, List<String>> map = new HashMap<>();

        makeMap(user, friends, map);

        List<String> user_friend = new ArrayList<>();
        user_friend = map.get(user);
        Map<String, Integer> friend_score = new HashMap<>(); // (map (이름 : 점수))

        userFriendDelete(map, user_friend); // 사용자 친구는 항목에서 제거 (추천할 필요 없으니)

        friendScorePut(visitors, map, user_friend, friend_score); // friendscore 부분에다가 넣어주기.

        removeNoResult(user, friend_score, visitors,
            user_friend); // 추천친구 목록에 들어가면 안되는 친구 분별하고 제외하는 과정

        List<Integer> listValueSet = new ArrayList<>(friend_score.values());
        List<String> listKeySet = new ArrayList<>(friend_score.keySet());

        sortResult(friend_score, listValueSet,
            listKeySet); // 점수가 같을 경우 알파벳 순으로 출력하기 위한 점수별 내림차순 정렬 과정, 이름도 같이 매칭되게 리스트 분류

        List<String> result = printResult(listValueSet,
            listKeySet);  // 최종적으로 출력하기 위하여서 문제 상황과 최대값이 같을시 알파벳 순으로 출력시키기 위한 과정

        return result;


    }

    private static void userFriendDelete(Map<String, List<String>> map, List<String> user_friend) {
        for (String s : user_friend) {
            map.remove(s);
        }
    }

    private static void makeMap(String user, List<List<String>> friends,
        Map<String, List<String>> map) {
        List<String> user_list = new ArrayList<>();
        user_list.add(user);
        map.put(user, new ArrayList<>());

        for (int i = 0; i < friends.size(); i++) {
            user_list.add(friends.get(i).get(0));
            user_list.add(friends.get(i).get(1));
        } //map(친구: 친구1, 친구2, 친구3) 중 친구 부분을 만들기 위한 과정

        Set<String> set = new HashSet<>(user_list);
        List<String> result = new ArrayList<>(set); // 중복되어있는 친구 이름 중복된 이름 제거

        for (int i = 0; i < result.size(); i++) {
            map.put(result.get(i), new ArrayList<>());
        }

        for (int i = 0; i < friends.size(); i++) {
            String friend1 = friends.get(i).get(0);
            String friend2 = friends.get(i).get(1);

            map.get(friend1).add(friend2);
            map.get(friend2).add(friend1); // 친구1,2,3 추가 (양방향적으로)
        }
    }

    private static void friendScorePut(List<String> visitors, Map<String, List<String>> map,
        List<String> user_friend, Map<String, Integer> friend_score) {
        for (String s : map.keySet()) {
            friend_score.put(s, 0);
        }

        for (String s : visitors) {
            friend_score.put(s, 0);
        }

        for (String s : visitors) {
            int a = friend_score.get(s) + 1;
            friend_score.put(s, a);
        }

        for (String s : map.keySet()) { // friend_score에 넣는 부분
            for (int i = 0; i < user_friend.size(); i++) {
                for (int j = 0; j < map.get(s).size(); j++) {
                    if (user_friend.get(i).equals(map.get(s).get(j))) {
                        int a = friend_score.get(s) + 10;
                        friend_score.put(s, a);
                    }
                }
            }
        }
    }


    private static void removeNoResult(String user, Map<String, Integer> friend_score,
        List<String> visitors, List<String> user_friend) {
        if (friend_score.containsKey(user)) {
            friend_score.remove(user); // 사용자와 친구인 경우 제거
        }
        for (String s : visitors) { // 방문자 제거
            if (user_friend.contains(s)) {
                friend_score.remove(s);
            }
        }

        List<String> removed = new ArrayList<>();

        for (String s : friend_score.keySet()) {
            if (friend_score.get(s) == 0) {
                removed.add(s); //0점인 경우도 제거하기위한 제거리스트
            }
        }

        for (int i = 0; i < removed.size(); i++) {
            friend_score.remove(removed.get(i)); // 0점인 친구들 제거
        }
    }

    private static void sortResult(Map<String, Integer> friend_score, List<Integer> listValueSet,
        List<String> listKeySet) {
        Collections.sort(listKeySet, (value1, value2) -> (friend_score.get(value2)
            .compareTo(friend_score.get(value1)))); // 점수별로 내림차순으로 친구 이름 정렬

        Collections.sort(listValueSet, Collections.reverseOrder()); // 점수 내림차순
    }


    private static List<String> printResult(List<Integer> listValueSet, List<String> listKeySet) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < listKeySet.size(); i++) {
            List<String> comp = new ArrayList<>(); // comp 점수가 같을 경우 알파벳 순으로 출력시킬 수 있도록 분류

            if (result.contains(
                listKeySet.get(i))) { // 점수 동일 여부 확인 후 이미 알파벳 순으로 정렬되고 결과 값으로 들어갈 수도 있는 경우 건너뛰기
                continue;
            }
            comp.add(listKeySet.get(i));
            for (int j = i + 1; j < listKeySet.size(); j++) {
                if (listValueSet.get(i) == listValueSet.get(
                    j)) {   //-> 이거 하는 이유? 그 comp라는게 존재하는 이유가 점수 같을 경우 알파벳순으로 추출할 문자열들을 추가하기 위함.
                    comp.add(listKeySet.get(j));
                }
            }
            Collections.sort(
                comp); // 만약 점수가 같지 않고 고유한 값인 경우 comp에는 값이 1개, 같은 경우 점수가 같은 만큼의 size가 나오게 됨.

            for (int j = 0; j < comp.size();
                j++) { // result에는 comp에서 이미 알파벳 정렬이 끝난 친구와 미리미리 상관없이 넣은 친구들을 위하여 넣음
                if (result.size() < 5) {
                    result.add(comp.get(j));
                }
            }
        }
        return result;
    }

}
