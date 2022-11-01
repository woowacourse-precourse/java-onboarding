package onboarding;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Problem7 {
    private static String User;
    private static List<String> user_friend = Collections.emptyList(); // register the friend of the user.

    public static class Priority_content{
        public String name;
        public int priority = 0;
        Priority_content(String name){
            this.name = name;
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
                return 1;
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
                return -1;
            }
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        User = user;
        List<Priority_content> Recommend_List = new ArrayList<Priority_content>(); // container to save and to sort
        // initialize the user_friend
        // find the friend of the user

        // remove user's friend from friends

        // initialize Recommend_List
        // find the people with the mutual friend with the user's timeline
        // find the people who visit user's
        // Rate the priority

        // Sort the List
        Recommend_List.sort(new Recommend_Comparator());
        // initialize the answer
        List<String> answer = Collections.emptyList();
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
