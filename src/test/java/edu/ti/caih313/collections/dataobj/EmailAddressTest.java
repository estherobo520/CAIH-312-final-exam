package edu.ti.caih313.collections.dataobj;

import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

public class EmailAddressTest {

    EmailAddress testEmail;

    //These are worth 2 points each
    //TODO test that null email address is not valid
    @Test
    public void testValidateEmailAddressNull() {

        String emailAddress1 = null;
        assertFalse(EmailAddress.validate(emailAddress1));
    }

    //TODO test that a normal email address is valid
    @Test
    public void testValidateEmailAddressRegular() {
        testEmail = new EmailAddress("testEmail@gmail.com", EmailAddress.Type.HOME);
        String emailAddress1 = testEmail.getEmailAddress(EmailAddress.Type.HOME);
        assertTrue(EmailAddress.validate(emailAddress1));
    }

    //TODO test that missing '@' in address is not valid
    @Test
    public void testValidateEmailAddressNoAt() {
        boolean thrown = false;
        try {
            testEmail = new EmailAddress("testEmailgmail.com", EmailAddress.Type.HOME);
            String emailAddress1 = testEmail.getEmailAddress(EmailAddress.Type.HOME);
        }
        catch (InvalidParameterException e){
            thrown = true;
        }
        assertTrue(thrown);
    }

    //TODO test that wrong ending of email address is not valid
    @Test
    public void testValidateEmailAddressWrongEnd() {
        boolean thrown = false;
        try {
            testEmail = new EmailAddress("testEmail@gmail", EmailAddress.Type.HOME);
            String emailAddress1 = testEmail.getEmailAddress(EmailAddress.Type.HOME);
        }
        catch (InvalidParameterException e){
            thrown = true;
        }
        assertTrue(thrown);
    }
}