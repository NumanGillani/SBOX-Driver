package numan.superboxdriver.VisitsReport;

/**
 * Created by Gillani on 10/4/2016.
 */
public class CustomerRowItem {

    private String ProviderName;
    private String ProductName;
    private String TotalQuantity;
    private String TotalAmount;
    private String CreatedOn;
    private String MobileNumber;

    public CustomerRowItem(String ProviderName, String ProductName, String TotalQuantity, String TotalAmount, String CreatedOn, String MobileNumber) {

        this.ProviderName = ProviderName;
        this.ProductName = ProductName;
        this.TotalQuantity = TotalQuantity;
        this.TotalAmount = TotalAmount;
        this.CreatedOn = CreatedOn;
        this.MobileNumber = MobileNumber;

    }

    public String getProviderName() {
        return ProviderName;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getTotalQuantity() {
        return TotalQuantity;
    }

    public String getTotalAmount() {
        return TotalAmount;
    }

    public String getCreatedOn() {
        return CreatedOn;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

}
