package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;

public class CrewController {
	private final DuplicationChecker duplicationChecker;
	private final ResultStyleFormatter resultStyleFormatter;

	public CrewController(DuplicationChecker duplicationChecker, ResultStyleFormatter resultStyleFormatter) {
		this.duplicationChecker = duplicationChecker;
		this.resultStyleFormatter = resultStyleFormatter;
	}

	private List<Crew> getCrews(List<List<String>> forms) {
		List<Crew> crews = new ArrayList<>();
		for (List<String> crew : forms) {
			crews.add(new Crew(crew.get(0), crew.get(1)));
		}
		return crews;
	}

	public List<String> process(List<List<String>> forms) {
		List<Crew> crews = getCrews(forms);

		List<Crew> duplicatedCrews = duplicationChecker.getDuplicatedCrews(crews);
		List<String> result = resultStyleFormatter.getResult(duplicatedCrews);
		return result;
	}
}
