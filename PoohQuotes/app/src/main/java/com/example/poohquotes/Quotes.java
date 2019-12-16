package com.example.poohquotes;

/**
 * The Quotes class stores the quotes in a private array
 * the public method getQuote returns the next quote in the array
 * if all quotes from the array were sent, starts from the beginning
 *
 */

public class Quotes {
    private static String[] myQuotes =
            {"The things that make me different are the things that make me, me. —Piglet", "A hug is always the right size. —Winnie the Pooh",
          "You’re braver than you believe, stronger than you seem and smarter than you think. —Christopher Robin",
            "Sometimes the smallest things take up the most room in your heart. —Winnie the Pooh",
            "A little consideration, a little thought for others, makes all the difference. —Eeyore",
            "People say nothing is impossible, but I do nothing every day. —Winnie the Pooh",
            "A day without a friend is like a pot without a single drop of honey left inside. —Winnie the Pooh",
            "If the person you are talking to doesn’t appear to be listening, be patient. " +
                    "It may simply be that he has a small piece of fluff in his ear. —Winnie the Pooh",
            "Some people care too much. I think it’s called love. —Winnie the Pooh",
            "it never hurts to keep looking for sunshine. —Eeyore",
            "You can’t stay in your corner of the Forest waiting for others to come to you. You have to go to them sometimes. —Winnie the Pooh",
            "Rivers know this: There is no hurry. We shall get there some day. —Winnie the Pooh",
            "Any day spent with you is my favorite day. So, today is my new favorite day. —Winnie the Pooh",
            "Don’t underestimate the value of Doing Nothing, of just going along, listening to all the things you can’t hear, and not bothering. —Winnie the Pooh",
            "I’m not lost for I know where I am. But however, where I am may be lost. —Winnie the Pooh",
            "When you see someone putting on his Big Boots, you can be pretty sure that an Adventure is going to happen. —Winnie the Pooh",
            "How lucky am I to have something that makes saying goodbye so hard. —Winnie the Pooh",
            "They’re funny things, Accidents. You never have them till you’re having them. —Eeyore",
            "Nobody can be uncheered with a balloon. —Winnie the Pooh",
            "What’s wrong with knowing what you know now and not knowing what you don’t know until later? —Winnie the Pooh",
            "If it’s not Here, that means it’s out There. —Winnie the Pooh"

    };

    private static int array_size = myQuotes.length;
    private static int current = 0;
    private static String currentQuote = "";

    public static String getQuote(){
        currentQuote = myQuotes[current];
        if(current < array_size) current++;
        else current = 0;

        return currentQuote;
    }
}
