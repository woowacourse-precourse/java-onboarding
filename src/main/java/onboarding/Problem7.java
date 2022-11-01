package onboarding;

import java.util.*;
public class Problem7 {
    public static List<String> getUserFriends(String user, List<List<String>> friends) {
        List<String> f = new ArrayList<>();

        for (int i = 0 ; i < friends.size(); i++) {
            if (friends.get(i).get(0).equals(user))
                f.add(friends.get(i).get(1));

            if (friends.get(i).get(1).equals(user))
                f.add(friends.get(i).get(0));
        }

        return f;
    }

    public static LinkedHashMap<String, Integer> sortByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (o2, o1) -> o1.getValue().compareTo(o2.getValue()));

        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        // User의 친구 목록 리스트 생성
        List<String> MyFriends = getUserFriends(user, friends);
        Map<String, Integer> people = new HashMap<String, Integer>();

        // user 길이가 1 미만 30 초과하면 예외 처리
        if (user.length() < 1 || user.length() > 30)
            return answer;

        // friends 리스트의 크기가 1 미만 10000 초과하면 예외 처리
        if (friends.size() < 1 || friends.size() > 10000)
            return answer;

        // visitors 리스트의 크기가 0 미만 10000 초과하면 예외 처리
        if (visitors.size() < 0 || visitors.size() > 10000)
            return answer;

        // user의 친구 리스트 에서 각 친구의 친구를 Ffriends에 저장 후
        // Ffriends에서 user를 뺸 나머지 유저를 people HashMap에
        // 함께 아는 친구로 key 값에 이름을 value 값에 10점 씩 저장
        // 이미 해당 사람이 HashMap에 있다면 value에 10을 추가
        for (int i = 0; i < MyFriends.size(); i++) {
            List<String> Ffriends = getUserFriends(MyFriends.get(i), friends);
            for (int j = 0; j < Ffriends.size(); j++) {
                if (!Ffriends.get(j).equals(user)) {
                    if (people.containsKey(Ffriends.get(j)))
                        people.put(Ffriends.get(j), people.get(Ffriends.get(j)) + 10);
                    else
                        people.put(Ffriends.get(j), 10);
                }
            }
        }

        // user의 방문자 리스트에서 이미 친구인 사람은 제외하고
        // 친구가 아닌 사람을 people Hashmap에 빈도 수를 Value 값에 이름을 key 값으로 생성
        for (int i = 0 ; i < visitors.size(); i++) {
            if (!MyFriends.contains(visitors.get(i)))
                people.put(visitors.get(i),Collections.frequency(visitors, visitors.get(i)));
        }

        answer = new ArrayList<>();

        // people HashMap이 비어 있으면 공백 리스트 반환
        if (people.isEmpty())
            answer = Collections.emptyList();

        // people HashMap을 Value 값으로 내림차순 정렬
        Map<String, Integer> result = sortByValue(people);

        // people HashMap을 차례대로 5개 값까지 answer 리스트에 저장
       Collection k = result.keySet();
       Iterator itr = k.iterator();
       int cnt = 5;
       while(itr.hasNext() && cnt > 0) {
           answer.add(itr.next().toString());
           cnt--;
       }

        return answer;
    }
}
