import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchByFile implements Callable<File>{
    private File file;
    private static String text;

    public SearchByFile(File file){
        this.file = file;
    }

    @Override
    public File call(){

        System.out.println(Thread.currentThread().getName());

        Pattern pattern = Pattern.compile(text);
        StringBuilder stringBuilder = new StringBuilder();
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    stringBuilder.append(scanner.next()).append(" ");
                }

                Matcher matcher = pattern.matcher(stringBuilder.toString());

                while (matcher.find()) {
                    System.out.println("Нашел епт");
                    return file;
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        return null;
    }


    public static void setText(String nText){
        text = nText;
    }

}
