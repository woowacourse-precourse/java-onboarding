package onboarding;
import java.util.*;
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        return Point.calcTotalPotint(user, friends, visitors);
    }
}
class UserInfo{
    private static final int MINIMUM_LENGTH_ID = 1;
    private static final int MAXIMUM_LENGTH_ID = 30;
    private static final String OUT_OF_RANGE = "길이가 1 이상 30 이하의 아이디를 입력해주세요";
    private static final String OUT_OF_SIZE = "길이가 0 이상 10,000 이하인 리스트,배열을 입력해주세요";
    private static final int MIMIMUM_SIZE_VISITOR = 0;
    private static final int MAXIMUM_SIZE_VISITOR = 10000;

    void validateRange(String id){
        if(id.length() < MINIMUM_LENGTH_ID || id.length() > MAXIMUM_LENGTH_ID)
            throw new IllegalArgumentException(OUT_OF_RANGE);
    }
    void validateSizeOfFriends(List<String> visitors){
        if(visitors.size() < MIMIMUM_SIZE_VISITOR || visitors.size() > MAXIMUM_SIZE_VISITOR)
            throw new IllegalArgumentException(OUT_OF_SIZE);
    }
}
class Point{
    static List<String> calcTotalPotint(String user, List<List<String>> friends,List<String> visitors) {
        int[] scoreTable = new int[friends.size()];
        boolean[][] friendsInfoTable = getFriendsInfoTable(friends, visitors);
        Object[] arrayFriends = countFriends(friends,visitors);
        int userIndex = getUserIndex(user, arrayFriends);

        getFriendsPoint(scoreTable, friendsInfoTable, userIndex);
        getVisitorsPoint(visitors, scoreTable, friendsInfoTable, arrayFriends, userIndex);
        List<String> answer = getTopFiveList(scoreTable, arrayFriends, userIndex);

        return answer;
    }

    private static List<String> getTopFiveList(int[] scoreTable, Object[] arrayFriends, int userIndex) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int maxIndex = findIndexByMaxValue(scoreTable, userIndex);
            // 점수가 0인 경우
            if(maxIndex == -1) continue;
            // user를 지칭한 경우 친구에서 제외
            if(maxIndex == userIndex) continue;
//            maxIndex의 사람 이름을 answer에 삽입
            answer.add(arrayFriends[maxIndex].toString());
            setValueToZeroIndexValue(scoreTable,maxIndex);
        }
        return answer;
    }

    private static void getVisitorsPoint(List<String> visitors, int[] scoreTable, boolean[][] friendsInfoTable, Object[] arrayFriends, int userIndex) {
        for (int i = 0; i < visitors.size(); i++) {
            int friendsIndex = getFriendIndex(visitors.get(i), arrayFriends);
            if( !friendsInfoTable[userIndex][friendsIndex] )
                scoreTable[friendsIndex] += 1;
        }
    }

    private static void getFriendsPoint(int[] scoreTable, boolean[][] friendsInfoTable, int userIndex) {
        for (int i = 0; i < friendsInfoTable.length; i++) {
            for (int j = 0; j < friendsInfoTable.length; j++) {
                if(friendsInfoTable[userIndex][i] && friendsInfoTable[i][j]) {
                    scoreTable[j] += 10;
                }
            }
        }
    }

    private static int findIndexByMaxValue(int[] arr,int userIndex) {
        // 최대값, 최대값의 인덱스 초기값 세팅
        int max = arr[0];
        int maxIndex = 0;
        // 최대값, 최대값의 인덱스 구하기
        for (int i = 0; i < arr.length; i++) {
            if(i == userIndex) continue;
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        if(max == 0) return -1;
        return maxIndex;
    }
    private static void setValueToZeroIndexValue(int[] scoreTable, int index) {
        scoreTable[index] = 0;
    }
    private static int getFriendIndex(String s,Object[] friendsInfoTable) {
        for (int i = 0; i < friendsInfoTable.length; i++) {
            if(friendsInfoTable[i] == s)
                return i;
        }
        return 0;
    }
    private static int getUserIndex(String user, Object[] friendsInfoTable) {
        for (int i = 0; i < friendsInfoTable.length; i++) {
            if(friendsInfoTable[i].equals(user)){
                return i;
            }
        }
        return -1;
    }
    private static Object[] countFriends(List<List<String>> friends,List<String> visitors) {
        HashSet<String> countFriendsSet = new HashSet<>();
        for (List<String> emailObject : friends) {
            countFriendsSet.add(emailObject.get(0));
            countFriendsSet.add(emailObject.get(1));
        }
        for(String visit : visitors)
            countFriendsSet.add(visit);
        return countFriendsSet.toArray();
    }
        private static boolean[][] getFriendsInfoTable(List<List<String>> friends,List<String> visitors) {
            boolean[][] arr = new boolean[friends.size()][friends.size()];
            Object[] objects = countFriends(friends,visitors);
            for (List<String> emailObject : friends) {
                String baseUser = emailObject.get(0);
                String matchFriends = emailObject.get(1);
                int baseIndex = -1;
                int matchIndex = -1;
                for (int i = 0; i < objects.length; i++) {
                    if (objects[i].equals(baseUser)) {
                        baseIndex = i;
                    }
                    else if (objects[i].equals(matchFriends)) {
                        matchIndex = i;
                    }
                    if (baseIndex != -1 && matchIndex != -1) {
                        arr[baseIndex][matchIndex] = true;
                        arr[matchIndex][baseIndex] = true;
                    }
                }
            }
        return arr;
        }
    }