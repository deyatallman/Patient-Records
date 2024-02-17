# University Health System Patient Management System

This project is a Java program designed for the University of Utah Health system (UHealth) to manage patient and physician records across various healthcare facilities. The program tracks patients using unique identifiers (UHealth ID), assigns physicians to patients, and maintains visitation records. The system is designed to handle various representations of physicians and expandability to accommodate future healthcare facilities.

## Phases Overview

The project is divided into four phases:

### Phase 1: Basic Implementation
- **Patient**: Base class representing patient information.
- **CurrentPatient**: Subclass of Patient, includes physician (represented by uNID) and last visit date.
- **Facility**: Class for managing patient records at a facility.
- **FacilityTester**: Test class for Facility functionality.

### Phase 2: Generic Implementation
- **CurrentPatientGeneric**: Generic version of CurrentPatient, allowing flexible physician representation.
- **FacilityGeneric**: Generic version of Facility, supporting generic patient types.
- **FacilityGenericTester**: Test class for FacilityGeneric functionality.

### Phase 3: Additional Features
- **FacilityGeneric**: Enhancements include sorting patients by different criteria (UHealth ID, name, last visit date).
- **FacilityGenericTester**: Updated to test new features thoroughly.

### Phase 4: Patient Index
- **PatientIndex**: Class to create and manage an index for quick patient lookup by UHealth ID.
- **PatientIndexTester**: Test class for PatientIndex functionality.

## Requirements and Implementation Details

- **Patient**: Base class with basic information and equality comparison.
- **CurrentPatient**: Subclass with additional physician and visitation information.
- **Facility**: Manages patient records, includes methods for adding, updating, and retrieving patients.
- **FacilityGeneric**: Generic version of Facility to support flexibility in patient and physician representations.
- **PatientIndex**: Class for quick patient lookup based on UHealth ID.
- **JUnit Tests**: Exhaustive tests provided for each phase's functionality.

## Getting Started

1. Clone the repository.
2. Compile and run the Java program files in your preferred IDE or command line environment.

## Contributors

- Deya Tallman
- Eric Heisler

