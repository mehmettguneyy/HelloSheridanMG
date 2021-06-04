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
        int rand = (int) (2 * Math.random());
        name = INPUTS[rand / 2];
        number = rand + 1;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    @Override
    public String toString(){
        return name;
    }


}






