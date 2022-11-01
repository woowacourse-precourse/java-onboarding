package onboarding;

import java.util.*;

public class Problem7 {
    static final int COMMON_FRIEND_SCORE = 10;
    static final int VISIT_FRIEND_SCORE = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        ArrayList<Member> sortedUserList = getSortedMemberList(user, friends, visitors);
        List<String> answer = getResultList(user, sortedUserList);

        return answer;
    }

    public static List<String> getResultList(String userName, ArrayList<Member> memberList){
        Member user = findMemberByName(userName, memberList);
        ArrayList<String> result = new ArrayList<>();
        int cnt = 0;

        for (Member member : memberList){
            String memberName = member.getMemberName();
            if(isUsersFriend(user, memberName)){
                continue;
            }
            if(isScoreIsZero(member)){
                continue;
            }
            result.add(memberName);
            cnt++;

            if(cnt == 5){
                break;
            }
        }

        return result;
    }

    public static boolean isUsersFriend(Member user, String userName){
        List<String> userFriends = user.getMemberFriends();
        if(userFriends.contains(userName)){
            return true;
        }
        return false;
    }

    public static boolean isScoreIsZero(Member member){
        if(member.getScore() == 0){
            return true;
        }
        return false;
    }

    public static ArrayList<Member> getSortedMemberList(String user, List<List<String>> friends, List<String> visitors){
        ArrayList<Member> memberList = getMemberList(user, friends, visitors);

        setCommonFriendScore(user, memberList, friends);
        setVisitFriendScore(memberList, visitors);

        sortByScore(memberList);

        return memberList;
    }

    public static void sortByScore(ArrayList<Member> memberList){
        Collections.sort(memberList, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                int o1Score = o1.getScore();
                int o2Score = o2.getScore();
                String o1Name = o1.getMemberName();
                String o2Name = o2.getMemberName();

                if(o1Score != o2Score){
                    return o2Score - o1Score;
                } else{
                    return o1Name.compareTo(o2Name);
                }
            }
        });
    }

    public static void setVisitFriendScore(ArrayList<Member> memberList, List<String> visitors){
        for (String visitor : visitors){
            Member findMember = findMemberByName(visitor, memberList);
            if(findMember != null){
                findMember.addScore(VISIT_FRIEND_SCORE);
            }
        }
    }

    public static Member findMemberByName(String name, ArrayList<Member> memberList){
        for (Member member : memberList){
            if(name.equals(member.getMemberName())){
                return member;
            }
        }
        return null;
    }
    public static void setCommonFriendScore(String user, ArrayList<Member> memberList, List<List<String>> friends){
        Member findMember = findMemberByName(user, memberList);

        for (Member member : memberList){
            if(member == findMember){
                 continue;
            }
            int commonFriendNum = getCommonFriendNum(findMember, member);
            member.addScore(commonFriendNum * COMMON_FRIEND_SCORE);
        }
    }

    public static int getCommonFriendNum(Member user, Member member){
        int cnt = 0;

        if(!user.getMemberFriends().isEmpty()){
            List<String> userFriends = user.getMemberFriends();
            List<String> memberFriends = member.getMemberFriends();

            for (String userFriend : userFriends){
                for (String memberFriend : memberFriends){
                    if(userFriend.equals(memberFriend)){
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }


    public static ArrayList<Member> getMemberList(String user, List<List<String>> friends, List<String> visitors){
        ArrayList<Member> memberList = new ArrayList<>();
        Set<String> memberNameSet = getMemberNameSet(user, friends, visitors);

        for (String memberName : memberNameSet){
            Member member = new Member(memberName, friends);
            memberList.add(member);
        }

        return memberList;
    }

    public static Set<String> getMemberNameSet(String user, List<List<String>> friends, List<String> visitors){
        Set<String> memberNames = new HashSet<>();

        memberNames.add(user);

        for (List<String> friendList : friends){
            for (String friend : friendList){
                memberNames.add(friend);
            }
        }

        for (String visitor : visitors){
            memberNames.add(visitor);
        }

        return memberNames;
    }

}

class Member{
    private String memberName;
    private ArrayList<String> memberFriends = new ArrayList<>();
    private int score = 0;

    public Member(String userName, List<List<String>> friends) {
        this.memberName = userName;
        setMemberFriends(friends);
    }

    public void addScore(int score){
        this.score += score;
    }
    public void setMemberFriends(List<List<String>> friends){
        for (List<String> friendList : friends){
            if(friendList.contains(memberName)){
                for (String friend : friendList){
                    if(!friend.equals(memberName)){
                        memberFriends.add(friend);
                    }
                }
            }
        }
    }

    public int getScore(){
        return score;
    }

    public String getMemberName() {
        return memberName;
    }

    public List getMemberFriends() {
        if(memberFriends.size() == 0){
            return Collections.emptyList();
        }
        return memberFriends;
    }
}
