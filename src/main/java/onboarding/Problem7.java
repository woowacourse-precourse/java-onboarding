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

        //친구관계 기록하기
        int totalNumberOfUsers = recordFriendNetwork(friends, userNameArray, userNameMap, friendsNetwork);

        //사용자 함께 아는  친구의 수를 계산하여 친밀도 계산하기
        int userIndex = userNameMap.get(user);
        calculateIntimacyByCommonFriends(userIndex, friendsNetwork, intimacyArray);

        //사용자의 타임라인에 방문한 횟수로 친밀도 계산하기(이미 친구이면 친밀도 안 높이기)
            //user의 친구를 담은 Set만들기
        Set<Integer> myFriendsSet = makeMyFriendsSet(userIndex, friendsNetwork);
        totalNumberOfUsers = calculateIntimacyByTimeLineVisits(visitors, userNameMap, userNameArray, intimacyArray, totalNumberOfUsers, myFriendsSet);

        //총 사용자 수만큼 array에 index기록
        for(int i = 0; i < totalNumberOfUsers; i++) {
            intimacyArray[i][1] = i;
        }
        //총 사용자 수만큼 자르기
        intimacyArray = cutArray(intimacyArray, totalNumberOfUsers);
        //친밀도 순으로 내림차순 정렬
        Arrays.sort(intimacyArray, (o1, o2) -> o2[0] - o1[0]);

        //순위 중복의 경우 처리하면서 필요한 만큼만 배열 자르기
        intimacyArray = trimIntimacyArray(intimacyArray, totalNumberOfUsers);

        //이름까지 포함해서 다시 정렬
        Arrays.sort(intimacyArray, (o1, o2) -> o2[0] == o1[0] ? userNameArray[o1[1]].compareTo(userNameArray[o2[1]]) : o2[0] - o1[0]);

        //상위 5등까지만 친구 이름 기록
        for(int i = 0; i < 5; i++) {
            if(intimacyArray[i][0] == 0) break;
            String friendName = userNameArray[intimacyArray[i][1]];
            recommendedFriends.add(friendName);
        }

        return recommendedFriends;
    }

    private static int[][] cutArray(int[][] arr, int num) {
        if(num < 5) num = 5;
        int[][] newArr = new int[num][2];
        for(int i = 0; i < num; i++) {
            newArr[i][0] = arr[i][0];
            newArr[i][1] = arr[i][1];
        }
        return newArr;
    }
    private static Set<Integer> makeMyFriendsSet(int userIndex, List<List<Integer>> friendsNetwork) {
        //내 친구들
        List<Integer> friends = friendsNetwork.get(userIndex);
        return friends.stream().collect(Collectors.toSet());
    }
    private static int[][] trimIntimacyArray(int[][] intimacyArray, int totalNumberOfUsers) {
        int sameRankIndex = 6;
        int[][] trimmedIntimacyArray;
        //총 5명 초과의 유저가 있을 때
        if(totalNumberOfUsers > 5) {
            //5등과 6등의 점수가 같을 때
            if(intimacyArray[4][0] != 0 && intimacyArray[4][0] == intimacyArray[5][0]) {
                //몇 등까지 같은지 센다.
                while(intimacyArray[sameRankIndex][0] == intimacyArray[sameRankIndex - 1][0]) {
                        sameRankIndex++;
                }
            }
            //sameRankIndex - 1의 인덱스까지 같다.
        } else {
            sameRankIndex = 5;
        }


        trimmedIntimacyArray = cutArray(intimacyArray, sameRankIndex);

        return trimmedIntimacyArray;
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
    private static void calculateIntimacyByCommonFriends(int user, List<List<Integer>> friendsNetwork, int[][] intimacyArray) {
        //나의 친구의 친구들에게 10점씩 추가

        //나의 친구들
        List<Integer> friendsOfUser = friendsNetwork.get(user);
        for(Integer friend : friendsOfUser) {
            if(friend == user) continue;
            //나의 친구의 친구들
            List<Integer> friendsOfFriend = friendsNetwork.get(friend);
            for(int friendOfFriend : friendsOfFriend) {
                if(friendOfFriend == user) continue;
                intimacyArray[friendOfFriend][0] += 10;
            }
        }
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
}
