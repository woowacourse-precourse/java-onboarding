package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, People> contacts = new HashMap<>();
        for (List<String> friend : friends) { // 친구 목록 만들기
            String nameA = friend.get(0);
            String nameB = friend.get(1);

            People peopleA = contacts.get(nameA);
            if (contacts.get(nameA)==null) {
                contacts.put(nameA, new People(nameA, nameB));
            } else {
                peopleA.addFriendList(nameB);
                contacts.put(nameA, peopleA);
            }

            People peopleB = contacts.get(nameB);
            if (contacts.get(nameB)==null) {
                contacts.put(nameB, new People(nameB, nameA));
            } else {
                peopleB.addFriendList(nameA);
                contacts.put(nameB, peopleB);
            }
        }
        List<String> userFriends = contacts.get(user).friendList;
        for (String name : contacts.keySet()) {
            People nowPeople = contacts.get(name);
            if (isFriends(name, userFriends) || name.equals(user)) { // user의 친구 목록에 들어있고, 자기 자신이면 continue
                continue;
            }
            int point = duplicateCount(userFriends, contacts.get(name).friendList);
            nowPeople.plusPoint(point*10);
            contacts.put(name, nowPeople);
        }

        for (String visitor : visitors) {
            if (isFriends(visitor, userFriends)) {
                continue;
            }
            People newPeople;
            if (contacts.get(visitor) == null){
                newPeople = new People(visitor);

            } else {
                newPeople = contacts.get(visitor);
            }
            newPeople.plusPoint(1);
            contacts.put(visitor, newPeople);
        }
        List<People> keyList = new ArrayList<>(contacts.values());
        Collections.sort(keyList);

        List<String> answer = new ArrayList<>();
        for (People people : keyList) {
            if (people.point>0 && !people.name.equals(user)){
                answer.add(people.name);
            }
        }
        return answer;
    }

    private static List<String> makeFriendList(String people, List<String> friendList) {
        if (friendList==null) {
            return new ArrayList(Arrays.asList(people));
        }
        friendList.add(people);
        return friendList;
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

        public People(String name, String friend) {
            this.name = name;
            this.addFriendList(friend);
        }

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