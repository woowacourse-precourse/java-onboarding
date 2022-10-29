package domain;

import java.util.HashSet;

public class Crew {
	private String email;
	private String nickname;
	
	public Crew(String email, String nickname) {
		super();
		this.email = email;
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public String getNickname() {
		return nickname;
	}
    @Override
	public String toString() {
		return "Crew [email=" + email + ", nickname=" + nickname + "]";
	}
    
	/**
     * 객체가 가진 닉네임을 이루는 모든 두 글자 문자열을 반환한다.
     * @param nickname
     * @return 중복 없는 모든 두 글자 문자열
     */
    public HashSet<String> getAllUsedTwoWordsByNickname() {
    	HashSet<String> twoWords = new HashSet<>();
    	for (int i = 0; i < this.nickname.length()-1; i++) {
    		twoWords.add(this.nickname.substring(i, i+2));
    	}
    	return twoWords;
    }
	
}
