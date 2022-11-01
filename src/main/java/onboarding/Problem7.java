package onboarding;

import java.util.*;

public class Problem7 {
    // 사용자 정보를 나타내기 위한 클래스
    // name: 사용자명
    // friends: 사용자의 친구 목록
    // score: 해당 사용자의 입력 user에 대한 친구 추천 점수
    private static class Person implements Comparable<Person> {
        String name;
        Set<String> friends;
        int score;

        public Person(String name) {
            this.name = name;
            this.friends = new HashSet<>();
            this.score = 0;
        }

        // 점수에 대해서 내림차순, 점수가 같다면 이름에 대해서 오름차순 정렬
        @Override
        public int compareTo(Person o) {
            if(this.score == o.score) {
                return this.name.compareTo(o.name);
            } else {
                return o.score - this.score;
            }
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // other: 다른 사용자
        Person other;
        // people: 조건에 따라 정렬된 사용자 리스트
        List<Person> people;
        // myFriends: 입력으로 받은 user의 친구 목록
        // myFriendsCopy: Set의 retainAll 함수 사용을 위해 user의 친구 목록을 복제한 것
        Set<String> myFriends, myFriendsCopy;
        // infos: 사용자들의 정보를 저장한 맵
        Map<String, Person> infos;

        infos = new HashMap<>();
        for(List<String> friend: friends) {
            // 해당 사용자가 infos에 없다면 추가
            for(String name: friend) {
                if(!infos.containsKey(name))
                    infos.put(name, new Person(name));
            }

            // 친구 목록에 상대방을 추가
            infos.get(friend.get(0)).friends.add(friend.get(1));
            infos.get(friend.get(1)).friends.add(friend.get(0));
        }


        myFriends = infos.get(user).friends;
        for(String key: infos.keySet()) {
            // 입력으로 받은 user 본인은 친구 추천 목록에 필요없으므로 삭제
            if(key.equals(user)) {
                infos.remove(user);
                continue;
            }

            other = infos.get(key);
            // 내 친구 목록과 상대방의 친구 목록의 교집합을 구함
            myFriendsCopy = new HashSet<>(myFriends);
            myFriendsCopy.retainAll(other.friends);
            // 일치하는 친구 수 * 10만큼 점수를 추가
            other.score += myFriendsCopy.size() * 10;
        }

        // 타임라인 방문마다 +1점
        for(String name: visitors) {
            if(!infos.containsKey(name))
                infos.put(name, new Person(name));
            infos.get(name).score++;
        }

        // Map의 values를 리스트로 변경하고 조건에 따라 정렬
        people = new ArrayList<>(infos.values());
        Collections.sort(people);

        // 이미 친구인 사용자를 제외하고 친구 추천 목록이 5명이 될 때까지 결과에 추가
        answer = new ArrayList<>();
        for(Person person: people) {
            if(myFriends.contains(person.name))
                continue;

            answer.add(person.name);

            if(answer.size() == 5)
                break;
        }

        return answer;
    }
}
