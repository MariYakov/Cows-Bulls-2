import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Read {
    private String fileReader;
    private int lastGame;
    public int lastGameNum () throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileReader reader = new FileReader("Rezult.txt");
        Scanner scannerReader = new Scanner(reader);
        //считываем Rezult.txt и ищем последний номер игры
        fileReader = "";
        lastGame = 0;
        String lastGameStr = "0";
        while (scannerReader.hasNext()) {
            fileReader = scannerReader.nextLine();
            if (fileReader.indexOf("№") != -1) {
                lastGameStr = fileReader.substring(Integer.valueOf(fileReader.indexOf("№"))+1,Integer.valueOf(fileReader.indexOf(" ",Integer.valueOf(fileReader.indexOf("№"))))+1);
                if (lastGameStr.equals(" ")) {
                    lastGameStr = "0";
                }
                lastGame = Integer.parseInt(lastGameStr.trim());
            }
        }
        reader.close();
        lastGame = lastGame + 1;
        return  lastGame;
    }
}
