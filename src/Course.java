class Course {
    protected static final byte DEFAULT_BYTE = 0;
    protected static final double DEFAULT_DOUBLE = 0.0;
    protected static final String DEFAULT_STRING = "";
    private String courseNumber, descriptiveTitle;
    private byte term, year; //
    private double units, grades;

    /**
     * Default Constructor
     * Constructs a course with the empty string as the course number,
     * empty string as the course title, 0 as the units,
     * 0 as the year level, 0 as the term, 0 as the grade
     */
    Course () {
        this(DEFAULT_STRING, DEFAULT_STRING,
                DEFAULT_BYTE, DEFAULT_BYTE, DEFAULT_DOUBLE, DEFAULT_DOUBLE);
    }

    /** given string t as the course title,
     * given u as the units,
     * given y as the year level,
     * given e the term,
     * given g as the grade
     */
    Course(String courseNumber, String descriptiveTitle,
           byte term, byte year, double units, double grades) {
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

    public void setTerm(byte term) {
        this.term = term;
    }

    public void setYear(byte year) {
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

    public int compareTo(Course another){
        if (this.toString().equals(another.toString()))
            return 0; else
        if (this.toString().compareTo(another.toString()) < 0) return -1;
        else
            return 1;
    }
}