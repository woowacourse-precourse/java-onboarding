package onboarding.problem6.crew;

import java.util.List;

import onboarding.problem6.dto.CrewInfoListDto;

public class CrewService {

	private CrewRepository crewRepository = new CrewRepository();

	public void saveCrewsByCrewInfos(CrewInfoListDto crewInfoListDto) {
		List<List<String>> crewInfoList =
			crewInfoListDto.getCrewInfoList();

		for (List<String> info : crewInfoList) {
			String email = info.get(0);
			String nickname = info.get(1);

			Crew crew = new Crew(email, nickname);

			crewRepository.addCrew(crew);
		}

	}

	public List<Crew> getAllCrews() {
		return crewRepository.getAllCrews();
	}

}
