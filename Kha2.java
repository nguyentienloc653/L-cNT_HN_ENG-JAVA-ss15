import java.util.ArrayDeque;
import java.util.Queue;

class Patient {
    private String id;
    private String name;
    private int age;

    public Patient(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + "Ten: " + name + " | " + "Tuoi: " + age;
    }
}

class PatientQueue {
    private static Queue<Patient> queue = new ArrayDeque<>();

    public static void addPatient(Patient p) {
        queue.add(p);
    }

    public static Patient callNext() {
        return queue.poll();
    }

    public static Patient peekCallNext() {
        if (isEmpty()) {
            return null;
        }
        return queue.peek();
    }

    public static boolean isEmpty() {
        if (queue.size() == 0) {
            return true;
        }
        return false;
    }

    public static void displayHistory() {
        for (Patient patient : queue) {
            System.out.println(patient.toString());
        }
    }
}

class Kha2 {
    public static void main(String[] args) {
        Patient p1 = new Patient("1", "Bui Son", 20);
        Patient p2 = new Patient("2", "Thai Son", 19);
        Patient p3 = new Patient("3", "Son Bui", 21);

        PatientQueue.addPatient(p1);
        PatientQueue.addPatient(p2);
        PatientQueue.addPatient(p3);

        System.out.println(PatientQueue.peekCallNext());

        System.out.println(PatientQueue.callNext());

        PatientQueue.displayHistory();
    }
}
