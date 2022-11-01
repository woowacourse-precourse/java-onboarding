package onboarding;

import java.util.*;

public class Problem7 {
    static final int COMMON_FRIEND_SCORE = 10;
    static final int VISIT_FRIEND_SCORE = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        ArrayList<User> sortedUserList = getSortedUserList(user, friends, visitors);
        List<String> answer = getResultList(user, sortedUserList);

        return answer;
    }

    public static List<String> getResultList(String userName, ArrayList<User> userList){
        User user = findUserByName(userName, userList);
        ArrayList<String> result = new ArrayList<>();
        int cnt = 0;

        for (User otherUser : userList){
            String otherUserName = otherUser.getUserName();
            if(isUsersFriend(user, otherUserName)){
                continue;
            }
            if(isScoreIsZero(otherUser)){
                continue;
            }
            result.add(otherUserName);
            cnt++;

            if(cnt == 5){
                break;
            }
        }

        return result;
    }

    public static boolean isUsersFriend(User user, String userName){
        List<String> userFriends = user.getUserFriends();
        if(userFriends.contains(userName)){
            return true;
        }
        return false;
    }

    public static boolean isScoreIsZero(User otherUser){
        if(otherUser.getScore() == 0){
            return true;
        }
        return false;
    }

    public static ArrayList<User> getSortedUserList(String user, List<List<String>> friends, List<String> visitors){
        ArrayList<User> userList = getUserList(user, friends, visitors);

        setCommonFriendScore(user, userList, friends);
        setVisitFriendScore(userList, visitors);

        sortByScore(userList);

        return userList;
    }

    public static void sortByScore(ArrayList<User> userList){
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int o1Score = o1.getScore();
                int o2Score = o2.getScore();
                String o1Name = o1.getUserName();
                String o2Name = o2.getUserName();

                if(o1Score != o2Score){
                    return o2Score - o1Score;
                } else{
                    return o1Name.compareTo(o2Name);
                }
            }
        });
    }

//    public static int compareByName(User o1, User o2){
//        String o1Name = o1.getUserName();
//        String o2Name = o2.getUserName();
//        int i = 0;
//
//        while(true){
//            if(o1Name.charAt(i) > o2Name.charAt(i)){
//                return 1;
//            }
//            if(o1Name.charAt(i) < o2Name.charAt(i)){
//                return -1;
//            }
//            i++;
//        }
//    }

    public static void setVisitFriendScore(ArrayList<User> userList, List<String> visitors){
        for (String visitor : visitors){
            User findUser = findUserByName(visitor, userList);
            if(findUser != null){
                findUser.addScore(VISIT_FRIEND_SCORE);
            }
        }
    }

    public static User findUserByName(String name, ArrayList<User> userList){
        for (User user : userList){
            if(name.equals(user.getUserName())){
                return user;
            }
        }
        return null;
    }
    public static void setCommonFriendScore(String user, ArrayList<User> userList, List<List<String>> friends){
        User user1 = findUserByName(user, userList);

        for (User otherUser : userList){
            if(otherUser == user1){
                 continue;
            }
            int commonFriendNum = getCommonFriendNum(user1, otherUser);
            otherUser.addScore(commonFriendNum * COMMON_FRIEND_SCORE);
        }
    }

    public static int getCommonFriendNum(User user, User otherUser){
        int cnt = 0;

        if(!user.getUserFriends().isEmpty()){
            List<String> userFriends = user.getUserFriends();
            List<String> otherUserFriends = otherUser.getUserFriends();

            for (String userFriend : userFriends){
                for (String otherUserFriend : otherUserFriends){
                    if(userFriend.equals(otherUserFriend)){
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }


    // 방문자 이름 set을 User객체로 만들어 반환
    public static ArrayList<User> getUserList(String user, List<List<String>> friends, List<String> visitors){
        ArrayList<User> userList = new ArrayList<>();
        Set<String> userNameSet = getUserNameSet(user, friends, visitors);

        for (String userName : userNameSet){
            User addUser = new User(userName, friends);
            userList.add(addUser);
        }

        return userList;
    }


    // friends + visitors 모든 방문자 이름 set 반환
    public static Set<String> getUserNameSet(String user, List<List<String>> friends, List<String> visitors){
        Set<String> userNames = new HashSet<>();

        userNames.add(user);

        for (List<String> friendList : friends){
            for (String friend : friendList){
                userNames.add(friend);
            }
        }

        for (String visitor : visitors){
            userNames.add(visitor);
        }

        return userNames;
    }

}

class User{
    private String userName;
    private ArrayList<String> userFriends = new ArrayList<>();
    private int score = 0;

    public User(String userName, List<List<String>> friends) {
        this.userName = userName;
        setFriends(friends);
    }

    public void addScore(int score){
        this.score += score;
    }
    public void setFriends(List<List<String>> friends){
        for (List<String> friendList : friends){
            if(friendList.contains(userName)){
                for (String friend : friendList){
                    if(!friend.equals(userName)){
                        userFriends.add(friend);
                    }
                }
            }
        }
    }

    public int getScore(){
        return score;
    }

    public String getUserName() {
        return userName;
    }

    public List getUserFriends() {
        if(userFriends.size() == 0){
            return Collections.emptyList();
        }
        return userFriends;
    }
}
