package onboarding.problem6.crew;

import static onboarding.problem6.Problem6Constant.*;

import java.util.List;
import java.util.stream.Collectors;

import onboarding.problem6.dto.CrewInfoListDto;

public class CrewService {

	private final CrewRepository crewRepository = new CrewRepository();

	public void saveCrewsByCrewInfos(CrewInfoListDto crewInfoListDto) {
		List<List<String>> crewInfoList =
			crewInfoListDto.getCrewInfoList();

		for (List<String> info : crewInfoList) {
			String email = info.get(EMAIL_INDEX);
			String nickname = info.get(NICKNAME_INDEX);

			Crew crew = new Crew(email, nickname);

			crewRepository.addCrew(crew);
		}

	}

	public List<Crew> getAllCrews() {
		return crewRepository.getAllCrews();
	}

	public List<String> toResultForm(List<Crew> duplicateCrews) {
		return duplicateCrews.stream()
			.map(Crew::getEmail)
			.distinct()
			.sorted()
			.collect(Collectors.toList());
	}

}
