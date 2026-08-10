import java.util.HashMap;
import java.util.Map;

public class TreeTypeFactory {
    private static final Map<String, TreeType> TYPES = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + ":" + color + ":" + texture;

        if (!TYPES.containsKey(key)) {
            TYPES.put(key, new TreeType(name, color, texture));
            System.out.println("Created shared TreeType: " + key);
        }

        return TYPES.get(key);
    }

    public static int getTypeCount() {
        return TYPES.size();
    }
}
