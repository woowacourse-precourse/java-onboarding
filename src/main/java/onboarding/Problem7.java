package onboarding;


import onboarding.problem7.*;

import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        UserRepository userRepository = new UserRepository();
        FriendRepository friendRepository = new FriendRepository();
        VisitorRepository visitorRepository = new VisitorRepository();

        UserService userService = new UserService(userRepository, friendRepository, visitorRepository);
        ScoreService scoreService = new ScoreService(userRepository, friendRepository, visitorRepository);

        userService.saveAll(user, friends, visitors);
        userService.saveFriends(friends);
        userService.saveVisitor(user, visitors);

        List<User> recommendList = scoreService.getRecommendList(user);

        return recommendList.stream()
                .map(User::getName)
                .limit(5)
                .collect(Collectors.toList());

    }

}