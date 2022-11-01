package onboarding;

import java.util.*;
import java.util.Collection;

public class Problem7 {
    // 1. 친구 목록 만들기
    // 2. 친구의 친구 목록만들기 -> 추천친구에 무조건추가 +10
    // 3. 방문자 확인하기 -> 친구만아니면 추천친구에 추가하기 +1
    // 4. 정렬하기


    // 추천 친구목록에는 친구의친구만 추가되어있음
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        if(!constraints(user,friends,visitors)) return Collections.EMPTY_LIST;
        Map<String, Integer> list = visitorCalculate(user, friends, visitors);
        if(list.isEmpty()) return Collections.EMPTY_LIST; // 만약 동일한 친구관계가 중복 혹은 추천할 친구가 없으면 빈 리스트를 반환
        List<String> answer = new ArrayList<>(list.keySet());

        answer.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return list.get(o2).compareTo(list.get(o1));
            }
        });


        if(answer.size()>5) {
            for (int i = answer.size() - 1; i > 4; i--) {
                answer.remove(i);
            }
        }

        return answer;
    }



    public static Set friendsList(String user, List<List<String>> friends){
        // 친구목록만들기
        //  1번 값이 mrko면 0번값을 친구목록에 저장
        Set friendsSet = new HashSet();
        for (int i =0; i<friends.size();i++){
            String left = friends.get(i).get(0);
            String right = friends.get(i).get(1);
            if(left.equals(right)){return Collections.EMPTY_SET;} // 동일한 친구 관계가 중복해서 주어지면 빈 set을 리턴
            if(right.equals(user))friendsSet.add(left);
        }
        return friendsSet;

    }
    public static boolean constraints(String user,List<List<String>> friends,  List<String> visitors) { // 제한사항
        if (user.length() < 1 || user.length() > 30) {
            System.out.println("user의 길이가 1미만 혹은 30초과 입니다.");
            return false;
        }
        if (friends.size() < 1 || friends.size() > 10000) {
            System.out.println("friends의 길이가 1미만 혹은 10000초과 입니다.");
            return false;
        }
        if (visitors.size() < 1 || visitors.size() > 10000) {
            System.out.println("visitors의 길이가 1미만 혹은 10000초과 입니다.");
            return false;
        }
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).size() != 2) {
                System.out.println("friends의 원소의 길이가 2가 아닙니다.");
                return false;
            }
            if (friends.get(i).get(0).length() < 1 || friends.get(i).get(0).length() > 30 || friends.get(i).get(1).length() < 1 || friends.get(i).get(1).length() > 30) {
                System.out.println("아이디의 길이가 올바르지 않습니다");
                return false;
            }

        }
        for (int i = 0; i < user.length(); i++) {
            int num = Integer.valueOf(user.charAt(i));
            if (num > 64 && num < 91) { // 대문자 아스키 코드 A ~Z : 65~91
                System.out.println("대문자가 포함되어있습니다");
                return false;
            }
        }
        return true;
    }

    public static Map friendsfriendsList(Set friendsSet, String user, List<List<String>> friends){
        // 받아온 친구목록이랑 0번값이 친구면 친구의친구 -> 추천친구에 무조건 추가 +10
        Map<String, Integer> recommendedFriend = new HashMap<>();
        for (int i =0; i<friends.size();i++){
            String left = friends.get(i).get(0);
            String right = friends.get(i).get(1);
            if(!friendsSet.add(left) && !right.equals(user))recommendedFriend.put(right, recommendedFriend.getOrDefault(right,0)+10);
        }
        return recommendedFriend;
    }
    public static Map visitorCalculate(String user, List<List<String>> friends, List<String> visitors){
        // 친구목록이랑 방문자 친구 비교해서 친구 아니면 추천친구에 +1
        Set friendsSet = friendsList(user,friends);
        if(friendsSet.isEmpty()) return Collections.EMPTY_MAP;
        Map<String, Integer> recommendedFriend = friendsfriendsList(friendsSet,user,friends);
        for(String s :visitors){ // 방문자의 수 체크하기
            if(!friendsSet.add(s)) { // 이미 친구 추천에 있는경우 방문했으니 +1
                if(recommendedFriend.containsKey(s))recommendedFriend.put(s,recommendedFriend.getOrDefault(s,0)+1);
            }
            else{ // visitors와 친구리스트를 비교해서 친구 아니면 +1
                recommendedFriend.put(s,recommendedFriend.getOrDefault(s,0)+1);}
        }
        return recommendedFriend;

    }}




