package onboarding.problem7.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Relation)) return false;
        Relation relation = (Relation) o;
        return memberNames.size() == relation.memberNames.size() &&
                new HashSet<>(memberNames).containsAll(relation.memberNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberNames);
    }
}
