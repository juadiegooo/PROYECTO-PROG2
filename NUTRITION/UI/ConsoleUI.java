package UI;
import Model.*;
import Persistence.*;
import java.util.Scanner;
import java.util.List;

public class ConsoleUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Dietitian dietitian = null;
        byte cons=0;
        while (cons==0) {
            System.out.println("\nMenu:");
            System.out.println("1. Log in");
            System.out.println("2. Register a new dietitian");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    dietitian = logIn(scanner);
                    if (dietitian != null) {
                        System.out.println("\nLogged in as Dietitian:");
                        System.out.println(dietitian);
                        cons++;
                    // Additional functionality for the logged-in dietitian can be added here
                    dietitianMenu(scanner, dietitian); // Agregar esta línea para mostrar el menú del dietitian
                    } else {
                        System.out.println("Login failed. Dietitian not found.");
                    }
                    break;
                case 2:
                    dietitian = registerNewDietitian(scanner);
                    if (dietitian != null) {
                        System.out.println("\nNew Dietitian Registered:");
                        System.out.println(dietitian);
                        CsvHandler.writeCsv("dietitians.csv", List.of(dietitian.toCsvString()));
                    } else {
                        System.out.println("Registration failed. Unable to create Dietitian.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void dietitianMenu(Scanner scanner, Dietitian dietitian) {
        while (true) {
            System.out.println("\nDietitian Menu:");
            System.out.println("1. Register a new patient");
            System.out.println("2. Consult patients");
            System.out.println("3. Log out");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    registerNewPatient(scanner, dietitian);
                    break;
                    case 2:
                    System.out.print("Enter patient ID to consult: ");
                    int consultPatientId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    List<String[]> patientData = CsvHandler.readCsv("patients.csv");

                    boolean patientFound = false;
                    for (String[] data : patientData) {
                        if (Integer.parseInt(data[0]) == consultPatientId) {
                            // Found the patient
                            System.out.println("\nPatient Details:");
                            System.out.println("Patient ID: " + data[0]);
                            System.out.println("Name: " + data[1]);
                            System.out.println("Age: " + data[2]);
                            System.out.println("Weight: " + data[3]);
                            System.out.println("Height: " + data[4]);
                            System.out.println("Preexisting Conditions: " + data[5]);

                            // Check from DietPlan
                            List<String[]> dietPlanData = CsvHandler.readCsv("dietPlans.csv");
                    for (String[] dietPlan : dietPlanData) {
                        if (Integer.parseInt(dietPlan[4]) == consultPatientId) {
                            System.out.println("\nDietPlan Details:");
                            System.out.println("Plan ID: " + dietPlan[0]);
                            System.out.println("Daily Calories: " + dietPlan[1]);
                            System.out.println("Macronutrient Distribution: " + dietPlan[2]);
                            System.out.println("Specific Recommendations: " + dietPlan[3]);
                    break;
                        }
                    }
                    // Check from Meal
                        List<String[]> mealData = CsvHandler.readCsv("meals.csv");
                        System.out.println("\nMeals:");
                        for (String[] meal : mealData) {
                            if (Integer.parseInt(meal[0]) == consultPatientId) {
                                System.out.println("Meal Name: " + meal[1]);
                                System.out.println("Meal Macronutrients: " + meal[2]);
                                System.out.println("Meal Calories: " + meal[3]);
                                System.out.println("Meal Time of Day: " + meal[4]);
                                System.out.println("--------------");
                            }
                        }
                            patientFound = true;
                            break;
                        }
                    }

                    if (!patientFound) {
                        System.out.println("Patient not found.");
                    }
                    break;
                case 3:
                    System.out.println("Logging out. Goodbye!");
                    return; // Regresar al menú principal
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerNewPatient(Scanner scanner, Dietitian dietitian) {
        System.out.println("\nRegistering a new patient:");
    
        // Gather patient information
        System.out.print("Enter patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
    
        System.out.print("Enter patient age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
    
        System.out.print("Enter patient weight: ");
        double weight = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
    
        System.out.print("Enter patient height: ");
        double height = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
    
        System.out.print("Enter patient preexisting conditions: ");
        String preexistingConditions = scanner.nextLine();
    
        // Create a new patient object
    
        Patient newPatient = new Patient(patientId, name, age, weight, height, preexistingConditions);
    
        // Display the registered patient information
        System.out.println("\nNew Patient Registered:");
        System.out.println(newPatient);
    
        // Gather diet plan information
        System.out.print("\nEnter daily calories for the diet plan: ");
        double dailyCalories = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
    
        System.out.print("Enter macronutrient distribution for the diet plan: ");
        String macronutrientDistribution = scanner.nextLine();
    
        System.out.print("Enter specific recommendations for the diet plan: ");
        String specificRecommendations = scanner.nextLine();
    
        // Create a new diet plan object
        int nextPlanId = patientId; // In a real system, you would fetch the next available plan ID
        DietPlan newDietPlan = new DietPlan(nextPlanId, dailyCalories, macronutrientDistribution, specificRecommendations);
    
        // Display the registered diet plan information
        System.out.println("\nNew Diet Plan Created:");
        System.out.println(newDietPlan);

        System.out.println("Enter meal details:");

        System.out.print("Enter meal name: ");
        String mealName = scanner.nextLine();

        System.out.print("Enter meal macronutrients: ");
        String mealMacronutrients = scanner.nextLine();

        System.out.print("Enter meal calories: ");
        double mealCalories = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter meal time of day: ");
        String mealTimeOfDay = scanner.nextLine();
        int nexMealId = patientId;
        // Create a new meal object
        Meal newMeal = new Meal(nexMealId, mealName, mealMacronutrients, mealCalories, mealTimeOfDay);

        // Display the registered meal information
        System.out.println("\nNew Meal Registered:");
        System.out.println(newMeal);
    
        // Assign the patient and dietitian to the diet plan
        newDietPlan.setPatient(newPatient);
        newDietPlan.setDietitian(dietitian);
    
        // Simulate writing data to CSV
        CsvHandler.writeCsv("patients.csv", List.of(newPatient.toCsvString()));
        CsvHandler.writeCsv("dietPlans.csv", List.of(newDietPlan.toCsvString()));
        CsvHandler.writeCsv("meals.csv", List.of(newMeal.toCsvString()));
    }
    

    private static Dietitian logIn(Scanner scanner) {
        System.out.println("\nLog in as a Dietitian:");

        // Gather dietitian ID from user input
        System.out.print("Enter dietitian ID: ");
        int dietitianId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Search for the dietitian in the CSV file
        List<String[]> dietitianData = CsvHandler.readCsv("dietitians.csv");
        for (String[] data : dietitianData) {
            if (Integer.parseInt(data[0]) == dietitianId) {
                // Found the dietitian
                return new Dietitian(Integer.parseInt(data[0]), data[1], data[2]);
            }
        }

        // Dietitian not found
        return null;
    }

    private static Dietitian registerNewDietitian(Scanner scanner) {
        System.out.println("\nRegistering a new dietitian:");

        // Gather dietitian information from user input
        System.out.print("Enter dietitian ID: ");
        int dietitianId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter dietitian name: ");
        String name = scanner.nextLine();

        System.out.print("Enter dietitian specialty: ");
        String specialty = scanner.nextLine();

        // Create a new dietitian object
        return new Dietitian(dietitianId, name, specialty);

    }
}

