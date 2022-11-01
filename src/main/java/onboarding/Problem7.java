package onboarding;

import onboarding.problem7.infra.UserNameValidation;
import onboarding.problem7.repository.UserRepositoryImpl;
import onboarding.problem7.service.PointService;
import onboarding.problem7.service.UserInfoServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Problem7 {

    private static final UserRepositoryImpl userRepository = new UserRepositoryImpl();
    private static final UserInfoServiceImpl userInfoService = new UserInfoServiceImpl();
    private static final PointService pointService = new PointService();
    private static final int USER_NAME_INDEX = 0;
    private static final int DIFFERENT_USER_NAME_INDEX = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        try {
            UserNameValidation validation = new UserNameValidation();
            valid(user, friends, visitors, validation);

            userInfoCreate(friends);
            Set<String> findFriends = userRepository.findFriends(user);
            pointCalcul(user, visitors, findFriends);

            return pointService.getFriendshipList(user);
        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    private static void valid(String user, List<List<String>> friends, List<String> visitors, UserNameValidation validation) {
        validation.checkValid(user);
        friendValid(friends, validation);
        visitorsValid(visitors, validation);
    }

    private static void visitorsValid(List<String> visitors, UserNameValidation validation) {
        for (String userName : visitors) {
            validation.checkValid(userName);
        }
    }

    private static void friendValid(List<List<String>> friends, UserNameValidation validation) {
        for (List<String> friend : friends) {
            for (String userName : friend) {
                validation.checkValid(userName);
            }
        }
    }

    private static void pointCalcul(String user, List<String> visitors, Set<String> findFriends) {
        pointService.friendshipPointCalcul(findFriends, user);
        pointService.visitorPointCalcul(visitors);
    }

    private static void userInfoCreate(List<List<String>> friends) {
        userInfoService.create(friends, USER_NAME_INDEX, DIFFERENT_USER_NAME_INDEX);
        userInfoService.create(friends, DIFFERENT_USER_NAME_INDEX, USER_NAME_INDEX);
    }

    public static void main(String[] args) {
        String user = "mrko";

        List<List<String>> friends = new ArrayList<>() {{
            add(new ArrayList<>(List.of("donut", "andole")));
            add(new ArrayList<>(List.of("donut", "jun")));
            add(new ArrayList<>(List.of("donut", "mrko")));
            add(new ArrayList<>(List.of("shakevan", "andole")));
            add(new ArrayList<>(List.of("shakevan", "jun")));
            add(new ArrayList<>(List.of("shakevan", "mrko")));
        }};

        List<String> visitors = new ArrayList<>() {{
            addAll(List.of("bedi", "bedi", "donut", "bedi", "shakevan"));
        }};

        System.out.println(solution(user, friends, visitors));
    }
}
