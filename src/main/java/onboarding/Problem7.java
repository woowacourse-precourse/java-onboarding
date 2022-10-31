package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        MemberRepository memberRepository = new MemberRepository();
        memberRepository.updateMember(new Member(user, 0));

        for (List<String> friend : friends) {
            memberRepository.updateFriendListByMember(new Member(friend.get(0), 0), friend.get(1));
            memberRepository.updateFriendListByMember(new Member(friend.get(1), 0), friend.get(0));
        }

        updateScoreByUserFriendList(memberRepository, user);
        updateScoreByVisitors(memberRepository, visitors);

        deleteMemberByUserFriendList(user, memberRepository);

        return memberRepository.findAll()
                .stream()
                .sorted((o1, o2) -> {
                    if (o1.getScore() < o2.getScore()) {
                        return 1;
                    } else if (o1.getScore() > o2.getScore()) {
                        return -1;
                    } else {
                        return o1.getName().compareTo(o2.getName());
                    }
                })
                .map(i -> i.getName())
                .limit(5)
                .collect(Collectors.toList());
    }


    static class Member {
        private String name;
        private Integer score;

        private List<String> friendList = new ArrayList<>();


        public Member(String name, Integer score) {
            this.name = name;
            this.score = score;
        }

        public List<String> getFriendList() {
            return friendList;
        }

        public String getName() {
            return name;
        }

        public Integer getScore() {
            return score;
        }

        public void changeScore(Integer score) {
            this.score = score;
        }

    }


    static class MemberRepository {

        private Map<String, Member> store = new HashMap();

        public void updateMember(Member member) {
            store.put(member.getName(), member);
        }

        public void updateFriendListByMember(Member user, String friend) {
            if (!store.containsKey(user.getName())) {
                store.put(user.getName(), user);
            }
            store.get(user.getName()).getFriendList().add(friend);
        }

        public void deleteMember(String user) {
            store.remove(user);
        }

        private boolean containUsername(String user) {
            return store.containsKey(user);
        }


        public Optional<Member> findMemberByUsername(String user) {
            return Optional.ofNullable(store.get(user));
        }

        public List<Member> findAll() {
            return new ArrayList<>(store.values());
        }

        public Optional<List<String>> findFriendListByUsername(String user) {
            Optional<Member> member = findMemberByUsername(user);

            return Optional.ofNullable(member.get().getFriendList());
        }
    }

    private static void updateScoreByUserFriendList(MemberRepository memberRepository,
                                                    String user) {

        Optional<List<String>> friendListByUsername = memberRepository.findFriendListByUsername(user);

        if (!friendListByUsername.isPresent()) {
            return;
        }

        for (String userFriend : friendListByUsername.get()) {
            for (Member member : memberRepository.findAll()) {
                if (member.getFriendList().contains(userFriend)) {
                    member.changeScore(member.score + 10);
                }
            }
        }
    }

    private static void deleteMemberByUserFriendList(String user, MemberRepository memberRepository) {
        Optional<List<String>> friendListByUsername = memberRepository.findFriendListByUsername(user);
        if (!friendListByUsername.isPresent()) {
            return;
        }

        for (String userFriend : friendListByUsername.get()) {
            memberRepository.deleteMember(userFriend);
        }
        memberRepository.deleteMember(user);
    }

    private static void updateScoreByVisitors(MemberRepository memberRepository, List<String> visitors) {

        for (String visitor : visitors) {

            if (!memberRepository.containUsername(visitor)) {
                memberRepository.updateFriendListByMember(new Member(visitor, 1), null);
                continue;
            }

            for (Member member : memberRepository.findAll()) {
                if (member.getName().equals(visitor)) {
                    member.changeScore(member.score + 1);
                }
            }
        }
    }


}
