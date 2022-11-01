package onboarding.problem6;

public class Crews {

    private final int MAX_CREWS_SIZE = 10_000;

    private List<Crew> crews;

    public Crews() {
        crews = new LinkedList<>();
    }

    public boolean add(Crew crew) {

        if (crews.size() == MAX_CREWS_SIZE) return false;

        crews.add(crew);
        return true;
    }

}
