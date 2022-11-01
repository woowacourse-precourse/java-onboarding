package onboarding.problem7;

public enum RecommendPoint {
	FRIEND(10),
	VISITOR(1);

	private int point;

	RecommendPoint(int point){
		this.point = point;
	}

	public int getPoint(){
		return this.point;
	}
}
