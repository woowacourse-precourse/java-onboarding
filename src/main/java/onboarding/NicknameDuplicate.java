package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Collections.sort;

class NicknameDuplicate {
    List<List<String>> forms;

    public NicknameDuplicate(List<List<String>> forms) {
        this.forms = forms;
    }

    int exception() {
        if((forms.size() < 1) || (forms.size() > 10000)) {
            return -1;
        } else {
            int emailLength, nicknameLength;
            for(int i = 0; i < forms.size(); i++) {
                emailLength = forms.get(i).get(0).length();
                nicknameLength = forms.get(i).get(1).length();

                if((emailLength < 11) || (emailLength >= 20)) {
                    return -1;
                } else if(!(forms.get(i).get(0).substring(emailLength - 9, emailLength).equals("email.com"))) {
                    return -1;
                } else if((nicknameLength < 1) || (nicknameLength >= 20)) {
                    return -1;
                }
            }
        }

        return 0;
    }

    List<String> duplicate() {
        Set<String> nicknameDup = new HashSet<>();
        List<String> result;

        for(int i = 0; i < forms.size(); i++) {
            String nicknameA = forms.get(i).get(1);

            for(int j = i + 1; j < forms.size(); j++) {
                String nicknameB = forms.get(j).get(1);

                if(checkDuplicate(nicknameA, nicknameB)) {
                    nicknameDup.add(forms.get(i).get(0));
                    nicknameDup.add(forms.get(j).get(0));
                }
            }
        }

        result = new ArrayList<>(nicknameDup);
        sort(result);

        return result;
    }

    boolean checkDuplicate(String nicknameA, String nicknameB) {
        for(int i = 0; i < nicknameA.length() - 1; i++) {
            if(nicknameB.contains(nicknameA.substring(i, i + 2))) {
                return true;
            }
        }

        return false;
    }
}
