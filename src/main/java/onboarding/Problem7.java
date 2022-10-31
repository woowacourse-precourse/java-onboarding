package onboarding;

import problem7.FriendCommendResponseDto;
import problem7.UserRepository;
import problem7.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        UserService userService = new UserService(new UserRepository());
        userService.addFriends(friends);
        List<FriendCommendResponseDto> responseDtos = userService.operateFriendCommendation(user, visitors);

        return responseDtos.stream().map(FriendCommendResponseDto::getUserId).collect(Collectors.toList());
    }
}
