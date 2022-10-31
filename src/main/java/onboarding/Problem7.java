package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        // 친구 리스트 만듦
        List<String> memberList = makeFriendList(friends);

        // 그래프 구조로 친구 관계를 만들기
        List<String>[] friendList = makeFriendGraph(memberList, friends);

        // 입력받은 user가 친구가 없는 경우
        if(!memberList.contains(user)){
            // 방문자로 점수 처리
            // 방문자를 중복 없는 리스트로 정리
            List<String> visitorList = visitorList(visitors);

            // 방문자 횟수로 점수 매김
            int[] visitorPoint = makeVisitorPointArr(visitorList, visitors);

            // 우선순위 큐로 정렬
            PriorityQueue<User> visitorPQ = new PriorityQueue<>();
            for(int i=0; i<visitorPoint.length; i++){
                String name = visitorList.get(i);
                int point = visitorPoint[i];

                visitorPQ.add(new User(name, point));
            }

            while (!visitorPQ.isEmpty()){
                User nowUser = visitorPQ.poll();

                String nowName = nowUser.name;
                int nowPoint = nowUser.point;

                answer.add(nowName);
            }

            return answer;
        }

        // 사용자와 함께 아는 친구의 점수를 매김(10점)
        int userIdx = memberList.indexOf(user); // 파라미터로 받은 유저의 인덱스
        int[] memberPoint = new int[memberList.size()]; // 추천 점수 표시할 배열

        List<String> userFriend = friendList[userIdx]; // 파라미터로 받은 유저의 직접 친구 리스트
        for(int i=0; i<userFriend.size(); i++){
            String friendOfUser = userFriend.get(i); // 파라미터로 받은 유저의 직접 친구
            int friendOfUserIdx = memberList.indexOf(friendOfUser); // 파라미터로 받은 유저의 직접 친구 인덱스
            List<String> indirectFriendList = friendList[friendOfUserIdx]; // 파라미터로 받은 유저의 직접 친구와 친구 관계인 유저 리스트
            
            Iterator<String> indirectFriendItr = indirectFriendList.iterator();
            for(int j=0; j< indirectFriendList.size(); j++){
                String indirectFriend = indirectFriendItr.next();
                // 입력받은 user는 점수 안매김
                if(indirectFriend.equals(user)) continue;

                int indirectFriendIdx = memberList.indexOf(indirectFriend);
                memberPoint[indirectFriendIdx] += 10;
            }
        }

        // 방문자로 점수 처리
        // 방문자를 중복 없는 리스트로 정리
        List<String> visitorList = visitorList(visitors);

        // 방문자 횟수로 점수 매김
        int[] visitorPoint = makeVisitorPointArr(visitorList, visitors);

        // 최종 점수 구하기
        Map<String, Integer> totalPointMap = makeTotalScoreMap(memberList, memberPoint, visitorList, visitorPoint);
        for(int i=0; i<userFriend.size(); i++){
            String friend = userFriend.get(i);
            totalPointMap.remove(friend);
        }

        // 우선순위 큐 사용: point 기준으로 정렬
        PriorityQueue<User> userPQue = new PriorityQueue<>();
        Iterator<String> totalPointMapItr = totalPointMap.keySet().iterator();
        for(int i=0; i< totalPointMap.size(); i++){
            String name = totalPointMapItr.next();
            int point = totalPointMap.get(name);

            User exUser = new User(name, point);
            userPQue.add(exUser);
        }

        List<String> nameList = new ArrayList<>();
        while (!userPQue.isEmpty()){
            User nowUser = userPQue.poll();

            String name = nowUser.name;
            int point = nowUser.point;

            if(point > 0){
                nameList.add(name);
            }
            if(nameList.size() >= 5) break;
        }

        answer = nameList;

        return answer;
    }

    /**
     * User 객체
     */
    static class User implements Comparable<User>{
        String name;
        int point;

        User(String name, int point){
            this.name = name;
            this.point = point;
        }

        @Override
        public int compareTo(User u){
            if(u.point > this.point){
                return 1;
            } else if(u.point < this.point){
                return -1;
            } else {
                char userChar = u.name.charAt(0);
                char thisChar = this.name.charAt(0);

                if(userChar > thisChar){
                    return -1;
                } else if(userChar < thisChar){
                    return 1;
                } else {
                    int userLen = u.name.length();
                    int thisLen = this.name.length();
                    int min = Math.min(userLen, thisLen);
                    for(int i=0; i<min; i++){
                        char userC = u.name.charAt(i);
                        char thisC = this.name.charAt(i);
                        if(userC > thisC){
                            return 1;
                        } else if(userC < thisC){
                            return -1;
                        } else {
                            continue;
                        }
                    }
                    return 0;
                }
            }
        }
    }

    /**
     * 등장하는 친구를 리스트에 중복 없이 넣음
     * @param friends 친구 관계 리스트
     * @return 친구 리스트
     */
    static List<String> makeFriendList(List<List<String>> friends){
        List<String> member = new ArrayList<>();

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

        return member;
    }

    /**
     * 친구 관계를 그래프 구조로 구현하는 메소드
     * @param member 친구 리스트
     * @param friends 친구 관계 나타낸 리스트
     * @return 리스트 배열로 구현된 그래프
     */
    static List<String>[] makeFriendGraph(List<String> member, List<List<String>> friends){
        // 친구 수 만큼 리스트 만들고 초기화
        List<String>[] friendList = new ArrayList[member.size()];
        for(int i=0; i< member.size(); i++){
            friendList[i] = new ArrayList<>();
        }

        // 그래프 구조 구현
        Iterator<List<String>> friendsItr = friends.iterator();
        for(int i=0; i<friends.size(); i++){
            List<String> ABfriend = friendsItr.next();
            String A = ABfriend.get(0);
            String B = ABfriend.get(1);

            int aIdx = member.indexOf(A);
            int bIdx = member.indexOf(B);

            friendList[aIdx].add(B);
            friendList[bIdx].add(A);
        }

        return friendList;
    }

    /**
     * 방문자를 중복 없이 리스트에 넣는 메소드
     * @param visitors
     * @return 중복 제외한 방문자 리스트
     */
    static List<String> visitorList(List<String> visitors){
        List<String> visitorList = new ArrayList<>();
        for(int i=0; i<visitors.size(); i++){
            if(!visitorList.contains(visitors.get(i))){
                visitorList.add(visitors.get(i));
            }
        }

        return visitorList;
    }

    /**
     * 방문자 횟수 만큼 점수를 +1 해주는 메소드
     * @param visitorList 방문자를 중복 없이 저장해놓은 리스트
     * @param visitors 방문자 기록
     * @return 방문자 점수 기록한 배열
     */
    static int[] makeVisitorPointArr(List<String> visitorList, List<String> visitors) {
        int[] visitorPoint = new int[visitorList.size()];
        // 입력 받은 방문자 기록을 보고 해당 방문자가 있는 위치의 점수를 +1
        for (int i = 0; i < visitors.size(); i++) {
            String nowVisitor = visitors.get(i);
            int visitorIdx = visitorList.indexOf(nowVisitor);
            visitorPoint[visitorIdx]++;
        }

        return visitorPoint;
    }

    /**
     * 최종 점수를 key: 이름, value: 점수 인 Map 구조로 만드는 메소드
     * @param memberList 친구 관계 리스트
     * @param memberPoint 친구 관계로 만든 점수 배열
     * @param visitorList 방문자 리스트
     * @param visitorPoint 방문자로 만든 점수 배열
     * @return 만들어진 Map
     */
    static Map<String, Integer> makeTotalScoreMap(List<String> memberList, int[] memberPoint, List<String> visitorList, int[] visitorPoint){
        Map<String, Integer> recommendPoint = new HashMap<>();
        // 10점 짜리 점수 넣기
        for(int i=0; i<memberList.size(); i++){
            String recommendName = memberList.get(i);
            int recommendNamePoint = memberPoint[i];

            recommendPoint.put(recommendName, recommendNamePoint);
        }

        // 방문자 횟수 점수 추가
        for(int i=0; i< visitorList.size(); i++){
            String visitorName = visitorList.get(i);
            int visitorNamePoint = visitorPoint[i];
            // 방문자가 이미 친구 관계에 있을 때
            if(recommendPoint.containsKey(visitorName)){
                int point = recommendPoint.get(visitorName);
                recommendPoint.remove(visitorName);
                recommendPoint.put(visitorName, point + visitorNamePoint);
            }
            // 방문자가 친구 관계에 없을 때
            else {
                recommendPoint.put(visitorName, visitorNamePoint);
            }
        }

        return recommendPoint;
    }

}
