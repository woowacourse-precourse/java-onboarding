package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        //user 길이 1이상 30이하 문자열 확인
        if(user.length()<1 || user.length()>30)
            return null;
        //friends 길이 1이상 10,000 이하인  리스트/배열 확인
        if (friends.size()<1 || friends.size()>10000)
            return null;
        //visitors 길이 0이상 10,000 이하인 리스트/배열 확인
        if (visitors.size()<0 || visitors.size()>10000)
            return null;
        //사용자 아이디 알파벳 소문자로만 이뤄졌는지 확인
        //만약 대문자가 존재한다면 전부 소문자로 변환한 것과 달라 거짓이 나오게 된다.
        if (!user.toLowerCase().equals(user))
            return null;
        //기존 친구들만 따로 리스트에 저장
        ArrayList<String> oldFriends= (ArrayList<String>) getOldFriends(user, friends);
        //기존 친구들의 친구들의 점수 계산
        ArrayList<FriendScore> friendScores = new ArrayList<FriendScore>();

        for (int i=0; i<oldFriends.size(); i++){
            for (int j=0; j<friends.size();j++){
                if (friends.get(j).contains(user))
                    break;
                if (friends.get(j).contains(oldFriends.get(i))){
                    if (oldFriends.get(i).equals(friends.get(j).get(0))){
                        friendScores = (ArrayList<FriendScore>) updateScore(friendScores, friends.get(j).get(1),10);
                    } else{
                        friendScores = (ArrayList<FriendScore>) updateScore(friendScores, friends.get(j).get(0),10);
                    }
                }
            }
        }

        for (int i=0; i<visitors.size();i++){
            if (!visitors.get(i).equals(user) && !oldFriends.contains(visitors.get(i)))
                friendScores = (ArrayList<FriendScore>) updateScore(friendScores,visitors.get(i),1);
        }

        return answer;
    }

    public static List<String> getOldFriends(String user, List<List<String>> friends){
        ArrayList<String> oldFriends = new ArrayList<String>();

        for (int i=0; i<friends.size(); i++){
            if (friends.get(i).contains(user)){
                if (friends.get(i).get(0).equals(user))
                    oldFriends.add(friends.get(i).get(1));
                else
                    oldFriends.add(friends.get(i).get(0));
            }
        }
        return oldFriends;
    }

    public static List<FriendScore> updateScore(List<FriendScore> friendScores, String nickname, int scoreSize){
        if (friendScores.size()==0){
            FriendScore friendScore = new FriendScore(nickname,scoreSize);
            friendScores.add(friendScore);
            return friendScores;
        }

        for (int i =0; i<friendScores.size();i++){
            if (friendScores.get(i).getNickname()==nickname){
                int score = friendScores.get(i).getScore();
                score += scoreSize;
                friendScores.get(i).setScore(score);
                return friendScores;
            }
        }

        FriendScore friendScore = new FriendScore(nickname,scoreSize);
        friendScores.add(friendScore);
        return friendScores;
    }
}

class FriendScore {
    public int score;
    public String nickname;

    public FriendScore(String nickname, int score) {
        this.score = score;
        this.nickname = nickname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNickname() {
        return nickname;
    }
}

