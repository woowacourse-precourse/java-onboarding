package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 점수판 초기화
        Map<String,Integer> point = new HashMap<>();
        // 유저의 친구 찾기
        List<String> userFriends = findUserFriends(user, friends);
        // 유저의 친구의 친구 찾기
        List<String> sameFriends = findFriends(userFriends, friends, user);
        // 친구의 친구일 경우의 점수 추가
        sameFriendsPoint(point, sameFriends);
        // 방문했을 경우의 점수 추가
        visitPoint(point, visitors);
        // 점수에 따른 친구 정렬
        resultList(userFriends, point);
        // 점수에 따른 친구의 정렬을 최대인원 5명으로 제한
        List<String> answer = maxFriends(resultList(userFriends, point));
        return answer;
    }

    // user의 친구 목록 만들기 메소드
    public static List<String> findUserFriends(String user,List<List<String>> friends){
        List<String> userFriends = new ArrayList<>();
        for(int i=0; i<friends.size(); i++){
            for(int j=0; j<2; j++){
                if(user.equals(friends.get(i).get(j))){
                    int findNumber = j>0?0:1;
                    userFriends.add(friends.get(i).get(findNumber));
                }
                }
            }
        return userFriends;
        }
    // user 친구의 친구들을 찾는 메소드
    public static List<String> findFriends(List<String> userFriends, List<List<String>> friends, String user){
        List<String> sameFriends = new ArrayList<>();
        for(int i=0; i<userFriends.size(); i++){
            for(int j=0; j<friends.size(); j++){
                for(int k=0; k<2; k++){
                    if(userFriends.get(i).equals(friends.get(j).get(k))){
                        int findNumber = k>0?0:1;
                        sameFriends.add(friends.get(j).get(findNumber));
                    }
                }
            }
        }
        while(sameFriends.remove(user)){
            sameFriends.remove(user);
        }
        return  sameFriends;
    }
    // 같은 친구일 경우 점수 추가 메소드
    public static Map<String, Integer>sameFriendsPoint(Map<String, Integer> point, List<String> friendList){
        for(int i=0; i<friendList.size(); i++){
            point.put(friendList.get(i),point.get(friendList.get(i))!=null?point.get(friendList.get(i))+10:10);
        }
        return point;
    }
    // 방문자일 경우 점수 추가 메소드
    public static Map<String, Integer>visitPoint(Map<String, Integer> point, List<String> visitor){
        for(int i=0; i<visitor.size(); i++){
            point.put(visitor.get(i),point.get(visitor.get(i))!=null?point.get(visitor.get(i))+1:1);
        }
        return point;
    }

    // 점수에 따른 리스트 정렬
    public static List<String> resultList(List<String> userFriends, Map<String, Integer> point){
        for(int i=0; i<userFriends.size(); i++){
            point.remove(userFriends.get(i));
        }

        List<String> nameList = new ArrayList<>(point.keySet());

        nameList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(point.get(o1)<point.get(o2)) {
                    return 1;
                }else if(point.get(o1)==point.get(o2)){
                    return o1.substring(0,1).compareTo(o2.substring(0,1));
                }else{
                    return -1;
                }
            }
        });
        
        return nameList;
    }

    // 결과 최대 인원 5명 메소드
    public static List<String> maxFriends(List<String> friends){
        List<String> sub = new ArrayList<>();
        if(friends.size()>5){
            for(int i=0; i<5; i++){
                sub.add(friends.get(i));
            }
            return sub;
        }
        return friends;
    }
    }
