package com.example.ror;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.widget.TextView;

public class QuestionLibrary {

    //Easy Stage 1
    private String mQuestions [] = {

            "Fill in the missing even number.Fill in the missing even number.\n" +
                    "2, 4, 6, _? 10 ",
            "What is a number that rhymes with the word done?",
            "Fill in the missing odd number.\n" +
                    "11, 13, 15, 17, _?",
            "Fill in the missing even number.\n" +
                    "_? 24, 26, 28, 30",
            "What number rhymes with Alive?",
            "What number rhymes with Sticks?",
            "What number rhymes with Heaven?",
            "What number rhymes with Plate?",""
    };

    private String mChoices[][] = {
            {"4","8","3"},
            {"1","4","2"},
            {"19","18","20"},
            {"32","22","40"},
            {"1","2","5"}

    };
// Easy stage 2
    private String mCorrectAnswers[] = {"8","1","19", "22","5"};


    private String mQuestions2 [] = {

            "What is a number that rhymes with the word hive?",
            "What is a number that rhymes with the word delve?",
            "What is a number that rhymes with the word dirty tree?",
            "Fill in the missing even number:\n" +
                    "32, _? 36, 38, 40",
            "What number rhymes with Alive?"

    };

    private String mChoices2[][] = {
            {"5","1","2"},
            {"11","12","22"},
            {"22","33","11"},
            {"33","31","34"},
            {"1","2","5"}

    };

    private String mCorrectAnswers2[] = {"5","12","33", "34","5"};



    //Medium stage 1

    private String mQuestionsMedium [] = {

            "What is a number that rhymes with the word then?",
            "I'm a number that sounds heaven, a little odd number, a number between 5 and 9. What am I?",
            "I am a number that wants more, a little even number, a number between 2 and 6. What am I?",
            "What is a number that rhymes with the word plenty?",
            "I'm a number for tea that can free you out of your worries, an odd number, a number between 41 and 45. What am I?",
            "Fill in the missing even number.\n" +
                    "42, _? 46, 48, 50",
            "I'm a number that is quite thrifty, an even number, a number between 48 and 52. What am I?",""
    };

    private String mChoicesMedium[][] = {
            {"10","8","2"},
            {"3","8","7"},
            {"4","2","3"},
            {"11","20","22"},
            {"43","42","41"},
            {"41","44","31"},
            {"51","50","55"},
            {"8","7","5"}

    };
    private String mCorrectAnswersMedium[] = {"10","7","4", "20","43","44","50","8"};
    //Medium stage 2

    private String mQuestionsMedium2 [] = {

            "Fill in the missing odd number:\n" +
                    "31, 33, _, 37, 39",
            "I'm a number of greatness too, a little even number, a number between 0 and 4. What am I?",
            "I'm a number plenty for extra more, an even number, a number between 22 and 26. What am I?",
            "I'm a number of a birdie with a weight of a turkey, an even number, a number between 36 and 40. What am I?",
            "Fill in the missing odd number:\n" +
                    "41, _? 45, 47, 49",
            "I'm a number of an empty hive, an odd number, a number between 23 and 27. What am I?",
            "Fill in the missing odd number:\n" +
                    "21, 23, _? 27, 29",""
    };

    private String mChoicesMedium2[][] = {
            {"35","41","32"},
            {"1","2","7"},
            {"24","22","31"},
            {"32","31","38"},
            {"42","41","43"},
            {"55","25","35"},
            {"25","35","45"},
            {"8","7","5"}

    };

    private String mCorrectAnswersMedium2[] = {"35","2","24", "38","43","25","25","8"};
    //Hard stage 1

    private String mQuestionsHard [] = {

            "I'm a number between 6 and 12, an odd number, a number less than 11, you can find me by adding 2+7.",
            "Fill in the missing even number:\n" +
                    "48, 50, _? 54, 56, 58, 60",
            "I'm a number between 3 and 9, an even number, a number less than 9, you can find me by subtracting 10-4.",
            "I'm a number between 13 and 19, an even number, a number less than 17, you can find me by adding 12+4.",
            "What is a number that rhymes with the word nifty free?",
            "I'm a number of pixie mix, an even number, a number between 63 and 69. What am I?",
            "I'm a number between 8 and 14, an odd number, a number greater than 8, you can find me by subtracting 20-9.",
            "I'm a number between 16 and 22, an odd number, a number greater than 15, you can find me by subtracting 35-16.",
            "Fill in the missing odd number:\n" +
                    "47, 49, 51, 53, 55, _? 59",""
    };

    private String mChoicesHard [][] = {
            {"5","9","3"},
            {"52","53","57"},
            {"6","3","9"},
            {"16","17","13"},
            {"53","51","55"},
            {"66","64","61"},
            {"12","11","13"},
            {"19","32","23"},
            {"57","56","52"},
            {"25","35","45"}
    };

    private String mCorrectAnswersHard [] = {"9","52","6", "16","53","66","11","19","57",""};

    //Hard stage 2

    private String mQuestionsHard2 [] = {

            "I'm a number between 70 and 78, an even number, a number greater than 73, you can find me by subtracting 90-16.",
            "Fill in the missing odd number:",
            "I'm a number between 59 and 67, an odd number, a number greater than 61, you can find me by multiplying 9x7.",
            "I'm a number between 6 and 14, an even number, a number less than 13, you can find me by dividing 50/5. ",
            "I'm a number that was once hunted, an even number, a number between 96 and 104. What am I?",
            "What is a number that rhymes with a word windy?",
            "I'm a number between 84 and 92, an even number, a number less than 92, you can find me by adding 74+14.",
            "I'm a number between 71 and 79, an odd number, a number greater than 73, you can find me by subtracting 25x3.",
            "I'm a number between 27 and 37, an even number, a number less than 35, you can find me by dividing 96/3.",""
    };

