package onboarding.problem6;

import java.util.List;

public class NicknameValidator implements ICrewValidator{

	@Override
	public boolean isValid(List<Crew> crewList) {
		for(Crew i : crewList){
			if(!checkLength(i)){
				return false;
			}

			if(!checkKorean(i)){
				return false;
			}
		}

		return true;
	}

	private boolean checkLength(Crew crew){
		if(crew.getNickName().length() < 1 || crew.getNickName().length() >= 20){
			return false;
		}

		return true;
	}

	private boolean checkKorean(Crew crew){
		if(!crew.getNickName().matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")){
			return false;
		}

		return true;
	}
}
