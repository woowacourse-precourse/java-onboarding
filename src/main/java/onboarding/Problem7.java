package onboarding;

import java.util.*;

/**
 * - 큰 틀의 기능구현
 * 1. input 값이 valid 한지 체크하는 기능
 * 2. user와 연결되 있는 friends 목록 생성 기능
 * 3. 2번에서의 친구들의 친구들의 목록 배열 생성 -> 2차원 배열로 10점씩 점수 부여
 * 4. visitors 배열을 확인 후 3번 배열에 추가 -> 1점씩 점수 추가
 * 5. 점수 단위로 sorting
 * 6. 상위 5명 출력 하는 기능
 * **/

/***
 * 1. input 값이 valid 한지 체크하는 기능
 * - user의 길이는 1<= length <= 30 체크 함수
 * - friends 길이가 1 <= length <= 10000 체크 함수
 *   - friends 의 각 원소 길이는 2인 리스트
 * - visitor의 길이는 0 <= length <= 10000 리스트
 * - 사용자 아이디는 알파벳 소문자로만 이루어져 있다.
 * */

/***
 * 2. user와 연결 되 있는 friends 목록 생성 기능
 * - userName을 제외한 친구 이름만 반환 하는 함수
 * - userName이 포함되는지 안되는지 체크하는 함수
 * */

/***
 * 3. 2번에서의 친구들의 친구들의 목록 배열 생성 -> 2차원 배열로 10점씩 점수 부여
 * - User 제외
 * - Hashmap 클래스 변수 생성 -> 중복된 값 자동 업데이트
 *
 * */

/***
 * 4. visitor 배열을 확인 후 3번 배열에 값 추가 -> 1점씩 점수 추가
 * - user 친구들은 제외
 * - 중복된 값  -> 1점 추가
 * - 새로운 값 -> 1점으로 저장
 * */

/***
 * 4. visitor 배열을 확인 후 3번 배열에 값 추가 -> 1점씩 점수 추가
 * - 중복된 값  -> 1점 추가
 * - 새로운 값 -> 1점으로 저장
 * */

/***
 * 5. 점수 단위로 sorting
 * - HashMap valiue기준으로 내림차순 sorting
 * */

/***
 * 6.최대 상위 5명 출력 하는 기능
 * */

public class Problem7 {

    private static List<String> userToFriendList = new ArrayList<>();
    private static HashMap<String, Integer> friendToFriendMap = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = makeResult(friends,visitors,user);
        return answer;
    }
