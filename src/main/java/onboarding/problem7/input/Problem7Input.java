package onboarding.problem7.input;

import onboarding.problem.ProblemInput;
import onboarding.problem7.domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7Input implements ProblemInput {

    private final User user;
    private final Map<String, User> userMap;

    public Problem7Input(String user, List<List<String>> friendRelations, List<String> visitors) {
        userMap = new HashMap<>();
        this.user = new User(user);

        userMap.put(this.user.getName(), this.user);

        makeFriends(friendRelations);
        makeVisitor(visitors);
    }

    private void makeFriends(List<List<String>> friendRelations) {
        for (List<String> friendRelation : friendRelations) {
            String fromName = friendRelation.get(0);
            if (isUserNotRegistered(fromName)) {
                userMap.put(fromName,  new User(fromName));
            }

            String toName = friendRelation.get(1);
            if (isUserNotRegistered(toName)) {
                userMap.put(toName,  new User(toName));
            }

            User fromUser = userMap.get(fromName);
            User toUser = userMap.get(toName);
            fromUser.addFriend(toUser);
        }
    }

    private boolean isUserNotRegistered(String fromName) {
        return !userMap.containsKey(fromName);
    }

    private void makeVisitor(List<String> visitors) {
        for (String name : visitors) {
            if (isUserNotRegistered(name)) {
                userMap.put(name,  new User(name));
            }

            User visitor = userMap.get(name);
            this.user.addVisitor(visitor);
        }
    }

    @Override
    public boolean hasError() {
        return false;
    }
}
