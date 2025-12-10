package ui;

import progress.EconomyManager;
import quiz.Question;
import quiz.Quiz;
import quiz.QuizManager;


public class QuizMenu {

    private final QuizManager quizManager;
    private final EconomyManager economy;

    public QuizMenu(QuizManager quizManager, EconomyManager economy) {
        this.quizManager = quizManager;
        this.economy = economy;
    }

    public void show() {
        ConsoleUtils.printSeparator();
        System.out.println("===================== F1 QUIZ ===================== ");
        int n = ConsoleUtils.readInt("Number of questions 1-16 : ");
        if (n <= 0) {
            System.out.println("No quiz played.");
            return;
        }

        Quiz quiz = quizManager.buildSimpleQuiz(Math.min(n, 5));
        int earned = 0;

        for (Question q : quiz.getQuestions()) {
            ConsoleUtils.printSeparator();
            System.out.println("Q: " + q.getText());
            var opts = q.getOptions();
            for (int i = 0; i < opts.size(); i++) {
                System.out.println((i + 1) + ") " + opts.get(i));
            }
            int answer = ConsoleUtils.readInt("Your answer (1-" + opts.size() + "): ");

            if (answer - 1 == q.getCorrectIndex()) {
                System.out.println("Correct!");
                earned += q.getRewardPoints();
            } else {
                System.out.println("Wrong. Correct answer was: " +
                        opts.get(q.getCorrectIndex()));
            }
        }

        economy.addPoints(earned);
        System.out.println("Quiz finished. Earned points: " + earned +
                " | Total: " + economy.getTotalPoints());
    }
}
