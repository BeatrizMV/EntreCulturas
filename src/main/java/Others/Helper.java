package Others;

public class Helper {
    public final static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
