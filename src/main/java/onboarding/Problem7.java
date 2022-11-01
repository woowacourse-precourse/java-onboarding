package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> recomList =new ArrayList<>();
        List<String> userFriends = new ArrayList<>();
        List<Integer> recomScore = new ArrayList<Integer>();
        boolean flag = true;

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                String name = friends.get(i).get(j);
                if (!recomList.contains(name)) {
                    if(name == user) break;
                    recomList.add(name);
                }
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            String name = visitors.get(i);
            if(!recomList.contains(name)) {
                recomList.add(name);
            }
        }

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                if (friends.get(i).get(j) == user) {
                    if(!userFriends.contains(friends.get(i).get((j+1)%2))) {
                        userFriends.add(friends.get(i).get((j+1)%2));
                    }
                }
            }
        }

        for (int i = 0; i < userFriends.size(); i++) {
            recomList.remove(userFriends.get(i));
        }

        for (int i = 0; i < recomList.size(); i++) {
            recomScore.add(0);
        }

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < userFriends.size(); j++) {
                if (friends.get(i).get(0) == userFriends.get(j)) {
                    if (friends.get(i).get(1) == user) break;
                    int index = recomList.indexOf(friends.get(i).get(1));
                    recomScore.set(index, recomScore.get(index) + 10);
                }

                if (friends.get(i).get(1) == userFriends.get(j)) {
                    if (friends.get(i).get(0) == user) break;
                    int index = recomList.indexOf(friends.get(i).get(0));
                    recomScore.set(index, recomScore.get(index) + 10);
                }
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            if (recomList.contains(visitors.get(i))) {
                int index = recomList.indexOf(visitors.get(i));
                recomScore.set(index, recomScore.get(index) + 1);
            }
        }

        while (flag) {
            for (int i = 0; i < recomList.size()-1; i++) {
                if (recomScore.get(i) < recomScore.get(i+1)) {
                    Collections.swap(recomList, i, i+1);
                    Collections.swap(recomScore, i, i+1);
                }
            }

            for (int j = 0; j < recomScore.size()-1; j++) {
                flag = false;
                if (recomScore.get(j) < recomScore.get(j+1)) {
                    flag = true;
                    break;
                }
            }
        }

        flag = true;

        while (flag) {
            for (int i = 0; i < recomList.size()-1; i++) {
                if (recomScore.get(i) == recomScore.get(i+1)) {
                    String former = recomList.get(i);
                    String latter = recomList.get(i+1);
                    if (former.compareTo(latter) > 0) {
                        Collections.swap(recomList, i, i + 1);
                        System.out.println("recomList " + recomList);
                        System.out.println("recomScore " + recomScore);
                    }
                }
            }

            for (int i = 0; i < recomList.size()-1; i++) {
                if (recomScore.get(i) == recomScore.get(i+1)) {
                    String former = recomList.get(i);
                    String latter = recomList.get(i+1);
                    flag = false;
                    if (former.compareTo(latter) > 0) {
                        flag = true;
                        break;
                    }
                }
            }
        }

        if (recomList.size() < 5) answer = recomList;
        if (recomList.size() >= 5) answer = recomList.subList(0,5);

        return answer;
    }
}
