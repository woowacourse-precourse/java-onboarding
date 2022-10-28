package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;


public class DuplicateNickname {

    final static int NICKNAME = 1;
    private final List<Integer> formsIdx;
    private final List<String> splitNickname;

    public DuplicateNickname(List<List<String>> froms) {
        formsIdx = new ArrayList<>();
        splitNickname = new ArrayList<>();
        initNicknameSplit(froms);
    }

    public Set<Integer> duplicateNicknameIndex() {
        Map<String,Integer> withoutDuplicateNickname = new HashMap();
        Set<Integer> result = new TreeSet<>();

        for(int i = 0; i < this.splitNickname.size(); i++) {
            if (withoutDuplicateNickname.containsKey(splitNickname.get(i))) {
                result.add(formsIdx.get(i));
                result.add(withoutDuplicateNickname.get(splitNickname.get(i)));
            } else if (!withoutDuplicateNickname.containsKey(splitNickname.get(i))) {
                withoutDuplicateNickname.put(splitNickname.get(i), i);
            }
        }
        return result;
    }

    private void initNicknameSplit(List<List<String>> froms) {
        for (int i=0; i < froms.size(); i++) {
            String nickname = froms.get(i).get(NICKNAME);

            for (int j=0; j < nickname.length() - 1; j++) {
                this.formsIdx.add(i);
                this.splitNickname.add(nickname.substring(j, j+2));
            }
        }
    }

 }
