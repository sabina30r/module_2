package nix.edu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FirstTaskUtil {

    private static boolean isValidDate(String string) {
        List<String> regexList = Arrays.asList("[0-9]{2}/[0-9]{2}/[0-9]{4}",
        "[0-9]{4}/[0-9]{2}/[0-9]{2}",
       "[0-9]{2}-[0-9]{2}-[0-9]{4}");
        return regexList.stream().parallel().anyMatch(string::matches);
    }

    public static List<String> convertDateList(List<String> list) {
        List<String> convertedList = list.stream()
                .filter(FirstTaskUtil::isValidDate)
                .map(s->s.replaceAll("[^0-9]",""))
                .collect(Collectors.toList());
        return convertedList;
    }

}
