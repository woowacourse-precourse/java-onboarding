package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7 p7 = new Problem7();
        List<List<String>> newFriendList = p7.getFriendList(friends);
        Map<String, Integer> friendMap = p7.myFriendScore(newFriendList,user);
        Map<String, Integer> visitMap = p7.getVisitScore(visitors);
        Map<String, Integer> totalMap = p7.getTotoalScore(visitMap, friendMap);
        Set<String> set = p7.getReverseMap(totalMap);

        List<String> answer = new ArrayList<>();
        for(String s: set){
            answer.add(s);
        }


        return answer;
    }

    public Map<String,Integer> getVisitScore(List<String> visitors) {
        Map<String, Integer> visitScore = new TreeMap<>();
        for (String visitor : visitors) {
            if(visitScore.containsKey(visitor)){
                visitScore.put(visitor,visitScore.get(visitor)+1);
            }else {
                visitScore.put(visitor, 1);
            }
        }
        return  visitScore;
    }

    public List<List<String>> getFriendList (List<List<String>> friends) {
        List<List<String>> friendsList = new ArrayList<>();
        for(List<String> friend : friends){
            List<String> n = new ArrayList<>();
            n.add(0, friend.get(1));
            n.add(1,friend.get(0));
            friendsList.add(n);
            friendsList.add(friend);
        }
        return friendsList;
    }


    public  Map<String, Integer> myFriendScore (List<List<String>> friendList, String user) {
        List<List<String>> userFriends = new ArrayList<>();
        Map<String, Integer> friendScore = new TreeMap<>();
        int score = 10;
        for (List<String> friend : friendList){
            if(friend.get(0).equals(user)){
                userFriends.add(friend);
            }
        }

        for(List<String> userfriend : userFriends) {
            for(List<String> friend : friendList) {
                if(userfriend.get(1).equals(friend.get(1))){
                    if(friendScore.containsKey(friend.get(0))){
                        friendScore.put(friend.get(0),friendScore.get(friend.get(0))+score);
                    }
                        friendScore.put(friend.get(0),10);
                }
            }
        }

        return friendScore;
    }


    public Map<String, Integer> getTotoalScore(Map<String, Integer> visitScore, Map<String, Integer> friendScore){
        Set<String> vset =visitScore.keySet();
        Set<String> fset =friendScore.keySet();
        Iterator<String> viterator = vset.iterator();
        Iterator<String> fiterator = fset.iterator();
        Map<String, Integer> totalScore = new TreeMap<>();

        while(viterator.hasNext()){ // 양쪽 리스트에 같은 값이 있으면 그것만 계산
            while(fiterator.hasNext()) {
                String vkey = viterator.next();
                String fkey = fiterator.next();
                if(fkey.equals(vkey)){
                    totalScore.put(fkey, friendScore.get(fkey));
                    viterator.remove();
                    fiterator.remove();
                }
            }
        }

        for(String v: vset){ //양쪽 리스트에 있는거 모두 다 저장
            totalScore.put(v, friendScore.get(v));
        }
        for(String f: fset){ //양쪽 리스트에 있는거 모두 다 저장
            totalScore.put(f, friendScore.get(f));
        }
        return totalScore;
    }

    public Set<String> getReverseMap(Map<String,Integer> totalScore) {
        Set<String> recommadScore = new TreeSet<>();
        TreeMap<Integer, String> reverse = new TreeMap<>();


        Set<String> tset = totalScore.keySet();
        for (String s : tset) {
            reverse.put(totalScore.get(s), s);
        }
        int count=1;
        NavigableMap<Integer, String> descendingMap = reverse.descendingMap();
        Set<Map.Entry<Integer,String>>  descendingEntrySet = descendingMap.entrySet();
        for(Map.Entry<Integer, String> e : descendingEntrySet){
            recommadScore.add(e.getValue());

            if(count==5){break;}
            count++;
        }

        return recommadScore;
    }



}