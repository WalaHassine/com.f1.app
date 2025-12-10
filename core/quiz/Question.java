package quiz;

import java.util.List;

public class Question {
    private String text;
    private List<String> options;
    private int correctIndex;
    private int rewardPoints;

    public Question(String text, List<String> options, int correctIndex, int rewardPoints) {
        this.text = text;
        this.options = options;
        this.correctIndex = correctIndex;
        this.rewardPoints = rewardPoints;
    }

    public String getText() { return text; }
    public List<String> getOptions() { return options; }
    public int getCorrectIndex() { return correctIndex; }
    public int getRewardPoints() { return rewardPoints; }
}
