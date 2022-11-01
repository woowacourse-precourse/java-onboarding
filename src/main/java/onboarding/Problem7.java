package onboarding;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Problem7 {
    private static String User;
    private static List<String> user_friend = new ArrayList<String>(); // register the friend of the user.

    public static class Priority_content{
        public String name;
        public int priority = 0;
        Priority_content(String name){
            this.name = name;
        }
        Priority_content(String name, int point){
            this.name = name;
            this.priority += point;
        }
        public void score(int point){
            priority += point;
        }
    }
    // comparator
    // to use List.sort(), define comparator
    public static class Recommend_Comparator implements Comparator<Priority_content> { // object to save name and priority
        @Override
        public int compare(Priority_content o1, Priority_content o2) {
            // o1's priority is higher
            if(o1.priority > o2.priority){
                return -1;
            }
            else if(o1.priority == o2.priority){
                // if the priorities are the same,
                // compare the name
                int name_compare = o1.name.compareTo(o2.name);
                if(name_compare > 0){ // if the name of o1 comes first,
                    return 1;
                }
                else if(name_compare == 0){ // if the names are same
                    return 0;
                }
                else{ // name_compare < 0 ,
                    return -1;
                }
            }
            else{ // o1.score < o2.score
                return 1;
            }
        }
    }
    public static int find_index(String target_name, List<Priority_content> list){ // find the index of the content with name
        for(int i = 0; i < list.size(); i++){ // brute force
            if(target_name == list.get(i).name){
                return i;
            }
        }
        return -1; // cannot find the index, there is no such content.
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        User = user;
        List<Priority_content> Recommend_List = new ArrayList<Priority_content>(); // container to save and to sort
        // argument friends is immutable object, so make mutable object
        List<List<String>> mutable_friends = new ArrayList<List<String>>();
        for(int i = 0; i < friends.size(); i++){
            mutable_friends.add(friends.get(i));
        }
        // initialize the user_friend
        // find the friend of the user
        List<Integer> erase_list = new ArrayList<Integer>();
        for(int i = 0; i < mutable_friends.size(); i++){
            List<String> pair = mutable_friends.get(i); //
            if(pair.get(0) == User){
                user_friend.add(pair.get(1));
                // add index to the erase_list to erase the pair from friends
                erase_list.add(i);
            }
            else if(pair.get(1) == user){
                user_friend.add(pair.get(0));
                // add index to the erase_list to erase the pair from friends
                erase_list.add(i);
            }
            else{ // not a friend of the user
                continue;
            }
        }
        // erase the pair
        int erase_limit = erase_list.size();
        for(int i = 0; i < erase_limit; i++){
            mutable_friends.remove(erase_list.get(i) - i);
        }

        // initialize Recommend_List from the rest of the friends
        // Rate the priority
        int search_limit = mutable_friends.size();
        for(int i = 0; i < search_limit; i++){
            List<String> pair = mutable_friends.get(i);
            // find the  mutual friend
            if(user_friend.contains(pair.get(0))){ // pair.get(1) is mutual friend
                int index = find_index(pair.get(1),Recommend_List);
                if(index >= 0){ // if pair.get(1) is already in the recommend list
                    // just add 10 points
                    Recommend_List.get(index).score(10);
                }
                else{ // there is no such name in the recommend list, so add it
                    // register the content and add 10 points
                    Recommend_List.add(new Priority_content(pair.get(1),10));
                }
            }
            else if(user_friend.contains(pair.get(1))){ // pair.get(0) is mutual friend
                int index = find_index(pair.get(0),Recommend_List);
                if(index >= 0){ // if pair.get(1) is already in the recommend list
                    // just add 10 points
                    Recommend_List.get(index).score(10);
                }
                else{ // there is no such name in the recommend list, so add it
                    // register the content and add 10 points
                    Recommend_List.add(new Priority_content(pair.get(0),10));
                }
            }
            else{
                continue;
            }
        }
        // find the people who visit user's timeline
        for(int i = 0; i < visitors.size(); i++){
            String target = visitors.get(i);
            int index = find_index(target, Recommend_List);
            if(index >= 0){
                Recommend_List.get(index).score(1);
            }
            else if((index < 0)                        // not in the recommend list,
                    && (!user_friend.contains(target)) // not a friend of the user,
                    && (target != User)){              // not a user
                Recommend_List.add(new Priority_content(target, 1));
            }
        }

        // Sort the List
        Recommend_List.sort(new Recommend_Comparator());
        // initialize the answer
        List<String> answer = new ArrayList<String>();
        int remaining_recommend_number = 5;
        for(int i = 0; i < Recommend_List.size(); i++ ){
            if((remaining_recommend_number > 0) && (Recommend_List.get(i).priority != 0)){
                answer.add(Recommend_List.get(i).name);
                remaining_recommend_number--;
            }
            else{ // exit the loop
                break;
            }
        }
        return answer;
    }
}
