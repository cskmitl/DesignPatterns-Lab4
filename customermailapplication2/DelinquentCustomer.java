public class DelinquentCustomer extends Customer {
    @Override
    public String createMail() {
        return "Delinquent Customer Mail";
    }

    @Override
    public String createBrochure() {
        return "Delinquent Customer Brochure";
    }
}
