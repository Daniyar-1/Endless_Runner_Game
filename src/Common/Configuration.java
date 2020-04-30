package Common;

public class Configuration {

    private static Configuration INSTANCE;
    private Score score;

    private Configuration() {
        score = new Score();
    }
    public static Configuration getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Configuration();
        }
        return INSTANCE;
    }

    public void saveGameHighScore(int pSCoreInt) {
        this.score.setScore(pSCoreInt);
        score.writeScore();
    }

    public int getHighScore() {
        score.readScore();
        return this.score.getScore();
    }
}
