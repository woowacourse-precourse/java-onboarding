package onboarding.problem5;

public class AccountRequest {
	private int cashAmount;
	private RequestType requestType;

	public int getCashAmount() {
		return cashAmount;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public AccountRequest(int cashAmount, RequestType requestType){
		this.cashAmount = cashAmount;
		this.requestType = requestType;
	}
}
