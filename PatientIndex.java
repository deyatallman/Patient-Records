package assign02;

import java.util.TreeMap;

/**
 * This Class represents a place to store patients name and UHeathID This class
 * uses TreeMaps unlike CurrentPatient
 */
public class PatientIndex {

	private TreeMap<UHealthID, String> index;

	public PatientIndex() {

		index = new TreeMap<>((id1, id2) -> id1.toString().compareTo(id2.toString()));
	}

	public void addPatient(Patient p) {
		UHealthID id = p.getUHealthID();
		String name = p.getFirstName() + " " + p.getLastName();
		index.put(id, name);
	}

	public void removePatient(Patient p) {
		UHealthID id = p.getUHealthID();
		index.remove(id);
	}

	public String getName(UHealthID id) {
		return index.get(id);
	}
}
