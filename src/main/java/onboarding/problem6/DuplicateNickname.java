package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;

public class DuplicateNickname {

    final static int NICKNAME = 1;
    private final List<Integer> forms_idx = new ArrayList<>();
    private final List<String> split_nickname = new ArrayList<>();

    public DuplicateNickname(List<List<String>> froms) {
        SplitNicknameInit(froms);
    }

    private void SplitNicknameInit(List<List<String>> froms) {
        for (int i=0; i < froms.size(); i++) {
            String nickname = froms.get(i).get(NICKNAME);

            for (int j=0; j < nickname.length() - 1; j++) {
                this.forms_idx.add(i);
                this.split_nickname.add(nickname.substring(j, j+2));
            }
        }
    }

}
