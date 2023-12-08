package Model;
// Dietitian.java

public class Dietitian {
    private int dietitianId;
    private String name;
    private String specialty;

    public Dietitian(int dietitianId, String name, String specialty) {
        this.dietitianId = dietitianId;
        this.name = name;
        this.specialty = specialty;
    }

    public void registerDietitian() {
        System.out.println("Dietitian registered: " + this.name);
    }

    public void manageDietitian() {
        System.out.println("Managing dietitian: " + this.name);
    }

    // Método para convertir la información del Dietitian a formato CSV
    public String toCsvString() {
        return dietitianId + "," + name + "," + specialty;
    }
    
    public int getDietitianId() {
        return dietitianId;
    }
}

