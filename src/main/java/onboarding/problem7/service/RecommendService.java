package onboarding.problem7.service;

import onboarding.problem7.repository.FriendRepository;
import onboarding.problem7.vo.Member;

import java.util.List;

public class RecommendService {
    private final FriendRepository friendRepository;

    public RecommendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    public List<String> recommendFriends(List<List<String>> friends, List<String> visitors) {
        friends.forEach(
                relation -> relation.forEach(friend -> {
                    if (relation.contains(friendRepository.getUser())) {
                        friendRepository.save(Member.ofAlreadyFriend(friend));
                    } else {
                        friendRepository.save(Member.of(friend));
                    }
                })
        );
        visitors.forEach(visitor -> friendRepository.save(Member.of(visitor)));

        analyzeRelations(friends);
        analyzeVisitors(visitors);

        return friendRepository.findAllNameSortByScoreNot0DescNameAsc();
    }

    private void analyzeVisitors(List<String> visitors) {
        visitors.forEach(visitor -> friendRepository.findByName(visitor)
                .ifPresent(member -> member.addScore(1))
        );
    }

    private void analyzeRelations(List<List<String>> friends) {
        friends.forEach(relation -> {
            List<Member> alreadyFriend = friendRepository.findByIsAlreadyFriend(true);
            if (alreadyFriend.contains(Member.of(relation.get(0))) || alreadyFriend.contains(Member.of(relation.get(1)))) {
                        relation.forEach(friend -> friendRepository.findByName(friend)
                                .ifPresent(member -> member.addScore(10)));
                    }
                }
        );
    }
}
