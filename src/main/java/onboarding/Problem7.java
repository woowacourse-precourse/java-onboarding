package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> myfriend = new ArrayList<String>();
        List<String> friendsfriend = new ArrayList<String>();
        List<String> visitors_name = new ArrayList<String>();


        myfriend = find_friend(friends);
        myfriend = List_set_List(myfriend);
        friendsfriend = finds_friend(friends);
        friendsfriend = List_set_List(friendsfriend);
        //친구의 친구에서 user 제거
        friendsfriend.remove(user);
        visitors_name = List_set_List(visitors);

        Score score[] = new Score[friendsfriend.size() + visitors_name.size()];
        for (int i = 0; i < friendsfriend.size() + visitors_name.size(); i++) {
            score[i] = new Score();
        }

        for (int i = 0; i < myfriend.size(); i++) {
            visitors_name.remove(myfriend.get(i));
        }

        // 친구가 될수있는 score
        int count = 0;
        for (int i = 0; i < friendsfriend.size(); i++, count++) {
            score[count].name = friendsfriend.get(i);
            score[count].name_score += 10;
        }
        for (int i = 0; i < visitors_name.size(); i++, count++) {
            score[count].name = visitors_name.get(i);
            score[count].name_score += 1;
        }

        // 점수가 높은 순서대로 answer에 add
        for (int i = 0; i < score.length; i++, count++) {
            int tempscore = 0;
            int biggest = 0;
            if (score[i].name_score > tempscore) {
                tempscore = score[i].name_score;
                if (score[i].name_score != 0)
                    answer.add(score[i].name);
                score[i].name_score = 0;

            }

        }
        
        return answer;
    }

    static class Score {
        String name = "";
        int name_score = 0;
    }
    // 친구 list 반환
    public static List<String> find_friend(List<List<String>> friends) {
        List<String> friend = new ArrayList<String>();
        for (int i = 0; i < friends.size(); i++) {
            friend.add(friends.get(i).get(0));
        }
        return friend;
    }

    // 친구의 친구 list 반환
    public static List<String> finds_friend(List<List<String>> friends) {
        List<String> friend = new ArrayList<String>();
        for (int i = 0; i < friends.size(); i++) {
            friend.add(friends.get(i).get(1));
        }
        return friend;
    }
    // 중복제거
    public static List<String> List_set_List(List<String> SList) {
        HashSet<String> distinct = new HashSet<String>(SList);
        List<String> return_list = new ArrayList<String>(distinct);

        return return_list;
    }
}
