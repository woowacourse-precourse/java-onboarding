package onboarding.problem6.repository;

import onboarding.problem6.vo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User 리스트의 상태를 관리하는 리포지토리 클래스입니다.
 * @author BackFoxx
 */
public class UserRepository {
    private final List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    /**
     * User 객체 하나를 저장합니다.
     * @param user 저장할 User 객체입니다.
     */
    public void save(User user) {
        users.add(user);
    }

    /**
     * UserRepository 가 갖고 있는 User 리스트 전체를 조회합니다.
     */
    public List<User> findAll() {
        return users;
    }

    /**
     * name 필드에 word 값이 포함된 User 를 전부 조회합니다.
     * @param word name 값에 포함되었는 지 확인할 문자열입니다.
     */
    public List<User> findAllByNameContaining(String word) {
        return users.stream()
                .filter(user -> user.getName().contains(word))
                .collect(Collectors.toList());
    }
}
