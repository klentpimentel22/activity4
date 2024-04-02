import java.util.*;

// Model classes
class Client {
    private String name;
    private double totalAmountBilled;

    public Client(String name) {
        this.name = name;
        this.totalAmountBilled = 0;
    }

    public String getName() {
        return name;
    }

    public double getTotalAmountBilled() {
        return totalAmountBilled;
    }

    public void addToTotalAmountBilled(double amount) {
        this.totalAmountBilled += amount;
    }
}

class Service {
    private String name;
    private double rate;
    private int totalHoursBilled;

    public Service(String name, double rate) {
        this.name = name;
        this.rate = rate;
        this.totalHoursBilled = 0;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    public int getTotalHoursBilled() {
        return totalHoursBilled;
    }

    public void addToTotalHoursBilled(int hours) {
        this.totalHoursBilled += hours;
    }

    public void addService(Service service) {
        throw new UnsupportedOperationException("Unimplemented method 'addService'");
    }

    public Client getClient() {
        throw new UnsupportedOperationException("Unimplemented method 'getClient'");
    }
}

class Invoice {
    private int invoiceNumber;
    private Client client;
    private ArrayList<Service> services;

    public Invoice(int invoiceNumber, Client client) {
        this.invoiceNumber = invoiceNumber;
        this.client = client;
        this.services = new ArrayList<>();
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public Client getClient() {
        return client;
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    public void addService(Service service) {
        services.add(service);
    }

    public void removeService(Service service) {
        services.remove(service);
    }
}

// Controller class
class InvoiceSystem {
    private ArrayList<Client> clients;
    private ArrayList<Service> services;
    private ArrayList<Invoice> invoices;
    private int nextInvoiceNumber;

    public InvoiceSystem() {
        this.clients = new ArrayList<>();
        this.services = new ArrayList<>();
        this.invoices = new ArrayList<>();
        this.nextInvoiceNumber = 1;
    }

    // Client Management
    public void addClient(String name) {
        clients.add(new Client(name));
    }

    public void viewClients() {
        for (Client client : clients) {
            System.out.println("Client: " + client.getName() + ", Total Amount Billed: $" + client.getTotalAmountBilled());
        }
    }

    // Service Management
    public void addService(String name, double rate) {
        services.add(new Service(name, rate));
    }

    public void viewServices() {
        for (Service service : services) {
            System.out.println("Service: " + service.getName() + ", Rate: $" + service.getRate() + ", Total Hours Billed: " + service.getTotalHoursBilled());
        }
    }

    // Invoice Management
    public void createInvoice(Client client) {
        invoices.add(new Invoice(nextInvoiceNumber++, client));
    }

    public void addServiceToInvoice(Service service2, Service service) {
        service2.addService(service);
        service.addToTotalHoursBilled(1); // Assuming one hour of service for simplicity
        double amount = service.getRate(); // Assuming rate per hour for simplicity
        service2.getClient().addToTotalAmountBilled(amount);
    }

    public void viewInvoicesForClient(Client client) {
        for (Invoice invoice : invoices) {
            if (invoice.getClient() == client) {
                System.out.println("Invoice Number: " + invoice.getInvoiceNumber() + ", Total Amount: $" + getTotalAmountForInvoice(invoice));
            }
        }
    }

    public double getTotalAmountForInvoice(Invoice invoice) {
        double totalAmount = 0;
        for (Service service : invoice.getServices()) {
            totalAmount += service.getRate(); // Assuming rate per hour for simplicity
        }
        return totalAmount;
    }

    public ArrayList<Service> getInvoices() {
        throw new UnsupportedOperationException("Unimplemented method 'getInvoices'");
    }

    public ArrayList<Service> getServices() {
        throw new UnsupportedOperationException("Unimplemented method 'getServices'");
    }
}

public class VAsystem {
    public static void main(String[] args) {
        InvoiceSystem system = new InvoiceSystem();

        // Adding clients
        system.addClient("Client A");
        system.addClient("Client B");

        // Adding services
        system.addService("Service X", 50.0);
        system.addService("Service Y", 60.0);

        // Creating invoices
        system.createInvoice(system.getClass().get(0)); // Creating invoice for Client A
        system.createInvoice(system.getClass().get(1)); // Creating invoice for Client B

        // Adding services to invoices
        system.addServiceToInvoice(system.getInvoices().get(0), system.getServices().get(0)); // Adding Service X to Invoice 1
        system.addServiceToInvoice(system.getInvoices().get(0), system.getServices().get(1)); // Adding Service Y to Invoice 1
        system.addServiceToInvoice(system.getInvoices().get(1), system.getServices().get(0)); // Adding Service X to Invoice 2

        // Viewing invoices for clients
        system.viewInvoicesForClient(system.getClass().get(0)); // Viewing invoices for Client A
        system.viewInvoicesForClient(system.getClass().get(1)); // Viewing invoices for Client B
    }
}
