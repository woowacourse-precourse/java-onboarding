package onboarding.problem7.vo;

import java.util.List;
import java.util.function.Consumer;

public class Relation {
    private final List<String> memberNames;

    public Relation(List<String> memberNames) {
        this.memberNames = memberNames;
    }

    public static Relation of(List<String> memberNames) {
        return new Relation(memberNames);
    }

    public void forEach(Consumer<? super String> action) {
        memberNames.forEach(action);
    }

    public boolean contains(String name) {
        return memberNames.contains(name);
    }

    public String getMemberName() {
        return memberNames.get(0);
    }

    public String getAnotherMemberName() {
        return memberNames.get(1);
    }
}
