package onboarding;

import java.lang.reflect.Array;
import java.util.*;

public class Problem7 {
    public static boolean is_repeat(List<String> list, String name ){
        if(list.contains(name)){
            return false;
        }
        return true;
    }
    //user의 이름과 friends 2차원 리스트가 주어지면 user와 친구인 리스트를 반환한다.
    public static List<String> is_friends(String user, List<List<String>> friends){
        List<String> User_friend = new ArrayList<>();
        int fr_size = friends.size();
        for(int i = 0 ; i < fr_size ; i++) {
            //유저와 친구인사람을 추출
            if(user == friends.get(i).get(0) ){//중복 체크하고 넣자
                if(is_repeat(User_friend,friends.get(i).get(1) )){
                    User_friend.add(friends.get(i).get(1));
                }
            }
            if(user == friends.get(i).get(1)){//중복 체크 하고 넣자
                if(is_repeat(User_friend,friends.get(i).get(0) )){
                    User_friend.add(friends.get(i).get(0));
                }
            }
        }
        return User_friend;
    }

    //point라는 map 에 friend에 담긴 개수 만큼 10점씩 point
    public static Map<String,Integer> pointing(Map<String,Integer> point,  List<List<String>> friend, List<String> visitors){

        for(int i = 0 ; i< friend.size() ; i++){
            for(int k = 0; k < friend.get(i).size();k++){
                if(point.containsKey(friend.get(i).get(k))){//point가 friend의 원소하나하나 check, 만약 있다면
                    //원래 있던 숫자에 10을 더한다.
                    point.replace(friend.get(i).get(k),point.get(friend.get(i).get(k))+10);
                    //다음 루프로 간다.
                    continue;
                }
                //만약 없다면
                point.put(friend.get(i).get(k),10);
            }
        }
        //이번엔 visitors point check
        for(int i = 0; i < visitors.size() ; i++){{
            if(point.containsKey(visitors.get(i))){//point가 friend의 원소하나하나 check, 만약 있다면
                //원래 있던 숫자에 10을 더한다.
                point.replace(visitors.get(i),point.get(visitors.get(i))+1);
                //다음 루프로 간다.
                continue;
                }
                //만약 없다면
                point.put(visitors.get(i),1);
            }
        }

        return point;

    }

    public static List<String> sort_logic(List<String> sort_list , Map<String,Integer> point){
        List<String> max_key = new ArrayList<>();

        if(point.size() == 0){
            return sort_list;
        }
        int max_value = 0;
        //가장 큰 value 를 구하고
        for(String key : point.keySet()){
            if(max_value < point.get(key)){
                max_value = point.get(key);
            }
        }
        //그 value값을 가지고 있는 key를 list에 추가한다.
        for(String key : point.keySet()){
            if(point.get(key) == max_value){
                max_key.add(key);
            }
        }
        //그리고 정렬 후 sort_key에 추가한다.
        //sort(max_key);
        Collections.sort(max_key);
        sort_list.addAll(max_key);

        //map에서 max_value를 가지고 있는 key를 제거하고 반복.
        for(String key : max_key){
            point.remove(key);
        }


        //max_key는 초기화 한다.
        max_key.clear();

        return sort_logic(sort_list,point);

    }
    //counting sort 써서 정렬
    public static List<String> sorting_Map(Map<String,Integer> point){
        //가장 큰 value 를 가진 key를 List 에 추가
        List<String> max_key = new ArrayList<>();
        List<String> sort_key = new ArrayList<>();


        //return sort_key;
        return sort_logic(sort_key,point);
    }
    public static List<List<String>> remove_user(List<List<String>> friend , String user){
        for(int i = 0 ; i < friend.size(); i++){
            friend.get(i).remove(user);
        }
        return friend;
    }
    public static Map<String,Integer> remove_friends(List<String> User_friend , Map<String,Integer> fr_point){

        for(int i = 0; i< User_friend.size() ; i++){
            if(fr_point.containsKey(User_friend.get(i))){
                fr_point.remove(User_friend.get(i));
            }
        }

        return fr_point;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = Collections.emptyList();

        //user 의 친구 목록
        List<String> User_friend = new ArrayList<>();

        //1. user 와 친구인 사람을 결정 ArrayList로 작성
        User_friend = is_friends(user,friends);

        //2. user와 친구의 친구를 구한다. (2차원 list로) 왜냐하면 각각 pointing하려고
        List<List<String>> friend = new ArrayList<>();
        for(int i = 0 ; i < User_friend.size() ; i++){
            friend.add(i,is_friends(User_friend.get(i),friends));
        }
        //2-1. 친구-친구 목록에서 user 의 이름은 뺸다.
        friend = remove_user(friend,user);

        //3. friend별로 pointing 하기위해 hashmap을 선언한다 key, value => name , point
        System.out.println("friend = " + friend);



        Map<String, Integer> fr_point = new HashMap<>();

        //4. pointing
        fr_point = pointing(fr_point, friend,visitors);

        //5. user와 친구라면 point맵에서 제거한다.
        remove_friends(User_friend,fr_point);

        //6. 포인트순으로 정렬 , point가 동일하다면 이름순으로 sorting 한다.
        answer = new ArrayList<>();
        answer.addAll(sorting_Map(fr_point));

        System.out.println(friend);
        System.out.println(fr_point);


       System.out.println(answer);
        return answer;
    }

//    public static void main(String[] args) {
//
//        String user = "mrko";
//        List<List<String>> friends = List.of(
//                List.of("donut", "andole"),
//                List.of("donut", "jun"),
//                List.of("donut", "mrko"),
//                List.of("shakevan", "andole"),
//                List.of("shakevan", "jun"),
//                List.of("shakevan", "mrko")
//        );
//        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
//        //List<String> result = List.of("andole", "jun", "bedi");
//        solution(user, friends,visitors);
//
//    }


}
