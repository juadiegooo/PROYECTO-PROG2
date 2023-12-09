# Nutrition Management System

The Nutrition Management System is a Java-based application designed for dietitians to manage patient information, diet plans, and meals. It allows dietitians to register, log in, and perform various operations related to patient care and dietary planning.

## Classes

### Dietitian
- Represents a dietitian with attributes such as ID, name, and specialty.
- Methods:
  - `registerDietitian()`: Displays a message when a dietitian is registered.
  - `manageDietitian()`: Displays a message when managing a dietitian.
  - `toCsvString()`: Converts dietitian information to CSV format.

### DietPlan
- Represents a diet plan with attributes like plan ID, daily calories, macronutrient distribution, and specific recommendations.
- Methods:
  - `createDietPlan()`: Displays a message when a diet plan is created.
  - `adjustDietPlan()`: Displays a message when adjusting a diet plan.
  - `setPatient()`: Assigns a patient to the diet plan.
  - `setDietitian()`: Assigns a dietitian to the diet plan.
  - `getPatient()`: Returns the patient associated with the diet plan.
  - `getDietitian()`: Returns the dietitian associated with the diet plan.
  - `toCsvString()`: Converts diet plan information to CSV format.

### Meal
- Represents a meal with attributes such as patient code, name, macronutrients, calories, and time of day.
- Methods:
  - `toCsvString()`: Converts meal information to CSV format.

### Patient
- Represents a patient with attributes like patient ID, name, age, weight, height, and preexisting conditions.
- Methods:
  - `registerPatient()`: Displays a message when a patient is registered.
  - `updatePatientInfo()`: Displays a message when updating patient information.
  - `deletePatient()`: Displays a message when deleting a patient.
  - `getPatientId()`: Returns the patient ID.
  - `toCsvString()`: Converts patient information to CSV format.

### CsvHandler
- Utility class for reading from and writing to CSV files.
- Methods:
  - `writeCsv(String filePath, List<String> lines)`: Writes lines to a CSV file.
  - `readCsv(String filePath)`: Reads data from a CSV file.

### ConsoleUI
- Main class for running the console-based user interface.
- Methods:
  - `main(String[] args)`: Entry point of the program.
  - `dietitianMenu(Scanner scanner, Dietitian dietitian)`: Displays the menu for a logged-in dietitian.
  - `registerNewPatient(Scanner scanner, Dietitian dietitian)`: Handles the registration of new patients.
  - `logIn(Scanner scanner)`: Handles the login process for dietitians.
  - `registerNewDietitian(Scanner scanner)`: Handles the registration of new dietitians.

## Instructions for Use

1. **Log In or Register a New Dietitian:**
   - Run the program.
   - Choose option 1 to log in as an existing dietitian or option 2 to register a new dietitian.
   - Follow the prompts to enter dietitian information.

2. **Dietitian Menu:**
   - After logging in, a dietitian menu will be displayed.
   - Choose from options to register a new patient, consult patients, or log out.

3. **Register a New Patient:**
   - From the dietitian menu, choose option 1 to register a new patient.
   - Enter patient details and diet plan information when prompted.

4. **Consult Patients:**
   - From the dietitian menu, choose option 2 to consult patients.
   - Enter the patient ID to view patient details, associated diet plan, and meals.

5. **Logging Out:**
   - Choose option 3 from the dietitian menu to log out.

6. **Exit:**
   - Choose option 3 from the main menu to exit the program.

Note: Patient IDs and Diet Plan IDs are used to associate patients with their respective diet plans. Ensure that IDs are unique to avoid conflicts.

## Author
Juan Diego Henao Quintero
Valntina Galvis Nieto