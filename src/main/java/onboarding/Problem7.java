package onboarding;

import onboarding.problem7.Problem7Service;
import onboarding.problem7.Problem7SnsRepository;
import onboarding.problem7.RepositoryFactory;
import onboarding.problem7.User;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {
    static final Problem7SnsRepository repo=RepositoryFactory.makeProblem7SnsRepository();
    static final Problem7Service problem7Service=new Problem7Service();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        repo.removeAll();
        problem7Service.save(user);
        for(int i=0;i<friends.size();i++){
            List<String> friendPair = friends.get(i);
            problem7Service.save(friendPair.get(0));
            problem7Service.save(friendPair.get(1));
            problem7Service.addFriend(friendPair.get(0),friendPair.get(1));
        }

        for(String visitor:visitors){
            problem7Service.save(visitor);
        }

        List<User> users = problem7Service.suggestUser(user, visitors);
        List<String> suggestUserName = users.stream().map(u -> u.getUserName()).collect(Collectors.toList());
        return suggestUserName;
    }
}
