import java.util.ArrayDeque;
import java.util.Queue;

class EmergencyPatient {
    private String id;
    private String name;
    private int priority;

    public EmergencyPatient(String id, String name, int priority) {
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

class EmergencyQueue {
    private static Queue<EmergencyPatient> priorityQueue = new ArrayDeque<>();
    private static Queue<EmergencyPatient> queue = new ArrayDeque<>();

    public static void addPatient(EmergencyPatient p) {
        if (p.getPriority() == 1) {
            queue.add(p);
        } else if (p.getPriority() == 2) {
            priorityQueue.add(p);
        }
    }

    public static EmergencyPatient callNext() {
        // Ưu tiên gọi hàng đợi ưu tiên
        if (!priorityQueue.isEmpty()) {
            return priorityQueue.remove();
        } else if (!queue.isEmpty()) {
            return queue.remove();
        }
        return null;

    }

    public static void displayQueue() {
        for (EmergencyPatient emergencyPatient : priorityQueue) {
            System.out.println(emergencyPatient.toString());
        }
        for (EmergencyPatient patient : queue) {
            System.out.println(patient.toString());
        }
    }
}

class Gioi2 {
    public static void main(String[] args) {
        EmergencyPatient p1 = new EmergencyPatient("1", "Son", 1);
        EmergencyPatient p2 = new EmergencyPatient("2", "Bui Son", 2);

        EmergencyQueue.addPatient(p1);
        EmergencyQueue.addPatient(p2);

        System.out.println(EmergencyQueue.callNext().toString());
        System.out.println(EmergencyQueue.callNext().toString());
    }
}
