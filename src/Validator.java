public class Validator {
    public String checkNumber(String str) {

        if ((str.length() != 4) || (!str.matches("[0-9]+"))) {
            System.out.println("Вы ввели не четырехзначное число!");
            return "error";
        }
        else {
            return str;
        }
    }
}
