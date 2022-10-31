package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList();
        List<String> user_friends = new ArrayList();
        List<String> recommend_friends = new ArrayList();


        int len = friends.size();
        for (int i = 0; i < len; i++){
            if (friends.get(i).get(0) == user) {
                if (!user_friends.contains(friends.get(i).get(1))){
                    user_friends.add(friends.get(i).get(1)); 
                } 
            }
            else if (friends.get(i).get(1) == user) {
                if (!user_friends.contains(friends.get(i).get(0))){
                    user_friends.add(friends.get(i).get(0)); 
                }
            }
        }

        for (int i = 0; i < len; i++) {
            String le = friends.get(i).get(0);
            String ri = friends.get(i).get(1);

            if (le != user && ri != user){
                if (user_friends.contains(le)){
                    if (!recommend_friends.contains(ri)){
                        recommend_friends.add(ri);
                    }
                }
                else if (user_friends.contains(ri)){
                    if (!recommend_friends.contains(le)){
                        recommend_friends.add(le);
                    }
                }
            }
        }

        for (int i = 0; i < visitors.size(); i++){
            String v = visitors.get(i);

            if (!user_friends.contains(v)){
                if (!recommend_friends.contains(v)){
                    recommend_friends.add(v);
                }
            }
        }
        Collections.sort(recommend_friends);
 
        int size = recommend_friends.size();
        List<Integer> val = new ArrayList<Integer>(size);

        for (int i = 0; i < size; i++){
            String current = recommend_friends.get(i);
            int flag = 0;

            for (int j = 0; j < len; j++){
                String le = friends.get(j).get(0);
                String ri = friends.get(j).get(1);

                if (le == current){
                    if (user_friends.contains(ri)){
                        flag = 1;
                        break;
                    }
                }
                else if (ri == current){
                    if (user_friends.contains(le)){
                        flag = 1;
                        break;
                    }
                }
            }

            if (flag == 1)
                val.add(10);
            else
                val.add(0);

            for (int j = 0; j < visitors.size(); j++){
                if (current == visitors.get(j)){
                    int tmp = val.get(i);
                    val.remove(i);
                    val.add(i, tmp + 1);
                }
            }
        }
        
        for (int j = 0; j < 5; j ++){
            int max = 0;
            int index = -1;
            for (int i = 0; i < size; i++){
                if (max < val.get(i)){
                    max = val.get(i);
                    index = i;
                }
            }
            if (max != 0){
                answer.add(recommend_friends.get(index));
                val.remove(index);
                val.add(index, 0);
            }
            else break;
        }
        
        return answer;
    }
}
