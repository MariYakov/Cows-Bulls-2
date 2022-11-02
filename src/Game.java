import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class Game {

    private NumberGenerator generator;
    private InputNumber inputNumber;
    private NumberTry numberTry;
    private InputAnswer inputAnswer;
    private String zapros;
    public void start() throws IOException {

        //запуск игры, пока того хочет пользователь
        while (true) {

            //генерируем число
            NumberGenerator generator = new NumberGenerator();
            String hiddenNumber = generator.generateString();
            System.out.println("Загаданное число:"+hiddenNumber);

            //считываем Rezult.txt и ищем последний номер игры
            Read read = new Read();
            int lastGame = read.lastGameNum();

            //записываем номер игры и загаданное число в Rezult.txt
            Scanner scanner = new Scanner(System.in);
            FileWriter writer = new FileWriter("Rezult.txt",true);
            Date date = new Date();
            writer.write("Game №"+lastGame+" "+date+" Загаданная строка "+hiddenNumber);
            writer.write('\n');

            int Mytry = 1;
            while (true) {
                //вводим число
                InputNumber inputnumber = new InputNumber();
                String inputStr = inputnumber.getInputNumber();
                if (inputStr.equals("error")) {
                    continue;
                }

                //угадываем число
                NumberTry numbertry = new NumberTry();
                zapros = numbertry.effort(hiddenNumber, inputStr);

                //записываем результат запроса в Rezult.txt
                writer.write("    Запрос: " + inputStr + " Ответ: " + zapros);
                writer.write('\n');

                //проверяем правильность введенного числа
                if (hiddenNumber.equals(inputStr)) {

                    //записываем число попыток в Rezult.txt
                    writer.write("Строка была угадана за " + Mytry);
                    switch (Mytry) {
                        case 1:
                            writer.write(" попытку.");
                            break;
                        case 2, 3, 4:
                            writer.write(" попытки.");
                            break;
                        default:
                            writer.write(" попыток.");
                    }
                    writer.write("\n");
                    writer.close();
                    break;
                }
                Mytry++;
            }
            //"сыграем еще раз?"
            InputAnswer inputanswer = new InputAnswer();
            String yesNo = inputanswer.getInputAnswer();
            if (yesNo.equals("да")) {
                continue;
            } else if (yesNo.equals("нет")) {
                break;
            }
        }
    }
}
