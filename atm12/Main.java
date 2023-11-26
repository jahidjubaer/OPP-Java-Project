
package atm12;

import java.text.DecimalFormat;
import java.util.Scanner;

class Account {
        Scanner input = new Scanner(System.in);
        DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

        public int setCustomerNumber(int customerNumber) {
                this.customerNumber = customerNumber;
                return customerNumber;
        }

        public int getCustomerNumber() {
                return customerNumber;
        }

        public int setPinNumber(int pinNumber) {
                this.pinNumber = pinNumber;
                return pinNumber;
        }

        public int getPinNumber() {
                return pinNumber;
        }

        public double getCheckingBalance() {
                return checkingBalance;
        }

        public double getSavingBalance() {
                return savingBalance;
        }

        public double calcCheckingWithdraw(double amount) {
                checkingBalance = (checkingBalance - amount);
                return checkingBalance;
        }

        public double calcSavingWithdraw(double amount) {
                savingBalance = (savingBalance - amount);
                return savingBalance;
        }

        public double calcCheckingDeposit(double amount) {
                checkingBalance = (checkingBalance + amount);
                return checkingBalance;
        }

        public double calcSavingDeposit(double amount) {
                savingBalance = (savingBalance + amount);
                return savingBalance;
        }

        public void getCheckingWithdrawInput() {

                System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
                System.out.print("Amount you want to withdraw from Checking Account: ");
                double amount = input.nextDouble();

                if ((checkingBalance - amount) >= 0) {
                        calcCheckingWithdraw(amount);
                        System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
                } else {
                        System.out.println("Balance Cannot be Negative." + "\n");
                }
        }

        public void getsavingWithdrawInput() {

                System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
                System.out.print("Amount you want to withdraw from saving Account: ");
                double amount = input.nextDouble();

                if ((savingBalance - amount) >= 0) {
                        calcSavingWithdraw(amount);
                        System.out.println("New saving Account Balance: " + moneyFormat.format(savingBalance));
                } else {
                        System.out.println("Balance Cannot be Negative." + "\n");
                }
        }

        public void getCheckingDepositInput() {

                System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
                System.out.print("Amount you want to Deposit from Checking Account: ");
                double amount = input.nextDouble();

                if ((checkingBalance + amount) >= 0) {
                        calcCheckingDeposit(amount);
                        System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
                } else {
                        System.out.println("Balance Cannot be Negative." + "\n");
                }
        }

        public void getSavingDepositInput() {

                System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
                System.out.print("Amount you want to Deposit from saving Account: ");
                double amount = input.nextDouble();

                if ((savingBalance + amount) >= 0) {
                        calcSavingDeposit(amount);
                        System.out.println("New saving Account Balance: " + moneyFormat.format(savingBalance));
                } else {
                        System.out.println("Balance Cannot be Negative." + "\n");
                }
        }
        private int customerNumber;
        private int pinNumber;
        private double checkingBalance = 0;
        private double savingBalance = 0;
}


package atm12;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

class OptionMenu extends Account {
        Scanner menuInput = new Scanner(System.in);
        DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
        HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

        public void getLogin() throws IOException {
                int x = 1;
                do {
                     try {
                                data.put(222115116, 116);
                                data.put(222115105, 105);
                                data.put(222115109, 108);
                                
                                
                                System.out.println("Welcome to the ATM Project!");
                                System.out.println("Enter your customer Number");
                                setCustomerNumber(menuInput.nextInt());
                                System.out.print("Enter your PIN Number: ");
                                
                                setPinNumber(menuInput.nextInt());
                        } catch (Exception e) {
                                System.out.println("\n" + "Invalid Character(s). Only Numbers." + "\n");
                                x = 2;
                        }
                        int cn = getCustomerNumber();
                        int pn = getPinNumber();

                        if (data.containsKey(cn) && data.get(cn) == pn) {
                               getAccountType();
                        } else
                                System.out.println("\n" + "Wrong Customer Number or Pin Number" + "\n");
                } while (x == 1);
       }

        public void getAccountType() {
                System.out.println("Select the Account you Want to Access: ");
                System.out.println(" Type 1 - Checking Account");
                System.out.println(" Type 2 - Saving Account");
               System.out.println(" Type 3 - Exit");

                int selection = menuInput.nextInt();

               switch (selection) {
                case 1:
                        getChecking();
                        break;
                case 2:
                        getSaving();
                        break;
                case 3:
                        System.out.println("Thank You for using this ATM, bye.  \n");
                        break;
                default:
                        System.out.println("\n" + "Invalid Choice." + "\n");
                        getAccountType();
                }
        }

        public void getChecking() {
                System.out.println("Checking Account: ");
                System.out.println(" Type 1 - View Balance");
                System.out.println(" Type 2 - Withdraw Funds");
                System.out.println(" Type 3 - Deposit Funds");
                System.out.println(" Type 4 - Exit");
                System.out.print("Choice: ");

                int selection = menuInput.nextInt();

                switch (selection) {
                case 1:
                        System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                        getAccountType();
                        break;
                case 2:
                        getCheckingWithdrawInput();
                        getAccountType();
                        break;
                case 3:
                        getCheckingDepositInput();
                        getAccountType();
                        break;
                case 4:
                        System.out.println("Thank You for using this ATM, bye.");
                        break;
                default:
                        System.out.println("\n" + "Invalid Choice." + "\n");
                        getChecking();
                }
        }

        public void getSaving() {
                System.out.println("Saving Account: ");
                System.out.println(" Type 1 - View Balance");
                System.out.println(" Type 2 - Withdraw Funds");
                System.out.println(" Type 3 - Deposit Funds");
                System.out.println(" Type 4 - Exit");
                System.out.print("Choice: ");

                int selection = menuInput.nextInt();

                switch (selection) {
                case 1:
                        System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                        getAccountType();
                        break;
                case 2:
                        getsavingWithdrawInput();
                        getAccountType();
                        break;
                case 3:
                        getSavingDepositInput();
                        getAccountType();
                        break;
                case 4:
                        System.out.println("Thank You for using this ATM, bye.");
                        break;
                default:
                        System.out.println("\n" + "Invalid Choice." + "\n");
                        getChecking();
                }
        }
}



package atm12;


import java.text.DecimalFormat;
import java.util.*;
import java.io.IOException;

public class ATM extends OptionMenu {
        public static void main(String[] args) throws IOException {
                OptionMenu optionMenu = new OptionMenu();
                optionMenu.getLogin();
        }
}



