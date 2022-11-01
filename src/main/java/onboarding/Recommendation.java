package onboarding;

import java.util.*;

class Recommendation {
    String user;
    List<List<String>> friends;
    List<String> visitors;
    HashMap<String, Integer> users;
    List<String> userFriend;

    public Recommendation(String user, List<List<String>> friends, List<String> visitors) {
        this.user = user;
        this.friends = friends;
        this.visitors = visitors;
        this.users = new HashMap<>();
        this.userFriend = new ArrayList<>();
    }

    int exception() {
        if((user.length() < 1) || (user.length() > 30)) {
            return -1;
        } else if((friends.size() < 1) || (friends.size() > 10000)) {
            return -1;
        } else if((visitors.size() > 10000)) {
            return  -1;
        } else {
            for(int i = 0; i < friends.size(); i++) {
                if((friends.get(i).get(0).length() < 1) || (friends.get(i).get(0).length() > 30)) {
                    return -1;
                } else if((friends.get(i).get(1).length() < 1) || (friends.get(i).get(1).length() > 30)) {
                    return -1;
                }
            }
        }

        return 0;
    }

    void init() {
        for(int i = 0; i < friends.size(); i++) {
            users.put(friends.get(i).get(0), 0);
            users.put(friends.get(i).get(1), 0);
        }
        for(int i = 0; i < visitors.size(); i++) {
            users.put(visitors.get(i), 0);
        }
    }

    void visitScore() {
        int value;

        for(int i = 0; i < visitors.size(); i++) {
            value = users.get(visitors.get(i));
            users.put(visitors.get(i), value + 1);
        }
    }

    void acquainScore() {
        userFriend();
        int value;

        for(int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < userFriend.size(); j++) {
                if (friends.get(i).get(0).equals(userFriend.get(j))) {
                    if(friends.get(i).get(1).equals(user)) {
                        continue;
                    }
                    value = users.get(friends.get(i).get(1));
                    users.put(friends.get(i).get(1), value + 10);
                } else if (friends.get(i).get(1).equals(userFriend.get(j))) {
                    if(friends.get(i).get(0).equals(user)) {
                        continue;
                    }
                    value = users.get(friends.get(i).get(0));
                    users.put(friends.get(i).get(0), value + 10);
                }
            }
        }
    }

    void userFriend() {
        for(int i = 0; i < friends.size(); i++) {
            if(friends.get(i).get(0).equals(user)) {
                userFriend.add(friends.get(i).get(1));
            } else if(friends.get(i).get(1).equals(user)) {
                userFriend.add(friends.get(i).get(0));
            }
        }
    }

    List<String> sorting() {
        List<String> result = new ArrayList<>();
        List<String> sortingResult =  new ArrayList<>(users.keySet());
        Collections.sort(sortingResult, ((o1, o2) -> Integer.compare(users.get(o2), users.get(o1))));

        int cnt = 0;
        for(int i = 0; i < sortingResult.size(); i++) {
            if(cnt == 5) {
                break;
            }

            if(userFriend.contains(sortingResult.get(i)) || sortingResult.get(i).equals(user)) {
                continue;
            } else {
                result.add(sortingResult.get(i));
            }
        }

        return result;
    }
}
