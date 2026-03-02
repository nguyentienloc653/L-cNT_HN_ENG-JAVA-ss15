import java.util.Stack;

class MedicationProcessChecker {

    private Stack<String> stack = new Stack<>();

    public boolean checkProcess(String[] actions) {
        for (int i = 0; i < actions.length; i++) {
            if (actions[i].equals("PUSH")) {
                stack.push("MED");
            } else if (actions[i].equals("POP")) {
                if (stack.isEmpty()) {
                    System.out.printf("Sai tai buoc %d\n", i + 1);
                    return false;
                }
                stack.pop();
            } else {
                System.out.printf("Thao tac khong hop le tai buoc %d\n", i + 1);
                return false;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("Ket thuc ca truc van con thuoc chua hoan tat");
            return false;
        }

        System.out.println("Quy trinh hop le");
        return true;
    }

    public void reset() {
        stack.clear();
    }
}

class Gioi1 {
    public static void main(String[] args) {
        MedicationProcessChecker checker = new MedicationProcessChecker();
        String[] actions1 = { "PUSH", "PUSH", "POP", "POP" };
        String[] actions2 = { "PUSH", "PUSH", "PUSH", "POP" };
        String[] actions3 = { "PUSH", "PUSH", "ED", "POP" };

        checker.checkProcess(actions1);
        checker.checkProcess(actions2);
        checker.checkProcess(actions3);
    }
}