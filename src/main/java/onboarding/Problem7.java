package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    final static int LEFT_FRIEND = 0;
    final static int RIGHT_FRIEND = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        System.out.println("user = " + user);

        // user와 친구가 아닌것을 걸러야된다.
        ArrayList<String> notFriendUserList = new ArrayList<>();
        ArrayList<String> friendUserList = new ArrayList<>();
        ArrayList<String> personList = new ArrayList<>();
        ArrayList<String> allFriendsVisitors = new ArrayList<>();
        ArrayList<String> notFriendAndVisitorUserList = new ArrayList<>();


        List<String> listAtNow = null;
        String leftFriendsInList = "";
        String rightFriendsInList = "";
        String namePersonAtNow = "";

        int endFistSize = friends.size();
        int endSecondSize = friends.get(0).size();
        for (int firstListIndex = 0; firstListIndex < endFistSize; firstListIndex++) {
            // friends 리스트 안의 리스트 작업
            listAtNow = friends.get(firstListIndex);

            leftFriendsInList = listAtNow.get(LEFT_FRIEND);
            rightFriendsInList = listAtNow.get(RIGHT_FRIEND);

            // user의 친구면? FriendUserListdp 넣는다.
            if (Objects.equals(user, leftFriendsInList)) {
                friendUserList.add(rightFriendsInList);
            }
            if (Objects.equals(user, rightFriendsInList)) {
                friendUserList.add(leftFriendsInList);
            }
            personList.add(leftFriendsInList);
            personList.add(rightFriendsInList);
        }

        personList = (ArrayList<String>) personList.stream().distinct().collect(Collectors.toList());
        System.out.println("personList.toString() = " + personList.toString());

        friendUserList = (ArrayList<String>) friendUserList.stream().distinct().collect(Collectors.toList());
        System.out.println("friendUserList.toString() = " + friendUserList.toString());

        // 친구가 아닌 리스트를 만든다.
        boolean isFriend = true;
        int endPersonList = personList.size();
        for (int personIndex = 0; personIndex < endPersonList; personIndex++) {
            isFriend = false;
            namePersonAtNow = personList.get(personIndex);

            // 현재 사람이 친구인지 판별
            for (int friendUserIndex = 0; friendUserIndex < friendUserList.size(); friendUserIndex++) {
                String nameFriendUserAtNow = friendUserList.get(friendUserIndex);
                if (namePersonAtNow.equals(nameFriendUserAtNow)) {
                    isFriend = true;
                }
            }
            if (!isFriend && !user.equals(namePersonAtNow)) {
                notFriendUserList.add(namePersonAtNow);
            }
        }

        notFriendUserList = (ArrayList<String>) notFriendUserList.stream().distinct().collect(Collectors.toList());
        System.out.println("notFriendUserList.toString() = " + notFriendUserList.toString());

        // personList, friendUserList, notFriendUserList 구현 완료
        System.out.println("visitors = " + visitors);

        // notFriendUserList의 우선순위를 가진 map을 구현
        Map<String, Integer> priorityNotFriendMap = new HashMap<>();
        int endNotFriendSize = notFriendUserList.size();
        for (int notFriendUserIndex = 0; notFriendUserIndex < endNotFriendSize; notFriendUserIndex++) {
            String nameNotFriend = notFriendUserList.get(notFriendUserIndex);
            priorityNotFriendMap.put(nameNotFriend, 10);
        }

        System.out.println();
        System.out.println("priorityNotFriendMap의 키 값");
        for (Map.Entry<String, Integer> entry : priorityNotFriendMap.entrySet()) {
            System.out.println("[key]:" + entry.getKey() + ", [value]:" + entry.getValue());
        }

        // User의 친구와 User의 친구가 아닌것과 Visitor의 전체 배열 연관된 모든사람 List만듬
        int endPersonListVisitors = personList.size() + visitors.size();
        allFriendsVisitors.addAll(personList);

        int endVisitor = visitors.size();
        for (int visitorIndex = 0; visitorIndex < endVisitor; visitorIndex++) {
            String nameVisitor = visitors.get(visitorIndex);
            allFriendsVisitors.add(nameVisitor);
        }

        allFriendsVisitors = (ArrayList<String>) allFriendsVisitors.stream().distinct().collect(Collectors.toList());
        System.out.println("allFriendsVisitors.toString() = " + allFriendsVisitors.toString());

        // visitor들의 방문횟수를 가져왔다.
        Map<String, Integer> cntVisitorMap = new HashMap<>();
        for (String nameVisitor : visitors) {
            cntVisitorMap.put(nameVisitor, 0);
        }
        for (String nameVisitor : visitors) {
            if (cntVisitorMap.containsKey(nameVisitor)) {
                int numBeforValue = cntVisitorMap.get(nameVisitor);
                cntVisitorMap.put(nameVisitor, numBeforValue + 1);
            }
        }
        System.out.println();
        System.out.println("cntVisitorMap의 키 값");
        for (Map.Entry<String, Integer> entry : cntVisitorMap.entrySet()) {
            System.out.println("[key]:" + entry.getKey() + ", [value]:" + entry.getValue());
        }

        // 친구가 아닌 visitor들의 방문횟수를 가져왔다.
        Map<String, Integer> cntNotFrendsVisitorMap = new HashMap<>();
        int endFriendUserList = friendUserList.size();
        for (Map.Entry<String, Integer> entry : cntVisitorMap.entrySet()) {
            isFriend = false;
            String nameVisitor = entry.getKey();
            int cntPriorityVisitor = entry.getValue();

            for (int FriendIndex = 0; FriendIndex < endFriendUserList; FriendIndex++) {
                String nameFriendUserAtNow = friendUserList.get(FriendIndex);
                if (nameVisitor.equals(nameFriendUserAtNow)) {
                    isFriend = true;
                }
            }
            if (!isFriend) {
                cntNotFrendsVisitorMap.put(nameVisitor, cntPriorityVisitor);
            }
        }
        System.out.println();
        System.out.println("cntNotFrendsVisitorMap의 키 값");
        for (Map.Entry<String, Integer> entry : cntNotFrendsVisitorMap.entrySet()) {
            System.out.println("[key]:" + entry.getKey() + ", [value]:" + entry.getValue());
        }

        // 이제 전체적  priorityNotFriendMap과 cntVisitorMap의 값을 합쳐야합니다.
        Map<String, Integer> priorityAllNotFriendMap = new HashMap<>();
        priorityAllNotFriendMap.putAll(priorityNotFriendMap);
        for (Map.Entry<String, Integer> entry : cntNotFrendsVisitorMap.entrySet()) {
            String nameNotFrendsVisitor = entry.getKey();
            int priorityNotFrendsVisitor = entry.getValue();
            priorityAllNotFriendMap.put(nameNotFrendsVisitor, priorityNotFrendsVisitor);
        }

        System.out.println();
        System.out.println("priorityAllNotFriendMap의 키 값");
        for (Map.Entry<String, Integer> entry : priorityAllNotFriendMap.entrySet()) {
            System.out.println("[key]:" + entry.getKey() + ", [value]:" + entry.getValue());
        }


        // 우선순위로 정렬
        List<String> keySet = new ArrayList<>(priorityAllNotFriendMap.keySet());

        // Value 값으로 내림차순 정렬
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (priorityAllNotFriendMap.get(o2) - priorityAllNotFriendMap.get(o1));
            }
        });
        System.out.println();
        List<String> resultList = new ArrayList<>();
        for (String key : keySet) {
            resultList.add(key);
        }
        System.out.println("resultList.toString() = " + resultList.toString());

        answer.addAll(resultList);
        return answer;
    }
}
