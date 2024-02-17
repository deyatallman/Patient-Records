package assign02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * This class contains tests for Facility.
 *
 * @author Eric Heisler and Deya Tallman
 * @version May 5, 2023
 */
public class FacilityTester {

	private Facility emptyFacility, verySmallFacility, smallFacility, largerFacility;
	private UHealthID uHID1, uHID2, uHID3;
	private GregorianCalendar date1, date2, date3;

	@BeforeEach
	void setUp() throws Exception {

		uHID1 = new UHealthID("AAAA-1111");
		uHID2 = new UHealthID("BCBC-2323");
		uHID3 = new UHealthID("HRHR-7654");

		date1 = new GregorianCalendar(2023, 0, 1);
		date2 = new GregorianCalendar(2023, 3, 17);
		date3 = new GregorianCalendar(2022, 8, 21);

		emptyFacility = new Facility();

		verySmallFacility = new Facility();
		verySmallFacility.addPatient(new CurrentPatient("Jane", "Doe", uHID1, 1010101, date1));
		verySmallFacility.addPatient(new CurrentPatient("Drew", "Hall", uHID2, 3232323, date2));
		verySmallFacility.addPatient(new CurrentPatient("Riley", "Nguyen", uHID3, 9879876, date3));


		smallFacility = new Facility();
		smallFacility.addAll("small_patient_list.txt");
		
		largerFacility = new Facility();
		largerFacility.addAll("additional_patient_list.txt");

		// FILL IN -- Extend this tester to add more tests for the facilities above,
		// as well as to create and test larger facilities.
		// (HINT: For larger facility, generate random names, UHIDs, physicians, and
		// dates in a loop, instead of typing one at a time.)
	}

	// Empty Facility tests --------------------------------------------------------

	@Test
	public void testEmptyLookupUHID() {
		assertNull(emptyFacility.lookupByUHID(uHID1));
	}

	@Test
	public void testEmptyLookupPhysician() {
		ArrayList<CurrentPatient> patients = emptyFacility.lookupByPhysician(1010101);
		assertEquals(0, patients.size());
	}

	@Test
	public void testEmptySetVisit() {
		emptyFacility.setLastVisit(uHID2, date3);
	}

	@Test
	public void testEmptySetPhysician() {
		emptyFacility.setPhysician(uHID2, 1010101);
	}

	@Test
	public void testEmptyGetInactivePatients() {
		ArrayList<CurrentPatient> patients = emptyFacility.getInactivePatients(date3);
		assertEquals(0, patients.size());
	}
	@Test
	public void testEmptySetPhysicianMultiplePatients() {
	    assertTrue(emptyFacility.addPatient(new CurrentPatient("Alex", "Johnson", new UHealthID("WXYZ-4321"), 3030303, new GregorianCalendar(2023, 2, 20))));
	    assertTrue(emptyFacility.addPatient(new CurrentPatient("Emma", "Williams", new UHealthID("LMNO-5678"), 4040404, new GregorianCalendar(2023, 6, 5))));

	    emptyFacility.setPhysician(new UHealthID("WXYZ-4321"), 1010101);
	    emptyFacility.setPhysician(new UHealthID("LMNO-5678"), 2020202);

	    assertEquals(1010101, emptyFacility.lookupByUHID(new UHealthID("WXYZ-4321")).getPhysician());
	    assertEquals(2020202, emptyFacility.lookupByUHID(new UHealthID("LMNO-5678")).getPhysician());
	}

	// Very small facility tests ---------------------------------------------------

	@Test
	public void testVerySmallLookupUHID() {
		Patient expected = new Patient("Drew", "Hall", new UHealthID("BCBC-2323"));
		CurrentPatient actual = verySmallFacility.lookupByUHID(new UHealthID("BCBC-2323"));
		assertEquals(expected, actual);
	}

	@Test
	public void testVerySmallLookupPhysicianCount() {
		ArrayList<CurrentPatient> actualPatients = verySmallFacility.lookupByPhysician(9879876);
		assertEquals(1, actualPatients.size());
	}

	@Test
	public void testVerySmallLookupPhysicianPatient() {
		Patient expectedPatient = new Patient("Riley", "Nguyen", new UHealthID("HRHR-7654"));
		ArrayList<CurrentPatient> actualPatients = verySmallFacility.lookupByPhysician(9879876);
		assertEquals(expectedPatient, actualPatients.get(0));
	}

