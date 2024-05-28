package code;

import java.util.Arrays;

public class Puzzle8State_651304 {
    public int[] sequence;
    public int score;
    
    public Puzzle8State_651304(int[] newSequence) {
        sequence = newSequence;
    }

    public static boolean equals(Puzzle8State_651304 a, Puzzle8State_651304 b){
        return true;
    }

    public static boolean equals(Puzzle8State_651304 newState, Puzzle8_651304 puzzle8) {
        return false;
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sequence.length; i++) {
            if (i % 3 == 0 && i != 0)
                sb.append("\n");
            if (sequence[i] == 9){
                sb.append("  ");
            }else{
                sb.append(sequence[i] + " ");
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Puzzle8State_651304 that = (Puzzle8State_651304) obj;
        return Arrays.equals(sequence, that.sequence);
    }
}
