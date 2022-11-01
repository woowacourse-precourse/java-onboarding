package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {

        Forms input = new Forms(forms);

        for (int i = 0; i < input.getSize() - 1; i++) {
            Nickname nickname1 = input.findNickname(i);
            for (int j = i + 1; j < input.getSize(); j++) {
                Nickname nickname2 = input.findNickname(j);
                if (nickname1.compare(nickname2)) {
                    input.updateDuplications(i);
                    input.updateDuplications(j);
                }
            }
        }

        return input.getMailList();

    }

}


class Forms {
    private final HashMap<Nickname, Email> forms = new HashMap<>();
    private final ArrayList<Nickname> nicknames;
    private final ArrayList<Boolean> duplications = new ArrayList<>();

    public Forms (List<List<String>> input){
        validateSize(input);
        for (List<String> form : input) {
            Nickname nickname = new Nickname(form.get(1));
            Email email = new Email(form.get(0));
            this.forms.put(nickname, email);
            this.duplications.add(false);
        }
        this.nicknames = new ArrayList<>(this.forms.keySet());
    }

    private void validateSize(List<List<String>> input) {
        if (input.size() < 1) {
            throw new IllegalArgumentException("크루원은 최소 1명은 있어야합니다.");
        }
        if (input.size() > 10000) {
            throw new IllegalArgumentException("크루원은 10000명일 수 없습니다.");
        }
    }

    public Nickname findNickname (int idx) {
        return this.nicknames.get(idx);
    }

    public Map<Nickname, Email> getForms() {
        return this.forms;
    }

    public int getSize() {
        return this.forms.size();
    }

    public void updateDuplications(int idx) {
        duplications.set(idx, true);
    }

    public List<String> getMailList() {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nicknames.size(); i++) {
            if (duplications.get(i)) {
                String emailString = forms
                        .get(nicknames.get(i))
                        .getEmail();
                set.add(emailString);
            }
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
}

class Nickname {

    private final String nickname;

    private final List<String> partNickName = new ArrayList<>();

    public Nickname(String nickname) {
        validateSize(nickname);
        this.nickname = nickname;
        cuttingNickname();
    }

    private void validateSize(String nickname) {
        if(nickname.length() < 1) {
            throw new IllegalArgumentException("닉네임은 공백은 불가합니다.");
        }
        if(nickname.length() >= 20){
            throw new IllegalArgumentException("닉네임은 20자 미만으로 입력해주세요");
        }
    }

    private void cuttingNickname() {
        String temp;
        for (int j = 0; j < this.nickname.length()-1; j++) {
            temp = this.nickname.substring(j, j + 2);
            this.partNickName.add(temp);
        }
    }

    public String getNickname() {
        return this.nickname;
    }

    public List<String> getPartNickName() {
        return this.partNickName;
    }

    public boolean compare(Nickname target) {
        boolean flag =  false;
        String targetString = target.getNickname();
        for (String twoChar : partNickName) {
            if (targetString.contains(twoChar)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}



class Email {

    private final String email;

    public Email(String email) {
        validateSize(email);
        validateDomain(email);
        this.email = email;
    }

    private void validateDomain(String email) {
        if(!email.matches(".+@email.com")){
            throw new IllegalArgumentException("이메일을 ~@email.com 형식으로 입력해주세요.");
        }
    }

    private void validateSize(String email){
        if(email.length() < 11) {
            throw new IllegalArgumentException("이메일은 11자 이상만 가능합니다.");
        }
        if(email.length() > 20) {
            throw new IllegalArgumentException("이메일은 20자 이하만 가능합니다.");
        }
    }

    public String getEmail() {
        return this.email;
    }

}
