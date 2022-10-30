package onboarding.problem6;

import java.util.List;

public class EmailValidator implements ICrewValidator{

	@Override
	public boolean isValid(List<Crew> crewList) {
		for(Crew i : crewList){
			if(!checkLength(i)){
				return false;
			}

			if(!checkDomain(i)){
				return false;
			}
		}

		return true;
	}

	private boolean checkLength(Crew crew){
		if(crew.getEmail().length() < 11 || crew.getEmail().length() >= 20){
			return false;
		}

		return true;
	}

	private boolean checkDomain(Crew crew){
		String domain = crew.getEmail().split("@")[1];

		if(!domain.equals("email.com")){
			return false;
		}

		return true;
	}
}
