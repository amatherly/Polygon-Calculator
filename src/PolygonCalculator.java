import java.util.Scanner;

// This program asks the user for the number of sides of a polygon, then prompts them to input each corner point.
// It will calculate the area of any polygon with more than three sides.
public class PolygonCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of sides:");
        int sides = scanner.nextInt();

        double[] xCoords = new double[sides + 1];
        double[] yCoords = new double[sides + 1];

        //Prompting the user for the coordinates of each point
        for (int i = 0; i < sides; i++) {
            System.out.println("x sub " + (i + 1) + ":");
            xCoords[i] = scanner.nextInt();
            System.out.println("y sub " + (i + 1) + ":");
            yCoords[i] = scanner.nextInt();
        }

        xCoords[sides] = xCoords[0];
        yCoords[sides] = yCoords[0];

        System.out.println("Area: " + findArea(xCoords, yCoords));
    }

    public static double findArea(double[] x, double[] y) {
        double area = 0;
        for (int i = 0; i < x.length - 1; i++) {
            // the formula derived from the sum in the document
            area += (x[i] * y[i + 1] - x[i + 1] * y[i]);
        }
        // if area is negative, flip the sign
        if (area < 0) return area / -2;
        else return area / 2;
    }
}
