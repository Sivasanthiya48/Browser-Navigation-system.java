import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserNavigationSystem {

    private Deque<String> backStack = new ArrayDeque<>();
    private Deque<String> forwardStack = new ArrayDeque<>();
    private String current = null;

    public void visit(String url) {
        if (current != null) {
            backStack.push(current);
        }
        current = url;
        forwardStack.clear();
    }

    public String back() {
        if (backStack.isEmpty()) {
            return null;
        }
        forwardStack.push(current);
        current = backStack.pop();
        return current;
    }

    public String forward() {
        if (forwardStack.isEmpty()) {
            return null;
        }
        backStack.push(current);
        current = forwardStack.pop();
        return current;
    }

    public void showStatus() {
        System.out.println("\n=== Browser Status ===");
        System.out.println("Current Page : " + current);
        System.out.println("Back Stack   : " + backStack);
        System.out.println("Forward Stack: " + forwardStack);
        System.out.println("=======================\n");
    }

    public static void main(String[] args) {

        BrowserNavigationSystem nav = new BrowserNavigationSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====== Browser Navigation System ======");
            System.out.println("1. Visit New URL");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Show Current Page");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter URL: ");
                    String url = sc.nextLine();
                    nav.visit(url);
                    System.out.println("Visited: " + url);
                    nav.showStatus();
                    break;

                case 2:
                    String back = nav.back();
                    if (back == null)
                        System.out.println("No page to go back!");
                    else
                        System.out.println("Moved Back → " + back);

                    nav.showStatus();
                    break;

                case 3:
                    String forward = nav.forward();
                    if (forward == null)
                        System.out.println("No page to go forward!");
                    else
                        System.out.println("Moved Forward → " + forward);

                    nav.showStatus();
                    break;

                case 4:
                    System.out.println("Current Page: " + nav.current);
                    nav.showStatus();
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
