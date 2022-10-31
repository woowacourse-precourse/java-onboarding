package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userFriends = findUserFriends(user, friends);

        List<Person> friendList = findRecommendationFromFriends(user, friends, userFriends);
        List<Person> visitorList = findRecommendationFromVisitors(visitors, userFriends);
        List<Person> combineList = combineList(friendList, visitorList);
        answer = sortList(combineList);
        return answer;
    }

    private static List<String> findUserFriends(String user, List<List<String>> friends){
        List<String> list = new ArrayList<>();
        for(List<String> item : friends){
            if(item.contains(user))
                list.add(item.get(1 - item.indexOf(user)));
        }
        return list.stream().distinct().collect(Collectors.toList());
    }
    private static List<Person> findRecommendationFromFriends(String user, List<List<String>> friends, List<String> userFriends){
        List<String> list = new ArrayList<>();
        for(List<String> item : friends){
            if(userFriends.contains(item.get(0)) && !item.get(1).equals(user))
                list.add(item.get(1));
            else if(userFriends.contains(item.get(1)) && !item.get(0).equals(user))
                list.add(item.get(0));
        }
        return calculateScore(list, 10);
    }

    private static List<Person> findRecommendationFromVisitors(List<String> visitors, List<String> userFriends){
        List<String> list = new ArrayList<>();
        for(String item : visitors){
            if(!userFriends.contains(item))
                list.add(item);
        }
        return calculateScore(list, 1);
    }

    private static List<Person> calculateScore(List<String> persons, int score){
        List<Person> list = new ArrayList<>();
        for(String item : persons.stream().distinct().collect(Collectors.toList())){
            int frequency = Collections.frequency(persons, item);
            list.add(new Person(item, frequency* score));
        }
        return list;
    }

    private static List<Person> combineList(List<Person> friendList, List<Person> visitorList){
        List<Person> combineList = new ArrayList<>();
        combineList.addAll(friendList);
        combineList.addAll(visitorList);
        return combineList;
    }

    private static List<String> sortList(List<Person> list){
        Collections.sort(list, new PersonComparator().reversed());
        List<String> sortList = new ArrayList<>();
        int count =1;
        for(Person person : list){
            if(count <= 5){
                count++;
                sortList.add(person.name);
            }
        }

        return sortList;
    }

    static class PersonComparator implements Comparator<Person>{
        @Override
        public int compare(Person p1, Person p2){
            if(p1.score == p2.score){
                return p2.name.compareTo(p1.name);
            }
            if(p1.score > p2.score)
                return 1;
            if(p1.score < p2.score)
                return -1;
            return 0;
        }
    }

    static class Person{
        String name;
        int score;

        public Person(String name, int score){
            this.name = name;
            this.score = score;
        }
    }
}
