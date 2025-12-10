package state;

import progress.EconomyManager;
import progress.PlayerProfile;
import quiz.Question;
import quiz.Quiz;
import quiz.QuizManager;

public class QuizState implements GameState {

    private QuizManager quizManager = new QuizManager();

    @Override
    public void enter(PlayerProfile profile, EconomyManager economy) {
        System.out.println("=== QUIZ MODE ===");
    }

    @Override
    public void handle(PlayerProfile profile, EconomyManager economy) {
        Quiz quiz = quizManager.buildSimpleQuiz(2);
        for (Question q : quiz.getQuestions()) {
            System.out.println("Q: " + q.getText());
            System.out.println("Options: " + q.getOptions());
            // Ici : lire réponse utilisateur dans la couche UI
            System.out.println("Assuming correct answer for demo.");
            economy.addPoints(q.getRewardPoints());
        }
        System.out.println("Quiz completed. Total points: " + economy.getTotalPoints());
    }

    @Override
    public void exit(PlayerProfile profile, EconomyManager economy) {
        System.out.println("Leaving QUIZ.");
    }
}