	@Test
	public void testVerySmallAddNewPatient() {
		assertTrue(verySmallFacility.addPatient(new CurrentPatient("Jane", "Doe", new UHealthID("BBBB-2222"), 1010101, date1)));
	}

	@Test
	public void testVerySmallUpdatePhysician() {
		verySmallFacility.lookupByUHID(uHID1).updatePhysician(9090909);
		CurrentPatient patient = verySmallFacility.lookupByUHID(uHID1);
		assertEquals(9090909, patient.getPhysician());
	}
	public void testVerySmallSetLastVisit() {
	    // Set last visit for an existing patient in verySmallFacility
	    verySmallFacility.setLastVisit(new UHealthID("BCBC-2323"), new GregorianCalendar(2023, 4, 12));
	    assertEquals(new GregorianCalendar(2023, 4, 12), verySmallFacility.lookupByUHID(new UHealthID("BCBC-2323")).getLastVisit());
	}

	// Small facility tests -------------------------------------------------------------------------

	@Test
	public void testSmallLookupPhysicianCount() {
		ArrayList<CurrentPatient> actualPatients = smallFacility.lookupByPhysician(8888888);
		assertEquals(2, actualPatients.size());
	}

	@Test
	public void testSmallLookupPhysicianPatient() {
		Patient expectedPatient1 = new Patient("Kennedy", "Miller", new UHealthID("QRST-3456"));
		Patient expectedPatient2 = new Patient("Taylor", "Miller", new UHealthID("UVWX-7890"));

		ArrayList<CurrentPatient> actualPatients = smallFacility.lookupByPhysician(8888888);
		assertTrue(actualPatients.contains(expectedPatient1) && actualPatients.contains(expectedPatient2));
	}

	@Test
	public void testSmallGetInactivePatients() {
		ArrayList<CurrentPatient> actual = smallFacility.getInactivePatients(new GregorianCalendar(2020, 0, 0));
		assertEquals(9, actual.size());
	}

	@Test
	public void testSmallGetPhysicianList() {
		ArrayList<Integer> actual = smallFacility.getPhysicianList();
		assertEquals(7, actual.size());
	}
	@Test
	public void testLargerFacilityLookupUHID() {
	    Patient expectedPatient = new Patient("Daniel", "White", new UHealthID("LMNO-6789"));
	    CurrentPatient actualPatient = largerFacility.lookupByUHID(new UHealthID("LMNO-6789"));
	    assertEquals(expectedPatient, actualPatient);
	}

	@Test
	public void testLargerFacilityLookupPhysicianCount() {
	    ArrayList<CurrentPatient> actualPatients = largerFacility.lookupByPhysician(8765432);
	    assertEquals(2, actualPatients.size());
	}

	@Test
	public void testLargerFacilityGetInactivePatients() {
	    ArrayList<CurrentPatient> actualPatients = largerFacility.getInactivePatients(new GregorianCalendar(2020, 0, 0));
	    assertEquals(14, actualPatients.size());
	}

	@Test
	public void testLargerFacilitySetLastVisit() {
	    largerFacility.setLastVisit(new UHealthID("YZAB-5678"), new GregorianCalendar(2023, 4, 12));
	    assertEquals(new GregorianCalendar(2023, 4, 12), largerFacility.lookupByUHID(new UHealthID("YZAB-5678")).getLastVisit());
	}

	@Test
	public void testLargerFacilitySetPhysicianMultiplePatients() {
	    assertTrue(largerFacility.addPatient(new CurrentPatient("Sophie", "Smith", new UHealthID("WXYZ-9876"), 5050505, new GregorianCalendar(2022, 3, 15))));
	    assertTrue(largerFacility.addPatient(new CurrentPatient("Lucas", "Miller", new UHealthID("LMNO-5432"), 6060606, new GregorianCalendar(2022, 7, 8))));

	    largerFacility.setPhysician(new UHealthID("WXYZ-9876"), 8765432);
	    largerFacility.setPhysician(new UHealthID("LMNO-5432"), 7654321);

	    assertEquals(8765432, largerFacility.lookupByUHID(new UHealthID("WXYZ-9876")).getPhysician());
	    assertEquals(7654321, largerFacility.lookupByUHID(new UHealthID("LMNO-5432")).getPhysician());
	}
	
}
