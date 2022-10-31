package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> nameSetCreator(String user ,List<List<String>> friends) {
        Set<String> names = new HashSet<String>();
        for (List<String> friend : friends) {
            names.add(friend.get(0));
            names.add(friend.get(1));
        }
        names.add(user);

        List<String> result = new ArrayList<>(names);
        Collections.sort(result);
        return result;
    }
    public static Map<String, Integer> friendScorePare(String user, List<List<String>> friends){
        List<String> namesList = nameSetCreator(user,friends);
        Collections.sort(namesList);
        List<List<Integer>> matrix = new ArrayList<>(namesList.size());

        for (int i = 0; i < namesList.size(); i++) {
            matrix.add(new ArrayList<>(namesList.size()));
            for (int j = 0; j < namesList.size(); j++) {
                matrix.get(i).add(0);
            }
        }

        for (List<String> friend : friends) {
            int x = namesList.indexOf(friend.get(0));
            int y = namesList.indexOf(friend.get(1));

            matrix.get(x).set(y, 1);
            matrix.get(y).set(x, 1);

        }

        // test

//        System.out.println(String.join(", ", namesList));
//        for (int i = 0; i < matrix.size(); i++) {
//            System.out.println(matrix.get(i).toString());
//        }

        //test end


        Map<String, Integer> scorePare = new HashMap<String, Integer>();
        for (String name : namesList) {
            scorePare.put(name, 0);
        }



        int userIndex = namesList.indexOf(user);
        List<Integer> userScore = matrix.get(userIndex);
        for (int i = 0; i <namesList.size(); i++) {
            if (i != userIndex) {
                List<Integer> compUserScore = matrix.get(i);
                for (int j = 0; j < compUserScore.size(); j++) {
                    int adder = (userScore.get(j)==1 && compUserScore.get(j)==1) ? 10 : 0;

                    //test®
//                    if(userScore.get(j)==1 && compUserScore.get(j)==1) {
//                        System.out.println(userScore.get(j) + ", " + compUserScore.get(j));
//                    }
                    //test end

                    scorePare.put(namesList.get(i), scorePare.get(namesList.get(i)) + adder);
                }
            }
        }

        return scorePare;


    }

    public static Map<String, Integer> visitorScorePare(Map<String , Integer> friendScorePare, List<String> visitors){
        for (String visitor : visitors) {
            if (friendScorePare.keySet().contains(visitor)) {
                friendScorePare.put(visitor, friendScorePare.get(visitor) + 1);
            } else {
                friendScorePare.put(visitor, 1);
            }
        }
        return friendScorePare;
    }

}
