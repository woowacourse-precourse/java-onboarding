package onboarding;

import java.util.*;

public class Problem7_re {
    public static void main(String[] args){
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

        System.out.println(solution(user,friends,visitors));
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //user의 친구 리스트. 인덱스 0번은 user
        List<String> usersFriends = findFriends(friends, user);
        //친구 점수 매기기
        HashMap<String,Integer> friendPoint = addPoint(usersFriends,friends,visitors);
        //정렬 및, 상위 5명의 이름을 골라서 추천 리스트 만들기
        return makeRecomendList(friendPoint);
    }

    public static List<String> makeRecomendList(HashMap<String,Integer> friendPoint){
        List<Map.Entry<String,Integer>> entryList = sortFriendPoint(friendPoint);
        List<String> recomendList = putInRecomendList(entryList);
        return cutRecomendListFive(recomendList);
    }

    public static List<String> cutRecomendListFive(List<String> recomendList){
        if (recomendList.size() > 5) {
            recomendList = recomendList.subList(0, 5);
        }
        return recomendList;
    }
    public static List<String> putInRecomendList(List<Map.Entry<String,Integer>> entryList){
        List<String> recomendList = new ArrayList<>();
        for (Map.Entry<String,Integer> entry : entryList){
            recomendList.add(entry.getKey());
        }
        return recomendList;
    }

    public static List<Map.Entry<String,Integer>> sortFriendPoint(HashMap<String,Integer> friendPoint){
        List<Map.Entry<String,Integer>> entryList = new LinkedList<>(friendPoint.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //값이 같을 경우 알파벳 기준으로 오름차순
                return sortBy(o1,o2);
            }
        });
        return entryList;
    }

    private static int sortBy(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
        if (o2.getValue().compareTo(o1.getValue()) == 0){
            return o1.getKey().compareTo(o2.getKey());
        }else{
            return o2.getValue().compareTo(o1.getValue());
        }
    }


    public static HashMap<String,Integer> addPoint(List<String> usersFriends,List<List<String>> friends,List<String> visitors){
        HashMap<String,Integer> friendPoint = new HashMap<>();;
        friendPoint = addRelationPoint(friendPoint,friends,usersFriends);
        friendPoint = addVisitPoint(friendPoint,visitors,usersFriends);
        return friendPoint;
    }

    public static HashMap<String,Integer> addRelationPoint(HashMap<String,Integer> friendPoint,List<List<String>> friends,List<String> usersFriends){
        for (String friend : usersFriends){
            List<String> friendsFriendList = findFriends(friends,friend);
            for (String ff : friendsFriendList){
                if (ff.equals(usersFriends.get(0)) || usersFriends.contains(ff)) {continue;}
                if (friendPoint.get(ff) == null){friendPoint.put(ff, 0);}
                friendPoint.put(ff, friendPoint.get(ff)+10);
            }
        }
        return friendPoint;
    }

    public static HashMap<String,Integer> addVisitPoint(HashMap<String,Integer> friendPoint,List<String> visitors, List<String> usersFriends ){
        for (String v : visitors){
            if (usersFriends.contains(v)) {continue;}
            if (friendPoint.get(v) == null){friendPoint.put(v, 0);}
            friendPoint.put(v, friendPoint.get(v)+1);
        }
        return friendPoint;
    }

    public static List<String> findFriends(List<List<String>> friends, String user){
        List<String> friendsList = new ArrayList<>();
        friendsList.add(user);
        for (List<String> f: friends){
            if (f.get(0).equals(user)) {
                friendsList.add(f.get(1));
            } else if (f.get(1).equals(user)) {
                friendsList.add(f.get(0));
            }
        }
        return friendsList;
    }

}
