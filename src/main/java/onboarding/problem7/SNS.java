package onboarding.problem7;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SNS {

    private Database database;

    public SNS(List<List<String>> friends, List<String> visitors) {
        database = new Database(visitors);
        for (var relation : friends) {
            database.addRelation(relation);
        }
        database.registerUsersFromLog(visitors);
    }

    public List<String> recommendFriends(String name) {
        return database.getRecommendedUsersByName(name)
                .stream()
                .sorted(Comparator.<User,Integer>
                        comparing(user -> -user.getScore())
                        .thenComparing(user->user.getName()))
                .map(user -> user.getName())
                .limit(5)
                .collect(Collectors.toList());
    }

}
