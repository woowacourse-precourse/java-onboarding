package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> userFriend = new ArrayList<>();
        makeUserFriendList(user, friends, userFriend);

        HashMap<String, List<String>> friendHash = new HashMap<>();
        for (List<String> friend : friends) {
            String a = friend.get(0);
            String b = friend.get(1);

            if(!a.equals(user) && !b.equals(user)){
                addFriend(friendHash, a, b);
                addFriend(friendHash, b, a);
            }
        }

        HashMap<String, Integer> scoreList = new HashMap<>();
        for (String s : friendHash.keySet()) {

            List<String> friendsOfS = friendHash.get(s);
            int score = 0;
            for (String friendOfS : friendsOfS) {
                if (userFriend.contains(friendOfS)){
                    score+=10;
                }
            }
            scoreList.put(s,score);
        }

        for (String visitor : visitors) {
            if(scoreList.containsKey(visitor)){
                scoreList.put(visitor, scoreList.get(visitor) + 1);
            }
            else {
                scoreList.put(visitor, 1);
            }
        }

        List<PointAndName> tmpAnswer = new ArrayList<>();
        for (String name : scoreList.keySet()) {
            if (!userFriend.contains(name)){
                PointAndName pointAndName = new PointAndName(scoreList.get(name), name);
                tmpAnswer.add(pointAndName);
            }
        }

        tmpAnswer.sort(new PointAndNameCompare());
        if (tmpAnswer.size() >= 5){
            for(int i=0; i<5; i++){
                answer.add(tmpAnswer.get(i).getName());
            }
        }
        else {
            for (PointAndName pointAndName : tmpAnswer) {
                answer.add(pointAndName.getName());
            }
        }
        return answer;
    }

    public static class PointAndName{
        int point;
        String name;

        public PointAndName(int point, String name) {
            this.point = point;
            this.name = name;
        }

        public int getPoint() {
            return point;
        }
        public String getName() {
            return name;
        }
    }

    public static class PointAndNameCompare implements Comparator<PointAndName>{

        int result = 0;
        @Override
        public int compare(PointAndName o1, PointAndName o2) {

            if(o1.point < o2.point){
                result =  1;
            }

            if(o1.point == o2.point){
                if(o1.name.compareTo(o2.name) < 0){
                    result = -1;
                }
                else if(o1.name.compareTo(o2.name) == 0){
                    result = 0;
                }
                else if(o1.name.compareTo(o2.name) > 0){
                    result = 1;
                }
            }

            if(o1.point > o2.point){
                result = -1;
            }
            return result;
        }
    }

    private static void makeUserFriendList(String user, List<List<String>> friends, List<String> userFriend) {
        for (List<String> friend : friends) {
            String a = friend.get(0);
            String b = friend.get(1);

            if(a.equals(user)) userFriend.add(b);
            else if(b.equals(user)) userFriend.add(a);
        }
    }

    private static void addFriend(HashMap<String, List<String>> friendHash, String a, String b) {
        if(!friendHash.containsKey(a)){
            List<String> tmp = new ArrayList<>();
            tmp.add(b);
            friendHash.put(a, tmp);
        }
        else{
            friendHash.get(a).add(b);
        }
    }
}
