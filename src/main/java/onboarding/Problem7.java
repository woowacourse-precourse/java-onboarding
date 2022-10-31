package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/*
 * 여기서 친구 사이를 알아 놓는다
 * 친구가 아닌 사람을 배열에 모아 놓는다
 * 그 사람들의 점수를 know_with_user_score 함수에 넣어서 점수 알아오고
 * visitor 점수를 알기 위해 visitor_score 함수에 넣고 온다
 */

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        // 유저 기준 사람들 목록과 점수 저장 해쉬맵
        Map<String, Integer> score_board = get_people_name_and_point(friends);
        score_board.remove(user);
//        System.out.println("점수판 : " + score_board);

        // 내 친구
        List<String> my_friend = get_my_friend(user, friends);
//        System.out.println("내 친구들 : " + my_friend);

        //내 친구의 친구들 모음(유저 제외)
        Map<String, List<String>> my_friend_friend = new HashMap<>();
        for(String s : my_friend){
            my_friend_friend.put(s, get_my_friend_relation(user, s, friends));
        }
//        System.out.println("친구의 친구들 모음 : " + my_friend_friend);

        //모르는 사람 리스트
        List<String> get_dont_know_friend = new ArrayList<>(score_board.keySet());
        for(String s : my_friend){
            get_dont_know_friend.remove(s);
        }
//        System.out.println("모르는 친구들 : " + get_dont_know_friend);

        get_score_board(visitors, score_board, my_friend_friend, get_dont_know_friend);

        return get_result(score_board, my_friend);
    }

    private static void get_score_board(List<String> visitors, Map<String, Integer> score_board, Map<String, List<String>> my_friend_friend, List<String> get_dont_know_friend) {
        // 친구의 친구에게 점수를 +10 해줌
        my_friend_friend.values().stream().flatMap(Collection::stream).
                filter(get_dont_know_friend::contains).forEach(s2 -> score_board.put(s2, score_board.get(s2) + 10));
//        System.out.println("+10점 해준 점수판 : " + score_board);

        // 방문자 점수 더 해줌
        visitors.forEach(visitor -> {
            if (!score_board.containsKey(visitor)) {
                score_board.put(visitor, 0);
            }
            score_board.put(visitor, score_board.get(visitor) + 1);
        });
//        System.out.println("최종 점수판 : " + score_board);
    }

    private static List<String> get_result(Map<String, Integer> score_board, List<String> my_friend) {
        //1차 - 친구 삭제
        my_friend.forEach(score_board.keySet()::remove);
//        System.out.println("친구 삭제한 1차 수정본 : " + score_board);

        //2차 - 점수로 먼저 정렬, 같으면 이름 순으로 정렬
        List<Map.Entry<String, Integer>> entry_list = new LinkedList<>(score_board.entrySet());
        entry_list.sort(((o1, o2) -> {
            if(o1.getValue().equals(o2.getValue())) {
                // 같은 점수일 때 정렬
                return o1.getKey().compareTo(o2.getKey());
            }
            return Integer.compare(o2.getValue(), o1.getValue());
        }));
//        System.out.println("정렬 끝 entry_list: " + entry_list);
        //3차 - 5명 컷
        List<String> result = new ArrayList<>();
        int cnt = 0;

        for(Map.Entry<String, Integer> entry : entry_list){
            // 5명이 채워지면 멈추기
            if (entry.getValue() == 0 || cnt == 5) break;
            result.add(entry.getKey());
            cnt++;
        }
        return result;
    }

    private static List<String> get_my_friend_relation(String user, String friend, List<List<String>> friends) {
        List<String> friends_friend_list = new ArrayList<>();

        for(List<String> relation_list: friends){
            for(String people_name : relation_list){
                if(!relation_list.contains(user) && relation_list.contains(friend)){
                    friends_friend_list.add(people_name);
                    friends_friend_list.remove(friend);
                }
            }
        }
        return friends_friend_list;
    }
    //내 친구만 들어있는 배열 만들어주는 메서드
    private static List<String> get_my_friend(String user, List<List<String>> friends) {
        List<String> my_friend = new ArrayList<>(30);
        //내 친구들 구함
        for(List<String> relation_list : friends){
            for (String friend : relation_list){
                if (relation_list.contains(user)) my_friend.add(friend); //내 친구다 싶으면
                my_friend.remove(user);
            }
        }
        return my_friend;
    }

    //사람들 이름과 점수판을 만들어주는 메서드
    private static Map<String, Integer> get_people_name_and_point(List<List<String>> friends) {
        //사람들 이름 모아놓을 곳
        List<String> people_name = new ArrayList<>();

        for (List<String> friend : friends) {
            people_name.add(friend.get(0));
            people_name.add(friend.get(1));
        }
        //모든 사람들 이름이 들어있는 배열
        List<String> people = people_name.stream().distinct().collect(Collectors.toList());
        //점수판
        Map<String, Integer> score_board = new HashMap<>(30); // 점수 저장
        //점수판 초기화
        for(String s : people){
            score_board.put(s, 0);
        }
        return score_board;
    }
}
