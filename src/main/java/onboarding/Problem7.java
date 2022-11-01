package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    public static List<String> userFriends(String user, List<List<String>> friends){
        List<String> userFriendArr = new ArrayList<>();
        for(int i=0; i<friends.size(); i++){
            if(friends.get(i).get(0).equals(user)){
                userFriendArr.add(friends.get(i).get(1));
            } else if (friends.get(i).get(1).equals(user)) {
                userFriendArr.add(friends.get(i).get(0));
            }
        }
        //중복제거
        HashSet<String> hashSet = new HashSet<>();
        for(String item : userFriendArr){
            hashSet.add(item);
        }
        ArrayList<String> finalUserFriend = new ArrayList<>(hashSet);

        return finalUserFriend;
    }

    public static List<String> userWithFriend(String user, List<List<String>> friends,List<String> userFriend){
        List<String> userWithFriendsArr = new ArrayList<>();
        for(int i=0; i<userFriend.size(); i++){
            for(int j=0; j<friends.size(); j++){
                if(userFriend.get(i).equals(friends.get(j).get(0))){
                    userWithFriendsArr.add(friends.get(j).get(1));
                } else if (userFriend.get(i).equals(friends.get(j).get(1))) {
                    userWithFriendsArr.add(friends.get(j).get(0));
                }
            }
        }

        for(int i=0; i<userWithFriendsArr.size(); i++){
            if(userWithFriendsArr.get(i).equals(user)){
                userWithFriendsArr.remove(i);
            }
        }

        return userWithFriendsArr;
    }

    public  static List<List<String>> nameScoreSave(List<String> userWithFriendArr, List<String> visitors){
        List<String> nameArr = new ArrayList<>();
        List<String> visitorArr = new ArrayList<>();
        List<Integer> friendScoreArr = new ArrayList<>();
        List<Integer> visitScoreArr = new ArrayList<>();
        List<String> scoreStringArr = new ArrayList<>();
        List<List<String>> nameScoreArr = new ArrayList<>();

        for(String item : userWithFriendArr){
            if(!nameArr.contains(item))
                nameArr.add(item);
        }

        for(int i=0; i<nameArr.size(); i++) {
            int friendScore = 0;
            for (int j = 0; j < userWithFriendArr.size(); j++) {
                if (nameArr.get(i).equals(userWithFriendArr.get(j))) {
                    friendScore += 10;
                    friendScoreArr.add(friendScore);
                }
            }
        }



        for(String item: visitors){
            if(!visitorArr.contains(item)){
                visitorArr.add(item);
            }
        }

        for(int k=0; k<visitorArr.size(); k++){
            int visitorScore =0;
            for(int j=0; j<visitors.size(); j++){
                if(visitorArr.get(k).equals(visitors.get(j))){
                    visitorScore += 10;
                    visitScoreArr.add(visitorScore);
                }
            }
        }
        //합치기
        for(int l=0; l<visitorArr.size(); l++){
            nameArr.add(visitorArr.get(l));
            friendScoreArr.add(visitScoreArr.get(l));
        }

        for(int m=0; m<nameArr.size(); m++){
            for(int j=m+1; j<nameArr.size()-m; j++){
                if(nameArr.get(m).equals(nameArr.get(j))){
                    nameArr.remove(j);
                    Integer sum = friendScoreArr.get(m)+friendScoreArr.get(j);
                    friendScoreArr.set(m, sum);
                    friendScoreArr.remove(j);
                }
            }
        }

        for(int n=0; n< friendScoreArr.size(); n++){
            String str = Integer.toString(friendScoreArr.get(n));
            scoreStringArr.add(str);
        }

        nameScoreArr.add(nameArr);
        nameScoreArr.add(scoreStringArr);
        return nameScoreArr;
        }

    public static List<String> scoreOrderName(List<List<String>> nameScoreArr){
        List<String> newNameArr = new ArrayList<>(nameScoreArr.get(0));
        List<Integer> scoreArr = new ArrayList<>();
        for(int i=0; i<nameScoreArr.get(1).size(); i++){
            scoreArr.add(Integer.parseInt(nameScoreArr.get(1).get(i)));
        }
        //내림차순
        for(int i=0; i<scoreArr.size(); i++) {
            for(int j=i+1; j<scoreArr.size(); j++) {
                if(scoreArr.get(i) <= scoreArr.get(j)) {
                    Integer tmp = scoreArr.get(i);
                    scoreArr.set(i, scoreArr.get(j));
                    scoreArr.set(j, tmp);

                    String strTmp = newNameArr.get(i);
                    newNameArr.set(i, newNameArr.get(j));
                    newNameArr.set(i, strTmp);
                }
            }
        }

        //nameArr 오름차순 정렬
        Collections.sort(newNameArr);
        return newNameArr;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriend = userFriends(user, friends);
        List<String> userWithFriendArr = userWithFriend(user, friends, userFriend);
        List<List<String>> nameScoreArr = nameScoreSave(userWithFriendArr, visitors);

        List<String> answer = scoreOrderName(nameScoreArr);
        return answer;
    }

    public static void main(String[] args){
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
        System.out.println("userFriends");
        System.out.println(userFriends(user,friends));
        List<String> userFriend = userFriends(user,friends);
        System.out.println("userWithFriends");
        System.out.println(userWithFriend(user,friends,userFriend));
        List<String> userWithFriend = userWithFriend(user,friends,userFriend);
    }
}
