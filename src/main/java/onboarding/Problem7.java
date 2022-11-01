package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(Collections.emptyList());
        List<String> checkAlreadyFriend = new ArrayList<>();
        List<String> acquaintanceList = new ArrayList<>();
        List<String> visitorsList = new ArrayList<>();
        List<List<String>> calcScoreList = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                if (friends.get(i).get(0).equals(user)) {
                    checkAlreadyFriend.add(friends.get(i).get(1));
                } else {
                    checkAlreadyFriend.add(friends.get(i).get(0));
                }
            }
        }
        checkAlreadyFriend.add(user);

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < friends.get(i).size(); j++) {
                boolean checkFlag = true;
                for (int k = 0; k < checkAlreadyFriend.size(); k++) {
                    if (friends.get(i).get(j).equals(checkAlreadyFriend.get(k))) {
                        checkFlag = false;
                        break;
                    }
                }
                if (checkFlag) acquaintanceList.add(friends.get(i).get(j));
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            boolean checkFlag = true;
            for (int j = 0; j < checkAlreadyFriend.size(); j++) {
                if (visitors.get(i).contains(checkAlreadyFriend.get(j))) {
                    checkFlag = false;
                    break;
                }
            }
            if (checkFlag) visitorsList.add(visitors.get(i));
        }

        getScore(acquaintanceList, calcScoreList, 10);
        getScore(visitorsList, calcScoreList, 1);
        calcScoreList.sort(new Comparator<>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return Integer.valueOf(o1.get(1)).compareTo(Integer.valueOf(o1.get(1)));
            }
        });

        for(int i = 0; i<calcScoreList.size(); i++){
            answer.add(calcScoreList.get(i).get(0));
        }

        return answer;
    }

    public static void getScore(List<String> refList, List<List<String>> calcScoreList, int scoreFlag) {
        for (int i = 0; i < refList.size(); i++) {
            boolean checkFlag = true;
            for (int j = 0; j < calcScoreList.size(); j++) {
                if (calcScoreList.get(j).contains(refList.get(i))) {
                    checkFlag = false;
                    int score = Integer.parseInt(calcScoreList.get(j).get(1)) + scoreFlag;
                    calcScoreList.get(j).set(1, String.valueOf(score));
                    break;
                }
            }
            if (checkFlag) calcScoreList.add(Arrays.asList(refList.get(i), String.valueOf(scoreFlag)));
        }
    }
}


