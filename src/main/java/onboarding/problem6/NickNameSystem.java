package onboarding.problem6;

import java.util.List;

public class NickNameSystem {
    private static final int EMAIL = 0;
    private static final int NICK_NAME = 1;

    private static void selectForm(List<List<String>> forms) {
        for (List<String> form : forms) {
            String nickName = form.get(NICK_NAME);
            String email = form.get(EMAIL);
        }
    }
}
