package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    // 점수가 높은 순으로 5명을 리턴한다.
    // 점수가 같으면 이름순으로 정렬한다.
    // 0점이면 리턴하지 않는다
    // 함께아는 친구: 10점
    // 타임라인에 방문한 횟수: 1점

    // TODO 전체 유저 닉네임을 반환하는 메서드 -> 중복을 제거한다
    public static List<String> getUsers(String user, List<List<String>> friends, List<String> visitors) {
        List<String> users = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < friends.get(i).size(); j++) {
                users.add(friends.get(i).get(j));
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            users.add(visitors.get(i));
        }
        users = users.stream()
                .distinct()
                .filter(s -> !s.equals(user))
                .sorted().collect(Collectors.toList());

        return users;
    }


    // TODO user와 친구 관계인 유저들을 반환하는 메서드
    public static List<String> userFriends (String user, List<List<String>> friends) {
        List<List<String>> list = new ArrayList<>();
        List<String> friendsOfUser = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) list.add(friends.get(i));
        }

        for (int i = 0; i < list.size(); i++) {
            friendsOfUser.addAll(list.get(i));
        }

        friendsOfUser.removeAll(Arrays.asList(user));
        return friendsOfUser;
    }


    // TODO 뽑은 요소들에서 user와 친구인 유저를 찾는다.
        // 찾은 친구의 리스트에 담겨있는 유저에게 +10
        //  visitors를 돌며 2차원배열에 +1
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userList = getUsers(user, friends, visitors);
        List<String> friendsOfUser = userFriends(user, friends); // 유저의 친구

        List<String> noFriends = new ArrayList<>(); // 유저와 친구가 아닌 유저
        noFriends.addAll(userList);
        noFriends.removeAll(friendsOfUser);


        // 추천친구의 점수를 담을 해시맵
        HashMap<String, Integer> recommendScore = new HashMap<>();
        for (String s : userList){
            recommendScore.put(s, 0);
        }

        for (int i = 0; i < friendsOfUser.size(); i++) {
            String name = friendsOfUser.get(i);
            for (int j = 0; j<recommendScore.size(); j++) {
                if (recommendScore.containsKey(name)) {
                    recommendScore.remove(name);
                }
            }
        }

        List<List<String>> tmp = new ArrayList<>();
        tmp.addAll(friends);
        for (int i = 0; i < tmp.size(); i++) {
            if (tmp.get(i).contains(user)) tmp.remove(i);
        }


        for (int i =0; i < tmp.size(); i++) {
            for (int j =0; j < tmp.get(i).size(); j++) {
                String name = tmp.get(i).get(j);
                if (recommendScore.containsKey(name)) {
                    recommendScore.put(name, recommendScore.get(name)+10);
                }
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            String name = visitors.get(i);
            if (recommendScore.containsKey(name)) {
                recommendScore.put(name, recommendScore.get(name)+1);
            }
        }


        List<Map.Entry<String, Integer>> list = new LinkedList<>(recommendScore.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                }
                else if (o1.getValue() < o2.getValue()) {
                    return 1;
                }

                return o1.getKey().compareTo(o2.getKey());
            }
        });

        if (list.size() > 5) {
            list = list.subList(0,5);
        }


        List<String> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> m : list) {
            answer.add(m.getKey());
        }

        return answer;
    }
}