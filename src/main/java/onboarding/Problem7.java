package onboarding;

import problem7.Friend;

import java.util.*;
import java.util.Map.Entry;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //List<String> answer = Collections.emptyList();
        List<String> answer = new ArrayList<String>();

        Friend friend = new Friend();

        //친구 목록 만들기
        HashMap<String, List<String>> friendMap = friend.makeFriendMap(friends);

        //user의 친구 목록 찾기
        List<String> userFriends = friendMap.get(user);

        HashMap<String, Integer> friendsScore = new HashMap<String, Integer>();

        //친구의 친구들 찾기
        for(String userFriend : userFriends) {
            List<String> dupFriendsOfFriend = friendMap.get(userFriend);

            //친구의 친구 중복 제거
            HashSet<String> temp = new HashSet<String>(dupFriendsOfFriend);
            List<String> friendsOfFriend = new ArrayList<String>(temp);

            for(String friendOfFriend : friendsOfFriend) {
                //이미 friendsScore에 있으면 값을 업데이트
                if(friendsScore.containsKey(friendOfFriend)) {
                    Integer score = friendsScore.get(friendOfFriend);
                    friendsScore.put(friendOfFriend, score+10);
                }else { //없으면 20점을 가지는 친구를 생성
                    friendsScore.put(friendOfFriend, 10);
                }
            }
        }

        //visitor 점수 주기
        for(String visitor : visitors) {
            if(friendsScore.containsKey(visitor)) {
                Integer score = friendsScore.get(visitor);
                friendsScore.put(visitor, score+1);
            }else { //없으면 20점을 가지는 친구를 생성
                friendsScore.put(visitor, 1);
            }
        }

        //friendScore에서 user와 user의 친구 제거
        friendsScore.remove(user);

        for(String userFriend : userFriends) {
            friendsScore.remove(userFriend);
        }

        //정렬
        List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(friendsScore.entrySet());

        // 비교함수 Comparator를 사용하여 내림 차순으로 정렬
        Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
            // compare로 값을 비교
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
            {
                // 점수가 같으면 이름 오룸차순 정렬
                if(obj2.getValue().compareTo(obj1.getValue())==0) {
                    return obj1.getKey().compareTo(obj2.getKey());
                }else { //점수 내림 차순으로 정렬
                    return obj2.getValue().compareTo(obj1.getValue());
                }
            }
        });

        //answer에 정렬된 것 담기
        for(Entry<String, Integer> entry : list_entries) {
            if(answer.size() < 5) {
                answer.add(answer.size(), entry.getKey());
            }
        }

        return answer;
    }
    
}
