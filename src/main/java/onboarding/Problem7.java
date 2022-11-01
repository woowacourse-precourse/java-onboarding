package onboarding;

import java.sql.Array;
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

        HashMap<String , Integer> friendsFriendsMap = new HashMap<>();

        // 2. 친구의 친구 맵에 포인트와 함께 저장하기 (user의 친구가 한명도 없는 경우)
        if(userFriendsList.size()==0){

            // a. 방문객 리스트를 친구의 친구 맵에 넣어준다 (추천할 친구가 없는 경우는 주어지지 않기 때문에 visitors은 무조건 0보다 크다)
            for(String visitor : visitors){
                // 중복값이라면
                if(visitor!= user && friendsFriendsMap.get(visitor)!=null){
                    int point = friendsFriendsMap.get(visitor);
                    friendsFriendsMap.put(visitor, point+ 1);
                }
                // 처음입력이라면
                if(visitor!= user && friendsFriendsMap.get(visitor)==null){
                    friendsFriendsMap.put(visitor, 1);
                }
            }

        } else {  // 2.친구의 친구 맵에 포인트와 함께 저장하기 (user의 친구가 존재하는 경우)
            // a. 친구리스트로 친구의 친구 맵을 만들어 포인트를 준다 (중복값 있음 중복이면 점수가 중복인거임!!)
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

            // b. a의 맵에서 친구 리스트와 공통된 사람이 있다면 빼준다
            for( String userFriend : userFriendsList){
                if(friendsFriendsMap.get(userFriend) != null){
                    friendsFriendsMap.remove(userFriend);
                }
            }

            // c. 방문객 리스트의 크기가 0이아니라면, 친구의 친구맵에 추가한다 (이미 존재하는 사람이라면 1을 올려주고, 없는 사람이라면 1 포인트와 함께 새로 입력해준다)
            if(visitors.size()>0){
                for(String visitor : visitors){
                    // 중복값이라면
                    if(visitor!= user && friendsFriendsMap.get(visitor)!=null){
                        int point = friendsFriendsMap.get(visitor);
                        friendsFriendsMap.put(visitor, point+ 1);
                    }
                    // 처음입력이라면
                    if(visitor!= user && friendsFriendsMap.get(visitor)==null){
                        friendsFriendsMap.put(visitor, 1);
                    }
                }

                // d. 방문객 리스트의 크기가 0이아니라면, 친구의 친구맵에 중에 친구리스트에 포함된 사람을 뺴준다
                for( String userFriend : userFriendsList){
                    if(friendsFriendsMap.get(userFriend) != null){
                        friendsFriendsMap.remove(userFriend);
                    }
                }
            }

        } // end of else

        answer = new ArrayList<>();

        // 3. 리스트에 넣어서 포인트내림차순, 아이디 오름차순으로 정렬한다
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(friendsFriendsMap.entrySet());
        entryList.sort(
                Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed()
                        .thenComparing(Map.Entry::getKey)
        );

        // 4. 최대 5명 까지만 answer 리스트에 담아서 return 한다
        int cnt = 0 ;
        for(Map.Entry<String, Integer> entry : entryList){
            answer.add(entry.getKey());
            cnt ++;
            if(cnt == 5){
                break;
            }
        }

        return answer;
    }


}
