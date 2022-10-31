package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {
    List<User> userRepository = new ArrayList<>();

    public void create(List<String> data) {
    }

    public List<String> getUsers() {
        return this.userRepository.stream().map(user->user.getEmail()).collect(Collectors.toList());
    }

    //userRepository에 User 추가하는 함수 이 때 모든 배열 요소에 체크 함수를 검사한다.

    //userRepository에서 email만 String 배열로 반환하는 함수
}
