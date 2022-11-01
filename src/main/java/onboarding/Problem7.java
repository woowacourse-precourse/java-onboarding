package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        return answer;
    }
    // 점수 계산기
    public static HashMap<String, Integer> scoreCal(List<String> justList, int score) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        for (int i = 0; i < justList.size(); i++) {
            Integer count = result.get(justList.get(i));
            if (count == null) result.put(justList.get(i), score);
            else result.put(justList.get(i), count + score);
        }
        return result;
    }
    //user의 친구 구하기
    public static Set<String> trueFriends(String user, List<List<String>> friends) {
        Set<String> result = new HashSet<String>();
        for (int i = 0; i < friends.size(); i++) {

            if (user.equals(friends.get(i).get(0))) {
                result.add(friends.get(i).get(1));
            }
            if (user.equals(friends.get(i).get(1))) {
                result.add(friends.get(i).get(0));
            }
        }
        System.out.println(result);
        return result;
    }

    //friends 중 함께 아는 친구 구하고 +10 계산하기
    public static HashMap<String, Integer> featuredFriends(String user,List<List<String>>friends, Set<String>trueFriends){
        String[] trueList = trueFriends.toArray(new String[trueFriends.size()]);
        List<String> friendsAndNot = new ArrayList<String>();

        //user가 들어간 list 제외하고, 친구가 포함된 list만 저장
        for(List<String>friend : friends){
            if(user.equals(friend.get(0)) || user.equals(friend.get(1))) continue;
            else for(int i=0; i<trueList.length; i++){
                if(trueList[i].equals(friend.get(0))){
                    friendsAndNot.add(friend.get(1));
                } else if(trueList[i].equals(friend.get(1))){
                    friendsAndNot.add(friend.get(0));
                }
            }
        }

        //점수 계산하기
        List<String> trueFriendList = new ArrayList<>(trueFriends);
        // 방문자 리스트 중 친구 제외
        List<String> recommendList = new ArrayList<>();
        recommendList.addAll(friendsAndNot);
        recommendList.removeAll(trueFriendList);
        HashMap<String, Integer> result = scoreCal(recommendList, 10);
        return result;
    }
    //방문자 목록 정리, +1계산
    public static HashMap<String, Integer> visitorsPeople(List<String> visitors, Set<String> trueFriends) {
        List<String> trueFriendList = new ArrayList<>(trueFriends);
        // 방문자 리스트 중 친구 제외
        List<String> visitorsList = new ArrayList<>();
        visitorsList.addAll(visitors);
        visitorsList.removeAll(trueFriendList);
        HashMap<String, Integer> result = scoreCal(visitorsList, 1);
        return result;
    }
}
