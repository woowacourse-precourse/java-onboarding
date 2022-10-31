package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        List<String> acquaintance;
        List<String> friends_list;
        List<String> visitors_list;

        acquaintance = users_friend(user, friends);
        friends_list = find_friend(user, acquaintance, friends);
        visitors_list = delete_friend(acquaintance, visitors);
        answer = Suggest_friend(friends_list, visitors_list);

        return answer;
    }

    private static List<String> users_friend(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.get(0).contains(user)) result.add(friend.get(1));
            else if (friend.get(1).contains(user)) result.add(friend.get(0));
        }

        return result;
    }

    private static List<String> find_friend(String user, List<String> acquaintance, List<List<String>> friends) {
        List<String> result = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.get(0).contains(acquaintance.get(0))) result.add(friend.get(1));
            else if (friend.get(0).contains(acquaintance.get(1))) result.add(friend.get(1));
            else if (friend.get(1).contains(acquaintance.get(0))) result.add(friend.get(0));
            else if (friend.get(1).contains(acquaintance.get(1))) result.add(friend.get(0));
        }

        while (result.remove(String.valueOf(user))) {}

        return result;
    }

    private static List<String> delete_friend(List<String> acquaintance, List<String> visitors) {
        List<String> result = new ArrayList<>(visitors);
        for (String s : acquaintance) {
            while (result.remove(String.valueOf(s))) {
            }
        }

        return result;
    }

    private static List<String> Suggest_friend(List<String> suggestion_friend, List<String> visitors_list) {
        List<String> result;
        List<String> name_list = new ArrayList<>();
        List<Integer> score_list = new ArrayList<>();
        Integer friend_score = 10;
        Integer visitor_score = 1;

        name_list.addAll(suggestion_friend);
        name_list.addAll(visitors_list);

        HashSet<String> tmp = new HashSet<>(name_list);
        name_list = new ArrayList<>(tmp);

        for(int i=0; i<name_list.size(); i++){
            score_list.add(0);
        }

        for (String s : suggestion_friend) {
            add_list(name_list, score_list, s, friend_score);
        }

        for (String s : visitors_list) {
            add_list(name_list, score_list, s, visitor_score);
        }

        result = score_result(name_list, score_list);

        return result;
    }

    private static void add_list(List<String> name_list, List<Integer> score_list, String name, Integer score) {
        for(int i=0; i<name_list.size(); i++){
            if(Objects.equals(name_list.get(i), name)) score_plus(score_list, score, i);
        }
    }

    private static void score_plus(List<Integer> score_list, Integer score, Integer index) {
        Integer exist_score = score_list.get(index);
        score_list.set(index, exist_score+score);
    }

    private static List<String> score_result(List<String> name_list, List<Integer> score_list) {
        List<String> result = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        int prev_max = 0, max, index, size;

        size = score_list.size();

        for(int i=0; i<size; i++){
            max = Collections.max(score_list);
            index = score_list.indexOf(max);
            if(prev_max == max){
                tmp.add(name_list.get(index));
                tmp.sort(String.CASE_INSENSITIVE_ORDER);
            }
            else{
                result.addAll(tmp);
                result.add(name_list.get(index));
            }
            name_list.remove(String.valueOf(name_list.get(index)));
            score_list.remove(score_list.get(index));
            prev_max = max;
        }

        HashSet<String> temp = new HashSet<>(result);
        result = new ArrayList<>(temp);

        return result;
    }
}
