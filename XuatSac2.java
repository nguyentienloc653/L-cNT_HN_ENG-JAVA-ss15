import java.util.*;

class Patient {
    private String id;
    private String name;
    private int age;
    private String gender;

    public Patient(String id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String toString() {
        return id + " - " + name + " - " + age + " - " + gender;
    }
}

class PatientWaitingQueue {
    private Queue<Patient> waitingQueue = new LinkedList<>();

    public void addPatient(Patient patient) {
        waitingQueue.offer(patient);
    }

    public Patient callNextPatient() {
        return waitingQueue.poll();
    }

    public int getTotalPatients() {
        return waitingQueue.size();
    }
}

class EditAction {
    private String description;
    private String editedBy;
    private String editTime;

    public EditAction(String description, String editedBy, String editTime) {
        this.description = description;
        this.editedBy = editedBy;
        this.editTime = editTime;
    }

    public String toString() {
        return editedBy + " - " + description + " - " + editTime;
    }
}

class MedicalRecordHistory {
    private Stack<EditAction> editStack = new Stack<>();
    private String recordId;

    public MedicalRecordHistory(String recordId) {
        this.recordId = recordId;
    }

    public void addEdit(EditAction action) {
        editStack.push(action);
    }

    public EditAction undoLastEdit() {
        if (!editStack.isEmpty()) {
            return editStack.pop();
        }
        return null;
    }

    public String getRecordId() {
        return recordId;
    }
}

class Ticket {
    private int ticketNumber;
    private String issuedTime;

    public Ticket(int ticketNumber, String issuedTime) {
        this.ticketNumber = ticketNumber;
        this.issuedTime = issuedTime;
    }

    public String toString() {
        return "Ticket: " + ticketNumber + " - " + issuedTime;
    }
}

class TicketSystem {
    private Queue<Ticket> ticketQueue = new LinkedList<>();
    private int currentNumber = 0;

    public Ticket issueTicket(String time) {
        Ticket ticket = new Ticket(++currentNumber, time);
        ticketQueue.offer(ticket);
        return ticket;
    }

    public Ticket callNext() {
        return ticketQueue.poll();
    }
}

class InputAction {
    private String fieldName;
    private String oldValue;
    private String newValue;
    private String actionTime;

    public InputAction(String fieldName, String oldValue, String newValue, String actionTime) {
        this.fieldName = fieldName;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.actionTime = actionTime;
    }

    public String toString() {
        return fieldName + " | " + oldValue + " -> " + newValue + " | " + actionTime;
    }
}

class UndoManager {
    private Stack<InputAction> undoStack = new Stack<>();
    private int maxUndoSteps;

    public UndoManager(int maxUndoSteps) {
        this.maxUndoSteps = maxUndoSteps;
    }

    public void recordAction(InputAction action) {
        if (undoStack.size() >= maxUndoSteps) {
            undoStack.remove(0);
        }
        undoStack.push(action);
    }

    public InputAction undo() {
        if (!undoStack.isEmpty()) {
            return undoStack.pop();
        }
        return null;
    }
}

public class XuatSac2 {
    public static void main(String[] args) {

        PatientWaitingQueue queue = new PatientWaitingQueue();
        queue.addPatient(new Patient("P01", "Nguyen Van A", 30, "Nam"));
        queue.addPatient(new Patient("P02", "Tran Thi B", 25, "Nu"));
        System.out.println("Next patient: " + queue.callNextPatient());

        MedicalRecordHistory history = new MedicalRecordHistory("R01");
        history.addEdit(new EditAction("Cap nhat chan doan", "Dr.A", "02/03/2026 09:00"));
        history.addEdit(new EditAction("Cap nhat don thuoc", "Dr.B", "02/03/2026 09:30"));
        System.out.println("Undo edit: " + history.undoLastEdit());

        TicketSystem ticketSystem = new TicketSystem();
        ticketSystem.issueTicket("02/03/2026 08:00");
        ticketSystem.issueTicket("02/03/2026 08:05");
        System.out.println("Calling: " + ticketSystem.callNext());

        UndoManager undoManager = new UndoManager(5);
        undoManager.recordAction(new InputAction("name", "Nguyen Van A", "Nguyen Van B", "02/03/2026 10:00"));
        undoManager.recordAction(new InputAction("age", "30", "31", "02/03/2026 10:05"));
        System.out.println("Undo input: " + undoManager.undo());
    }
}