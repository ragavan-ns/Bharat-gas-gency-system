package gasSupplier;

public interface gasAgency {
    public String agencyName = "Bharat Gas";
    public int agencyCode = 1234;
    public int phNumber = 938267172;

    default void agencyDisplay(){
        System.out.println("The agency name is: " + agencyName);
        System.out.println("The agency code is: " + agencyCode);
        System.out.println("The agency phNumber is: " + phNumber);
    }
}
