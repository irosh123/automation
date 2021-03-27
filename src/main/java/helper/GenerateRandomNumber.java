package helper;


import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class GenerateRandomNumber {


    public Integer randomNumberGenerate()
    {
        // create instance of Random class
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(1000000);
        return rand_int1;
    }



    public String dateTime(){
        String FORMAT = "yyyy-MM-dd HH:mm:ss";
        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli();
        ZoneId zone = ZoneId.systemDefault();
        DateTimeFormatter df = DateTimeFormatter.ofPattern(FORMAT).withZone(zone);
        String time = df.format(Instant.ofEpochMilli(timeStampMillis));

        return time;
    }
}
