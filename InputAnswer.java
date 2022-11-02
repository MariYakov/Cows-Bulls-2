import java.util.Scanner;
public class InputAnswer {
    private String findString;
    public String getInputAnswer() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Хотите сыграть еще раз?");
            findString = scanner.next();
            if ((findString.toLowerCase().equals("да")) || (findString.toLowerCase().equals("нет"))) {
                return findString.toLowerCase();
            } else {
                System.out.println("Нужно ответить только \"да\" или \"нет\". ");
                continue;
            }
        }
    }
}
