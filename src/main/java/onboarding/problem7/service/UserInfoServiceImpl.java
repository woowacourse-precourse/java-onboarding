package onboarding.problem7.service;

import onboarding.problem7.repository.UserRepository;
import onboarding.problem7.repository.UserRepositoryImpl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class UserInfoServiceImpl implements UserInfoService {

    private static final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public void create(List<List<String>> forms, int userNameIndex, int differentUserNameIndex) {
        for (List<String> friend : forms) {
            String userKey = friend.get(userNameIndex);
            String userFriend = friend.get(differentUserNameIndex);

            // map 에 사용자가 존재하는지
            if (userRepository.existsUser(userKey)) {
                // 사용자의 친구목록 리스트에 추가허여 merge 작업
                Set<String> friendList = userRepository.findFriends(userKey);
                friendList.add(userFriend);

                userRepository.save(userKey, friendList);
                continue;
            }

            // 존재하지 않으면 새로 추가
            userRepository.save(userKey, new LinkedHashSet<>(Set.of(userFriend)));
        }
    }
}
