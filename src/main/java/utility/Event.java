package utility;

import java.text.DecimalFormat;

@SuppressWarnings("ALL")
public class Event <T extends Event>{
    interface Type{
        int getTotalStates();

        int getSampleSpace(int times);
    }

    final Type type;

    public Event(Type type) {
        this.type = type;
    }

    int getPossibleOutcomes(T event) {
        if ((T) event != null && !this.type.equals(((T) event).type))
            return 2;
        return 1;
    }

    public Probability event(T event, int timesRolled) {
        DecimalFormat df = new DecimalFormat("#.##");
        double result = getPossibleOutcomes(event) / (double) type.getSampleSpace(timesRolled);
        return new Probability(Double.parseDouble(df.format(result)));
    }

    public Probability eventNotOccurred(int timesRolled) {
        DecimalFormat df = new DecimalFormat("#.##");
        double result = 1 - ((type.getTotalStates() - 1) / (double) type.getSampleSpace(timesRolled));
        return new Probability(Double.parseDouble(df.format(result)));
    }
}
