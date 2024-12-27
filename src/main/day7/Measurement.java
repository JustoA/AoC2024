package main.day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Measurement {
    //190: 10 19
    //3267: 81 40 27
    private final long testValue;
    private final ArrayList<Long> numbers;
    private final ArrayList<Character> operators = new ArrayList<>();
    private final boolean canConcat;
    public Measurement(String rawMeasurement, boolean canConcat){
        String[] splitMeas = rawMeasurement.split(": ");
        testValue = Long.parseLong(splitMeas[0]);
        numbers = Arrays.stream(splitMeas[1].split(" ")).map(Long::parseLong).collect(Collectors.toCollection(ArrayList::new));
        // I want to make an arraylist of length (numbers-1)
        // of all plus's.
        // forgive me for what i am about to do
        // truly a mutilation of what forEach is mean to do
        numbers.forEach(_ -> operators.add('+'));
        operators.removeLast();
        this.canConcat = canConcat;

    }
    public long calculate(){
        ArrayList<Long> mutableNumbers = new ArrayList<>(numbers);
        long answer = mutableNumbers.removeFirst();
        for (Character op: operators){
            if (op == '+'){
                answer += mutableNumbers.removeFirst();
            }
            else if (op=='*') {
                answer *= mutableNumbers.removeFirst();
            }
            else if (op=='|'){
                // idk if i have to force it into being a string or not
                answer = Long.parseLong(answer + "" + mutableNumbers.removeFirst());
            }
        }
        return answer;
    }
    private void mutateOperators(){
        //look for the first +, make it a *,
        //and turn everything to the left of it back into a +.
        //OR look for the first *, and make it a |.
        //and turn everything to the left of it back into a + (i hope!)

        // ++++
        // *+++
        // +*++
        // **++ ...

        // ++++
        // *+++
        // |+++
        // +*++
        // **++
        // |*++
        // +|++
        // *|++
        // ||++
        // ++*+
        // *+*+
        // |+*+
        // ***+
        for(int i=0;i<operators.size();i++){
            if(operators.get(i) == '+'){
                operators.set(i,'*');
                for (int j=0; j < i; j++){
                    operators.set(j,'+');
                }
                return;
            }
            else if (operators.get(i) == '*' && canConcat){
                operators.set(i,'|');
                for (int j=0; j < i; j++){
                    operators.set(j,'+');
                }
                return;
            }
        }

    }
    public boolean isPossible(){
        // there are 2^len(operators) possibilities for each measurement
        // if we are rocking with the concat operator, that's 3^len....
        // Q_Q
        double base = canConcat ? 3 : 2;
        double maxCombos =  Math.pow(base, operators.size());
        for(int i = 0; i< maxCombos; i++) {
            if (testValue == calculate()) {
                return true;
            }
            mutateOperators();
        }
        return false;
    }

    public long getTestValue() {
        return testValue;
    }
}
