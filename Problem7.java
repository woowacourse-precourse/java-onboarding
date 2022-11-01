package onboarding;

import java.util.*;

public class Problem7 {
    private final static int SCORE_OF_FRIENDS_WITH_USER = 10;
    private final static int SCORE_OF_TIMELINE_VISIT = 1;
    private final static int RECOMMEND_NUMBER_OF_PEOPLE = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> allPersonsSet = new HashSet<>();

        allPersonsSet.add(user);
        for (List<String> friend : friends) {
            for (String person : friend) {
                allPersonsSet.add(person);
            }
        }
        for (String person : visitors) {
            allPersonsSet.add(person);
        }

        List<PersonWithScore> personsWithScore = new ArrayList<>();
        for (String person : allPersonsSet) {
            PersonWithScore personWithScore = new PersonWithScore(person, 0);
            personsWithScore.add(personWithScore);
        }

        Set<String> directFriendsSet = new HashSet<>();

        for (int i = 0 ; i < friends.size() ; i++) {
            if (friends.get(i).get(0).equals(user)) {
                directFriendsSet.add(friends.get(i).get(1));
            } else if (friends.get(i).get(1).equals(user)) {
                directFriendsSet.add(friends.get(i).get(0));
            }
        }

        List<String> directFriendsList = new ArrayList<>(directFriendsSet);

        for (int i = 0 ; i < friends.size() ; i++) {
            for (int j = 0 ; j < directFriendsList.size() ; j++) {
                if (friends.get(i).get(0).equals(directFriendsList.get(j))) {
                    for (int k = 0; k < personsWithScore.size() ; k++) {
                        if (personsWithScore.get(k).person.equals(friends.get(i).get(1))) {
                            personsWithScore.get(k).score += 10;
                        }
                    }
                } else if (friends.get(i).get(1).equals(directFriendsList.get(j))) {
                    for (int k = 0; k < personsWithScore.size() ; k++) {
                        if (personsWithScore.get(k).person.equals(friends.get(i).get(0))) {
                            personsWithScore.get(k).score += 10;
                        }
                    }
                }
            }
        }

        for (int i = 0 ; i < visitors.size() ; i++) {
            for (int j = 0; j < personsWithScore.size(); j++) {
                if (visitors.get(i).equals(personsWithScore.get(j).person)) {
                    personsWithScore.get(j).score += 1;
                }
            }
        }

        Collections.sort(personsWithScore);

        List<String> answer = new ArrayList<>();

        for (int i = 0; i < personsWithScore.size(); i++) {
            if (personsWithScore.get(i).score > 0 && personsWithScore.get(i).person.equals(user)) {
                answer.add(personsWithScore.get(i).person);
            }
        }

        if (answer.size() > 5) {
            answer = answer.subList(0, 4);
        }

        return answer;
    }

    private static class PersonWithScore implements Comparable<PersonWithScore>{
        private String person;
        private int score;
        public PersonWithScore(String person, int score) {
            this.person = person;
            this.score = score;
        }

        @Override
        public int compareTo(PersonWithScore p) {
            return p.score - this.score;
        }
    }
}
