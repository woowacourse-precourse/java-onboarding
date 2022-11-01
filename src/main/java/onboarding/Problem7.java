package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Set<String> friends_list10 = new HashSet<>();
        Set<String> friends_list1 = new HashSet<>();
        Set<String> friends_list = new HashSet<>();
        Set<String> final_friends_set = new HashSet<>();
        List<Integer> score = new ArrayList<>();
        List<String> answer1 = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++){
            for (int a = 0; a < 2; a++){
                friends_list.add(friends.get(i).get(a));
            }//for2
        }//for

        for (int i = 0; i < visitors.size(); i++) {
            if (!friends_list.contains(visitors.get(i))){
                friends_list1.add(visitors.get(i));
            }//if
        }//for

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)){
                for (int a = 0; a < 2; a++) {
                    if (friends.get(i).get(a) != user) {
                        for (int b = 0; b < friends.size(); b++) {
                            if (friends.get(b).contains(friends.get(i).get(a))){
                                int friend_index = friends.get(b).indexOf(friends.get(i).get(a));
                                if (friend_index == 1){
                                    int new_friend_index = 0;
                                    friends_list10.add(friends.get(b).get(new_friend_index));
                                } else {
                                    int new_friend_index = 1;
                                    friends_list10.add(friends.get(b).get(new_friend_index));
                                }//if4
                            }//if3
                        }//for3
                    }//if2
                }//for2
            }//if1
        }//for1

        friends_list.remove(user);
        friends_list10.remove(user);
        final_friends_set.addAll(friends_list1);
        final_friends_set.addAll(friends_list10);
        List<String> final_friends_list = new ArrayList<>(final_friends_set);

        for (int i = 0; i < final_friends_list.size(); i++) {
            int count = 0;
            if (friends_list10.contains(final_friends_list.get(i))) {
                count += 10;
            }//if
            if (friends_list1.contains(final_friends_list.get(i))) {
                count += Collections.frequency(visitors, final_friends_list.get(i));
            }//if
            score.add(count);
        }//for

        for (int i = 0; i < 5; i++) {
            if (score.size() == 0 || Collections.max(score) == 0){
                break;
            }//if
            int max_index = score.indexOf(Collections.max(score));
            answer1.add(final_friends_list.get(max_index));
            final_friends_list.remove(max_index);
            score.remove(max_index);
        }//for
        answer = new ArrayList<>(answer1);
        return answer;
    }
}
