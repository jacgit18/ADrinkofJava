public class Technologist
{
    private String firstName = "empty";
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

    protected String firstN; //visibility to same package and subclasses
    protected String company = "Strategio";

    public void study() {
        System.out.println("I am studying!");
    }

}
