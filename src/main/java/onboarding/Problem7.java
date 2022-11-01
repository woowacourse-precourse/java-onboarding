package onboarding;

import java.util.*;

class FriendConnection{
    public static HashMap<String,ArrayList<String>> connect(List<List<String>> friends){
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for (List<String> friend : friends){
            ArrayList<String> list;
            if (map.containsKey(friend.get(0))){
                list = map.get(friend.get(0));
                list.add(friend.get(1));
            }
            else{
                list = new ArrayList<>();
                list.add(friend.get(1));
            }
            map.put(friend.get(0),list);

            ArrayList<String> list2;
            if (map.containsKey(friend.get(1))){
                list2 = map.get(friend.get(1));
                list2.add(friend.get(0));
            }
            else{
                list2 = new ArrayList<>();
                list2.add(friend.get(0));
            }
            map.put(friend.get(1),list2);
        }
        return map;
    }
}

class FriendPoint{
    public static HashMap<String,Integer> getFriendPoint(HashMap<String, ArrayList<String>> friend_map,
                                                         ArrayList<String> user_friend_list,
                                                         String user)
    {
        HashMap<String,Integer> point_map = new HashMap<>();

        if (user_friend_list != null) {
            for (Map.Entry<String, ArrayList<String>> entry : friend_map.entrySet()) {
                String key = entry.getKey();
                ArrayList<String> values = entry.getValue();

                if (user_friend_list.contains(key) || key.equals(user)) continue;   //사용자, 혹은 사용자와 1촌인 사람은 제외

                for (String person : values) {
                    if (user_friend_list.contains(person)) {
                        if (point_map.containsKey(key)) {
                            point_map.put(key, point_map.get(key) + 10);
                        } else {
                            point_map.put(key, 10);
                        }
                    }
                }
            }
        }
        return point_map;
    }
}

class VisitorPoint{
    public static void getVisitorPoint(HashMap<String,Integer> point_map,
                                       List<String> visitors,
                                       List<String> user_friend_list){
        for(String visitor:visitors){
            if (point_map.containsKey(visitor)){
                point_map.put(visitor,point_map.get(visitor)+1);
            }
            else{
                if (user_friend_list!= null && user_friend_list.contains(visitor)) continue;
                else point_map.put(visitor,1);
            }
        }
    }
}


public class Problem7 {

    /*
    기능 목록
    1. 주어진 유저에 대해, 주어진 사람들의 포인트를 매긴다.
        1) 아는 친구
        2) 방문 횟수
    2. 이것에 대해 포인트로는 내림차순, 이름으론 사전순(=오름차순)으로 정렬한다.
    3. 이름만 return한다.
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        HashMap<String, ArrayList<String>> friend_map = FriendConnection.connect(friends);
        //각 사람들끼리의 친구관계 설정.

        ArrayList<String> user_friend_list = friend_map.get(user);

        HashMap<String,Integer> point_map = FriendPoint.getFriendPoint(friend_map,user_friend_list,user);

        VisitorPoint.getVisitorPoint(point_map,visitors,user_friend_list);


        //방문자 1점씩.
        System.out.println("point_map = " + point_map);
        //point_map을 2차원배열로 만든 후, x[1]에 대해 내림차순으로 정렬하고 x[0]에 대해선 오름차순으로 정렬한다.

        ArrayList<ArrayList<String>> point_list = new ArrayList<>();

        for(Map.Entry<String,Integer> entry:point_map.entrySet()){
            ArrayList<String> temp = new ArrayList<>();
            if (entry.getValue() == 0) continue;    //추천점수 0이면 제외.
            temp.add(entry.getKey());
            temp.add(Integer.toString(entry.getValue()));
            point_list.add(temp);
        }
        System.out.println("point_list = " + point_list);

        //추천점수에 대해선 내림차순, 이름에 대해선 오름차순으로 정렬해야한다.
        Collections.sort(point_list, new Comparator<ArrayList<String>>(){
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2){
                Integer o1_point = Integer.parseInt(o1.get(1));
                Integer o2_point = Integer.parseInt(o2.get(1));
                if (o1_point < o2_point){//포인트에 대해선 내림차순
                    return 1;
                }
                else if (o1.get(1).contentEquals(o2.get(1))){
                    if (o1.get(0).compareTo(o2.get(0))>0){//이름은 오름차순.
                        return 1;
                    }
                }
                return -1;
            }
        });

        for (ArrayList<String> p : point_list){
            answer.add(p.get(0));
        }
        if (answer.size()<5) return answer;
        else return answer.subList(0,5);
    }
}
