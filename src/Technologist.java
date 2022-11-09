

abstract class Technologist {
    private String firstName = "empty";
    protected String firstN; //visibility to same package and subclasses
    protected String company = "Strategio";

    // Getter
    public String getFirstName()
    {
        return firstName;
    }

    // Setter
    public void setFirstName(String newFirstName)
    {
        this.firstName = newFirstName;
    }

    public abstract void study();

    public void attendClass() {
        System.out.println("I am attending class");
    }
}