package onboarding.problem7.service;

import onboarding.problem7.collection.Visitors;
import onboarding.problem7.repository.FriendRepository;
import onboarding.problem7.vo.Member;
import onboarding.problem7.vo.Relation;

import java.util.List;

public class RecommendService {
    public static final int RELATION_SCORE = 10;
    public static final int VISITOR_SCORE = 1;

    private final FriendRepository friendRepository;

    public RecommendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    public List<String> recommendFriends(List<List<String>> members, List<String> visitorList) {
        List<Relation> relations = Relation.ofList(members);
        Visitors visitors = Visitors.of(visitorList);

        saveAllMembers(relations, visitors);

        analyzeRelations(relations);
        analyzeVisitors(visitors);

        return friendRepository.findAllNameSortByScoreNot0DescNameAsc();
    }

    private void saveAllMembers(List<Relation> relations, Visitors visitors) {
        relations.forEach(relation -> saveMembersByRelation(relation));
        visitors.forEach(visitor -> friendRepository.save(Member.of(visitor)));
    }

    private void saveMembersByRelation(Relation relation) {
        relation.forEach(name -> {
            if (relation.contains(friendRepository.getUser())) {
                friendRepository.save(Member.ofAlreadyFriend(name));
            } else {
                friendRepository.save(Member.of(name));
            }
        });
    }

    private void analyzeRelations(List<Relation> relations) {
        relations.forEach(this::analyzeRelation);
    }

    private void analyzeRelation(Relation relation) {
        if (friendRepository.isMemberAlreadyFriend(Member.of(relation.getMemberName()))
                || friendRepository.isMemberAlreadyFriend(Member.of(relation.getAnotherMemberName()))
        ) {
            relation.forEach(name -> friendRepository.findByName(name)
                    .ifPresent(friend -> friend.addScore(RELATION_SCORE)));
        }
    }

    private void analyzeVisitors(Visitors visitors) {
        visitors.forEach(visitor -> friendRepository.findByName(visitor)
                .ifPresent(member -> member.addScore(VISITOR_SCORE))
        );
    }
}
