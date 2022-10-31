package onboarding.problem1.repository;

import java.util.List;

public class BookInfoRepository {
	List<Integer> pageInfo;
	Integer playerTopPoint; // 책 게임의 더하기 or 곱하기 최고 점수

	public BookInfoRepository(List<Integer> pageInfo) {
		this.pageInfo = pageInfo;
	}

	public Integer getPlayerTopPoint() {
		return playerTopPoint;
	}

	public void setPlayerTopPoint(Integer playerTopPoint) {
		this.playerTopPoint = playerTopPoint;
	}
}
