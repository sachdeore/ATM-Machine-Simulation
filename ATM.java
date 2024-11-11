public class ATM {
    private int balance;  // Variable to store the ATM balance
    private int pin;      // Variable to store the user's PIN

    // Constructor to initialize ATM with a balance and a PIN
    public ATM(int balance, int pin) {
        this.balance = balance;  // Initialize the balance
        this.pin = pin;          // Initialize the PIN
    }

    // Method to display the menu options
    public void displayMenu() {
        System.out.println("1: Check Balance");
        System.out.println("2: Deposit");
        System.out.println("3: Withdrawal");
        System.out.println("4: Change Pin");
        System.out.println("5: Exit");
    }

    // Method to deposit money into the ATM balance
    public void deposit(int amount) {
        balance += amount;  // Add the amount to the balance
    }

    // Method to withdraw money from the ATM balance
    public void withdraw(int amount) {
        if (balance < amount) {  // Check if there are sufficient funds
            System.err.println("Insufficient Funds");  // Error message if insufficient funds
            return;
        }
        balance -= amount;  // Deduct the amount from the balance
    }

    // Getter method to get the current balance of the ATM
    public int getBalance() {
        return balance;  // Return the current balance
    }

    // Method to validate if the entered PIN matches the stored PIN
    public boolean validatePin(int pin) {
        return this.pin == pin;  // Return true if the entered PIN matches, false otherwise
    }

    // Method to change the ATM's PIN
    public void changePin(int newPin) {
        pin = newPin;  // Set the new PIN
        System.out.println("Pin Changed");  // Inform the user that the PIN was successfully changed
    }

    // Main method where the ATM program runs
    public static void main(String[] args) {
        ATM atm = new ATM(1000, 1234);  // Create an ATM object with an initial balance of 1000 and PIN 1234

        // Prompt user to enter their PIN
        System.err.println("Enter the Pin");
        int pin = Integer.parseInt(System.console().readLine());  // Read and parse the user's entered PIN

        // Validate the entered PIN
        if (atm.validatePin(pin)) {
            atm.displayMenu();  // Display the menu if the PIN is correct

            int option = 0;  // Variable to store the user's menu option

            // Loop to allow the user to perform operations until they choose to exit
            while (option != 5) {
                atm.displayMenu();  // Display the menu again for each loop iteration
                option = Integer.parseInt(System.console().readLine());  // Read and parse the user's option

                // Switch-case to handle different menu options
                switch (option) {
                    case 1:  // Check Balance
                        System.out.println("Balance: " + atm.getBalance());  // Display the current balance
                        break;

                    case 2:  // Deposit money
                        System.out.print("Enter Amount: ");  // Prompt user for deposit amount
                        int amount = Integer.parseInt(System.console().readLine());  // Read the deposit amount
                        atm.deposit(amount);  // Call the deposit method to add the money to the balance
                        break;

                    case 3:  // Withdraw money
                        System.out.print("Enter Amount: ");  // Prompt user for withdrawal amount
                        amount = Integer.parseInt(System.console().readLine());  // Read the withdrawal amount
                        atm.withdraw(amount);  // Call the withdraw method to deduct the money from the balance
                        break;

                    case 4:  // Change PIN
                        System.out.print("Enter New Pin: ");  // Prompt user for a new PIN
                        int newPin = Integer.parseInt(System.console().readLine());  // Read the new PIN
                        atm.changePin(newPin);  // Call the changePin method to update the PIN
                        break;

                    case 5:  // Exit the program
                        System.out.println("Thank You for Using ATM!");  // Display exit message
                        break;

                    default:  // If the user enters an invalid option, do nothing
                        break;
                }
            }
        } else {  // If the entered PIN is incorrect
            System.out.println("You have entered Invalid Pin!");  // Display an error message
        }
    }
}
