import java.util.Scanner;
import java.util.ArrayList;

public class WeightGrade {
    private ArrayList<Double> fullPoints = new ArrayList<Double>();
    private ArrayList<Double> earnedPoints = new ArrayList<Double>();
    private ArrayList<Double> percentage = new ArrayList<Double>();
    private Double finalGrade = 0.0;
    private String letterGrade;

   // public WeightGrade()



    public void takeNumbers() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 8; i++)
        {
            System.out.println("Please type the total points for assignment " + i + ":");
            fullPoints.add(scanner.nextDouble());
        }

        for (int i = 0; i < 8; i++)
        {
            System.out.println("Please type points you earned for assignment " + i + ":");
            earnedPoints.add(scanner.nextDouble());
        }

        for (int i = 0; i < 8; i++)
        {
            System.out.println("Please type the percentage assignment " + i + " contributes to your final grade:");
            percentage.add(scanner.nextDouble());
        }
    } // take inputs from the user and store the values

    public void genFinalGrade()
    {
        for (int i = 0; i < 8; i++)
        {
            finalGrade += earnedPoints.get(i) / fullPoints.get(i) * percentage.get(i);
        } // sum all grades with weight and get a percentage total

        if (finalGrade >= 90)
        {
            letterGrade = "A";
        }
        else if (finalGrade >= 80)
        {
            letterGrade = "B";
        }
        else if (finalGrade >= 70)
        {
            letterGrade = "C";
        }
        else if (finalGrade >= 60) {
            letterGrade = "D";
        }
        else
        {
            letterGrade = "F";
        } // set letter grade according to percentage

        System.out.println("Your final grade is " + letterGrade + ", with a percentage of " + finalGrade + ".");
    } // calculate and output grades earned by the assignment in letter grade and percentage
}

