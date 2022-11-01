package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Problem7 P = new Problem7();
        List<String> following = P.checkFriend(user, friends);
        List<People> userScore = new ArrayList<>();

        for(List list : friends) {
            if(P.checkNeighbor(list, following, user)){
                if(userScore.size()==0){
                    userScore.add(new People(String.valueOf(list.get(1)),10));
                }else {
                    boolean already = false;
                    for (People p : userScore) {
                        if (p.name == list.get(1)) {
                            p.score += 10;
                            already = true;
                            break;
                        }
                    }
                    if(!already){
                        userScore.add(new People(String.valueOf(list.get(1)), 10));
                    }
                }
            }
        }

        for(String name : visitors){
            boolean isFriend = false;
            for(String s : following){
                if(s==name) {
                    isFriend = true;
                    break;
                }
            }
            if(!isFriend){
                boolean already = false;
                for(People p : userScore) {
                    if(p.name == name){
                        p.score += 1;
                        already = true;
                        break;
                    }
                }
                if(!already){
                    userScore.add(new People(name,1));
                }
            }
        }

        Collections.sort(userScore);
        if(userScore.size()>5){
            for(int i = 0; i<5; i++){
                answer.add(userScore.get(i).name);
            }
        }else{
            for(People p : userScore){
                answer.add(p.name);
            }
        }
        return answer;
    }

    // user와 이미 친구인 list를 반환하는 메서드
    public List<String> checkFriend (String user, List<List<String>> friends) {
        List<String> following = new ArrayList<>();
        for(List l : friends) {
            if(l.contains(user)){
                following.add(String.valueOf(l.get(0)));
            }
        }
        return following;
    }

    // 함께 아는 친구인지 확인하는 메서드
    public boolean checkNeighbor (List<String> friends, List<String> following, String user) {
        boolean check = false;
        if(friends.contains(user)) return false;
        for(String s : following){
            if(friends.contains(s)){
                check = true;
            }
        }
        return check;
    }
}

// 사용자별 추천 점수를 저장하는 클래스
class People implements Comparable<People>{
    String name;
    int score;
    People(String name, int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(People p){
        return p.score - this.score;
    }
}
