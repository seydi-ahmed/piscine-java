import java.util.ArrayList;
import java.util.List;

public class HexaBaseObserver implements NumericBaseObserver {
    private List<String> events = new ArrayList<>();

    @Override
    public void updateState(int state) {
        String hexaRepresentation = Integer.toHexString(state);
        events.add(hexaRepresentation);
    }

    @Override
    public List<String> getEvents() {
        return events;
    }
}
