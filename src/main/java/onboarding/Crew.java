package onboarding;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Crew {
    private static final int DUPLICATION_MIN_LENGTH = 2;

    private String email;
    private String name;

    public Crew(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public boolean duplicate(Crew crew) {
        if (equals(crew) || this.name.length() < DUPLICATION_MIN_LENGTH) {
            return false;
        }
        return words().stream()
                .anyMatch(crew::contains);
    }

    private List<String> words() {
        return IntStream.range(0, name.length())
                .mapToObj(this::wordsStartAt)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private List<String> wordsStartAt(int start) {
        return IntStream.range(2, name.length() - start + 1)
                .mapToObj(length -> name.substring(start, start + length))
                .collect(Collectors.toList());
    }

    private boolean contains(String word) {
        return this.name.contains(word);
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Crew crew = (Crew) o;
        return Objects.equals(getEmail(), crew.getEmail()) && Objects.equals(getName(), crew.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getName());
    }
}
