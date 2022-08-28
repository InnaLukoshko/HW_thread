public class Programmist {
    private ProgrammingLanguage language;
    private String fio;
    private int salary;
    private boolean distantWork;

    public Programmist(ProgrammingLanguage language, String fio, int salary, boolean distantWork) {
        this.language = language;
        this.fio = fio;
        this.salary = salary;
        this.distantWork = distantWork;
    }

    public ProgrammingLanguage getLanguage() {
        return language;
    }

    public String getFio() {
        return fio;
    }

    public int getSalary() {
        return salary;
    }

    public boolean isDistantWork() {
        return distantWork;
    }

    @Override
    public String toString() {
        return "Programmist{" +
                "language=" + language +
                ", fio='" + fio + '\'' +
                ", salary=" + salary +
                ", distantWork=" + distantWork +
                '}';
    }
}
