import java.util.Scanner;
public class InputNumber {
    private Validator validator;
    private String findString;
    public String getInputNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите четырехзначное число:");
        findString = scanner.nextLine();
        //проверяем число
        Validator validator = new Validator();
        return validator.checkNumber(findString);
    }
}
