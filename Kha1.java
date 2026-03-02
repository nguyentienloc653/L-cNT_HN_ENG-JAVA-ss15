import java.util.Stack;

class EditAction {
    private String description;
    private String time;

    public EditAction(String description, String time) {
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
        return description + " " + time;
    }

}

class MedicalRecordHistory {
    private static Stack<EditAction> history = new Stack<>();

    public static void addEdit(EditAction edit) {
        history.push(edit);
    }

    public static void undoEdit() {
        if (isEmpty()) {
            return;
        }
        history.pop();
    }

    public static EditAction getLatestEdit() {
        if (isEmpty()) {
            return null;
        }
        return history.peek();
    }

    private static boolean isEmpty() {
        if (history.size() == 0) {
            return true;
        }
        return false;
    }

    public static void displayHistory() {
        if (isEmpty()) {
            return;
        }
        for (EditAction editAction : history) {
            System.out.println(editAction.toString());
        }
    }
}

class Kha1 {
    public static void main(String[] args) {
        EditAction edit1 = new EditAction("edit1", "10h");
        EditAction edit2 = new EditAction("edit2", "11h");
        EditAction edit3 = new EditAction("edit3", "12h");
        MedicalRecordHistory.addEdit(edit1);
        MedicalRecordHistory.addEdit(edit2);
        MedicalRecordHistory.addEdit(edit3);

        MedicalRecordHistory.displayHistory();
        System.out.println();

        System.out.println(MedicalRecordHistory.getLatestEdit());
        System.out.println();

        MedicalRecordHistory.undoEdit();
        System.out.println(MedicalRecordHistory.getLatestEdit());
        System.out.println();

        MedicalRecordHistory.displayHistory();
    }
}