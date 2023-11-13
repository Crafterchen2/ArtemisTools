package com.deckerben.artemistools.text;

import static com.deckerben.artemistools.text.Constants.makeArg;

public enum GenericTexts implements Argumentable{

    COLON_BEFORE(makeArg(0)+" :"),
    COLON_AFTER(": "+makeArg(0)),
    COLON_BOTH(makeArg(0)+" : "+makeArg(1)),
    ;

    private final String msg;

    GenericTexts(String msg){
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
