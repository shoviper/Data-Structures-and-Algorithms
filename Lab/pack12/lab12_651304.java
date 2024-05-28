import java.util.Arrays;

import code.Puzzle8_651304;
import code.Puzzle8State_651304;

public class lab12_651304 {
    public static void main(String[] args) throws Exception {
        System.out.println("=============Demo 1================");
        demo1();
        System.out.println("=============Demo 2================");
        demo2();
        System.out.println("=============Demo 3================");
        demo3();
    }

    static void demo1(){
        Puzzle8_651304 game = new Puzzle8_651304(new int[] {9,0,0,1,0,1,3,0,2,4,1,0,2,1,1,5,1,2,7,2,0,8,2,1,6,2,2} );
        game.displayBoard();
    }

    static void demo2(){
        Puzzle8_651304 game = new Puzzle8_651304(new int[] {9,0,0,1,0,1,3,0,2,4,1,0,2,1,1,5,1,2,7,2,0,8,2,1,6,2,2} );
        game.generateNexMove();
    }
    
    static void demo3(){
        Puzzle8_651304 game = new Puzzle8_651304(new int[] {9,0,0,1,0,1,3,0,2,4,1,0,2,1,1,5,1,2,7,2,0,8,2,1,6,2,2} );
        game.nextMoveWithStack();
        System.out.println(game.explored.size());
        System.out.println("Partial explored state");
        for (Puzzle8State_651304 s : game.explored){
            if (s.sequence[0] == 1 && s.sequence[1] == 2 && s.sequence[2] == 3 && s.sequence[3] == 4)
                System.out.println(Arrays.toString(s.sequence));
        }
        System.out.println("note that the program termintate prior to pushing goal state into explored!!!");
    }
}