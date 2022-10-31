package onboarding.problem7;

import onboarding.problem6.UserRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SNS {
    //데이터베이스
    private Database database;

    //정보 바로 DB에 등록
    public SNS(List<List<String>> friends, List<String> visitors) {
        database = new Database(visitors);
        for (var relation : friends) {
            database.addRelation(relation);
        }
        database.registerUsersFromLog(visitors);
    }

    //친구추천 후 스트림을 통한 필터링
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
