package nix.edu;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SecondTaskUtil {

    public static void findFirstUniqueString(List<String> list) {

        Boolean isUnique = false;
        Map<String, Long> countMap = list.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        for (String s : list) {
            if (countMap.get(s) == 1) {
                isUnique = true;
                System.out.println("The first unique name is " + "\"" + s + "\"");
                break;
            }
        }
        if (!isUnique) {
            System.out.println("There are no unique names");
        }
    }
}
