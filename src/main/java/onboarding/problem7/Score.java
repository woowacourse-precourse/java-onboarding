package onboarding.problem7;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Score {

    public HashMap<String, Person> makeScoreMap(String user, List<List<String>> friends, List<String> visitors){
        HashMap<String, Person> map = new HashMap<>();
        map.put(user, new Person(user));
        for(List<String> friend : friends){

            String name1 = friend.get(0);
            String name2 = friend.get(1);

            if(!map.containsKey(name1)){
                map.put(name1, new Person(name1));
            }
            Person person1 = map.get(name1);
            person1.addToFriendList(name2);
            if(name2.equals(user)){
                person1.makeFriend();
            }

            if(!map.containsKey(name2)){
                map.put(name2, new Person(name2));
            }
            Person person2 = map.get(name2);
            person2.addToFriendList(name1);
            if(name1.equals(user)){
                person2.makeFriend();
            }
        }

        for(String visitor : visitors) {
            if(!map.containsKey(visitor)){
                map.put(visitor, new Person(visitor));
            }
        }

        for(String name : map.keySet().toArray(new String[0])){
            if(map.containsKey(name) && map.get(name).isFriend()){
                map.remove(name);
            }
        }
        return map;
    }


    public void scoreToFriend(ArrayList<String> friendsList, Person person){
        for(String friend : person.friendList){
            if(friendsList.contains(friend)){
                person.addScore(10);
            }
        }
    }

    public void giveFriendsScore(String user, HashMap<String, Person> map){
        ArrayList<String> friendsList = map.get(user).friendList;
        if(friendsList.isEmpty())
            return;
        for(Person person : map.values()){
            scoreToFriend(friendsList, person);
        }
    }

    public void giveVisitorsScore(HashMap<String, Person> map, List<String> visitors){
        if(visitors.isEmpty())
            return;

        for(String visitor : visitors){
            if(map.containsKey(visitor)){
                map.get(visitor).addScore(1);
            }
        }
    }

    public void addEmail(String user, Person person, ArrayList<String> recommendedList){
        if(person.name.equals(user) || person.getScore() == 0) return;
        recommendedList.add(person.name);
    }

    public ArrayList<String> getRecommendList(String user, HashMap<String, Person> map){
        ArrayList<String> recommendList = new ArrayList<>();
        Person[] people = map.values().toArray(new Person[0]);
        Arrays.sort(people);
        for(Person person : people){
            addEmail(user, person, recommendList);
            if(recommendList.size()==5) {
                break;
            }
        }
        return recommendList;
    }
    
}