//    public static void main(String[] args) {
//        String user = "mrko";
//        List<List<String>> friends = new ArrayList<>();
//        List<String> friends_in1 = new ArrayList<>();
//        friends_in1.add("donut");
//        friends_in1.add("andole");
//        List<String> friends_in2 = new ArrayList<>();
//        friends_in2.add("donut");
//        friends_in2.add("jun");
//        List<String> friends_in3 = new ArrayList<>();
//        friends_in3.add("donut");
//        friends_in3.add("mrko");
//        List<String> friends_in4 = new ArrayList<>();
//        friends_in4.add("shakevan");
//        friends_in4.add("andole");
//        List<String> friends_in5 = new ArrayList<>();
//        friends_in5.add("shakevan");
//        friends_in5.add("jun");
//        List<String> friends_in6 = new ArrayList<>();
//        friends_in6.add("shakevan");
//        friends_in6.add("mrko");
//        friends.add(friends_in1);
//        friends.add(friends_in2);
//        friends.add(friends_in3);
//        friends.add(friends_in4);
//        friends.add(friends_in5);
//        friends.add(friends_in6);
//        List<String> visitors = new ArrayList<>();
//        visitors.add("bedi");
//        visitors.add("bedi");
//        visitors.add("donut");
//        visitors.add("bedi");
//        visitors.add("shakevan");
//        System.out.println(solution(user, friends, visitors));
//    }

    private static boolean checkUserLower(String inputUser){
        String regLower = "^[a-z]*$";
        if(!inputUser.matches(regLower))
            return false;
        return true;
    }

    private static boolean checkUserSize(String inputUser){
        if(inputUser.length() < 1 || inputUser.length() >30)
            return false;
        return true;
    }

    private static boolean checkUser(String inputUser){
        if(!checkUserSize(inputUser) || !checkUserLower(inputUser))
            return false;
        return true;
    }

    private static boolean checkElementFriends(List<String> inputFriendElement){
        if(inputFriendElement.size() != 2)
            return false;
        return true;
    }

    private static boolean checkFriendSize(List<List<String>> inputFriends){
        if(inputFriends.size() < 1 || inputFriends.size() > 10000)
            return false;
        return true;
    }

    private static boolean checkFriends(List<List<String>> inputFriends){
        if(!checkFriendSize(inputFriends))
            return false;
        for(int i = 0; i < inputFriends.size(); i++){
            if(!checkElementFriends(inputFriends.get(i)) || !checkUser(inputFriends.get(i).get(0)) || !checkUser(inputFriends.get(i).get(1))){
                return false;
            }
        }
        return true;
    }

    private static boolean checkVisitorSize(List<String> inputVisitors){
        if(inputVisitors.size() < 0 || inputVisitors.size() > 10000)
            return false;
        return true;
    }

    private static boolean checkVisitor(List<String> inputVisitors){
        if(!checkVisitorSize(inputVisitors))
            return false;
        for(int i = 0; i < inputVisitors.size(); i++){
            if(!checkUser(inputVisitors.get(i)))
                return false;
        }
        return true;
    }

    private static boolean checkInput(List<List<String>> inputFriends, List<String> inputVisitors, String user)
    {
        if(!checkFriends(inputFriends) || !checkVisitor(inputVisitors) || !checkUser(user))
            return false;
        return true;
    }

    private static boolean checkIncludeFriend(String inputUser, List<String> inputElementFriend){
        for(int i = 0; i < inputElementFriend.size(); i++){
            if(inputElementFriend.get(i).equals(inputUser)){
                return true;
            }
        }
        return false;
    }
    private static String onlyFriendsNameInFriends(String inputUser, List<String> inputElementFriend){
        for(int i = 0; i < inputElementFriend.size(); i++)
        {
            if(!inputElementFriend.get(i).equals(inputUser)){
                return inputElementFriend.get(i);
            }
        }
        return null;
    }

    private static void makeUserToFriendList(List<List<String>> inputFriends, String inputUser){
        for(int i = 0; i < inputFriends.size(); i++){
            if(checkIncludeFriend(inputUser,inputFriends.get(i))){
                userToFriendList.add(onlyFriendsNameInFriends(inputUser,inputFriends.get(i)));
            }
        }
    }

    private static void makeFriendToFriendList(List<List<String>> inputFriends, String originUser){
        for(int i = 0; i < userToFriendList.size(); i++){
            for(int j = 0; j <inputFriends.size(); j++){
                if(checkIncludeFriend(userToFriendList.get(i),inputFriends.get(j)) && !checkIncludeFriend(originUser, inputFriends.get(j)))
                    friendToFriendMap.put(onlyFriendsNameInFriends(userToFriendList.get(i), inputFriends.get(j)), 10);
            }
        }
    }

    private static void addVisitorData(List<String> inputVisitor){
        for(int i = 0; i < inputVisitor.size(); i++){
            if(checkIncludeFriend(inputVisitor.get(i), userToFriendList))
                continue;
            if(friendToFriendMap.containsKey(inputVisitor.get(i)))
                friendToFriendMap.put(inputVisitor.get(i), friendToFriendMap.get(inputVisitor.get(i)) + 1);
            else
                friendToFriendMap.put(inputVisitor.get(i), 1);
        }
    }

    private static List<String> sortFriendToFriendMap(){
        List<String>keySet = new ArrayList<>(friendToFriendMap.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return friendToFriendMap.get(o1).compareTo(friendToFriendMap.get(o2));
            }
        });
        keySet.sort((o1, o2) -> friendToFriendMap.get(o2).compareTo(friendToFriendMap.get(o1)));
        return keySet;
    }

    private static List<String> makeResult(List<List<String>> inputsFriends, List<String> inputVisitors, String inputUser){
        if(!checkInput(inputsFriends,inputVisitors,inputUser))
            return Collections.emptyList();
        List<String> ret = new ArrayList<>();
        List<String> keySet;
        makeUserToFriendList(inputsFriends,inputUser);
        makeFriendToFriendList(inputsFriends,inputUser);
        addVisitorData(inputVisitors);
        keySet = sortFriendToFriendMap();
        for(int i = 0; i < keySet.size(); i++){
            if(i < 5)
                ret.add(keySet.get(i));
        }
        userToFriendList.clear();
        friendToFriendMap.clear();
        return ret;
    }
}
