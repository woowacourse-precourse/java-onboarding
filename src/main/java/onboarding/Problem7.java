package onboarding;

import java.util.*;

public class Problem7 {
    public static boolean[][] isFriend(List<List<String>> friends,int userSize,String user,HashMap<String , Integer> score){
        int pplCnt = 0;
        HashMap<String , Integer> pplNumber = new HashMap<>();
        List<String> myFriends = new ArrayList<>();
        boolean[][] friendArr = new boolean[userSize][userSize];
        for(int i=0;i<friends.size();i++){
            List<String> tmp = friends.get(i);
            String friend1 = tmp.get(0);
            String friend2 = tmp.get(1);
            if(!pplNumber.containsKey(friend1)){
                pplNumber.put(friend1,++pplCnt);
            }
            if(!pplNumber.containsKey(friend2)){
                pplNumber.put(friend2,++pplCnt);
            }
            friendArr[pplNumber.get(friend1)][pplNumber.get(friend2)]=true;
            friendArr[pplNumber.get(friend2)][pplNumber.get(friend1)]=true;
            if(friend1.equals(user)){
                myFriends.add(friend2);
            }else if(friend2.equals(user)){
                myFriends.add(friend1);
            }
        }
        for(int i=0;i<myFriends.size();i++){
            int myFriendsNum = pplNumber.get(myFriends.get(i));
            for(int j=0;j<friendArr.length;j++){
                if(friendArr[myFriendsNum][j]){
                    int tmpNum = score.get(getKey(pplNumber,j));
                    if(!pplNumber.containsKey(getKey(pplNumber,j))){
                        score.put(getKey(pplNumber,j),10);
                    }else{
                        score.put(getKey(pplNumber,j),tmpNum+10);
                    }

                }
            }
            System.out.println(pplNumber);
            System.out.println(myFriends);
            System.out.println(score);


        }
        return friendArr;
    }
    public static <K, V> K getKey(Map<K, V> map, V value) {

        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        int userSize = friends.size()+visitors.size();
        List<String> answer = Collections.emptyList();
        HashMap<String , Integer> scores = new HashMap<>();

        isFriend(friends,userSize,user,scores);
        return answer;
    }
}
