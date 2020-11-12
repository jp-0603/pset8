import java.util.HashMap;

public class BankAccount {

    private static long count = 0;
    private AccountOwner accountOwner;
    private double bal;
    private long accountNum;
    private static HashMap<Long, BankAccount> hashMap = new HashMap<Long, BankAccount>();


    public BankAccount(AccountOwner accountOwner, double bal) {
        this.accountOwner = accountOwner;
        this.bal = bal;
        this.accountNum = generateAccountNumber();
        hashMap.put(accountNum, this);
    }


    public int deposit(double amount) {
        if (amount <= 0) {
            return 2;
        } else {
            bal += amount;
            return 1;
        }
    }

    public long getAccountNum() {
        return accountNum;
    }

    public AccountOwner getAccountOwner() {
        return accountOwner;
    }

    public String getFormattedBalance() {
        return "$" + String.format("%,.2f", bal);
    }

    public int withdraw(double amount) {
        if (amount <= 0) {
            return 2;
        } else if (amount > bal) {
            return 3;
        } else {
            bal -= amount;
            return 1;
        }
    }

    public int transfer(long account, double amount) {
        BankAccount target = hashMap.get(account);
        if (amount <= 0) {
            return 2;
        } else if (amount > bal) {
            return 3;
        } else if (target == null) {
            return 4;
        } else {
            bal -= amount;
            target.deposit(amount);
            return 1;
        }

    }

    public String getMaskedAccountNumber() {
        String maskedNum = Long.toString(accountNum);
        maskedNum = maskedNum.substring(Math.max(0,maskedNum.length()-4));
        return "****" + String.format("%04d", Integer.parseInt(maskedNum));
    }

    private long generateAccountNumber() {
        return count++;
    }
}
