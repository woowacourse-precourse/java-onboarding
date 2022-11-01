package onboarding.problem6;

public class Crew {

	private String nickName;
	private String email;

	public Crew(String email, String nickName){
		this.email = email;
		this.nickName = nickName;
	}

	public String getNickName() {
		return nickName;
	}

	public String getEmail() {
		return email;
	}


}
