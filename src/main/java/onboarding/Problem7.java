package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Comparator;


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Problem7 problem = new Problem7();

        HashMap<String, Integer> listpeople;
        ArrayList<String> userfriendslist;
        ArrayList<String> friendfrinedlist;

        listpeople = problem.extractPeople(user, friends, visitors);
        userfriendslist = problem.extractUserFriend(user, friends);

        for(int i=0; i< userfriendslist.size(); i++) {
            listpeople.remove(userfriendslist.get(i));
        }

        friendfrinedlist = problem.extractFriendFriend(userfriendslist, friends);
        while(friendfrinedlist.remove("") || friendfrinedlist.remove(user)){};

        for(int i=0; i<friendfrinedlist.size(); i++) {
            if(listpeople.containsKey(friendfrinedlist.get(i))) {
                listpeople.put(friendfrinedlist.get(i), listpeople.get(friendfrinedlist.get(i)) + 10);
            }
        }

        for(String e : visitors) {
            if(listpeople.containsKey(e)) {
                listpeople.put(e, listpeople.get(e) + 1);
            }
        }

        ArrayList<PointPair> resultlist = new ArrayList<>();

        listpeople.forEach((key, value) -> {
            resultlist.add(new PointPair(key, value));
        });

        Collections.sort(resultlist, new NameComparator());
        Collections.sort(resultlist, new pointComparator().reversed());

        for(int i=0; i<resultlist.size(); i++) {
            if(resultlist.get(i).point == 0) {
                break;
            }

            if(i == 5) {
                break;
            }

            answer.add(resultlist.get(i).name);
        }

        return answer;
    }

    public HashMap<String, Integer> extractPeople(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> result = new HashMap<>();

        for(List e : friends) {
            for(Object s : e) {
                result.put((String) s, 0);
            }
        }

        for(String e : visitors) {
            result.put(e, 0);
        }

        result.remove(user);

        return result;
    }

    public ArrayList<String> extractUserFriend(String user, List<List<String>> friends) {
        HashSet<String> resulthash = new HashSet<>();
        ArrayList<String> resultarray;

        for(List e : friends) {
            if(e.contains(user)) {
                resulthash.add((String) e.get(0));
                resulthash.add((String) e.get(1));
            }
        }

        resulthash.remove(user);
        resultarray = new ArrayList<>(resulthash);

        return resultarray;
    }

    public ArrayList<String> extractFriendFriend(ArrayList<String> name, List<List<String>> friends) {
        Problem7 problem = new Problem7();
        ArrayList<String> resultarray = new ArrayList<>();

        for(int i=0; i<name.size(); i++) {
            for(List e : friends) {
                resultarray.add(problem.friendfriendlist(e, name.get(i)));
            }
        }

        return resultarray;
    }

    public String friendfriendlist(List list, String name) {
        String result = "";

        if(list.contains(name)) {
            if(list.get(0).equals(name) == false) {
                result = (String) list.get(0);
            }

            if(list.get(1).equals(name) == false) {
                result = (String) list.get(1);
            }
        }

        return result;
    }

}

class PointPair {
    String name;
    Integer point;

    PointPair(String name, int point){
        this.name = name;
        this.point = point;
    }
}

class NameComparator implements Comparator<PointPair> {
    public int compare(PointPair o1, PointPair o2) {
        return o1.name.compareTo(o2.name);
    }
}

class pointComparator implements Comparator<PointPair> {
    public int compare(PointPair o1, PointPair o2) {
        return o1.point.compareTo(o2.point);
    }
}