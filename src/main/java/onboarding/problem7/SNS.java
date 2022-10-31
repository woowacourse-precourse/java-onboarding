package onboarding.problem7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SNS {
    UserRelationRepository userRelationRepository;
    UserRepository userRepository;

    public void setDatas(List<List<String>> friends, List<String> visitors){
        friends.stream().flatMap(arr->arr.stream()).distinct().forEach(this.userRepository::save);
        this.userRelationRepository.addRelations(friends);
    }

    public List<String> recommendFriend(String name){

    }
}
