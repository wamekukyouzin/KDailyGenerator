import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by wamek on 2016/11/30.
 */
public class KDailyGenerator {
    public static void main(String[] args) {
        KDailyGenerator self = new KDailyGenerator();
        self.doIt(args[0]);
    }

    private void doIt(String filePath) {
        BufferedReader br;
        Path path;
        try {
            path = Paths.get(filePath);
            br  = Files.newBufferedReader(path, StandardCharsets.UTF_8);

            ArrayList<DailyModel> dailyList = new ArrayList<>();

            br.lines().forEach(line -> {
                String[] sepLine = line.split(",");
                if (sepLine.length != 3) {
                    return;
                }

                DailyModel daily = new DailyModel(sepLine[0], sepLine[1], sepLine[2]);
                dailyList.add(daily);
            });
            br.close();

            FileOutputStream fos = new FileOutputStream(path.getParent().toString() + "/CREATE_DAILY_MAP.ERB");
            fos.write(0xef);
            fos.write(0xbb);
            fos.write(0xbf);
            PrintWriter printWriter = new PrintWriter(fos);
            printWriter.write("@CREATE_DAILY_MAP()" + System.getProperty("line.separator"));
            dailyList.forEach(dailyModel -> printWriter.write(dailyModel.toString()));
            printWriter.close();


        } catch(IOException e) {
            System.out.println(e);
        }


    }
}
