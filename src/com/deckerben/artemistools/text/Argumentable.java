package com.deckerben.artemistools.text;

public interface Argumentable {

    default String withArgs(Object... args){
        String rv = toString();
        for (int i = 0; i < args.length; i++) {
            rv = rv.replaceAll(getPlaceHolder()+i,args[i].toString());
        }
        return rv;
    }

    String toString();

    static String getPlaceHolder(){
        return "ARG";
    }

    static String makeArg(int n){
        return getPlaceHolder() + n;
    }


}
