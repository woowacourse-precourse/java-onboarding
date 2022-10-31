package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> UserFriend = new ArrayList<>();
        for(int i = 0;i<friends.size();i++){
            if(friends.get(i).get(1).equals(user) == true){
                UserFriend.add(friends.get(i).get(0));
            }
        }
        HashMap<String,Integer> AllScore = new HashMap<>();


        List<String> list = new ArrayList<>();
        for(int i = 0;i<friends.size();i++){
            if((friends.get(i).get(1)).equals(user)){
                list.add(friends.get(i).get(0));
            }
        }
        HashMap<String,Integer> score = new HashMap<>();

        for(int i = 0;i<list.size();i++){

            for(int j = 0;j<friends.size();j++){
                if((friends.get(j).get(0)).equals(list.get(i)) && ((friends.get(j).get(1)).equals(user)==false)){

                    score.put(friends.get(j).get(1),0);
                    int how = (score.get(friends.get(j).get(1))+10);

                    score.put(friends.get(j).get(1),how+10);
                    AllScore.put(friends.get(j).get(1),score.get(friends.get(j).get(1)));
                }
            }
        }

        HashMap<String,Integer> visit = new HashMap<>();
        int a =0;
        for(int i = 0;i<visitors.size();i++){
            for(int j = 0;j<UserFriend.size();j++) {
                if ((visitors.get(i).equals(UserFriend.get(j)))== false && Collections.frequency(UserFriend, visitors.get(i))==0){
                    //visit.put(visitors.get(i), Collections.frequency(visitors, visitors.get(i)));
                    AllScore.put(visitors.get(i),Collections.frequency(visitors, visitors.get(i)));
                }
            }
        }
        List<Map.Entry<String, Integer>> list_entries = new ArrayList<Map.Entry<String, Integer>>(AllScore.entrySet());


        Collections.sort(list_entries, new Comparator<Map.Entry<String, Integer>>() {

            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {

                return obj2.getValue().compareTo(obj1.getValue());
            }
        });



        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : list_entries) {

            result.add(entry.getKey());
        }

        return  result;
    }
}
