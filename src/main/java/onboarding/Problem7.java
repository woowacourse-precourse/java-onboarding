package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Comparator;



public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        ArrayList<String> userfriends = new ArrayList<>();
        ArrayList<List<String>> drop = new ArrayList<>();
        ArrayList<List<String>> friends2 = new ArrayList<>();
        for (int i = 0; i<friends.size(); i++) {
            ArrayList<String> data = new ArrayList<>(friends.get(i));
            ArrayList<String> data2 = (ArrayList<String>) data.clone();
            friends2.add(data2);
            if (data.contains(user)) {
                drop.add(data2);
                data.remove(data.indexOf(user));
                userfriends.add(data.get(0));

            }
        }

        for (int i = 0; i<drop.size(); i++){
            friends2.remove(drop.get(i));
        }

        ArrayList<String> ten_member = new ArrayList<>();
        ArrayList<Integer> ten_score = new ArrayList<>();
        for (int i = 0; i<userfriends.size(); i++){
            for (int j = 0; j<friends2.size(); j++) {
                ArrayList<String> data = new ArrayList<>(friends2.get(j));
                if (data.contains(userfriends.get(i))){
                    data.remove(data.indexOf(userfriends.get(i)));
                    if (ten_member.contains(data.get(0))) {
                        ten_score.set(ten_member.indexOf(data.get(0)), ten_score.get(ten_member.indexOf(data.get(0))) + 10);
                    } else{
                        ten_member.add(data.get(0));
                        ten_score.add(10);
                    }
                }
            }
        }

        ArrayList<String> one_member = new ArrayList<>();
        ArrayList<Integer> one_score = new ArrayList<>();
        for (int i = 0; i< visitors.size(); i++) {
            if (one_member.contains(visitors.get(i))){
                one_score.set(one_member.indexOf(visitors.get(i)), one_score.get(one_member.indexOf(visitors.get(i))) + 1);
            } else {
                one_member.add(visitors.get(i));
                one_score.add(1);
            }
        }
        for (int i = 0; i<userfriends.size(); i++){
            one_score.remove(one_member.indexOf(userfriends.get(i)));
            one_member.remove(userfriends.get(i));
        }


        ArrayList<String> drop2 = new ArrayList<>();
        for (int i = 0; i<one_member.size(); i++){
            if (ten_member.contains(one_member.get(i))) {
                ten_score.set(ten_member.indexOf(one_member.get(i)), ten_score.get(ten_member.indexOf(one_member.get(i))) + one_score.get(i));
                drop2.add(one_member.get(i));
            }
        }
        for (int i = 0; i<drop2.size(); i++){
            one_score.remove(one_member.indexOf(drop2.get(i)));
            one_member.remove(drop2.get(i));
        }

        ArrayList<String> joined_member = new ArrayList<>();
        joined_member.addAll(ten_member);
        joined_member.addAll(one_member);
        ArrayList<Integer> joined_score = new ArrayList<>();
        joined_score.addAll(ten_score);
        joined_score.addAll(one_score);

        Map<String, Integer> testMap = new HashMap<String, Integer>();

        for (int i = 0; i< joined_score.size(); i++){
            testMap.put(joined_member.get(i), joined_score.get(i));
        }

        List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(testMap.entrySet());
        Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
            {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        ArrayList<String> order = new ArrayList<>();
        for(Entry<String, Integer> entry : list_entries) {
            order.add(entry.getKey());
        }
        ArrayList<String> answer = new ArrayList<>();
        if (order.size() >= 5) {
            for (int i = 0; i<5; i++){
                answer.add(order.get(i));
            }
        } else {
            answer = order;
        }
        return answer;
    }
}
