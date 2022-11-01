package onboarding.problem5;

public enum PolicyFactory {
	Lightweight(new LightweightPolicy());

	private IPolicy policy;

	PolicyFactory(IPolicy policy){
		this.policy = policy;
	}

	public IPolicy getPolicy(){
		return this.policy;
	}
}
