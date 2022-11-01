import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem7Debugging {

    public static void main(String[] args) {

        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");


        HashMap<String, Integer> nameAndPoint = new HashMap<>();

        for (int i = 0; i < 2 ; i++){
            for (int j = 0; j < friends.size() ; j++){
                String name = friends.get(j).get(i);
                nameAndPoint.put(name,0);
            }
        }

        for (int j = 0; j < visitors.size() ; j++){
            String name = visitors.get(j);
            nameAndPoint.put(name,0);
        }

        List<String> friendsOfUser = new ArrayList<>();



        for (int i =0 ; i < friends.size() ; i++) {
            int userIndex = friends.get(i).indexOf(user);

            int friendIndex = 1-userIndex;

            friendsOfUser.add(friends.get(i).get(friendIndex));

        }
        for (int i = 0 ; i < friendsOfUser.size() ; i ++){
            for (int j =0 ; j < friends.size() ; j++) {
                int friendsIndex = friends.get(j).indexOf(friendsOfUser.get(i));

                int friendOfFriendIndex = 1-friendsIndex;

                String friendNameOfFriendOfUser = friends.get(i).get(friendOfFriendIndex);

            }
        }





    }
}
