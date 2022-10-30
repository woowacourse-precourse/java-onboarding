package onboarding.problem6;

import java.util.List;

public class NickNameSystem {
    private static final int EMAIL = 0;
    private static final int NICK_NAME = 1;

    private void selectForm(List<List<String>> forms) {
        for (List<String> form : forms) {
            checkNickName(form);
        }
    }

    private void checkNickName(List<String> form) {
        String selectedName = form.get(NICK_NAME);
        String email = form.get(EMAIL);
        for (int idx = 0; idx < selectedName.length() - 1; idx++) {
            String subStr = selectedName.substring(idx, idx + 2);
        }
    }
}
