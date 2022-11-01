package onboarding.problem6.vo;

import java.util.Objects;

/**
 * 크루의 이메일과 이름을 보관하고 있는 VO 클래스입니다.
 * @author BackFoxx
 */
public class Crew {
    private final String email;
    private final String name;

    public Crew(String email, String name) {
        this.email = email;
        this.name = name;
    }

    /**
     * 인자로 들어온 값을 email 과 name 으로 하는 Crew 객체를 만드는 정적 팩토리 메소드입니다.
     * @param email 이메일 값입니다.
     * @param name 닉네임 값입니다.
     */
    public static Crew of(String email, String name) {
        return new Crew(email, name);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object anotherCrew) {
        if (this == anotherCrew)
            return true;
        if (!(anotherCrew instanceof Crew))
            return false;
        Crew crew = (Crew)anotherCrew;
        return email.equals(crew.email) && name.equals(crew.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name);
    }
}
