package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        /*
        친구 추천 알고리즘 구현
        사용자와 함께 아는 친구의 수 = 10점
        사용자의 타임 라인에 방문한 횟수 1점
        사용자의 아이디 user, 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitor가 매개변수로 주어질 때
        친구 추천 규칙에 따라 점수가 가장 높은순으로 정렬하여 최대 5명을 return 하도록 메서드 구현
        (이미 친구인 경우 친구 추천에 뜨지 않는다!!!!)
        단, 추천 점수가 0이면 추천하지 않으며 추천 점수가 같은 경우 이름순으로 정렬하여 return하기

        제한 조건
        user는 길이가 1이상 30 이하이다. 알파벳 소문자로만 이루어져 있다
        friends의 길이는 1이상 10000 이하인 리스트/배열이다
        friends의 각 원소는 길이가 2인 리스트/배열로 (아이디A, 아이디B) 순으로 들어오는데 A와 B는 친구라는 의미이다
        동일한 친구 관계가 중복해서 주어지지 않는다. 추천할 친구가 없는 경우는 주어지지 않는다.
        visitors는 길이가 0이상 10000이하인 리스트/배열이다
         */

        HashSet<String> users = makeUsers(user, friends, visitors);

        HashMap<String, HashSet<String>> friendsList = makeFriendList(users, friends);



        List<String> answer = new ArrayList<>();

        return answer;
    }
    private static HashSet<String> makeUsers(String user, List<List<String>> friends, List<String> visitors) {
        HashSet<String> users = new HashSet<>();
        //문제에서 제시한 모든 사용자들 묶어주기
        users.add(user);
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                users.add(friends.get(i).get(j));
            }
        }
        for (int i = 0; i < visitors.size(); i++) {
            users.add(visitors.get(i));
        }
        return users;
    }

    private static HashMap<String, HashSet<String>> makeFriendList(HashSet<String> users, List<List<String>> friends) {
        HashMap<String, HashSet<String>> friendsList = new HashMap<>();
        //users를 기반으로 친구관계 파악 Map 만들기
        for (String user : users) {
            //Map 초기화
            friendsList.put(user, new HashSet<>());
        }
        for (String s : friendsList.keySet()) {
            HashSet<String> friend = new HashSet<>();
            for (int i = 0; i < friends.size(); i++) {
                for (int j = 0; j < 2; j++) {
                    if (friends.get(i).get(0) == s) {
                        friend.add(friends.get(i).get(1));
                        friendsList.put(s, friend);
                    } else if (friends.get(i).get(1) == s) {
                        friend.add(friends.get(i).get(0));
                        friendsList.put(s, friend);
                    }
                }
            }
        }
        return friendsList;
    }


}
