package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Nickname {
    private String email;
    private String name;

    public Nickname(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public List<String> getToken(){
        List<String> result = new ArrayList<>(name.length() - 1);
        for(int i = 0; i < name.length()-1; i++) {
            result.add(name.substring(i, i+2));
        }
        return result;
    }
}
