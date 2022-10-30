package onboarding.problem6;

import onboarding.problem6.utils.Converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserList {
    private List<User> userList = new ArrayList<>();
    private Set<String> warningList = new HashSet<>();


    public void addUser(User user) {
        userList.add(user);
    }

    public List<String> generateWarningList() {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            List<String> partOfNicknameList = user.getPartOfNicknameList();
            checkConfusing(partOfNicknameList, i);
        }
        List<String> warningList = Converter.convertSetToList(this.warningList);
        return Converter.convertSortedList(warningList);
    }

    private void checkConfusing(List<String> partOfNicknameList, int curIndex) {
        for (int j = 0; j < userList.size(); j++) {
            if (j == curIndex) {
                continue;
            }

            addWarningList(partOfNicknameList, j);
        }
    }

    private void addWarningList(List<String> partOfNicknameList, int curIndex) {
        User user = userList.get(curIndex);
        if (user.checkConfusing(partOfNicknameList)) {
            warningList.add(user.getEmail());
        }
    }
}
