package pl.speedplugins.utilities;

import java.util.concurrent.TimeUnit;

public class TimerUtil {
    public static String convertLong(long milliseconds) {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds);
        long d = TimeUnit.SECONDS.toDays(seconds);
        long h = TimeUnit.SECONDS.toHours(seconds) - d * 24L;
        long m = TimeUnit.SECONDS.toMinutes(seconds) - d * 24L * 60L - h * 60L;
        long s = seconds - d * 24L * 60L * 60L - h * 60L * 60L - m * 60L;
        long ms = milliseconds - TimeUnit.SECONDS.toMillis(seconds);
        StringBuilder formattedTime = new StringBuilder();
        if (d != 0L) {
            formattedTime.append(d).append("d ");
        }

        if (h != 0L) {
            formattedTime.append(h).append("h ");
        }

        if (m != 0L) {
            formattedTime.append(m).append("min ");
        }

        if (s != 0L) {
            formattedTime.append(s).append("sek ");
        }

        if (ms != 0L) {
            formattedTime.append(ms).append("ms ");
        }

        return formattedTime.toString().trim();
    }
}
