package onboarding;


import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    protected static class User implements Comparable<User> {
        private String name ;
        private int score;

        protected User(String name, int score) {
            this.name = name;
            this.score = score;
        }

        protected String getName() {
            return this.name;
        }

        protected int getScore() {
            return this.score;
        }

        @Override
        public int compareTo(User user) {
            /*
            [ 사용자 정의 Override compareTo 메서드
            이번 미션은 큰 수가 앞으로 와야하기때문에 Score로 비교할 땐 반대로 음수를 붙여주고
            이름은 정상적으로 설정했음
             */
            if(this.score == user.getScore()){
                return Integer.compare(this.name.compareTo(user.getName()), 0);
            } else {
                return user.getScore() - this.score;
            }
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<User> checkingList = new ArrayList<>();
        Map<String, Integer> pointDict = new HashMap<>();
        Map<String, ArrayList<String>> friendListMap = new HashMap<>();
        friendListMap.put(user, new ArrayList<>());
        for (List<String> relation : friends) {
            if (!friendListMap.containsKey(relation.get(0)) && !friendListMap.containsKey(relation.get(1))) {
                friendListMap.put(relation.get(1), new ArrayList<>(){{ add(relation.get(0)); }});
                friendListMap.put(relation.get(0), new ArrayList<>(){{ add(relation.get(1)); }});
            } else if(friendListMap.containsKey(relation.get(0)) && !friendListMap.containsKey(relation.get(1))) {
                friendListMap.put(relation.get(1), new ArrayList<>(){{ add(relation.get(0)); }});
                ArrayList<String> beforeList = friendListMap.get(relation.get(0));
                beforeList.add(relation.get(1));
                friendListMap.put(relation.get(0), beforeList);
            } else if(!friendListMap.containsKey(relation.get(0)) && friendListMap.containsKey(relation.get(1))) {
                friendListMap.put(relation.get(0), new ArrayList<>(){{ add(relation.get(1)); }});
                ArrayList<String> beforeList = friendListMap.get(relation.get(1));
                beforeList.add(relation.get(0));
                friendListMap.put(relation.get(1), beforeList);
            } else {
                ArrayList<String> beforeList;
                beforeList = friendListMap.get(relation.get(0));
                beforeList.add(relation.get(1));
                friendListMap.put(relation.get(0), beforeList);
                beforeList = friendListMap.get(relation.get(1));
                beforeList.add(relation.get(0));
                friendListMap.put(relation.get(1), beforeList);
            }
        }
        // mrko의 직접 적인 친구는 친구 추천에 포함되지 않음!!!
        for(String directFriend : friendListMap.get(user)){
            ArrayList<String> ablePush = friendListMap.get(directFriend);
            for(String f : ablePush){
                if(f.equals(user)){continue;}
                if (!pointDict.containsKey(f)) {
                    pointDict.put(f,10);
                } else {
                    pointDict.put(f,pointDict.get(f)+10);
                }
            }
        }
        for(String visitFriend : visitors){
            if(friendListMap.get(user).contains(visitFriend)){continue;}
            if (!pointDict.containsKey(visitFriend)) {
                pointDict.put(visitFriend,1);
            } else {
                pointDict.put(visitFriend,pointDict.get(visitFriend)+1);
            }
        }
        for(String k: pointDict.keySet()){
            checkingList.add(new User(k,pointDict.get(k)));
        }
        return checkingList.stream().sorted().map(user1 -> user1.name).collect(Collectors.toList());
        }
}
