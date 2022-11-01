package onboarding.problem6.dto;

import java.util.List;

public class CrewInfoListDto {

	private List<List<String>> crewInfoList;

	public CrewInfoListDto(List<List<String>> crewInfoList) {
		this.crewInfoList = crewInfoList;
	}

	public List<List<String>> getCrewInfoList() {
		return crewInfoList;
	}
}
