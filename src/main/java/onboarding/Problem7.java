package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        if (CheckInput(user,friends,visitors)){
            Map<String, Integer> Friends = new HashMap<>();

            List<String> userFriends = MakeFriendsList(user,friends);
            CountScore(Friends,visitors,friends,userFriends,user);

            return SortRecommend(Friends);
        }throw new IllegalArgumentException("잘못된 입력값");
    }

    /* 기능1 : input 확인 */
    private static boolean CheckInput(String user, List<List<String>> friends, List<String> visitors){
        if(isUserInRange(user) && isFriendsInRange(friends) && isVisitorInRange(visitors))return true;
        return false;
    }
    private static boolean isUserInRange(String user){
        if(user.length() >=1 && user.length()<=30)return true;
        return false;
    }
    private static boolean isFriendsInRange(List<List<String>> friends){
        if(friends.size() >=1 && friends.size()<=10000)return true;
        return false;
    }
    private static boolean isVisitorInRange(List<String> visitors){
        if(visitors.size() >=0 && visitors.size()<=10000)return true;
        return false;
    }

    /* 기능2 : 사용자의 친구 list 생성 */
    private static List<String> MakeFriendsList(String user, List<List<String>> friends){
        List<String> userFriends = new ArrayList<>();
        for(int i=0;i<friends.size();i++){
            String a = friends.get(i).get(0);
            String b = friends.get(i).get(1);
            if(a == user)userFriends.add(b);
            if(b == user)userFriends.add(a);
        }
        return userFriends;
    }

    /* 기능3 : 함께 아는 친구 점수 count */
    private static void FriendOfAFriendCount(List<List<String>> friends, List<String> userFriends,Map<String, Integer> Friends){
        for(int i=0;i<friends.size();i++){
            String a = friends.get(i).get(0);
            String b = friends.get(i).get(1);
            if(userFriends.contains(a))Friends.put(b,Friends.getOrDefault(b,0)+10);
            if(userFriends.contains(b))Friends.put(a,Friends.getOrDefault(a,0)+10);
        }
    }

    /* 기능4 : 방문 횟수 점수 count */
    private static void VisitCount(Map<String, Integer> Friends, List<String> visitors){
        for(int i = 0; i < visitors.size(); i++){
            Friends.put(visitors.get(i),Friends.getOrDefault(visitors.get(i),0)+1);
        }
    }

    /* 기능5 : 사용자와 친구 제외 */
    private static void Exclusion(List<String> userFriends,Map<String, Integer> Friends,String user){
        for(int i= 0; i < userFriends.size(); i++){
            Friends.remove(userFriends.get(i));
        }
        Friends.remove(user);
    }

    /* 기능6 : 총 점수 count */
    private static void CountScore(Map<String, Integer> Friends, List<String> visitors,List<List<String>> friends, List<String> userFriends,String user){
        FriendOfAFriendCount(friends,userFriends,Friends);
        VisitCount(Friends,visitors);
        Exclusion(userFriends,Friends,user);
    }

    /* 기능7 : 추천친구 점수 내림차순 정렬 */
    private static List<String> SortRecommend(Map<String, Integer> Friends){
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(Friends.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return SortName(entryList);
    }

    /* 기능8 : 추천친구 이름 오름차순 정렬 */
    private static List<String> SortName(List<Map.Entry<String, Integer>> entryList){
        List<String> answer = new ArrayList<>();
        for(int i= 0; i<entryList.size(); i++){
            answer.add(entryList.get(i).getKey());
        }return answer;
    }




}
