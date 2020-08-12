package org.goiteens;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ChatBot {
    private static Map<String, Integer> professions;
    private static Map<String, Integer> dreams;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();

        initProfessions();
        initDreams();

        String botAnswer = process(message);
        System.out.println(botAnswer);
    }
    
    public static void initProfessions() {
        professions = new LinkedHashMap<>();

        professions.put("Designer", 20000);
        professions.put("Java", 55000);
        professions.put("Frontend", 40000);
    }

    public static void initDreams() {
        dreams = new LinkedHashMap<>();

        dreams.put("Машин", 260000);
        dreams.put("iPhone", 27000);
    }
    
    public static String process(String message) {
        if (isHelloMessage(message)) {
            return "Hello there! Team of Talks Outside the Box is happy to see you on our marathon!";
        }

        if (isFirstMessage(message)) {
            return  "Hello there! Team of Talks Outside the Box is happy to see you on our marathon! \n"+
                    "In this chat-bot will be published all needed information to perform well during event. \n" +
                    "Every Monday, Wednesday and Friday you will receive links for week's tasks and compilation of new words❗️\n" +
                    "\n" +
                    "\n" +
                    "We created a group for chatting, there members of marathon can get to know more about each other, find new friends, ask for help  \n" +
                    "to mentors and receive answers for all your questions about marathon." +
                    "\n" +
                    "Jump into our chat right now \uD83D\uDC47\uD83C\uDFFB\uD83D\uDC47\uD83C\uDFFB\n" +
                    "\n" +
                    "\n" +
                    "❗ https://t.me/joinchat/FsecXx2DY-GIkbsJBJv8Ng ❗️\n" +
                    "\n" +
                    "Joining to the chat is necessary, there will be published all relevant news and answers to asked questions!";
        }

        if (isWhatYouCanDo(message)) {
            return "You can write different commands, so I will answer immediately. \n" +
                    "By the way, I understand both English and Ukrainian languages❗️\n" +
                    "\n" +
                    "\n" +
                    "You can type 'FAQ' and I will answer to the frequently asked questions. \n" +
                    "Please type 'Generator' to get help with creating your speech." +
                    "\n" +
                    "\n" +
                    "You can type 'Recordings' and I will send you all our session's recordings \n" +
                    "Please type 'Joke' to entertain yourself." +
                    "\n" +
                    "\n" +
                    "You can type 'Words' and I will send you previous compilation of words \n" +
                    "Please type 'Test' to challenge your vocabulary." +
                    "\n" +
                    "\n" +
                    "Help Yourself!";
        }

        if (isHelloMessageUkr(message)) {
            return "Привіт! Це команда Talks Outside the Box, раді бачити тебе на нашому марафоні!";
        }

        if (isWhatYouCanDoUkr(message)) {
            return "Ти можеш написати різні команди, я відповім негайно. \n" +
                    "До того ж, я розумію англійську та українську мови, звертайся, як тобі зручніше❗️\n" +
                    "\n" +
                    "\n" +
                    "Ти можеш написати 'ЧЗП' і я відповім на часто задавані питання. \n" +
                    "Будь ласка, напиши 'Генератор', щоб отримати допомогу з створенням свого спічу." +
                    "\n" +
                    "\n" +
                    "Ти можеш написати 'Записи' і я надішлю всі записи наших сесій. \n" +
                    "Будь ласка, напиши 'Жарт', щоб трішки розважитись." +
                    "\n" +
                    "\n" +
                    "Ти можеш написати 'Нові Слова' і я надішлю тобі останню підбірку слів. \n" +
                    "Будь ласка, напиши 'Тест', щоб випробувати свій словниковий запас." +
                    "\n" +
                    "\n" +
                    "Буду радий допомогти!";
        }

        if (SwearWords(message)) {
            return "That was rude! My advice: don't use this word.";
        }
        if (SwearWordsUkr(message)) {
            return "Це було неввічливо! Моя порада - не вживай такі слова.";
        }

        int professionSalary = find(message, professions);
        int dreamCost = find(message, dreams);

        if (professionSalary < 0) {
            return "Excuse me, I don't quite understand you.";
        }

        if (dreamCost < 0) {
            return "Excuse me, I don't quite understand you.";
        }

        int monthCount = calculateMonthCount(dreamCost, professionSalary);

        return "Щоб отримати свою мрію, потрібно місяців: " + monthCount;
    }

    public static int find(String message, Map<String, Integer> data) {
        message = message.toLowerCase();

        for(String word: data.keySet()) {
            String lowerCasedWord = word.toLowerCase();

            if (message.contains(lowerCasedWord)) {
                return data.get(word);
            }
        }

        return -1;
    }
    
    public static int calculateMonthCount(int dreamCost, int professionSalary) {
        int monthCount = dreamCost / professionSalary;
        monthCount = validateMonthCount(monthCount);
        return monthCount;
    }

    public static int validateMonthCount(int monthCount) {
        if (monthCount == 0) {
            return 1;
        }

        return monthCount;
    }
    
    private static boolean isHelloMessage(String message) {
        message = message.toLowerCase();

        String helloWord1 = "hello";
        String helloWord2 = "hi";
        String helloWord4 = "what's up";
        String helloWord5 = "good evening";
        String helloWord6 = "good morning";

        return message.contains(helloWord1) || message.contains(helloWord2) || message.contains(helloWord4) || message.contains(helloWord5) || message.contains(helloWord6);
    }

    private static boolean isFirstMessage(String message) {
        message = message.toLowerCase();

        String firstWord1 = "/start";

        return message.contains(firstWord1);
    }

    private static boolean SwearWords(String message) {
        message = message.toLowerCase();

        String swearWord1 = "fuck";
        String swearWord2 = "wtf";
        String swearWord3 = "shit";
        String swearWord4 = "son of a bitch";
        String swearWord5 = "asshole";
        String swearWord6 = "bastard";

        return message.contains(swearWord1) || message.contains(swearWord2) || message.contains(swearWord3) || message.contains(swearWord4) || message.contains(swearWord5) || message.contains(swearWord6);
    }

    private static boolean isHelloMessageUkr(String message) {
        message = message.toLowerCase();

        String helloWord7 = "привіт";
        String helloWord8 = "здарова";
        String helloWord9 = "як справи";
        String helloWord10 = "добрий вечір";
        String helloWord11 = "доброго ранку";

        return message.contains(helloWord7) || message.contains(helloWord8) || message.contains(helloWord9) || message.contains(helloWord10) || message.contains(helloWord11);
    }

    private static boolean isWhatYouCanDoUkr(String message) {
        message = message.toLowerCase();

        String canWord1 = "що ти вмієш";
        String canWord2 = "що ти робиш";
        String canWord3 = "як ти мені допоможеш";
        String canWord4 = "що ти таке";
        String canWord5 = "що ти таке";

        return message.contains(canWord1) || message.contains(canWord2) || message.contains(canWord3) || message.contains(canWord4) || message.contains(canWord5);
    }

    private static boolean isWhatYouCanDo(String message) {
        message = message.toLowerCase();

        String canWord6 = "what can you do";
        String canWord7 = "what do you do";
        String canWord8 = "how can you help me";
        String canWord9 = "what are you";
        String canWord10 = "who are you";

        return message.contains(canWord6) || message.contains(canWord7) || message.contains(canWord8) || message.contains(canWord9) || message.contains(canWord10);
    }

    private static boolean SwearWordsUkr(String message) {
        message = message.toLowerCase();

        String swearWord7 = "сука";
        String swearWord8 = "блять";
        String swearWord9 = "нахуй";
        String swearWord10 = "скотина";

        return message.contains(swearWord7) || message.contains(swearWord8) || message.contains(swearWord9) || message.contains(swearWord10);
    }
}
