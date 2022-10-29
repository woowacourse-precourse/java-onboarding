package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static onboarding.problem7.FindList.*;
import static onboarding.problem7.Score.calculateTopThree;
import static onboarding.problem7.Validation.*;

public class Problem7 {

    private static final String OUT_OF_RANGE = "입력 값 길이가 잘못되었습니다.";
    private static final String INVALID_ID = "아이디 형식이 잘못되었습니다.";
    private static final String RESULT_NOT_EXIST = "추천 할 친구가 존재하지 않습니다.";

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> id = listInitialization(user, friends, visitors)
                .stream()
                .distinct()
                .collect(Collectors
                        .toList());

        if (isIdOutOfRange(id) || isListIndexOutOfRange(id)) {
            answer.add(OUT_OF_RANGE);
            return answer;
        }

        if (isInvalidId(id)) {
            answer.add(INVALID_ID);
            return answer;
        }

        answer = calculateTopThree(user, friends, visitors);

        if (answer.isEmpty()) {
            answer.add(RESULT_NOT_EXIST);
            return answer;
        }

        return answer;
    }

    private static List<String> listInitialization(String user, List<List<String>> friends, List<String> visitors) {
        List<String> id = new ArrayList<>();

        List<String> friendList = findAlreadyFriendList(user, friends);
        List<String> friendOfFriendList = findFriendOfFriendList(user, friendList, friends);
        List<String> othersList = findOthersList(visitors, friendList, friendOfFriendList);

        id.add(user);
        id.addAll(friendList);
        id.addAll(friendOfFriendList);
        id.addAll(othersList);

        return id;
    }
}
