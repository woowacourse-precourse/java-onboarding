package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;


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

    public Set<Integer> DuplicateNicknameIndex() {
        Map<String,Integer> map = new HashMap();
        Set<Integer> result = new TreeSet<>();

        for(int i = 0; i < this.split_nickname.size(); i++) {
            if (map.containsKey(split_nickname.get(i))) {
                result.add(forms_idx.get(i));
                result.add(map.get(split_nickname.get(i)));
            }
            else if (!map.containsKey(split_nickname.get(i)))
                map.put(split_nickname.get(i), i);
        }
        return result;
    }


 }
