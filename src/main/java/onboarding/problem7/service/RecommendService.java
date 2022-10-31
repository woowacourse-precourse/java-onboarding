package onboarding.problem7.service;

import onboarding.problem7.collection.Visitors;
import onboarding.problem7.repository.MemberRepository;
import onboarding.problem7.entity.Member;
import onboarding.problem7.vo.Relation;

import java.util.List;

/**
 * 친구 추천 알고리즘과 관련된 비즈니스 로직을 진행하는 서비스 레이어 클래스입니다.
 * @author BackFoxx
 */
public class RecommendService {
    public static final int RELATION_SCORE = 10;
    public static final int VISITOR_SCORE = 1;

    private final MemberRepository memberRepository;

    public RecommendService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 주어진 친구관계 배열과 방문자 목록을 바탕으로 추천 친구 목록을 추려 반환하는 메소드입니다.
     * @param members 친구관계가 List<String>으로 담긴 리스트입니다.
     * @param visitorList 방문자의 이름 값이 담긴 리스트입니다.
     * @return 알고리즘에 따라 추천 친구의 이름 값을 추천 점수 순서대로 최대 5명까지 담은 리스트입니다.
     */
    public List<String> recommendFriends(List<List<String>> members, List<String> visitorList) {
        List<Relation> relations = Relation.ofList(members);
        Visitors visitors = Visitors.of(visitorList);

        saveAllMembers(relations, visitors);

        analyzeRelations(relations);
        analyzeVisitors(visitors);

        return memberRepository.findAllNameSortByScoreNot0DescNameAsc();
    }

    /**
     * 주어진 친구관계 리스트와 방문자 리스트를 분석해 MemberRepository 에 저장하는 메소드입니다.
     * @param relations 친구관계가 List<Relation>으로 담긴 리스트입니다.
     * @param visitors 방문자의 이름 값이 담긴 리스트입니다.
     */
    private void saveAllMembers(List<Relation> relations, Visitors visitors) {
        relations.forEach(relation -> saveMembersByRelation(relation));
        visitors.forEach(visitor -> memberRepository.save(Member.of(visitor)));
    }

    /**
     * 주어진 Relation 리스트를 분석해 MemberRepository 에 저장하는 메소드입니다.
     * @param relation 친구관계가 List<Relation> 으로 담긴 리스트입니다.
     */
    private void saveMembersByRelation(Relation relation) {
        relation.forEach(name -> {
            if (relation.contains(memberRepository.getUser())) {
                memberRepository.save(Member.ofAlreadyFriend(name));
            } else {
                memberRepository.save(Member.of(name));
            }
        });
    }

    /**
     * 주어진 Relation 리스트에서 추천 친구를 찾아 추천 점수를 조정하는 메소드입니다.
     * @param relations relation 친구관계가 List<Relation> 으로 담긴 리스트입니다.
     */
    private void analyzeRelations(List<Relation> relations) {
        relations.forEach(this::analyzeRelation);
    }

    /**
     * 주어진 Relation 객체를 분석해 추천 친구를 찾고, 추천 점수를 조정하는 메소드입니다.
     * @param relation 추천친구를 찾을 때 사용되는 Relation 객체입니다.
     */
    private void analyzeRelation(Relation relation) {
        if (memberRepository.isMemberAlreadyFriend(Member.of(relation.getMemberName()))
                || memberRepository.isMemberAlreadyFriend(Member.of(relation.getAnotherMemberName()))
        ) {
            relation.forEach(name -> memberRepository.findByName(name)
                    .ifPresent(friend -> friend.addScore(RELATION_SCORE)));
        }
    }

    /**
     * 주어진 Visitors 컬렉션의 방문자를 분석해 추천 친구를 찾고, 추천 점수를 조정하는 메소드입니다.
     * @param visitors 방문자 이름 정보가 담겨있는 Visitors 일급 컬렉션입니다.
     */
    private void analyzeVisitors(Visitors visitors) {
        visitors.forEach(visitor -> memberRepository.findByName(visitor)
                .ifPresent(member -> member.addScore(VISITOR_SCORE))
        );
    }
}
