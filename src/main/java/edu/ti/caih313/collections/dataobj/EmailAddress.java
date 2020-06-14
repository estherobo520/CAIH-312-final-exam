package edu.ti.caih313.collections.dataobj;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class EmailAddress {
    public enum Type {HOME, WORK, SCHOOL};
    Map<Type, String> emailMap = new HashMap<>();

    public EmailAddress(String emailAddress, Type type) {
        if (!validate(emailAddress)) {
            throw new InvalidParameterException("Email address not valid: '" + emailAddress + "'");
        }
        emailMap.put(type, emailAddress);
    }

    public String getEmailAddress() {
        return getPrimaryEmailAddress();
    }

    private String getPrimaryEmailAddress() {
        String primaryEmailAddress = null;
        if (emailMap.containsKey(Type.HOME)) {
            primaryEmailAddress = emailMap.get(Type.HOME);
        } else if (emailMap.containsKey(Type.WORK)) {
            primaryEmailAddress = emailMap.get(Type.WORK);
        } else if (emailMap.containsKey(Type.SCHOOL)) {
            primaryEmailAddress = emailMap.get(Type.SCHOOL);
        }
        return primaryEmailAddress;
    }

    public String getEmailAddress(Type type) {
        return emailMap.get(type);
    }

    static boolean validate(String emailAddress) {

        if(emailAddress != null && emailAddress.contains("@") && (emailAddress.endsWith(".edu") || emailAddress.endsWith(".com")))
        {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {

        StringBuilder emailStringBuilder = new StringBuilder("<");
        if((getEmailAddress(Type.HOME) == null) && (getEmailAddress(Type.WORK) == null) && (getEmailAddress(Type.SCHOOL) == null)) {
            emailStringBuilder.append("no full name available");
        }
        if ((getEmailAddress(Type.WORK) != null)) {
            emailStringBuilder.append("WORK: " + (getEmailAddress(Type.WORK)));
        }
        if ((getEmailAddress(Type.SCHOOL) != null)) {
            emailStringBuilder.append("SCHOOL: " + (getEmailAddress(Type.SCHOOL)));
        }
        emailStringBuilder.append(">");

        return emailStringBuilder.toString();
    }

}
