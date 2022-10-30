package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // 1. 유저의 친구 리스트 구하기 (중복값 없음)
        List<String> userFriendsList = new ArrayList<>();

        for(List<String> list : friends){
            for(int i =0; i<list.size(); i++){
                if(list.get(i) == user){
                    userFriendsList.add(list.get(1-i));
                }
            }
        }

        // 2. 친구의 친구 맵에 포인트와 함께 저장하기
        HashMap<String , Integer> friendsFriendsMap = new HashMap<>();

        for( String userFriend : userFriendsList){
            for(List<String> list : friends){
                for(int i =0; i<list.size(); i++){
                    // 중복값이라면
                    if( friendsFriendsMap.get(list.get(1-i)) != null && list.get(i) == userFriend && list.get(1-i)!=user){
                        int point = friendsFriendsMap.get(list.get(1-i));
                        friendsFriendsMap.put(list.get(1-i), point+ 10);
                    }
                    // 처음 입력이라면
                    if( friendsFriendsMap.get(list.get(1-i)) == null && list.get(i) == userFriend && list.get(1-i)!=user){
                        friendsFriendsMap.put(list.get(1-i), 10);
                    }
                }
            }
        }

        // 3. 2의 맵에서 친구리스트에 있는 사람이 있다면 빼준다
        for( String userFriend : userFriendsList){
            if(friendsFriendsMap.get(userFriend) != null){
                friendsFriendsMap.remove(userFriend);
            }
        }

        // 4. 방문객 리스트를 친구의 친구 맵에 넣어준다
        for(String visitor : visitors){
            // 중복값이라면
            if(friendsFriendsMap.get(visitor)!=null){
                int point = friendsFriendsMap.get(visitor);
                friendsFriendsMap.put(visitor, point+ 1);
            }
            // 처음입력이라면
            if(friendsFriendsMap.get(visitor)==null){
                friendsFriendsMap.put(visitor, 1);
            }
        }

        // 4의 맵에서 친구가 있다면 빼준다
        for( String userFriend : userFriendsList){
            if(friendsFriendsMap.get(userFriend) != null){
                friendsFriendsMap.remove(userFriend);
            }
        }

        // System.out.println(friendsFriendsMap);

        answer = new ArrayList<>();

        // 정렬해서 리스트에 넣어준다
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(friendsFriendsMap.entrySet());
        entryList.sort(((o1, o2) -> friendsFriendsMap.get(o2.getKey()) - friendsFriendsMap.get(o1.getKey()) ));
        int cnt = 0 ;
        for(Map.Entry<String, Integer> entry : entryList){
            answer.add(entry.getKey());
            cnt ++;
            if(cnt == 5){
                break;
            }
            // System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
        }

        return answer;
    }

    /*public static void main(String[] args) {
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

        System.out.println(solution(user, friends, visitors).toString());
    }*/
}
