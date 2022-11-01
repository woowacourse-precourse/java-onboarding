package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        ArrayList<String> tmpAnswer = new ArrayList<>();
        /**
         * SNS 친구 추천 알고리즘
         * 사용자와 함께 아는 친구의 수 : 10점
         * 사용자의 타임 라인에 방문한 횟수 : 1점
         *
         * 추천 점수가 0점인 경우는 추천하지 않는다.
         * 추천 점수가 같은 경우는 이름 순으로 정렬한다.
         *
         * 사용자 아이디 User
         * */
        // 먼저 친구 정보를 저장할 hashmap을 생성한다. (key 값은 노드, value값은 그와 친구인 리스트를 만든다.)
        HashMap<String, List<String>> friendInfo= new HashMap<>();
        HashMap<String, Integer> friendScore= new HashMap<>();

        // 친구정보를 friendInfo에 저장한다.
        for (List<String> friend: friends){
            String friendA = friend.get(0);
            String friendB = friend.get(1);

            // A와 B의 친구 리스트를 불러온다.
            List<String> friendListOfA = friendInfo.get(friendA);
            List<String> friendListOfB = friendInfo.get(friendB);


            // 친구 리스트에 원소가 비어있는 경우 새로운 element를 넣는다.
            if (friendListOfA == null) {
                friendListOfA = new ArrayList<>();
                friendListOfA.add(friendB);
                friendInfo.put(friendA, friendListOfA);
            }

            if (friendListOfB == null) {
                friendListOfB = new ArrayList<>();
                friendListOfB.add(friendA);
                friendInfo.put(friendB, friendListOfB);
            }

            // A와 B는 각각 친구이므로, 각각 A,B키에 B,A를 친구리스트에 삽입한다.
            // 이미 원소가 있는 경우 value 값을 add한다.
            // 이미 친구A 리스트가 존재한다면,  원소 B를 리스트에 추가한다.
            if ( friendListOfA != null && friendListOfA.size() > 0 ) {
                friendListOfA.add(friendB);
            }
            // 이미 친구B 리스트가 존재한다면, 원소 A를 리스트에 추가한다.
            if ( friendListOfB != null && friendListOfB.size() > 0 ) {
                friendListOfB.add(friendA);
            }
        }

        // 친구의 친구를 조회하여 추천 친구의 점수를 +10 한다.
        for ( String friend: friendInfo.get(user) ){
            // 친구의 친구 리스트들을 확인한다.
            for (String friendOfFriend : friendInfo.get(friend)){
                // 이미 친구인지 확인한다.
                boolean alreadyFriend =  friendInfo.get(user).contains(friendOfFriend);

                // 친구의 친구 목록에 해당 유저를 제거한다.
                boolean isUser = friendOfFriend.equals(user);

                // 만약 이미 친구거나 유저인 경우 생략한다. (해당 유저는 score에 제외)
                if (alreadyFriend || isUser  ){ continue; }
                // 친구가 아니고 유저가 아닌 경우 점수에 추가한다.
                if ( !(alreadyFriend) || isUser) {
                    // 만약 스코어 원소가 안들어있으면 0을 삽입한다.
                    friendScore.putIfAbsent(friendOfFriend, 0);
                    // 친구의 점수가 등록되지 않은 경우 0을 기본으로 하여 넣는다.
                    int tmpScore = friendScore.get(friendOfFriend);
                    if (tmpScore >= 0) {
                        // 친구 점수를 더한다. ( + 10점 )
                        tmpScore += 10;
                        // 스코어에 점수를 업데이트한다.
                        friendScore.put(friendOfFriend, tmpScore);
                    }
                }
            }
        }

        // 추천친구가 방문자인 경우 추천 친구의 점수를 +1 한다.
        for (String visitor: visitors){
            boolean alreadyFriend =  friendInfo.get(user).contains(visitor);
            if (! (alreadyFriend) ){
                int tmpScore = friendScore.getOrDefault(visitor, 0);
                friendScore.put(visitor, tmpScore + 1);
            }
        }

        // Score 점수가 높은 순으로 정렬한다. (value 값 정렬)
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(friendScore.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        // 상위 5명을 노출시킨다.
        for( Map.Entry<String, Integer> entry : entryList ){
            int score = entry.getValue();
            String suggestedFriend = entry.getKey();
            // score가 0 이상인 경우만 추가한다.
            if (tmpAnswer.size() < 5 || score > 0){
                tmpAnswer.add(suggestedFriend);
            }
        }
        answer = tmpAnswer;

        return answer;
    }
}
