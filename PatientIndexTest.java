package assign02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PatientIndexTest {

	@Test
	void addPatientAndGetByName() {
		PatientIndex patientIndex = new PatientIndex();
		Patient patient = new Patient("John", "Doe", new UHealthID("HBUD-1223"));

		patientIndex.addPatient(patient);

		assertEquals("John Doe", patientIndex.getName(new UHealthID("HBUD-1223")));
	}

	@Test
	void updateExistingPatient() {
		PatientIndex patientIndex = new PatientIndex();
		Patient patient = new Patient("John", "Doe", new UHealthID("ABCD-1465"));
		Patient updatedPatient = new Patient("Jane", "Doe", new UHealthID("ABCD-1465"));

		patientIndex.addPatient(patient);
		patientIndex.addPatient(updatedPatient);

		assertEquals("Jane Doe", patientIndex.getName(new UHealthID("ABCD-1465")));
	}

	@Test
	void removePatient() {
		PatientIndex patientIndex = new PatientIndex();
		Patient patient = new Patient("John", "Doe", new UHealthID("ACBD-1234"));

		patientIndex.addPatient(patient);
		patientIndex.removePatient(patient);

		assertNull(patientIndex.getName(new UHealthID("ACBD-1234")));
	}

	@Test
	void getNameForNonexistentPatient() {
		PatientIndex patientIndex = new PatientIndex();

		assertNull(patientIndex.getName(new UHealthID("ACBD-1234")));
	}
}
