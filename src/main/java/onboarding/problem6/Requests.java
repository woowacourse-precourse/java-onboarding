package onboarding.problem6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Requests {

	private final List<Request> requests;

	public Requests(List<List<String>> forms) {
		List<Request> requests = new ArrayList<>();
		for (List<String> form : forms) {
			String email = form.get(0);
			String nickname = form.get(1);
			requests.add(new Request(email, nickname));
		}
		this.requests = requests;
	}

	public Collection<String> getOverlapCrewEmails() {
		Set<String> overlapCrewEmails = new TreeSet<>();
		for (Request request : requests) {
			overlapCrewEmails.addAll(findOverlapCrewEmailsBy(request));
		}
		return overlapCrewEmails;
	}

	private List<String> findOverlapCrewEmailsBy(Request request) {
		List<String> overlapCrewEmails = new ArrayList<>();
		for (Request otherRequest : requests) {
			if (request.equals(otherRequest)) {
				continue;
			}
			if (request.hasOverlapWith(otherRequest)) {
				overlapCrewEmails.add(request.getEmail());
				overlapCrewEmails.add(otherRequest.getEmail());
			}
		}
		return overlapCrewEmails;
	}
}
