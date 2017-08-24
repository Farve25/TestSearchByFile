import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchByFile implements Callable<File>{
    private File file;
    private static String text;
    private static Pattern pattern;

    public SearchByFile(File file){
        this.file = file;
    }

    @Override
    public File call(){

        System.out.println(Thread.currentThread().getName());

        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                        stringBuilder.append(scanner.next()).append(" ");
                }

                Matcher matcher = pattern.matcher(stringBuilder.toString());
                if (matcher.find()) {
                    System.out.println("Нашел епт");
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            if (flag) return file;
            else return null;

    }


    public static void setText(String nText){
        text = nText;
        pattern = Pattern.compile(text);
    }

}
