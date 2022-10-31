package onboarding.problem7;

import java.util.ArrayList;
import java.util.List;

public class UserRelationRepository {
    private List<UserRelation> userRelations = new ArrayList<>();

    public void addRelations(List<List<String>> friends) {
        friends.stream().forEach(relation->{
            User user1 = new User(relation.get(0));
            User user2 = new User(relation.get(1));
            userRelations.add(new UserRelation(user1, user2));
            userRelations.add(new UserRelation(user2, user1));
        });
    }
}
