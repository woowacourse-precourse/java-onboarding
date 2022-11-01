package onboarding.problem6.crew;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CrewRepository {

	private Map<String, Crew> crewMap = new HashMap<>();

	public void addCrew(Crew crew) {
		crewMap.computeIfAbsent(crew.getNickname(), c -> crew);
	}

	public List<Crew> getAllCrews() {
		return new ArrayList<>(crewMap.values());
	}
}
