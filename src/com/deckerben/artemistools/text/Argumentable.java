package com.deckerben.artemistools.text;

public interface Argumentable {

    default String withArgs(Object... args){
        String rv = toString();
        for (int i = 0; i < args.length; i++) {
            rv = rv.replaceAll("ARG"+i,args[i].toString());
        }
        return rv;
    }

    String toString();

}
