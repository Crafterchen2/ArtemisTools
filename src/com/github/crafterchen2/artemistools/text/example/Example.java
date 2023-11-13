package com.github.crafterchen2.artemistools.text.example;

public class Example {

    public static void main(String[] args) {
        //Feel free to adjust these values
        int totalApples = 10;
        int threshold = 0;
        int eatPerSession = 2;
        //START demo code
        if (totalApples > 0) {
            System.out.println(ExampleTexts.INTRO);
            System.out.println(ExampleTexts.AMOUNT.withArgs(totalApples));
            do {
                int nEaten = totalApples/eatPerSession;
                totalApples = totalApples-nEaten;
                if (nEaten <= threshold) {
                    System.out.println(ExampleTexts.EAT_ALL.withArgs(threshold+1));
                    totalApples = 0;
                }   else {
                    System.out.println(ExampleTexts.EAT.withArgs(nEaten,totalApples));
                }
            } while (totalApples > 0);
            System.out.println(ExampleTexts.EMPTY);
            System.out.println(ExampleTexts.OUTRO);
        } else if (totalApples == 0) {
            System.out.println(ExampleTexts.EMPTY);
        } else {
            System.out.println(ExampleTexts.ERROR);
        }
    }

}
