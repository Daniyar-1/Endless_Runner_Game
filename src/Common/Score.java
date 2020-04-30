package Common;

import java.io.*;

public class Score {
    int score;
    int hiScore;
    public void writeScore() {
        System.out.println("Go here to save");
        BufferedWriter bw = null;
            File file = new File("D:\\EndlessRunner_Game\\Scores.txt");
            try {
                bw = new BufferedWriter(new FileWriter(file, false));
                bw.write(String.valueOf(score));
               bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

            }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void readScore() {
        String line = "";
        File file = new File("D:\\EndlessRunner_Game\\Scores.txt");
        if(file.exists()) {
            try(BufferedReader br =  new BufferedReader(new FileReader(file))) {
                while((line = br.readLine()) != null) {
                    try {
                        score = Integer.valueOf(line);
                    }catch(NumberFormatException e) {

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
