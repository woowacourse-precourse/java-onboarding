package onboarding;

import java.util.*;

public class Problem7 {
    static final int DUPLICATE_POINT = 10;
    static final int VISITOR_POINT = 1;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, People> contacts = new HashMap<>();
        contacts.put(user, new People(user));
        for (List<String> friend : friends) { // 친구 목록 만들기
            String nameA = friend.get(0);
            String nameB = friend.get(1);

            People peopleA = contacts.get(nameA);
            People peopleB = contacts.get(nameB);
            contacts.put(nameA, makeFriendList(peopleA, nameA, nameB));
            contacts.put(nameB, makeFriendList(peopleB, nameB, nameA));
        }

        List<String> userFriends = contacts.get(user).friendList;
        for (String name : contacts.keySet()) {
            People nowPeople = contacts.get(name);
            if (isFriends(name, userFriends) || name.equals(user)) { // user의 친구 목록에 들어있고, 자기 자신이면 continue
                continue;
            }
            int point = duplicateCount(userFriends, contacts.get(name).friendList);
            nowPeople.plusPoint(point*DUPLICATE_POINT);
            contacts.put(name, nowPeople);
        }

        for (String visitor : visitors) {
            if (isFriends(visitor, userFriends)) {
                continue;
            }
            People people = findFriend(contacts.get(visitor), visitor);
            people.plusPoint(VISITOR_POINT);
            contacts.put(visitor, people);
        }
        List<People> keyList = new ArrayList<>(contacts.values());
        Collections.sort(keyList);

        List<String> answer = new ArrayList<>();
        for (People people : keyList) {
            if (people.point>0 && !people.name.equals(user)){
                answer.add(people.name);
            }
            if (answer.size()==5) {
                break;
            }
        }
        return answer;
    }

    private static People findFriend(People people, String name) {
        if (people==null) {
            return new People(name);
        }
        return people;
    }

    private static People makeFriendList(People people, String name1, String name2) {
        if (people==null) {
            people = new People(name1);
        }
        people.addFriendList(name2);
        return people;
    }

    private static boolean isFriends(String name, List<String> friendList) {
        return friendList.contains(name);
    }

    private static int duplicateCount(List<String> userFriendList, List<String> otherFriendList) {
        int count = 0;
        for (String name : userFriendList) {
            if (otherFriendList.contains(name)) {
                count+=1;
            }
        }
        return count;
    }

    private static class People implements Comparable<People>{
        String name;
        int point = 0;
        List<String> friendList = new ArrayList<>();

        public People(String name) {
            this.name = name;
        }

        public void plusPoint(int point) {
            this.point += point;
        }

        public void addFriendList(String friend) {
            this.friendList.add(friend);
        }

        @Override
        public int compareTo(People o) {
            if (o.point == this.point) {
                return this.name.compareTo(o.name);
            }
            return o.point-this.point;
        }
    }
}