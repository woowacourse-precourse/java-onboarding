package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import net.bytebuddy.implementation.bytecode.Removal;

import java.util.ArrayList;
import java.util.Arrays;
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static void main(String[] args){
        String user = "mrko";
        List<List<String>> friends = Arrays.asList(Arrays.asList("dount", "andole"),
        Arrays.asList("dount", "jun"),
        Arrays.asList("dount", "mrko"),
        Arrays.asList("shakevan", "andole"),
        Arrays.asList("shakevan", "jun"),
        Arrays.asList("shakevan", "mrko"));

        List<String> visitors = new ArrayList<>();
        visitors.add("bedi");
        visitors.add("bedi");
        visitors.add("dount");
        visitors.add("bedi");
        visitors.add("shakevan");

        // UserLenght range check
        int userLenght = user.length();
        if((1 <= userLenght) && (userLenght <= 30)){
            System.out.println("UserLengh range check");
        }
        // friend list range check
        int friendsLenght = friends.size();
        if((1 <= friendsLenght) && (friendsLenght <= 10000)){
            System.out.println("friendsLenght range check");
        }
        // id one, two lenght check
        for(int i=0;i<friends.size();i++){
            int idLenghtOne = friends.get(i).get(0).length();
            int idLenghtTwo = friends.get(i).get(1).length();
            if((1 <= idLenghtOne && idLenghtOne <= 30) && (1 <= idLenghtTwo && idLenghtTwo <= 30)){                System.out.println("id one and two lenght check");
            }
        }
        // visitors lenght check
        int visitorsListLenght = visitors.size();
        if(0 <= visitorsListLenght && visitorsListLenght <= 10000){
            System.out.println("visitors lenght check");
        }
        // user id patten check
        if(Pattern.matches("^[a-z]*$", user) == true){
            System.out.println("user id patten check");
        }
        // friends overlap check
        for(int i =0; i<friends.size()-1;i++){
            if(friends.get(i).get(0) != friends.get(i).get(1)){
                System.out.println("friends ovelap check");
            }
        }

        //friends check
        List<String> userFriendsList = new ArrayList<>();
        for(int i = 0; i < friends.size();i++){
            for(int j=0;j < 2;j++){
                if(friends.get(i).get(j).contains(user) && j == 0){
                    userFriendsList.add(friends.get(i).get(1));
                }
                if(friends.get(i).get(j).contains(user) && j == 1){
                    userFriendsList.add(friends.get(i).get(0));
                }
            }
        }
        System.out.println(userFriendsList);

        //frinedTofriend
        List<String> newFrienList = new ArrayList<>();
        for(int i = 0; i < friends.size();i++){
            for(int j = 0;j < userFriendsList.size();j++){
                if(friends.get(i).contains(userFriendsList.get(j))){
                    newFrienList.add(friends.get(i).get(1));
                }
                if(friends.get(i).contains(userFriendsList.get(j))){
                    newFrienList.add(friends.get(i).get(0));
                }
            }
        }
        System.out.println(newFrienList);

    // overlap remove
    for(int i = 0;i < newFrienList.size();i++){
        for(int j = 0; j < userFriendsList.size();j++){
            if(newFrienList.get(i).contains(userFriendsList.get(j))){
                newFrienList.remove(userFriendsList.get(j));
                }
            }
        }

    // user delete
    for(int i = 0;i < newFrienList.size();i++){
        if(newFrienList.get(i).contains(user)){
            newFrienList.remove(user);
            }
        }
    // overlap delete
    for(int i = 0;i < newFrienList.size()-1;i++){
        for(int j = 0;j < newFrienList.size();j++){
            if(newFrienList.get(i).equals(newFrienList.get(j))){
                newFrienList.remove(newFrienList.get(j));
            }
        }
        }
    System.out.println(newFrienList);
    }
}
