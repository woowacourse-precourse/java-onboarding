package onboarding;

import java.util.*;

// mrko // donut, shakevan

// donut // andole, jun, mrko // 1
// andole // donut, shakevan // 20
// jun // donut, shakevan // 20
// shakevan // andole, jun, mrko // 1
// bedi // 3

// andole, jun, bedi

// 그러니까 ..이 로직은 친구 추천 알고리즘에 관한 로직이니까
// 이미 친구인 사람에게는 점수를 주지 않는거구나. 이해됐다.
// 친구 목록에 user의 친구와 같은 친구가 있다면 점수에 +10
// visitors는 그냥.. 각 user 점수에 +1 해주면 되는거구
// friends 목록에 없고 visitors에만 있는 user도 있으니까 user 새로 생성해주면 되겠고
// 일단 배열을 받고 위의 표처럼 각 사용자의 친구가 누구인지 정리하는게 좋겠다.
// 그 다음 user의 친구들과 다른 users의 친구들이 같은지 비교하고, 있다면 +10

// todo
// 1. java에서 list는 순서가 보장되므로..하나의 리스트에 여러개의 리스트를 넣고,
//    각 리스트의 첫번째를 각 user의 이름으로 해서 friends 리스트를 정리해보자..
// 1-1. java에서 set은 중복을 허용하지 않으므로 friends와 visitors의 모든 user을 하나의 set에 넣는다.
// 1-2. set의 항목들은 각 user이므로

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = new ArrayList<String>();

        Set<String> userList = new HashSet<String>();

        for (List friend : friends) {
            userList.add((String) friend.get(0));
            userList.add((String) friend.get(1));
        }

        for (String visitor : visitors) {
            userList.add(visitor);
        }

        System.out.println(userList);

//        List<String> testString1 = new ArrayList<String>();
//        testString1.add("abc");
//        testString1.add("abc");
//        List<String> testString2 = new ArrayList<String>();
//        testString2.add("abc");
//        testString2.add("abc");
//        List<List<String>> testString3 = new ArrayList<>();
//        testString3.add(testString1);
//        testString3.add(testString2);
//
//        System.out.println(testString3);

        return answer;
    }
}