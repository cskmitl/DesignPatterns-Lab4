import java.util.Scanner;

public class CustomerMailApplication {
    private Customer customer;

    public CustomerMailApplication(Customer customer) {
        this.customer = customer;
    }

    public String generateMail() {
        return customer.createMail();
    }

    private static String getCustomerTypeFromUser() {
        String customerType = null;
        Scanner inp = new Scanner(System.in);
        System.out.print("Please choose customer type 1. Regular, 2. Mountain, 3. Delinquent ");
        int type = inp.nextInt();
        switch (type) {
            case 1:
                customerType = "Regular";
                break;
            case 2:
                customerType = "Mountain";
                break;
            case 3:
                customerType = "Delinquent";
                break;
        }
        inp.close();
        return customerType;
    }

    public static class CustomerMailFactory {
        public Customer createCustomer(String customerType) {
            switch (customerType) {
                case "Regular":
                    return createRegularCustomer();
                case "Mountain":
                    return createMountainCustomer();
                case "Delinquent":
                    return createDelinquentCustomer();
                default:
                    throw new IllegalArgumentException("Invalid customer type");
            }
        }

        protected Customer createRegularCustomer() {
            return new RegularCustomer();
        }

        protected Customer createMountainCustomer() {
            return new MountainCustomer();
        }

        protected Customer createDelinquentCustomer() {
            return new DelinquentCustomer();
        }
    }

    public String generateBrochure() {
        return customer.createBrochure();
    }

    public static void main(String[] args) {
        String customerType = getCustomerTypeFromUser();

        CustomerMailFactory factory = new CustomerMailFactory();
        Customer customer = factory.createCustomer(customerType);

        CustomerMailApplication app = new CustomerMailApplication(customer);
        System.out.println(app.generateMail());
        System.out.println(app.generateBrochure());
    }

}
