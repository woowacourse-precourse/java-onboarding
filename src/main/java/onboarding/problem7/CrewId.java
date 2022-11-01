package onboarding.problem7;

import java.util.Objects;

public class CrewId implements Comparable<CrewId> {

    protected final String id;

    public CrewId(String id) {
        validateIdLength(id);
        assertIdIsLowerAlphabet(id);

        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CrewId crewId = (CrewId) o;

        return Objects.equals(id, crewId.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public int compareTo(CrewId o) {
        return this.id.compareTo(o.getId());
    }

    private void validateIdLength(String id) throws IllegalArgumentException {
        if (!(1<=id.length() && id.length()<=30)) {
            throw new IllegalArgumentException("id의 길이는 1이상 30이하여야 합니다.");
        }
    }

    private void assertIdIsLowerAlphabet(String id) throws IllegalArgumentException {
        if (!id.matches("^[a-z]+$")) {
            throw new IllegalArgumentException("id는 알파벳 소문자로만 이루어져야 합니다.");
        }
    }
}
