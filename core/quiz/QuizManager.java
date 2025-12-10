package quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizManager {

    private List<Question> bank = new ArrayList<>();

    public QuizManager() {
        loadDefaultQuestions();
    }

private void loadDefaultQuestions() {

    // EXISTING QUESTIONS
    bank.add(new Question(
            "Who holds the record for most F1 titles?",
            List.of("Ayrton Senna", "Lewis Hamilton", "Michael Schumacher", "Sebastian Vettel"),
            2,
            20
    ));

    bank.add(new Question(
            "Which engine format is used in modern F1?",
            List.of("V10", "V12", "V8", "V6 Turbo Hybrid"),
            3,
            15
    ));


    // NEW QUESTIONS
    bank.add(new Question(
            "Which team has won the most Constructors' Championships?",
            List.of("Ferrari", "McLaren", "Mercedes", "Red Bull Racing"),
            0,
            20
    ));

    bank.add(new Question(
            "Who was the youngest driver to start an F1 race?",
            List.of("Lando Norris", "Max Verstappen", "Esteban Ocon", "Lance Stroll"),
            1,
            25
    ));

    bank.add(new Question(
            "Which circuit is the longest track currently on the F1 calendar?",
            List.of("Spa-Francorchamps", "Silverstone", "Baku City Circuit", "Monza"),
            0,
            15
    ));

    bank.add(new Question(
            "Which component is part of F1's ERS system?",
            List.of("MGU-K", "HANS", "DRS Wing", "Turbo Wastegate"),
            0,
            20
    ));

    bank.add(new Question(
            "Where was the first Formula 1 World Championship race held in 1950?",
            List.of("Monaco", "Silverstone", "Monza", "Zandvoort"),
            1,
            20
    ));

    bank.add(new Question(
            "Which driver earned the nickname 'The Iceman'?",
            List.of("Kimi Räikkönen", "Valtteri Bottas", "Nico Rosberg", "Mika Häkkinen"),
            0,
            10
    ));

    bank.add(new Question(
            "What does DRS stand for?",
            List.of("Downforce Reduction System",
                    "Drag Reduction System",
                    "Dynamic Racing Suspension",
                    "Driver Response System"),
            1,
            10
    ));

    bank.add(new Question(
            "Which team dominated the 2010–2013 seasons?",
            List.of("Red Bull Racing", "Ferrari", "Mercedes", "Williams"),
            0,
            15
    ));

    bank.add(new Question(
            "What country hosts the Suzuka Circuit?",
            List.of("South Korea", "China", "Japan", "Malaysia"),
            2,
            10
    ));

    bank.add(new Question(
            "Who is the only driver to win a championship posthumously?",
            List.of("Gilles Villeneuve", "Jochen Rindt", "Jim Clark", "Niki Lauda"),
            1,
            30
    ));

    bank.add(new Question(
            "Which year introduced the hybrid power units in F1?",
            List.of("2010", "2012", "2013", "2014"),
            3,
            20
    ));

    bank.add(new Question(
            "Which driver has the most career pole positions?",
            List.of("Sebastian Vettel", "Lewis Hamilton", "Michael Schumacher", "Ayrton Senna"),
            1,
            20
    ));

    bank.add(new Question(
            "What tyre supplier provides F1 tyres today?",
            List.of("Bridgestone", "Pirelli", "Michelin", "Goodyear"),
            1,
            10
    ));

    bank.add(new Question(
            "Which country hosts the Interlagos circuit?",
            List.of("Argentina", "Brazil", "Mexico", "Portugal"),
            1,
            15
    ));
}


    public Quiz buildSimpleQuiz(int numberOfQuestions) {
        List<Question> list = new ArrayList<>();
        for (int i = 0; i < numberOfQuestions && i < bank.size(); i++) {
            list.add(bank.get(i));
        }
        return new Quiz(list);
    }
}
