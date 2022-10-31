package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = recommendList(user, friends, visitors);
        return answer;
    }
    private static Set<String> findUserFriend(String user, List<List<String>> friends) {
        Set<String> friend = new HashSet<>();
        for(int index=0;index<friends.size();index++){
            String leftPerson = friends.get(index).get(0);
            String rightPerson = friends.get(index).get(1);
            if(leftPerson.equals(user))friend.add(rightPerson);
            if(rightPerson.equals(user))friend.add(leftPerson);
        }
        return friend;
    }
    private static Map<String, Integer> withUserFriend(String user, List<List<String>> friends, List<String> visitors) {
        Map<String,Integer> friendRecommend = new HashMap<>();
        Set<String> userFriend = findUserFriend(user, friends);
        for(int index=0;index<friends.size();index++){
            String leftPerson = friends.get(index).get(0);
            String rightPerson = friends.get(index).get(1);
            if(isAlreadyFriend(leftPerson,userFriend)&&!isAlreadyFriend(rightPerson,userFriend))friendRecommend.put(rightPerson,friendRecommend.getOrDefault(rightPerson,0)+10);
            if(isAlreadyFriend(rightPerson,userFriend)&&!isAlreadyFriend(leftPerson,userFriend))friendRecommend.put(leftPerson,friendRecommend.getOrDefault(leftPerson,0)+10);
        }
        visitorFindRecommend(visitors,friendRecommend,userFriend);
        return friendRecommend;
    }
    private static boolean isAlreadyFriend(String person, Set<String> userFriend) {
        if(userFriend.contains(person))return true;
        else return false;
    }
    private static void visitorFindRecommend(List<String> visitors, Map<String, Integer> friendRecommend, Set<String> userFriend) {
        for(int index=0;index<visitors.size();index++){
            String visitor = visitors.get(index);
            if(!isAlreadyFriend(visitor, userFriend))friendRecommend.put(visitor,friendRecommend.getOrDefault(visitor,0)+1);
        }
    }
    static class Person implements Comparable<Person>{
        private String name;
        private int score;
        public String getName(){return name;};
        public Person(String name, int score){
            this.name= name;
            this.score=score;
        }
        @Override
        public int compareTo(Person o) {
            if(o.score == this.score)return this.name.compareTo(o.name);
            else return o.score -  this.score;
        }
    }
    private static List<Person> MapToListAndSort(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> friendRecommend = withUserFriend(user, friends, visitors);
        List<Person> classList = new ArrayList<>();
        for(String key : friendRecommend.keySet()) {
            if(!key.equals(user))classList.add(new Person(key, friendRecommend.get(key)));
        }
        Collections.sort(classList);
        return classList;
    }

    private static List<String> recommendList(String user, List<List<String>> friends, List<String> visitors) {
        List<Person> sortList = MapToListAndSort(user, friends, visitors);
        List<String> recommend = new ArrayList<>();
        int listMax = sortList.size();
        if(listMax>=5)listMax=5;
        for(int index=0;index<listMax;index++)recommend.add(sortList.get(index).getName());
        return recommend;
    }
}
