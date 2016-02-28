/**
 * Created by Pierre Alline on 17/02/2016.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Pierre Alline on 17/02/2016.
 */
public class DownlaodFile {

    public static void DownloadFiles() {

        try {
            URL url = new URL("http://aleph.u-paris10.fr:1892/rest-dlf/patron/3589368/circulationActions/loans/NAN51002265814");
            URLConnection conexion = url.openConnection();
            conexion.connect();
            int lenghtOfFile = conexion.getContentLength();
            InputStream is = url.openStream();
            File testDirectory = new File("C:\\Users\\Pierre Alline\\Desktop");
            if (!testDirectory.exists()) {
                testDirectory.mkdir();
            }
            FileOutputStream fos = new FileOutputStream(testDirectory + "/test.xml");
            byte data[] = new byte[1024];
            int count = 0;
            long total = 0;
            int progress = 0;
            while ((count = is.read(data)) != -1) {
                total += count;
                int progress_temp = (int) total * 100 / lenghtOfFile;
                if (progress_temp % 10 == 0 && progress != progress_temp) {
                    progress = progress_temp;
                }
                fos.write(data, 0, count);
            }
            is.close();
            fos.close();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        DownloadFiles();
    }
}
