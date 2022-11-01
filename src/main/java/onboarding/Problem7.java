package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        final int maxNumberOfUsers = 30000;
        //index에 할당한 이름을 저장한 테이블
        String[] userNameArray = new String[maxNumberOfUsers];
        //유저 이름을 키 인덱스를 value로한 Map
        Map<String, Integer> userNameMap = new HashMap<>();
        //친구관계를 저장할 List
        List<List<Integer>> friendsNetwork = new ArrayList<>();
        //유저의 친밀도를 기록할 배열 [0] : 친밀도 [1] : indexNumber
        int[][] intimacyArray = new int[maxNumberOfUsers][2];
        //최종 제출할 추천 친구 이름을 기록할 List
        List<String> recommendedFriends = new ArrayList<>();
    }

    private static int recordFriendNetwork(List<List<String>> friends, String[] userNameListWithIndex,
                                           Map<String, Integer> userNameMap, List<List<Integer>> friendsNetwork) {
        int index = 0;
        for(List<String> relation: friends) {
            String userA = relation.get(0);
            String userB = relation.get(1);

            //이미 유저 정보를 저장했는지 확인하여, 저장안했다면 생성, 생성했다면 index 하나 증가
            index += createUser(userA, userNameListWithIndex, userNameMap, friendsNetwork, index);
            index += createUser(userB, userNameListWithIndex, userNameMap, friendsNetwork, index);

            //둘의 관계를 추가
            int indexOfUserA = userNameMap.get(userA);
            int indexOfUserB = userNameMap.get(userB);
            friendsNetwork.get(indexOfUserA).add(indexOfUserB);
            friendsNetwork.get(indexOfUserB).add(indexOfUserA);
        }

        return index;
    }

    private static int createUser(String user, String[] userNameListWithIndex, Map<String, Integer> userNameSet,
                                  List<List<Integer>> friendsNetwork, int index) {
        if(userNameSet.containsKey(user)) return 0;
        userNameListWithIndex[index] = user;
        userNameSet.put(user, index);
        friendsNetwork.add(new ArrayList<Integer>());
        return 1;
    }

    private static void calculateIntimacyByCommonFriends(int user, List<List<Integer>> friendsNetwork, int[][] intimacyArray) {
        //나의 친구의 친구들에게 10점씩 추가

        //나의 친구들
        List<Integer> friendsOfUser = friendsNetwork.get(user);
        for(Integer friend : friendsOfUser) {
            if(friend == user) continue;
            //나의 친구의 친구들
            List<Integer> friendsOfFriend = friendsNetwork.get(friend);
            for(int friendOfFriend : friendsOfFriend) {
                //이미 친구이면 패스
                if(friendsOfUser.contains(friendOfFriend)) continue;
                //본인이면 패스
                if(friendOfFriend == user) continue;
                intimacyArray[friendOfFriend][0] += 10;
            }
        }
    }
    private static int calculateIntimacyByTimeLineVisits(List<String> visitors, Map<String, Integer> userNameMap,
                                                         String[] userNameArray, int[][] intimacyArray, int index,
                                                         Set<Integer> myFriendsSet) {
        for(String visitor : visitors) {
            int indexOfVisitor;

            if(!userNameMap.containsKey(visitor)) {
                userNameArray[index] = visitor;
                userNameMap.put(visitor, index);
                indexOfVisitor = index;
                index++;
                //이미 친구라면 패스
            } else if(myFriendsSet.contains(userNameMap.get(visitor))){
                continue;
            } else {
                indexOfVisitor = userNameMap.get(visitor);
            }
            intimacyArray[indexOfVisitor][0]++;
        }
        return index;
    }
    private static Set<Integer> makeMyFriendsSet(Integer userIndex, List<List<Integer>> friendsNetwork) {
        if(userIndex == null) {
            return new HashSet<>();
        }
        //내 친구들
        List<Integer> friends = friendsNetwork.get(userIndex);
        return friends.stream().collect(Collectors.toSet());
    }
}
