package onboarding;

import onboarding.testCode.experiment7;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
//        Map<String, Integer> scorePare = friendScorePare(user, friends);
//        Map<String, Integer> scorePare1 = visitorScorePare(scorePare, visitors);
//        List<String> answer = recommender(user, friends, visitors);
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

    public static class recComparator implements Comparator<List<String>> {

        @Override
        public int compare(List<String> o1, List<String> o2) {
            Integer o1Int = Integer.parseInt(o1.get(1));
            Integer o2Int = Integer.parseInt(o2.get(1));
            int scoreComparison = o1Int.compareTo(o2Int);
            scoreComparison = -scoreComparison;
            int answer = (scoreComparison == 0) ? o1.get(0).compareTo(o2.get(0)) : scoreComparison;
            return answer;

        }
    }

    public static Set<String> createExcluder(String user, List<List<String>> friends) {
        Set<String> excludSet = new HashSet<>();
        for (List<String> friend : friends) {
            if (friend.get(0) == user || friend.get(1) == user) {
                excludSet.add(friend.get(0));
                excludSet.add(friend.get(1));

            }

        }
        return excludSet;
    }


    public  static List<String> recommender(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> scorePare = friendScorePare(user, friends);
        Map<String, Integer> finalScorePare = visitorScorePare(scorePare, visitors);
        Set<String> excludeSet = createExcluder(user, friends);



        List<List<String>> listPare = new ArrayList<>(finalScorePare.size());

        int tempCounter = -1;
        for (String key : finalScorePare.keySet()) {
            tempCounter += 1;
            listPare.add(new ArrayList<String>());
            listPare.get(tempCounter).add(key);
            if (excludeSet.contains(key)) {
                listPare.get(tempCounter).add("0");
            } else {
                listPare.get(tempCounter).add(finalScorePare.get(key).toString());
            }


        }


        Collections.sort(listPare, new experiment7.recComparator());


        List<String> answer = new ArrayList<String>();
        for (List<String> pare : listPare) {
            if(Integer.parseInt(pare.get(1))>0) {
                answer.add(pare.get(0));
            }
        }



        List<String> modifiedAnswer = (answer.size() > 5) ? answer.subList(0, 5) : answer;
        return modifiedAnswer;




    }

}
