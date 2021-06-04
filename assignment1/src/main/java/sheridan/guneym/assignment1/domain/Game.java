package sheridan.guneym.assignment1.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;


@SuppressWarnings("unused")
public class Game implements Serializable {

    @Min(0)
    @Max(2)
    private int option = 1;

    private final static String[] INPUTS
            = {"Rock", "Paper", "Scissor"};

    final private int number;
    final private String name;


    public Game() {
        int rand = (int) (3 * Math.random());
        name = INPUTS[rand % 3];
        number = rand;
    }

    public int numberReturn(){
        return number;
    }

    public String whoWon() {

        String whoWin = "";
        if (getOption() == 0 && numberReturn() == 1) {
            whoWin = "Computer won";
        } else if (getOption() == 0 && numberReturn() == 2) {
            whoWin = "You won";
        }else if
        (getOption() == 1 && numberReturn() == 0) {
            whoWin = "You won";
        }else if
        (getOption() == 1 && numberReturn() == 2) {
            whoWin = "Computer won";
        }else if
        (getOption() == 2 && numberReturn() == 0) {
            whoWin = "Computer won";
        }else if
        (getOption() == 2 && numberReturn() == 1) {
            whoWin = "You won";
        }else if
        (getOption() == numberReturn() ) {
            whoWin = "Tie";
        }
        return whoWin;
    }
    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }



    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Game{" +
                "option=" + option +
                                '}';
    }

}






