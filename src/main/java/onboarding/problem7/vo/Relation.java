package onboarding.problem7.vo;

import onboarding.problem7.validation.RelationsValidator;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 친구관계인 두 유저의 이름을 가지고 있는 VO 클래스입니다.
 * @author BackFoxx
 */
public class Relation {
    private final List<String> memberNames;

    public Relation(List<String> memberNames) {
        this.memberNames = memberNames;
    }

    /**
     * 친구관계인 두 유저의 이름으로 Relation 객체를 만드는 정적 팩토리 메소드입니다.
     * @param memberNames 친구관계인 두 유저의 이름을 가지고 있는 String 배열입니다.
     */
    public static Relation of(List<String> memberNames) {
        return new Relation(memberNames);
    }

    /**
     * 친구관계인 두 유저의 이름 배열이 여러 개 주어졌을 때 한 번에 Relation 으로 만들어 리스트를 반환하는 정적 팩토리 메소드입니다.
     * @param relations '친구관계인 두 유저의 이름 배열'의 배열입니다.
     */
    public static List<Relation> ofList(List<List<String>> relations) {
        RelationsValidator.validate(relations);
        return relations.stream()
                .map(Relation::of)
                .collect(Collectors.toList());
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
