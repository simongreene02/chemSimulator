import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public abstract class SymbolGetter {
    public static String getSymbol(List<ElementType> elementCompositions) {
        Map<ElementType, Integer> elementTypeIntegerMap = Maps.newLinkedHashMap();
        for (ElementType element : elementCompositions) {
            if (elementTypeIntegerMap.containsKey(element)) {
                elementTypeIntegerMap.put(element, elementTypeIntegerMap.get(element)+1);
            } else {
                elementTypeIntegerMap.put(element, 1);
            }
        }
        StringBuilder output = new StringBuilder();
        for (Map.Entry<ElementType, Integer> entry : elementTypeIntegerMap.entrySet()) {
            output.append(entry.getKey().getSymbol());
            if (entry.getValue() > 1) {
                output.append(entry.getValue());
            }
        }
        return output.toString();
    }
}
