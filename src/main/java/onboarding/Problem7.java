package onboarding;

import java.util.*;

public class Problem7 {
    public static class Point{
        String name;
        int point;
        public Point(String name, int point) {
            this.name = name;
            this.point = point;
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = Collections.emptyList();
        HashMap<String, Integer> point = new HashMap<>();   //포인트를 올릴 추천 친구 리스트
        HashSet<String> userFriend = new HashSet<>();   //user의 친구 목록

        for(int i = 0 ; i < friends.size() ; i++){  //user의 친구 목록 구하기

            String name1 = friends.get(i).get(0);
            String name2 = friends.get(i).get(1);

            if(name1.equals(user) || name2.equals(user)){
                userFriend.add( (name1.equals(user) ? name2 : name1) );
            }
        }

        for(int i = 0 ; i < friends.size() ; i++){  //user와 user의 친구 이외의 사람들 point에 넣기
            String name1 = friends.get(i).get(0);
            String name2 = friends.get(i).get(1);

            if(name1.equals(user) || name2.equals(user)) continue;
            if(userFriend.contains(name1))  {point.put(name2,0); continue;}
            if(userFriend.contains(name2))  {point.put(name1,0); continue;}

            point.put(name1, 0);
            point.put(name2, 0);
        }

        //사용자와 함꼐 아는 친구의 수 + 10
        for(int i = 0 ; i < friends.size() ; i++){

            String name1 = friends.get(i).get(0);
            String name2 = friends.get(i).get(1);

            if(name1.equals(user) || name2.equals(user))
                continue;

            if(userFriend.contains(name1)){
                point.replace(name2, point.get(name2) + 10);
            }
            if(userFriend.contains(name2)){
                point.replace(name1, point.get(name1) + 10);
            }
        }

        //사용자 타임라인에 방문한 횟수 +1
        for(int i = 0 ; i < visitors.size() ; i++){
            String visitor = visitors.get(i);

            if(visitor.equals(user) || userFriend.contains(visitor))
                continue;

            if(point.containsKey(visitor)) {
                point.replace(visitor, point.get(visitor) + 1);
            }
            else{
                point.put(visitor, 1);
            }
        }

        answer = sortPointAndName(point);

        return answer;
    }

    public static List<String> sortPointAndName(HashMap<String, Integer> point){

        List<Point> pointList = new ArrayList<>();  //hashmap은 순서가 없기에 정렬를 쉽게 하지 못하기때문에 변경
        List<String> result = new ArrayList<>();
        for(String key : point.keySet()){
            Point newPoint = new Point(key, point.get(key));
            pointList.add(newPoint);
        }

        Collections.sort(pointList, new Comparator<Point>() {   //point먼저 그후 name 정렬
            @Override
            public int compare(Point o1, Point o2) {

                if(o1.point < o2.point) return 1;
                else if(o1.point > o2.point) return -1;
                else{
                    return o1.name.compareTo(o2.name);
                }
            }
        });

        for(Point t : pointList){
            if(t.point > 0){
                result.add(t.name);
            }
        }

        return result;
    }
}
