package onboarding.problem6;

import java.util.LinkedList;
import java.util.List;

public class NicknameFilter {

	public List<Crew> doFilter(List<Crew> crewList) {
		List<Crew> duplicatedList = null;

		for(Crew i : crewList){
			duplicatedList = findDuplicatedCrew(i, crewList);

			if(duplicatedList.size() > 0){
				duplicatedList.add(i);
				break;
			}
		}

		if(duplicatedList != null && duplicatedList.size() > 0){
			crewList.removeAll(duplicatedList);
			return doFilter(crewList);
		}

		return crewList;
	}


	private List<Crew> findDuplicatedCrew(Crew crew, List<Crew> crewList){
		char[] origin = crew.getNickName().toCharArray();
		List<Crew> duplicatedCrewList = new LinkedList<>();

		for(Crew i : crewList){
			if(i.equals(crew)){
				continue;
			}

			char[] target = i.getNickName().toCharArray();

			if(getSimilarity(origin, target) >= 2){
				duplicatedCrewList.add(i);
			}
		}

		return duplicatedCrewList;
	}


	private int getSimilarity(char[] origin, char[] target){
		int originIndex = 0;
		int targetIndex = 0;

		int similarity = 0;
		int tempSimilarity = 0;

		while(originIndex < origin.length){
			if(origin[originIndex] == target[targetIndex]){
				tempSimilarity++;
				originIndex++;
			}

			targetIndex++;

			if(targetIndex >= target.length){
				targetIndex = 0;
				originIndex++;

				similarity = Math.max(similarity, tempSimilarity);
				tempSimilarity = 0;
			}
		}

		return similarity;
	}
}
