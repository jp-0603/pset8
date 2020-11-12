public class AccountOwner {
    String salutation;
    String firstName;
    String lastName;
    String email;
    long phoneNum;
    MailingAddress mailingAddress;

    public AccountOwner(String salutation, String firstName, String lastName, String email, long phoneNumber, MailingAddress mailingAddress) {

        this.salutation = salutation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNum = phoneNumber;
        this.mailingAddress = mailingAddress;

    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public MailingAddress mailingAddress() {
        return mailingAddress;
    }

    public String getName(int type) {

        if (type == 1) {
            return firstName + " " + lastName;
        } else if (type == 2) {
            if (salutation == null) {
                return firstName + " " + lastName;
            }
            return salutation + ". " + lastName;
        } else if (type == 3) {
            return lastName + ", " + firstName;
        } else {
            return null;
        }

    }

    public String getEmail() {
        return email;
    }

    public String getFormattedPhoneNumber() {
        String number = Long.toString(phoneNum);
        String p1 = number.substring(0,3);
        String p2 = number.substring(3,6);
        String p3 = number.substring(6,10);
        return "(" + p1 + ") " + p2 + "-" + p3;
    }

    public MailingAddress getMailingAddress() {
        return mailingAddress;
    }
}
