package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> non_friend = new ArrayList<>();
        List<Integer> score = new ArrayList<>();
        List<String> friend = new ArrayList<>();
        for(int i = 0; i < friends.size(); i++){
            if(friends.get(i).get(0).equals(user)){
                friend.add(friends.get(i).get(1));
            }
            else if(friends.get(i).get(1).equals(user)){
                friend.add(friends.get(i).get(0));
            }
        }
        for(int k = 0; k < friend.size(); k++){
            for(int i = 0; i < friends.size(); i++) {
                if(!friends.get(i).get(0).equals(user) && !friends.get(i).get(1).equals(user)){
                    if(friends.get(i).get(0).equals(friend.get(k))){
                        //String
                        if(!non_friend.contains(friends.get(i).get(1))) {
                            non_friend.add(friends.get(i).get(1));
                            score.add(10);
                        }
                        else{
                            int idx = non_friend.indexOf(friends.get(i).get(1));
                            score.set(idx, score.get(idx)+10);
                        }
                    }
                    else if(friends.get(i).get(1).equals(friend.get(k)) && !non_friend.contains(friends.get(i).get(0))){
                        non_friend.add(friends.get(i).get(0));
                    }
                }
            }
        }
        for(int i = 0; i < visitors.size(); i++){
            if(!friend.contains(visitors.get(i))){
                    if(!non_friend.contains(visitors.get(i))) {
                        non_friend.add(visitors.get(i));
                        score.add(1);
                    }
                    else{
                        int idx = non_friend.indexOf(visitors.get(i));
                        score.set(idx, score.get(idx)+1);
                    }
            }
        }
        while(true){
            boolean ch = true;
            for(int i = 0; i < score.size() - 1; i++) {
                if (score.get(i) < score.get(i + 1)) {
                    ch = false;
                    String tmp = non_friend.get(i);
                    int tmp2 = score.get(i);
                    non_friend.set(i, non_friend.get(i + 1));
                    score.set(i, score.get(i + 1));
                    non_friend.set(i + 1, tmp);
                    score.set(i + 1, tmp2);
                } else if (score.get(i) == score.get(i + 1)) {
                    //List<String> tmp = List.of(non_friend.get(i), non_friend.get(i + 1));
                    List<String> tmp = new ArrayList<>();
                    tmp.add(non_friend.get(i));
                    tmp.add(non_friend.get(i + 1));
                    List<String> tmp2 = tmp;
                    Collections.sort(tmp);
                    if (tmp.get(0) != tmp2.get(0)) {
                        ch = false;
                        String tmp3 = non_friend.get(i);
                        int tmp4 = score.get(i);
                        non_friend.set(i, non_friend.get(i + 1));
                        score.set(i, score.get(i + 1));
                        non_friend.set(i + 1, tmp3);
                        score.set(i + 1, tmp4);
                    }
                }
            }
            if (ch) {
                break;
            }
        }
        //List<String> answer = Collections.emptyList();
        return non_friend;
    }
}
