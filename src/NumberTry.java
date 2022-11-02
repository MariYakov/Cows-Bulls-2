import java.io.*;
public class NumberTry {
    private int cow;
    private int bull;
    private int pozBull;
    private String zapros;
        public String effort(String hiddenNumber,String findString) throws IOException {
        String[] hiddenArray = hiddenNumber.split("");
        String[] findArray = findString.split("");

        //создаем новый массив вводимого числа без повторящихся цифр
        String cowUnique = findArray[0];
        int countCow = 1;
        for (int i = 1; i < 4;i++) {
            if (!cowUnique.contains(findArray[i])) {
                cowUnique = cowUnique + findArray[i];
                countCow++;
            }
        }
        String[] cowArray = cowUnique.split("");

        //поиск коров и быков
        cow = 0;
        bull = 0;
        pozBull = 5;
        for (int i = 0; i < 4; i++) {
            //поиск быков
            for (int j = 0; j < 4; j++) {
                if (hiddenArray[i].equals(findArray[j])) {
                    if (i == j) {
                        pozBull = j;
                        bull++;
                    }
                }
            }
            //поиск коров
            //System.out.println(countCow);
            for (int j = 0; j < countCow; j++) {
                if (hiddenArray[i].equals(cowArray[j])) {
                    //System.out.println("i="+i);
                    if (i != pozBull) {
                        //System.out.println("cow="+cow);
                        cow++;
                    }
                }
            }
        }

        //формируем запись запроса
        zapros = "";
        switch (cow) {
            case 0:
                System.out.print(cow+" коров, ");
                zapros = zapros + Integer.toString(cow)+" коров, ";
                break;
            case 1:
                System.out.print(cow+" корова, ");
                zapros = zapros + Integer.toString(cow)+" корова, ";
                break;
            case 2,3,4:
                System.out.print(cow+" коровы, ");
                zapros = zapros + Integer.toString(cow)+" коровы, ";
                break;
        }
        switch (bull) {
            case 0:
                System.out.println(bull+" быков");
                zapros = zapros + Integer.toString(bull)+" быков";
                break;
            case 1:
                System.out.println(bull+" бык");
                zapros = zapros + Integer.toString(bull)+" бык";
                break;
            case 2,3,4:
                System.out.println(bull+" быка");
                zapros = zapros + Integer.toString(bull)+" быка";
                break;
        }
        return zapros;
    }
}
