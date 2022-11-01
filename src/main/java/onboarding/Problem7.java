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

        List<String> nonDupliUserWithFiend = new ArrayList<>();
        for(String item : userWithFriendArr){
            if(!nonDupliUserWithFiend.contains(item))
                nonDupliUserWithFiend.add(item);
        }

        for(int i=0; i<nonDupliUserWithFiend.size(); i++){
            nameArr.add(nonDupliUserWithFiend.get(i));
            int score=0;
            for(int j=0; j<userWithFriendArr.size(); j++){
                if(nonDupliUserWithFiend.get(i).equals(userWithFriendArr.get(j))){
                    score += 10;
                    friendScoreArr.add(score);
                }
            }
        }

        List<String> nonDupliVisitor = new ArrayList<>();
        for(String item: visitors){
            if(!nonDupliVisitor.contains(item)){
                nonDupliVisitor.add(item);
            }
        }

        for(int i=0; i<nonDupliVisitor.size(); i++){
            visitorArr.add(nonDupliVisitor.get(i));
            int score =0;
            for(int j=0; j<visitors.size(); j++){
                if(nonDupliVisitor.get(i).equals(visitors.get(j))){
                    score += 10;
                    visitScoreArr.add(score);
                }
            }
        }
        //합치기
        for(int i=0; i<nonDupliVisitor.size(); i++){
            nonDupliUserWithFiend.add(nonDupliVisitor.get(i));
            friendScoreArr.add(visitScoreArr.get(i));
        }

        for(int i=0; i<nonDupliUserWithFiend.size(); i++){
            for(int j=i+1; j<nonDupliUserWithFiend.size(); j++){
                if(nonDupliUserWithFiend.get(i).equals(nonDupliUserWithFiend.get(j))){
                    nonDupliUserWithFiend.remove(j);
                    Integer sum = friendScoreArr.get(i)+friendScoreArr.get(j);
                    friendScoreArr.set(i, sum);
                    friendScoreArr.remove(j);
                }
            }
        }

        for(int i=0; i< friendScoreArr.size(); i++){
            String str = Integer.toString(friendScoreArr.get(i));
            scoreStringArr.add(str);
        }

        nameScoreArr.add(nonDupliUserWithFiend);
        nameScoreArr.add(scoreStringArr);
        return nameScoreArr;
    }

    public static List<String> scoreOrderName(List<List<String>> nameScoreArr){
        List<String> nameArr = new ArrayList<>(nameScoreArr.get(0));
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

                    String strTmp = nameArr.get(i);
                    nameArr.set(i, nameArr.get(j));
                    nameArr.set(i, strTmp);
                }
            }
        }

        //nameArr 오름차순 정렬
        Collections.sort(nameArr);
        return nameArr;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriend = userFriends(user, friends);
        List<String> userWithFriendArr = userWithFriend(user, friends, userFriend);
        List<List<String>> nameScoreArr = nameScoreSave(userWithFriendArr, visitors);

        List<String> answer = scoreOrderName(nameScoreArr);
        return answer;
    }
}
