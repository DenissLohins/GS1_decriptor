import java.util.HashMap;
import java.util.Map;

class PrefixDatabase {

    private static final Map<String, Integer> dataBaseLength = new HashMap<>(){{
        put("01", 14);
        put("10", -20);
        put("11", 6);
        put("15", 6);
        put("17", 6);
        put("21", -20);
//        put("02", 14);
//        put("12", 6);
//        put("13", 6);
//        put("16", 6);
//        put("20", 2);
//        put("31", 8);

    }};

    private static final Map<String, String> dataBaseNames = new HashMap<>(){{
        put("01", "GTIN: ");
        put("10", "Batch No.: ");
        put("11", "Production date(YYMMD): ");
        put("15", "Best before date(YYMMDD): ");
        put("17", "Expiration date(YYMMDD): ");
        put("21", "Serial number: ");
    }};

    Integer find(String key){
        return dataBaseLength.get(key);
    }

    String getName(String key){
        return dataBaseNames.get(key);
    }

    boolean contains(String key){
        return dataBaseLength.containsKey(key);
    }
}
