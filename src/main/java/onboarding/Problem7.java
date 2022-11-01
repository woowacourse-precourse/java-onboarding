package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem7 {

    public static int acquaintancePoint = 10;
    public static int visitPoint = 1;

    public static Set<String> getCrewList(List<List<String>> friends, List<String> visitors) {
        Set<String> crewSet = new HashSet<>();
        for (List<String> friend : friends) {
            for (String name : friend) {
                crewSet.add(name);
            }
        }
        for (String visitor : visitors) {
            if (!crewSet.contains(visitor)) {
                crewSet.add(visitor);
            }
        }

        return crewSet;
    }

    public static HashMap<String, Integer> initializeScoreBoard(Set<String> crewSet) {
        HashMap<String, Integer> scoreBoard = new HashMap<>();
        for (String crew : crewSet) {
            scoreBoard.put(crew, 0);
        }
        return scoreBoard;
    }

    public static List<String> getUserFriend(String user, List<List<String>> friends) {
        List<String> userFriend = new ArrayList<>();
        for (List<String> friendship : friends) {
            if (friendship.contains(user)) {
                if (friendship.indexOf(user) == 0) {
                    userFriend.add(friendship.get(1));
                } else {
                    userFriend.add(friendship.get(0));
                }
            }
        }
        return userFriend;
    }

    public static List<String> getAcquaintance(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();
        List<String> userFriend = getUserFriend(user, friends);
        for (List<String> friendship : friends) {
            for (String crew : userFriend) {
                if (friendship.contains(crew) && !friendship.contains(user)) {
                    String target;
                    if (friendship.indexOf(crew) == 0) {
                        target = friendship.get(1);
                    } else {
                        target = friendship.get(0);
                    }
                    result.add(target);
                }
            }
        }
        return result;
    }

    public static HashMap<String, Integer> updateAcquaintancePoint(
        HashMap<String, Integer> scoreBoard, List<String> crews) {
        for (String crew : crews) {
            int score = scoreBoard.get(crew);
            score += acquaintancePoint;
            scoreBoard.put(crew, score);
        }

        return scoreBoard;
    }

    public static HashMap<String, Integer> updateVisitPoint(HashMap<String, Integer> scoreBoard,
        List<String> visitors) {
        for (String visitor : visitors) {
            int score = scoreBoard.get(visitor);
            score += visitPoint;
            scoreBoard.put(visitor, score);
        }

        return scoreBoard;
    }

    public static List<String> sortScore(HashMap<String, Integer> scoreBoard) {
        List<String> result = new ArrayList<>();
        List<String> keySetList = new ArrayList<>(scoreBoard.keySet());
        Collections.sort(keySetList,
            (o1, o2) -> (scoreBoard.get(o2).compareTo(scoreBoard.get(o1))));
        for (String key : keySetList) {
            result.add(key);
        }
        return result;
    }

    public static List<String> removeSelfAndFriend(List<String> sortedScore, String user,
        List<List<String>> friends) {
        sortedScore.remove(user);
        List<String> userFriend = getUserFriend(user, friends);
        for (String crew : userFriend) {
            if (sortedScore.contains(crew)) {
                sortedScore.remove(crew);
            }
        }
        return sortedScore;
    }

    public static int getResultSize(List<String> recommendedCrewList) {
        int resultSize;
        int maxSize = 5;
        int recommendedCrewSize = recommendedCrewList.size();

        if (recommendedCrewSize > maxSize) {
            resultSize = maxSize;
        } else {
            resultSize = recommendedCrewSize;
        }

        return resultSize;
    }

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
        Set<String> crews = getCrewList(friends, visitors);
        HashMap<String, Integer> scoreBoard = initializeScoreBoard(crews);

        List<String> userAcquaintance = getAcquaintance(user, friends);
        scoreBoard = updateAcquaintancePoint(scoreBoard, userAcquaintance);
        scoreBoard = updateVisitPoint(scoreBoard, visitors);

        List<String> sortedCrew = sortScore(scoreBoard);
        List<String> result = removeSelfAndFriend(sortedCrew, user, friends);

        int answerSize = getResultSize(result);
        List<String> answer = result.subList(0, answerSize);

        return answer;
    }
}
