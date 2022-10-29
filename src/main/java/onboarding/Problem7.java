package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> member = new ArrayList<>();

        // 친구 관계를 그래프로 저장
        Iterator<List<String>> friendsItr = friends.iterator();
        for(int i=0; i<friends.size(); i++){
            List<String> ABfriend = friendsItr.next();
            String A = ABfriend.get(0);
            String B = ABfriend.get(1);

            if(!member.contains(A)){
                member.add(A);
            }
            if(!member.contains(B)){
                member.add(B);
            }
        }

        List<String>[] friendList = new ArrayList[member.size()];
        for(int i=0; i< member.size(); i++){
            friendList[i] = new ArrayList<>();
        }

        // 친구 되어있는 관계를 리스트에 넣음
        friendsItr = friends.iterator();
        for(int i=0; i<friends.size(); i++){
            List<String> ABfriend = friendsItr.next();
            String A = ABfriend.get(0);
            String B = ABfriend.get(1);

            int aIdx = member.indexOf(A);
            int bIdx = member.indexOf(B);

            friendList[aIdx].add(B);
            friendList[bIdx].add(A);
        }

        // 사용자와 함께 아는 친구의 점수를 매김(10점)
        int[] memberPoint = new int[member.size()]; // 추천 점수 표시할 배열
        int userIdx = member.indexOf(user); // 파라미터로 받은 유저의 인덱스

        List<String> userFriend = friendList[userIdx]; // 파라미터로 받은 유저의 직접 친구 리스트
        for(int i=0; i<userFriend.size(); i++){
            String friendOfUser = userFriend.get(i); // 파라미터로 받은 유저의 직접 친구

            int friendOfUserIdx = member.indexOf(friendOfUser); // 파라미터로 받은 유저의 직접 친구 인덱스
            List<String> indirectFriendList = friendList[friendOfUserIdx]; // 파라미터로 받은 유저의 직접 친구와 친구 관계인 유저 리스트
            
            Iterator<String> indirectFriendItr = indirectFriendList.iterator();
            for(int j=0; j< indirectFriendList.size(); j++){
                String indirectFriend = indirectFriendItr.next();
                int indirectFriendIdx = member.indexOf(indirectFriend);
                memberPoint[indirectFriendIdx] += 10;
            }
        }

        // 방문자로 점수 처리
        // 방문자를 리스트로 정리
        List<String> visitorList = new ArrayList<>();
        for(int i=0; i<visitors.size(); i++){
            if(!visitorList.contains(visitors.get(i))){
                visitorList.add(visitors.get(i));
            }
        }

        // 방문자 횟수로 점수 매김
        int[] visitorPoint = new int[visitorList.size()];
        for(int i=0; i<visitors.size(); i++){
            String nowVisitor = visitors.get(i);
            int visitorIdx = visitorList.indexOf(nowVisitor);
            visitorPoint[visitorIdx]++;
        }

        // 최종 점수 구하기
        Map<String, Integer> recommendPoint = new HashMap<>();
        // 10점 짜리 점수 넣기
        for(int i=0; i<member.size(); i++){
            String recommendName = member.get(i);
            int recommendNamePoint = memberPoint[i];
            recommendPoint.put(recommendName, recommendNamePoint);
        }
        // 방문자 횟수 점수 추가
        for(int i=0; i< visitorList.size(); i++){
            String visitorName = visitorList.get(i);
            int visitorNamePoint = visitorPoint[i];

            if(recommendPoint.containsKey(visitorName)){
                int point = recommendPoint.get(visitorName);
                recommendPoint.remove(visitorName);
                recommendPoint.put(visitorName, point + visitorNamePoint);
            } else {
                recommendPoint.put(visitorName, visitorNamePoint);
            }
        }




        return answer;
    }



}
