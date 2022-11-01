package onboarding.problem7.repository;

import onboarding.problem7.validation.MemberValidator;
import onboarding.problem7.entity.Member;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 한 유저를 기준으로 한 친구추천 후보 목록을
 * Set<Member> 자료구조를 사용해 관리하는 리포지토리 객체입니다.
 *
 * @author BackFoxx
 */
public class MemberRepositoryImpl implements MemberRepository {
    private final String user;
    private final Set<Member> members;

    private MemberRepositoryImpl(String user) {
        this.user = user;
        this.members = new TreeSet<>();
    }

    /**
     * 주어진 유저 이름을 기준으로 한 MemberRepositoryImpl 객체를 만드는 메소드입니다.
     *
     * @param user 친구추천 후보 목록의 기준이 될 유저 이름입니다.
     */
    public static MemberRepositoryImpl of(String user) {
        MemberValidator.validate(user);
        return new MemberRepositoryImpl(user);
    }

    @Override
    public void save(Member member) {
        if (member.getName().equals(user)) {
            return;
        }
        if (member.isAlreadyFriend()) {
            members.remove(member);
            members.add(member);
        } else {
            members.add(member);
        }
    }

    @Override
    public Optional<Member> findByName(String name) {
        return members.stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findByIsAlreadyFriend(boolean isAlreadyFriend) {
        return members.stream()
                .filter(member -> member.isAlreadyFriend() == isAlreadyFriend)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllNameSortByScoreNot0DescNameAsc() {
        return members
                .stream().filter(member -> member.getScore() != 0)
                .sorted(
                        Comparator
                                .comparingInt(Member::getScore).reversed()
                                .thenComparing(Member::getName)
                )
                .map(Member::getName)
                .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isMemberAlreadyFriend(Member member) {
        return findByIsAlreadyFriend(true).contains(member);
    }

    @Override
    public String getUser() {
        return user;
    }
}
