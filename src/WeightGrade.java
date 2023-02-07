import java.util.Scanner;
import java.util.ArrayList;

public class WeightGrade {
    private ArrayList<Double> fullPoints = new ArrayList<Double>();
    private ArrayList<Double> earnedPoints = new ArrayList<Double>();
    private ArrayList<Double> percentage = new ArrayList<Double>();
    int numberOfAssignments;
    private Double finalGrade = 0.0;
    private String letterGrade;

   // public WeightGrade()

    public void takeNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many assignments do you have?");
        numberOfAssignments = scanner.nextInt(); // total number of assignments

        for (int i = 0; i < numberOfAssignments; i++)
        {
            System.out.println("Please type the total points for assignment " + i + ":");
            fullPoints.add(scanner.nextDouble());
        } // get full points for all assignments

        for (int i = 0; i < numberOfAssignments; i++)
        {
            System.out.println("Please type points you earned for assignment " + i + ":");
            earnedPoints.add(scanner.nextDouble());
        } // get points earned for each assignment

        Double totalPercentage = 0.0;
        for (int i = 0; i < numberOfAssignments; i++)
        {
            System.out.println("Please type the percentage assignment " + i + " contributes to your final grade:");
            Double temp = scanner.nextDouble();
            totalPercentage += temp;
            percentage.add(temp);
        } // get the weight of each assignment

        if (totalPercentage != 100.0) {
            System.out.println("Total percentage should add to 100.0");
            System.out.println("Current total percentage is " + totalPercentage + ", please try again.");

            //remove all values
            fullPoints.removeAll(fullPoints);
            earnedPoints.removeAll(earnedPoints);
            percentage.removeAll(percentage);

            //start over
            takeNumbers();
        } //in case total percentage does not add to 100, start over
    } // take inputs from the user and store the values

    public void genFinalGrade()
    {
        for (int i = 0; i < numberOfAssignments; i++)
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

