import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by wamek on 2016/11/30.
 */
public class DailyModel {
    public String name;
    public String accessor;
    public String genre;

    DailyModel(String genre, String accessor, String name) {
        this.genre = genre;
        this.accessor = accessor;
        this.name = name;
    }
    @Override
    public String toString() {
        return "CALL REGISTER_DAILY(デイリー_" + genre + ", \"" + accessor + "\", \"" + name + "\")"  + System.getProperty("line.separator");
    }
}
