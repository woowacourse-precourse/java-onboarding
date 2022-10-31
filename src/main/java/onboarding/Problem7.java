package onboarding;

import java.util.*;

public class Problem7 {
    static int idx = 0;
    static List<Person> personList;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        // friends 는 최대 20_000 명
        // 점수가 높은순, 같은경우 이름순

        HashMap<String, Integer> mapping = new HashMap<>(); // name -> index 맵핑
        personList = new ArrayList<>();

        // start
        mapping.put(user, idx++);
        personList.add(new Person(user, 0));

        // 친구관계 연결
        for (List<String> relation : friends) {
            if (!mapping.containsKey(relation.get(0))) {
                mapping.put(relation.get(0), idx++);
                personList.add(new Person(relation.get(0), 0));
            }
            if (!mapping.containsKey(relation.get(1))) {
                mapping.put(relation.get(1), idx++);
                personList.add(new Person(relation.get(1), 0));
            }

            Person p1 = personList.get(mapping.get(relation.get(0)));
            Person p2 = personList.get(mapping.get(relation.get(1)));

            p1.friends.add(p2);
            p2.friends.add(p1);

            if (p1.name.equals(user)) p2.isFriendWithUser = true;
            else if (p2.name.equals(user)) p1.isFriendWithUser = true;
        }

        // 함께 아는 친구의 수 score up
        // user의 친구에 대하여 score up 진행 (단, user 와는 이미 친구x)
        for (Person person : personList.get(0).friends) {
            for (Person _doubleFriend : person.friends) {
                if (!_doubleFriend.isFriendWithUser) {
                    _doubleFriend.score += 10;
                }
            }
        }

        // visitor score up
        for(String name : visitors){
            // friend 는 없지만 방문만 한 경우
            if(!mapping.containsKey(name)){
                mapping.put(name, idx++);
                personList.add(new Person(name, 0));
            }
            Person ptr = personList.get(mapping.get(name));
            ptr.score++;
        }

        // sorting
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                // 점수가 높을수록
                // 같은 경우, 이름순으로
                if(o1.score == o2.score){
                    return o1.name.compareTo(o2.name);
                }else return o2.score - o1.score;
            }
        });

        answer = new ArrayList<>();
        int _cnt = 0;
        for(Person p : personList){
            // user 제외
            if(p.name.equals(user)) continue;
            if(!p.isFriendWithUser && p.score > 0){
                answer.add(p.name);
                _cnt++;
            }

            if(_cnt >= 5) break;
        }
        return answer;
    }

    static class Person {
        String name;
        int score;
        boolean isFriendWithUser;
        List<Person> friends;

        public Person(String name, int score) {
            this.name = name;
            this.score = score;
            this.isFriendWithUser = false;
            friends = new ArrayList<>();
        }

    }
}
