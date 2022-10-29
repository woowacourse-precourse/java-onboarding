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

    @Override
    public boolean equals(Object obj) {
        if (obj==null) return false;
        if (getClass() != obj.getClass()) return false;
        if (name.equals(((Nickname)obj).name)) return true;
        return false;
    }
}
