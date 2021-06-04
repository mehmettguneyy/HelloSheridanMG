package sheridan.guneym.assignment1.domain;


public class Game {

    private final static String[] INPUT
            = {"Rock", "Paper", "Scissor"};

    final private int number;
    final private String name;


    public Game() {
        int rand = (int) (3 * Math.random());
        name = INPUT[rand / 3];
        number = rand + 1;
    }


}






