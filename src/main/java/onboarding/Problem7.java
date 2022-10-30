package onboarding;
import java.util.*;


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Set<String> friendsOfUser = new HashSet<>();
        List<String> redundantMutualFriends = new ArrayList<>();
        Map<String, Integer> points = new HashMap<>();

        // adding users from visiting logs
        Set<String> users = new HashSet<>(visitors);

        // adding users from friends info list
        friends.forEach( temp -> {
            if(temp.contains(user)){
                friendsOfUser.add(temp.get(0));
            } else{
                users.add(temp.get(0));
                users.add(temp.get(1));
            }
        });

        // storing users that are friends with user mutual friends
        friends.forEach(temp -> {
            friendsOfUser.forEach(name -> {
                if(temp.contains(name) && !temp.contains(user)){
                    redundantMutualFriends.add(temp.get(1));
                }
            });
        });

        users.forEach(key -> {
            points.put(key, 0);
        });

        redundantMutualFriends.forEach(mutualFriend -> {
            int currentPoint = points.get(mutualFriend);
            points.put(mutualFriend, currentPoint+10);
        });

        visitors.forEach(visitor -> {
            int currentPoint = points.get(visitor);
            points.put(visitor, currentPoint+1);
        });

        friendsOfUser.forEach(points::remove);

        // sorting the map
        List<Map.Entry<String, Integer>> elem = new LinkedList<Map.Entry<String, Integer>>(points.entrySet());

        Collections.sort(elem, new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2){
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for(Map.Entry<String, Integer> a : elem){
            temp.put(a.getKey(), a.getValue());
        }

        Set<String> stringSet = temp.keySet();
        List<String> preAnswer = new ArrayList<>(stringSet);

        List<String> answer = new ArrayList<>();

        int count = preAnswer.size();
        for(int i=0; i<count; i++){
            if(count>=5) break;
            answer.add(preAnswer.get(i));
        }

        return answer;
    }

//    public static void main(String[] args) {
//
//        List<List<String>> list = new ArrayList<>();
//        List<String> visitors = new ArrayList<>();
//
//        //================================================================================================
//        String user = "mrko";
//
//        List<String> l1 = List.of("donut", "andole");
//        List<String> l2 = List.of("donut", "jun");
//        List<String> l3 = List.of("donut", "mrko");
//        List<String> l4 = List.of("shakevan", "andole");
////        List<String> l5 = List.of("shakevan", "jun");
//        List<String> l6 = List.of("shakevan", "mrko");
//
//        list.add(l6);
////        list.add(l5);
//        list.add(l4);
//        list.add(l3);
//        list.add(l2);
//        list.add(l1);
//
//        visitors.add("bedi");
//        visitors.add("bedi");
//        visitors.add("donut");
//        visitors.add("bedi");
//        visitors.add("shakevan");
//
//        //================================================================================================
//
//        System.out.println(solution(user, list, visitors));
//
//    }
}
