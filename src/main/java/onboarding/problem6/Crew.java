package onboarding.problem6;

import onboarding.exception.ExceptionMessage;
import onboarding.exception.InputException;
import onboarding.problem6.exception.Problem6ExceptionMessage;

import java.util.List;

public class Crew {

    private Email email;
    private Nickname nickname;


    public Crew(List<String> form){
        if (form.size() != 2) throw new InputException(Problem6ExceptionMessage.NOT_FORM_MATCHED);
        this.email = new Email(form.get(0));
        this.nickname = new Nickname(form.get(1));
    }

    public String getEmail(){
        return email.getEmail();
    }

    public String getNickname(){
        return nickname.getNickname();
    }
}
