package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Member> memberDataBase = new HashMap<>();

        checkFriendStatus(memberDataBase, friends);

        addScoreByUserFriend(memberDataBase, user);

        addScoreByVisit(memberDataBase, user, visitors);

        return extractResultByScore(memberDataBase, user);
    }

    private static void checkFriendStatus(Map<String, Member> memberDataBase, List<List<String>> friends) {
        for (List<String> friendList : friends) {
            Member friend0 = getMemberData(memberDataBase, friendList.get(0));
            Member friend1 = getMemberData(memberDataBase, friendList.get(1));

            addFriendEachOther(friend0, friend1);
        }
    }

    private static List<String> extractResultByScore(Map<String, Member> memberDataBase, String user) {
        List<String> rtValList = new ArrayList<>();

        List<Member> memberDataBaseList = new ArrayList<Member>(memberDataBase.values());

        memberDataBaseList.sort(null);

        for (Member tempMember : memberDataBaseList) {
            if (tempMember.getName().equals(user)) {
                continue;
            }

            if (tempMember.getRecommendScore() > 0) {
                rtValList.add(tempMember.getName());
            }
        }
        return rtValList;
    }

    private static void addScoreByVisit(Map<String, Member> memberDataBase, String user, List<String> visitors) {
        for (String visitor : visitors) {
            Member tempVisitor = getMemberData(memberDataBase, visitor);

            tempVisitor.addRecommendScoreByVisitors();
        }
    }

    private static void addScoreByUserFriend(Map<String, Member> memberDataBase, String user) {
        List<Member> memberFriendList = getMemberData(memberDataBase, user).getFriendList();

        if (memberFriendList != null) {
            for (Member myFriend : memberFriendList) {
                myFriend.setFriendState();

                List<Member> friendListOfMyFriend = getMemberData(memberDataBase, myFriend.getName()).getFriendList();

                for (Member friend : friendListOfMyFriend) {
                    if (friend.getName().equals(user))
                        continue;

                    friend.addRecommendScoreByFriendship();
                }
            }
        }
    }

    private static Member getMemberData(Map<String, Member> userDataBase, String userName) {
        Member tempMember = userDataBase.get(userName);
        if (tempMember == null) {
            userDataBase.put(userName, new Member(userName, 0));
        }

        return userDataBase.get(userName);
    }

    private static void addFriendEachOther(Member friend1, Member friend2) {
        List<Member> friendList1 = friend1.getFriendList();
        friendList1.add(friend2);

        List<Member> friendList2 = friend2.getFriendList();
        friendList2.add(friend1);
    }

    static class Member implements Comparable<Member> {
        private String name;
        private int recommendScore;
        private List<Member> friendList = new ArrayList<>();

        public Member(String name, int recommendScore) {
            this.name = name;
            this.recommendScore = recommendScore;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Member> getFriendList() {
            return friendList;
        }

        public int getRecommendScore() {
            return recommendScore;
        }

        public void setRecommendScore(int recommendScore) {
            this.recommendScore = recommendScore;
        }

        public void addRecommendScoreByFriendship() {
            if (this.recommendScore < 0) {
                return;
            }

            this.recommendScore += 10;
        }

        public void addRecommendScoreByVisitors() {
            if (this.recommendScore < 0) {
                return;
            }

            this.recommendScore += 1;
        }

        public void setFriendState() {
            this.recommendScore = -1;
        }

        @Override
        public int compareTo(Member u) {
            if (this.getRecommendScore() > u.getRecommendScore()) {
                return -1;
            } else if (this.getRecommendScore() < u.getRecommendScore()) {
                return 1;
            } else {
                return this.getName().compareTo(u.getName());
            }
        }
    }
}
