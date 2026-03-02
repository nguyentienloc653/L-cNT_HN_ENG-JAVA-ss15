import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

class TreatmentStep {
    private String description;
    private String time;

    public TreatmentStep(String description, String time) {
        this.description = description;
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Mo ta: " + description + " | " + "Thoi gian: " + time;
    }
}

class Patient {
    private String id;
    private String name;
    private int priority;

    public Patient(String id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    private String priorityText(int priority) {
        switch (priority) {
            case 1:
                return "Khong";
            case 2:
                return "Co";
        }

        return "";
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + "Ten: " + name + " | " + "Uu tien: " + priorityText(priority);
    }
}

class EmergencyCase {
    private Patient patient;
    private static Stack<TreatmentStep> steps = new Stack<>();

    public EmergencyCase(Patient patient) {
        this.patient = patient;

    }

    public static void addStep(TreatmentStep step) {
        steps.add(step);
    }

    public static TreatmentStep undoStep() {
        return steps.pop();
    }

    public static void displaySteps() {
        if (steps.isEmpty()) {
            return;
        }
        Iterator<TreatmentStep> iterator = steps.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

    public Patient getPatient() {
        return patient;
    }
}

class EmergencyCaseQueue {
    private static Queue<EmergencyCase> queue = new ArrayDeque<>();

    public static void addCase(EmergencyCase c) {
        queue.add(c);
    }

    public static EmergencyCase getNextCase() {
        return queue.poll();
    }
}

class XuatSac1 {
    public static void main(String[] args) {
        Patient patient = new Patient("1", "Son", 1);
        TreatmentStep treatmentStep1 = new TreatmentStep("khong co mo ta", "10h");
        TreatmentStep treatmentStep2 = new TreatmentStep("khong co mo ta", "11h");
        EmergencyCase emergencyCase = new EmergencyCase(patient);

        EmergencyCase.addStep(treatmentStep1);
        EmergencyCase.addStep(treatmentStep2);
        EmergencyCase.undoStep();
        EmergencyCase.displaySteps();

        EmergencyCaseQueue.addCase(emergencyCase);
        System.out.println(EmergencyCaseQueue.getNextCase().toString());
    }
}