    private String mChoicesHard2 [][] = {
            {"74","71","73"},
            {"67,\n75","68,\n75","69,\n75"},
            {"63","36","69"},
            {"12","10","13"},
            {"120","110","100"},
            {"91","90","80"},
            {"88","81","83"},
            {"75","78","72"},
            {"32","33","38"},
            {"25","35","45"}

    };

    private String mCorrectAnswersHard2 [] = {"74","69,\n75","63", "10","100","90","88","75","32",""};

    private String mDialogQ [] = {

            "Avi: What do you want from me?",
            "Wizard: I require your skills.",
            "Avi: What kind of skills?",
            "Wizard: A type of skill that will defeat those who abuse their power.",
            "Avi: Why me? What made you call me?",
            "Wizard: I know you're having trouble with your numbers, but that difficulty might be an excellent chance for you to grow.",
            "Avi: H-How did you know I failed my math exam?",
            "Wizard: I am a wizard from another realm, child. And now I've come to seek assistance from other individuals.",
            "Wizard: But now I only need one person and that person happens to be you.",
            "Avi: What do you gain from someone who doesn't even know how to solve a simple math problem?",
            "Wizard: You will see once you decide to join me.",
            "Avi: .....",
            "Wizard: So, what will it be, child?",
            "Avi: .....Okay, I'll come with you.",
            "Wizard: Good. Now come closer to me."
    };
    public String getDialogTest(int a){
        String question = mDialogQ[a];
        return question;

    }
    //Execution
    //Hard Stage 1
    public String getQuestionHard(int a){
        String question = mQuestionsHard[a];
        return question;

    }

    public String getChoice1Hard(int a){
        String choice0 = mChoicesHard[a][0];
        return choice0;


    }
    public String getChoice2Hard(int a){
        String choice11 = mChoicesHard[a][1];
        return choice11;
    }
    public String getChoice3Hard(int a){
        String choice22 = mChoicesHard[a][2];
        return choice22;
    }
    public String getChoice4Hard(int a){
        String choice33 = mChoicesHard[a][3];
        return choice33;
    }

    public String getCorrectAnswerHard(int a){
        String answer = mCorrectAnswersHard[a];
        return answer;

    }
    //Execution
    //Hard Stage 2
    public String getQuestionHard2(int a){
        String question = mQuestionsHard2[a];
        return question;

    }

    public String getChoice1Hard2(int a){
        String choice0 = mChoicesHard2[a][0];
        return choice0;


    }
    public String getChoice2Hard2(int a){
        String choice11 = mChoicesHard2[a][1];
        return choice11;
    }
    public String getChoice3Hard2(int a){
        String choice22 = mChoicesHard2[a][2];
        return choice22;
    }
    public String getChoice4Hard2(int a){
        String choice33 = mChoicesHard2[a][3];
        return choice33;
    }

    public String getCorrectAnswerHard2(int a){
        String answer = mCorrectAnswersHard2[a];
        return answer;

    }
    //Execution
    //Medium Stage 2
    public String getQuestionMedium2(int a){
        String question = mQuestionsMedium2[a];
        return question;

    }

    public String getChoice1Medium2(int a){
        String choice0 = mChoicesMedium2[a][0];
        return choice0;


    }
    public String getChoice2Medium2(int a){
        String choice11 = mChoicesMedium2[a][1];
        return choice11;
    }
    public String getChoice3Medium2(int a){
        String choice22 = mChoicesMedium2[a][2];
        return choice22;
    }
    public String getChoice4Medium2(int a){
        String choice33 = mChoicesMedium2[a][3];
        return choice33;
    }

    public String getCorrectAnswerMedium2(int a){
        String answer = mCorrectAnswersMedium2[a];
        return answer;

    }
    //Medium Stage 1
    public String getQuestionMedium(int a){
        String question = mQuestionsMedium[a];
        return question;

    }

    public String getChoice1Medium(int a){
        String choice0 = mChoicesMedium[a][0];
        return choice0;


    }
    public String getChoice2Medium(int a){
        String choice11 = mChoicesMedium[a][1];
        return choice11;
    }
    public String getChoice3Medium(int a){
        String choice22 = mChoicesMedium[a][2];
        return choice22;
    }
    public String getChoice4Medium(int a){
        String choice33 = mChoicesMedium[a][3];
        return choice33;
    }

    public String getCorrectAnswerMedium(int a){
        String answer = mCorrectAnswersMedium[a];
        return answer;

    }
    //Easy

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;

    }

    public String getChoice1(int a){
        String choice0 = mChoices[a][0];
        return choice0;


    }
    public String getChoice2(int a){
        String choice11 = mChoices[a][1];
        return choice11;
    }
    public String getChoice3(int a){
        String choice22 = mChoices[a][2];
        return choice22;
    }
    public String getChoice4(int a){
        String choice33 = mChoices[a][3];
        return choice33;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;

    }
    //easy stage 2
    public String getQuestion2(int a){
        String question = mQuestions2[a];
        return question;

    }

    public String getChoice12(int a){
        String choice0 = mChoices2[a][0];
        return choice0;


    }
    public String getChoice22(int a){
        String choice11 = mChoices2[a][1];
        return choice11;
    }
    public String getChoice32(int a){
        String choice22 = mChoices2[a][2];
        return choice22;
    }
    public String getChoice42(int a){
        String choice33 = mChoices2[a][3];
        return choice33;
    }

    public String getCorrectAnswer2(int a){
        String answer = mCorrectAnswers2[a];
        return answer;

    }

}
