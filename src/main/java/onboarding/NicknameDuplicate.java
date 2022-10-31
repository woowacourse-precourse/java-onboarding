package onboarding;

import java.util.List;

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

}
