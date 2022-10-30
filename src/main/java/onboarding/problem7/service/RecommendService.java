package onboarding.problem7.service;

import onboarding.problem7.repository.FriendRepository;
import onboarding.problem7.vo.Member;

import java.util.List;

public class RecommendService {
    private final FriendRepository friendRepository;

    public RecommendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    public List<String> recommendFriends(List<List<String>> members, List<String> visitors) {
        saveAllMembers(members, visitors);
        analyzeRelations(members);
        analyzeVisitors(visitors);

        return friendRepository.findAllNameSortByScoreNot0DescNameAsc();
    }

    private void saveAllMembers(List<List<String>> friends, List<String> visitors) {
        friends.forEach(relation -> saveMembersAnalyzingRelation(relation));
        visitors.forEach(visitor -> friendRepository.save(Member.of(visitor)));
    }

    private void saveMembersAnalyzingRelation(List<String> relation) {
        relation.forEach(member -> {
            if (relation.contains(friendRepository.getUser())) {
                friendRepository.save(Member.ofAlreadyFriend(member));
            } else {
                friendRepository.save(Member.of(member));
            }
        });
    }

    private void analyzeVisitors(List<String> visitors) {
        visitors.forEach(visitor -> friendRepository.findByName(visitor)
                .ifPresent(member -> member.addScore(1))
        );
    }

    private void analyzeRelations(List<List<String>> friends) {
        friends.forEach(relation -> analyzeRelation(relation));
    }

    private void analyzeRelation(List<String> relation) {
        if (friendRepository.isMemberAlreadyFriend(Member.of(relation.get(0)))
                || friendRepository.isMemberAlreadyFriend(Member.of(relation.get(1)))
        ) {
            relation.forEach(member -> friendRepository.findByName(member)
                    .ifPresent(friend -> friend.addScore(10)));
        }
    }
}
