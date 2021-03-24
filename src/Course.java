class Course {
    protected static final int DEFAULT_INT = 0;
    protected static final double DEFAULT_DOUBLE = 0.0;
    protected static final String DEFAULT_STRING = "";
    private String courseNumber, descriptiveTitle;
    private int term, year;
    private double units, grades;

    Course () {
        this(DEFAULT_STRING, DEFAULT_STRING,
                DEFAULT_INT, DEFAULT_INT, DEFAULT_DOUBLE, DEFAULT_DOUBLE);
    }

    Course(String courseNumber, String descriptiveTitle,
           int term, int year, double units, double grades) {
        this.courseNumber = courseNumber;
        this.descriptiveTitle = descriptiveTitle;
        this.term = term;
        this.year = year;
        this.units = units;
        this.grades = grades;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setDescriptiveTitle(String descriptiveTitle) {
        this.descriptiveTitle = descriptiveTitle;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setUnits(double units) {
        this.units = units;
    }

    public void setGrades(double grades) {
        this.grades = grades;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public String getDescriptiveTitle() {
        return descriptiveTitle;
    }

    public int getTerm() {
        return term;
    }

    public int getYear() {
        return year;
    }

    public double getUnits() {
        return units;
    }

    public double getGrades() {
        return grades;
    }

}