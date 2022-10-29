package onboarding.problem7;

import java.util.List;
import java.util.stream.Collectors;

class SNS {

    private Database database;

    public SNS(List<List<String>> friends, List<String> visitors) {
        database = new Database(visitors);
        for (var relation : friends) {
            database.addRelation(relation);
        }
        database.registerUsersFromLog(visitors);
    }

    public List<String> recommendFriends(String name) {
        return database.getRecommendedUsersByName(name).stream().map(user -> user.getName()).collect(Collectors.toList());
    }

}
