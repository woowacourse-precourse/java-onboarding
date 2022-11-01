package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {


        // 유저의 친구 목록
        List<String> usersFriends = usersFriends(user, friends);

        // 친구 목록을 순회하면서 함께 아는 친구 값 증가
        Map<String, Integer> result = recommendFriends(user, friends, usersFriends);

        // 방문자 값 증가
        result = recommendFriendsVisitor(user , result, usersFriends, visitors);

        // 결과 Map 을 값(내림차순) , 키(오름차순) 순으로 정렬
        LinkedHashMap<String, Integer> sortedResult = sortValueAndKey(result);

        // Map을 순회하며 결과 추출
        List<String> answer = generateAnswer(sortedResult);

        return answer;
    }

    private static List<String> generateAnswer(LinkedHashMap<String, Integer> sortedResult) {

        List<String> answer = new ArrayList<>();

        // 정렬된 결과값을 순회하며 리스트에 값을 넣는다.
        sortedResult.entrySet().stream().forEach((val)->{
            answer.add(val.getKey());
        });

        // 리스트 사이즈가 5 초과시 subList 로 잘라준 리스트를 반환한다.
        if (answer.size() > 5) {
            return  answer.subList(0, 5);
        }

        return answer;
    }

    private static Map<String , Integer> recommendFriendsVisitor(String user , Map<String, Integer> result, List<String> usersFriends, List<String> visitors) {
        // 방문자 리스트를 순회하며 유저가 아니며 , 유저의 친구가 아닌 경우 값 증가
        visitors.stream().forEach((val)->{
            if(!usersFriends.contains(val) && !val.equals(user)){
                if (result.containsKey(val)) {
                    result.put(val, result.get(val) + 1);
                }else{
                    result.put(val, 1);
                }
            }
        });

        return result;
    }

    private static Map<String ,Integer> recommendFriends(String user, List<List<String>> friends , List<String> usersFriends) {
        Map<String, Integer> result = new HashMap<>();

        // 친구 관계를 순회하며 조건에 따라 result에 값을 넣는다.
        friends.stream().forEach((val)->{

            String userA = val.get(0);
            String userB = val.get(1);

            // 유저A 가 유저가 아니고 유저의 친구가 아니며 userB 가 유저의 친구일 때 ( 함께 아는 친구 )
            if(!userA.equals(user) && !usersFriends.contains(userA) &&  usersFriends.contains(userB) ){
                // 함께 아는 친구가 이미 있을 때 값 추가 , 없을 때 생성
                if(result.containsKey(userA)){
                    result.put(userA, result.get(userA) + 10);
                }else {
                    result.put(userA, 10);
                }
            }

            // 유저B 가 유저가 아니고 유저의 친구가 아니며 userB 가 유저의 친구일 때 ( 함께 아는 친구 )
            if(!userB.equals(user) && !usersFriends.contains(userB) && usersFriends.contains(userA)){
                if(result.containsKey(userB)){
                    result.put(userB, result.get(userB) + 10);
                }else {
                    result.put(userB, 10);
                }
            }

        });

        return result;
    }

    private static List<String> usersFriends(String user , List<List<String>> friends) {
        List<String> usersFriends = new ArrayList<>();

        friends.stream().forEach((val) -> {
            String userA = val.get(0);
            String userB = val.get(1);

            if(userA.equals(user)){
                usersFriends.add(userB);
            }

            if (userB.equals(user)) {
                usersFriends.add(userA);
            }
        });

        return usersFriends;
    }

    private static LinkedHashMap<String, Integer> sortValueAndKey(Map<String, Integer> result) {
        // map 자료구조인 result 를 entrySet 으로 순회하며 stream 의 sorted 메서드에 comparator 를 구현하여 정렬
        return result.entrySet().stream()
                .sorted(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> t1, Map.Entry<String, Integer> t2) {
                        // 값이 같을 때 키 값으로 정렬
                        if (t1.getValue() == t2.getValue()) {
                            return t1.getKey().compareTo(t2.getKey());
                        }
                        // 값이 다르다면 역순 정렬
                        return t2.getValue() - t1.getValue();
                    }   // collect 를 통해 map 자료구조를 생성
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public static void main(String[] args) {
        String user = "mrko";
        String [][] friends = {{"donut", "andole"}, {"donut", "jun"}, {"donut", "mrko"}, {"shakevan", "andole"}, {"shakevan", "jun"}, {"shakevan", "mrko"},
                {"abc", "donut"} , {"def", "donut"} , {"aaa", "donut"} , {"zzz", "donut"} , {"vcvc", "donut"},
                {"abc", "shakevan"} , {"def", "shakevan"} , {"aaa", "shakevan"}
        };

        String[] visitor = {"bedi", "bedi", "donut", "bedi", "shakevan"};

        List<List<String>> f = new ArrayList<>();
        Arrays.stream(friends).forEach( (val) -> {
            f.add(List.of(val));
        });

        List<String> v = List.of(visitor);

        solution(user, f, v);

    }
}
