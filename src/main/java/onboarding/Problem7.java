package onboarding;

import java.util.List;

// <기능 목록>
// 0. class person (String name, int score)
// 1. 추천 목록 만들기
//  a. 유저 친구 목록
//  b. 추천 점수 목록
//  c. 추천 점수 목록에서 user와 userFreinds 삭제
//  d 추천 점수 목록 PersonArray로 변환
// 2. 추천 목록 정렬하기

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        // 1. 추천 목록 만들기
        Person[] recommendList = makeRecommendList(user, friends, visitors);

        return answer;
    }


    // 1. 추천 목록 만들기
    public static Person[] makeRecommendList(String user, List<List<String>> friends,
                                             List<String> visitors) {

        // 1-a. 유저 친구 목록
        String[] userFriend = userFriendList(user, friends);

        // 1-b. 추천 점수 목록
        Map<String, Integer> recommendScoreMap = recommendScoreList(user, friends, visitors);

        // 1-c. 추천 점수 목록에서 user와 userFreinds 삭제
        recommendScoreMap = removeUserAndUserFriends(user, userFriend, recommendScoreMap);

        // 1-d. 추천 점수 목록을 PersonArray로 변환
        Person[] recommendPersonArray = hashMapToPersonArray(recommendScoreMap);

        return recommendPersonArray;
    }

    // 1-a. 유저 친구 목록
    public static String[] userFriendList(String user, List<List<String>> friends) {
        HashSet<String> userFriendHSet = new HashSet<>();
        String[] userFriendArray;

        // 중복 방지
        for (int i = 0; i < friends.size(); i++) {
            if (user.equals(friends.get(i).get(0))) {
                userFriendHSet.add(friends.get(i).get(1));
            } else if (user.equals(friends.get(i).get(1))) {
                userFriendHSet.add(friends.get(i).get(0));
            }
        }

        userFriendArray = new String[userFriendHSet.size()];
        Iterator<String> iter = userFriendHSet.iterator();
        for (int i = 0; i < userFriendHSet.size(); i++) {
            userFriendArray[i] = iter.next();
        }

        return userFriendArray;
    }

    // 1-b. 추천 점수 목록
    public static Map<String, Integer> recommendScoreList(String user, List<List<String>> friends,
                                                          List<String> visitors) {
        Map<String, Integer> recommendHMap = new HashMap<String, Integer>();

        for (int i = 0; i < friends.size(); i++) {
            String f0 = friends.get(i).get(0);
            if (recommendHMap.containsKey(f0)) {
                int fScore = recommendHMap.get(f0);
                recommendHMap.put(f0, fScore + 10);
            } else {
                recommendHMap.put(f0, 10);
            }

            String f1 = friends.get(i).get(1);
            if (recommendHMap.containsKey(f1)) {
                Integer fScore = recommendHMap.get(f1);
                recommendHMap.put(f1, fScore + 10);
            } else {
                recommendHMap.put(f1, 10);
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            String v = visitors.get(i);
            if (recommendHMap.containsKey(v)) {
                Integer vScore = recommendHMap.get(v);
                recommendHMap.put(v, vScore + 1);
            } else {
                recommendHMap.put(v, 1);
            }
        }

        return recommendHMap;
    }

    // 1-c. 추천 점수 목록에서 user와 userFreinds 삭제
    static public Map<String, Integer> removeUserAndUserFriends(String user, String[] userFriend,
                                                                Map<String, Integer> recommends) {
        for (int i = 0; i < userFriend.length; i++) {
            recommends.remove(userFriend[i]);
        }
        recommends.remove(user);
        return recommends;
    }

    // 1-d. 추천 점수 목록 PersonArray로 변환
    static public Person[] hashMapToPersonArray(Map<String, Integer> hMap) {
        Person[] persons = new Person[hMap.size()];
        int i = 0;
        for (String key : hMap.keySet()) {
            persons[i] = new Person(key, hMap.get(key));
            i++;
        }
        return persons;
    }

    // 0. class Person (String name, int score)
    public static class Person implements Comparable<Person> {
        String name;
        int score;

        Person(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public int compareTo(Person o) {
            // score는 내림차순, name은 오름차순
            if (this.score < o.score) {
                return 1;
            } else if (this.score == o.score) {
                return this.name.compareTo(o.name);
            } else {
                return -1;
            }

        }
    }
}
