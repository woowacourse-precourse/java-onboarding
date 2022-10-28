package onboarding.domain.problem6;

import java.util.List;

public class Nickname {
    final private String name;
    public Nickname(String name) {
        this.name = name;
    }

    public boolean hasOverlap(Nickname other) {
        for (int i=0; i<name.length()-1;i++)
            if (other.name.contains(name.substring(i,i+2)))
                return true;
        return false;
    }
}
