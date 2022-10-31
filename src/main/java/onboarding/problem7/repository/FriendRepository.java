package onboarding.problem7.repository;

import onboarding.problem7.validation.UserValidator;
import onboarding.problem7.vo.Member;

import java.util.*;
import java.util.stream.Collectors;

public class FriendRepository {
    private final String user;
    private final Set<Member> members;

    private FriendRepository(String user) {
        this.user = user;
        this.members = new TreeSet<>();
    }

    public static FriendRepository of(String user) {
        UserValidator.validate(user);
        return new FriendRepository(user);
    }

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

    public Optional<Member> findByName(String name) {
        return members.stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    public List<Member> findByIsAlreadyFriend(boolean isAlreadyFriend) {
        return members.stream()
                .filter(member -> member.isAlreadyFriend() == isAlreadyFriend)
                .collect(Collectors.toList());
    }

    public List<String> findAllNameSortByScoreNot0DescNameAsc() {
        return members
                .stream().filter(member -> member.getScore() != 0)
                .sorted(
                        Comparator
                                .comparingInt(Member::getScore).reversed()
                                .thenComparing(Member::getName)
                )
                .map(Member::getName)
                .collect(Collectors.toList());
    }

    public boolean isMemberAlreadyFriend(Member member) {
        return findByIsAlreadyFriend(true).contains(member);
    }

    public String getUser() {
        return user;
    }
}
