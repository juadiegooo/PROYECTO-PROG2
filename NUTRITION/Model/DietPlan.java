package Model;
// DietPlan.java
public class DietPlan {
    private int planId;
    private double dailyCalories;
    private String macronutrientDistribution;
    private String specificRecommendations;
    private Patient patient;
    private Dietitian dietitian;

    public DietPlan(int planId, double dailyCalories, String macronutrientDistribution, String specificRecommendations) {
        this.planId = planId;
        this.dailyCalories = dailyCalories;
        this.macronutrientDistribution = macronutrientDistribution;
        this.specificRecommendations = specificRecommendations;
    }

    public void createDietPlan() {
        System.out.println("Diet plan created: " + this.planId);
    }

    public void adjustDietPlan() {
        System.out.println("Adjusting diet plan: " + this.planId);
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDietitian(Dietitian dietitian) {
        this.dietitian = dietitian;
    }

    // Métodos getters para acceder a la información del paciente y del dietitian
    public Patient getPatient() {
        return patient;
    }

    public Dietitian getDietitian() {
        return dietitian;
    }

    // Método para convertir la información del DietPlan a formato CSV
    public String toCsvString() {
        return planId + "," + dailyCalories + "," + macronutrientDistribution + "," + specificRecommendations +
                "," + patient.getPatientId() + "," + dietitian.getDietitianId();
    }
}


