package com.github.crafterchen2.artemistools.text.example;

import com.github.crafterchen2.artemistools.text.Argumentable;

import static com.github.crafterchen2.artemistools.text.Argumentable.makeArg;

public enum ExampleTexts implements Argumentable {

    INTRO("Hello apple friends!"),
    AMOUNT("We have "+makeArg(0)+" apples."),
    EAT("We will have to eat "+makeArg(0)+" apples, to have "+makeArg(1)+" apples left."),
    EAT_ALL("Now we will eat the remaining "+makeArg(0)+" apples."),
    EMPTY("We are out of apples!"),
    OUTRO("See you next time!"),
    ERROR("We don't like negative apples!!"),
    ;

    private final String msg;

    ExampleTexts(String msg){
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }

}
