package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class pair {
    String nickname;
    int score;

    pair(String nickname, int score) {
        this.nickname = nickname;
        this.score = score;
    }

    void updateScore(int point) {
        score += point;
    }

    String getNickname() {
        return nickname;
    }

    int getScore() {
        return score;
    }
}

class pairComparator implements Comparator<pair> {
    @Override
    public int compare(pair pair1, pair pair2) {
        if (pair1.getScore() == pair2.getScore()) {
            return pair1.getNickname().compareTo(pair2.getNickname());
        }
        else {
            if (pair1.getScore() > pair2.getScore()) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}


public class Problem7 {
    public static List<String> getMyFriends(String user, List<List<String>> friends) {
        List<String> myFriends = new ArrayList<>();
        for (List<String> relationship: friends) {
            if (relationship.get(0).equals(user)) {
                myFriends.add(relationship.get(1));
            } else if (relationship.get(1).equals(user)) {
                myFriends.add(relationship.get(0));
            }
        }
        return myFriends;
    }

    public static List<pair> getRecommendations(String user, List<String> myFriends, List<List<String>> friends, List<String> visitors) {
        List<String> unknownUsers = new ArrayList<>();
        for (List<String> relationship: friends) {
            String firstUser = relationship.get(0);
            String secondUser = relationship.get(1);
            if (!(unknownUsers.contains(firstUser)) && !(firstUser.equals(user)) && !(myFriends.contains(firstUser))) {
                unknownUsers.add(firstUser);
            }
            else if (!(unknownUsers.contains(secondUser)) && !(secondUser.equals(user)) && !(myFriends.contains(secondUser))) {
                unknownUsers.add(secondUser);
            }
        }

        for (String visitor: visitors) {
            if (!(unknownUsers.contains(visitor)) && !(myFriends.contains(visitor))) {
                unknownUsers.add(visitor);
            }
        }

        List<pair> recommendations = new ArrayList<>();
        for (String unknownUser: unknownUsers) {
            pair newUnknownUser = new pair(unknownUser, 0);
            recommendations.add(newUnknownUser);
        }
        return recommendations;
    }

    public static void calculatePoint(List<pair> recommendations, List<String> myFriends, List<String> visitors,
                                      List<List<String>> friends, String user) {
        List<String> recommendationNames = new ArrayList<>();
        for (pair recommendation: recommendations) {
            recommendationNames.add(recommendation.nickname);
        }

        for (String visitor: visitors) { // 방문으로 인한 점수 업데이트
            if (recommendationNames.contains(visitor)) {
                int index = recommendationNames.indexOf(visitor);
                recommendations.get(index).updateScore(1);
            }
        }

        for (String myFriend: myFriends) { // 친구의 친구로 인한 점수 업데이트
            for (List<String> relationship: friends) {
                if ((relationship.get(0).equals(myFriend)) && !(relationship.get(1).equals(user))){
                    if (recommendationNames.contains(relationship.get(1))) {
                        int index = recommendationNames.indexOf(relationship.get(1));
                        recommendations.get(index).updateScore(10);
                    }
                } else if ((relationship.get(1).equals(myFriend)) && !(relationship.get(0).equals(user))){
                    if (recommendationNames.contains(relationship.get(0))) {
                        int index = recommendationNames.indexOf(relationship.get(0));
                        recommendations.get(index).updateScore(10);
                    }
                }
            }
        }
    }

    public static List<String> sortList(List<pair> recommendations) {
        Collections.sort(recommendations, new pairComparator());
        List<String> result = new ArrayList<>();
        for (int i = 0; i < recommendations.size(); i++) {
            if ((i >= 5) || (recommendations.get(i).getScore() == 0)) {
                break;
            }
            result.add(recommendations.get(i).nickname);
        }
        return result;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> myFriends = getMyFriends(user, friends);
        List<pair> recommendations = getRecommendations(user, myFriends, friends, visitors);
        calculatePoint(recommendations, myFriends, visitors, friends, user);
        List<String> answer = sortList(recommendations);
        return answer;
    }
}
