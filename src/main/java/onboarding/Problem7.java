package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashSet<String> names = new HashSet<>();
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        HashMap<String, Integer> ScoreMap = new HashMap<>();
        ArrayList<String> temp = new ArrayList<>();
        String name;

        for(int i=0;i<friends.size();i++){
            names.add(friends.get(i).get((0)));
            names.add(friends.get(i).get((1)));
        }
        List<String> name_list = new ArrayList<String>(names);
        System.out.println(name_list);

        for(int i=0;i<name_list.size();i++){            // graph 관계 만들기
            name = name_list.get(i);
            for(int j=0;j< friends.size();j++){
                if(name.equals(friends.get(j).get(0))){
                    temp.add(friends.get(j).get(1));
                }
                if(name.equals(friends.get(j).get(1))){
                    temp.add(friends.get(j).get(0));
                }
            }
            graph.put(name_list.get(i),returnFriends(temp));
            temp.clear();
        }

        Set<String> visits = new HashSet<>(visitors);
        List<String> VISITS = new ArrayList<>(visits);
        for(String key : graph.keySet()){
            ScoreMap.put(key, 0);
        }
        for(int i=0; i<VISITS.size();i++){
            ScoreMap.put(VISITS.get(i), 0);
        }


        ArrayList<String> UserFriends = new ArrayList<>(graph.get(user));

        ArrayList<String> Exceptions = new ArrayList<>(graph.get(user));
        Exceptions.add(user);

        ArrayList<String> ffriends = new ArrayList<>();
        String person;
        for(int i=0;i<UserFriends.size();i++){
            ffriends = graph.get(UserFriends.get(i));
            for(int j=0; j< ffriends.size();j++){
                person = ffriends.get(j);
                if(Exceptions.contains(person) || person.equals(user)) continue;
                ScoreMap.put(person, ScoreMap.get(person) + 10);
            }
        }
        for(int i=0; i<visitors.size();i++){
            person = visitors.get(i);
            if(Exceptions.contains(person) || person.equals(user)) continue;
            ScoreMap.put(person, ScoreMap.get(person) +1);
        }

        ArrayList<String> removal = new ArrayList<>();

        for(String key : ScoreMap.keySet()){
            if(ScoreMap.get(key) != 0) continue;
            removal.add(key);
        }
        for(int i=0;i< removal.size();i++){
            ScoreMap.remove(removal.get(i));
        }


        ArrayList<String> answer = new ArrayList<>();
        ArrayList<Map.Entry<String, Integer>> entryList = new ArrayList<>(ScoreMap.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for(Map.Entry<String, Integer> entry : entryList){
            answer.add(entry.getKey());
        }

       return answer;
    }
    public static ArrayList<String> returnFriends(ArrayList<String> list){
        ArrayList<String> arr = new ArrayList<>(list);
        return arr;
    }
}
