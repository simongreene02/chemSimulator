import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class ElementTypeManager {
    private List<ElementType> elementList = new ArrayList<>();

    public ElementTypeManager() {
    }

    public List<ElementType> getElementList() {
        return ImmutableList.copyOf(elementList);
    }

    public boolean addToElementList(ElementType element) {
        for (ElementType elementType : elementList) {
            if (elementType.getElementNumber() == element.getElementNumber()
                    || elementType.getName().equals(element.getName())
                    || elementType.getSymbol().equals(element.getSymbol())) {
                return false;
            }
        }
        elementList.add(element);
        return true;
    }
}
