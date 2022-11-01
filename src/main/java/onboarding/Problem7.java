package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String,Integer> graph =new HashMap<>();

        //user의 친구 리스트
        List<String> friendsList = findFriends(friends, user);


        // fruebds 배열로 점수 리스트 만들기
        for (List<String> f: friends){
            graph = makeUserPointList(graph,f, user,friendsList);
        }
        // visitors 배열로 점수 리스트 추가하기
        graph = makeUserPointList(graph,visitors,user,friendsList);


        // 친구관계 점수 매기기
        graph = addRelationPoint(graph,friends,friendsList,user);
        // 방문자 점수 매기기
        graph = addVisitPoint(graph, visitors,friendsList);





        Set<String> keySet = graph.keySet();
        for (String key : keySet) {
            System.out.println(key + " : " + graph.get(key));
        }


        return answer;
    }



    public static HashMap<String,Integer> makeUserPointList(HashMap<String,Integer> graph,List<String> friend,String user,List<String> friendsList){

        for (int i =0; i < friend.size(); i++){
            if (friend.get(i) != user&& !friendsList.contains(friend.get(i)) && graph.get(friend.get(i)) == null) {
                graph.put(friend.get(i),0);
            }
        }


        return graph;
    }
    
    public static List<String> findFriends(List<List<String>> friends, String user) {
        
        List<String> friendsList = new ArrayList<>();
        for (List<String> f: friends){

            if (f.get(0) == user) {
                friendsList.add(f.get(1));
            } else if (f.get(1) == user) {
                friendsList.add(f.get(0));
            }

        }
        return friendsList;
    }

    public static HashMap<String,Integer> addRelationPoint(HashMap<String,Integer> graph,List<List<String>> friends,List<String> friendsList,String user){


        for (String f : friendsList){
            List<String> friendsFriendList = findFriends(friends,f);

            for (String ff : friendsFriendList){
                System.out.println("ff = " + ff);
                if (ff == user || friendsList.contains(ff)) {continue;}
                graph.put(ff, graph.get(ff)+10);
            }
        }

        return graph;
    }

    public static HashMap<String,Integer> addVisitPoint(HashMap<String,Integer> graph,List<String> visitors, List<String> friendsList ){

            for (String v : visitors){
                System.out.println("v = " + v);
                if (friendsList.contains(v)) {continue;}
                graph.put(v, graph.get(v)+1);
            }

        return graph;
    }





    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko"),
                List.of("rovan", "andole"),
                List.of("rovan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");
        System.out.println(solution(user, friends, visitors));

    }
}
