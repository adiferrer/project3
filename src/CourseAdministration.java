import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CourseAdministration {
    static BufferedReader br;

    protected static List<Course> parseCSV () {
        List<Course> courseList = null;
        String line;
        try {
            br = new BufferedReader(new FileReader("BSCSCurriculumData1WithGrades.csv"));
            while ((line = br.readLine()) != null) {
                // Split on comma
                String[] courseCSV = line.split(",");
                // Create course object to store values
                Course courseTemp = new Course();
                // add values from csv to Course object
                courseTemp.setYear(Byte.parseByte(courseCSV[0]));
                courseTemp.setTerm(Byte.parseByte(courseCSV[1]));
                courseTemp.setCourseNumber(courseCSV[2]);
                courseTemp.setDescriptiveTitle(courseCSV[3]);
                courseTemp.setUnits(Double.parseDouble(courseCSV[4]));
                // TODO add a conditional statement for when the the grade cell is blank
                courseTemp.setGrades(Double.parseDouble(courseCSV[5]));
                courseList.add(courseTemp);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found.");
        } catch (IOException ioException) {
            System.out.println("I/O error: " + ioException);
        }
        return courseList;
    }

    /*// Implement if parseCSV() does not have a case
    // for a CSV file with grades
    protected static List<Course> parseCSVWithGrades() {
    }


    // Implement two cases: ascending and descending
    private static List<Course> sortCoursesByGPA(int key) {
        switch(key) {
        }
    }

    private static List<Course> inputGrades() {

    }

    private static boolean hasFailedCourse() {

    }*/

    private void showIntroduction() {

    }

    public static void main (String[] args) {
        List<Course> courseList = new ArrayList<>();
        System.out.println(courseList);
    }
}