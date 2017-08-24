import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SearchProcess extends Thread {

    private static String fileSeparator = File.separator;
    private static String ext;
    private File folder;
    private ExecutorService service = Executors.newFixedThreadPool(7);
    private List<Future<File>> resultList;


    public SearchProcess(File folder, String ext, String text){
        super.setName("SearchFileThread");
        this.ext = ext;
        this.folder = folder;
        resultList = new ArrayList<>();

        SearchByFile.setText(text);
    }

    @Override
    public void run(){
        if (folder.exists()) fileSearch(folder);

        for (Future<File> f: resultList){
            try {
                f.get();
            } catch (InterruptedException | ExecutionException e){
                e.printStackTrace();
            }
        }
        service.shutdown();
        System.out.println("все кончилось");
        System.out.println(resultList.size());
    }

    private void fileSearch(File folder){
        File[] listFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(ext));
        for (File s: listFiles){
            System.out.println(s.toString());

            resultList.add(service.submit(new SearchByFile(s)));

        }

        String[] files = folder.list();
        for (String file: files) {
            File s = new File(folder + fileSeparator + file);
            if (s.isDirectory()) fileSearch(s);
        }
    }
}
