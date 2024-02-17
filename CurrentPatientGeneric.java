package assign02;

import java.util.GregorianCalendar;

public class CurrentPatientGeneric<Type> extends Patient {

	private Type physician;
	private GregorianCalendar lastVisit;

	public CurrentPatientGeneric(String firstName, String lastName, UHealthID uHealthID, Type physician,
			GregorianCalendar lastVisit) {
		super(firstName, lastName, uHealthID);
		this.physician = physician;
		this.lastVisit = lastVisit;
	}

	public Type getPhysician() {
		return this.physician;
	}

	public GregorianCalendar getLastVisit() {
		return this.lastVisit;
	}

	public void updatePhysician(Type newPhysician) {
		this.physician = newPhysician;
	}

	public void updateLastVisit(GregorianCalendar date) {
		this.lastVisit = date;
	}

}
