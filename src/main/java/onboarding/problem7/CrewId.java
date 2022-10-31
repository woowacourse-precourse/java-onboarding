package onboarding.problem7;

import java.util.Comparator;
import java.util.Objects;

public class CrewId implements Comparable<CrewId> {

    protected final String id;

    public CrewId(String id) {
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
}
