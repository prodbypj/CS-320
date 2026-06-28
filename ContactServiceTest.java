/*
 * Name: Peyton Johnston
 * Course: CS 320
 * Assignment: Module Three Milestone - Contact Service
 * File: ContactServiceTest.java
 * Description: Tests the ContactService class for adding, deleting, finding, and updating contacts.
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void addsContactWithUniqueId() {
        ContactService service = new ContactService();
        Contact contact = new Contact("PJ2001", "Peyton", "Johnston", "5735559090", "22 Lake Road");

        service.addContact(contact);

        assertEquals("Peyton", service.findContact("PJ2001").getFirstName());
        assertEquals("Johnston", service.findContact("PJ2001").getLastName());
    }

    @Test
    public void rejectsNullContactWhenAdding() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(null);
        });
    }

    @Test
    public void rejectsDuplicateContactId() {
        ContactService service = new ContactService();

        Contact firstContact = new Contact("PJ2002", "Peyton", "Johnston", "5735559090", "22 Lake Road");
        Contact secondContact = new Contact("PJ2002", "Sam", "Miller", "4175552222", "44 Hill St");

        service.addContact(firstContact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(secondContact);
        });
    }

    @Test
    public void deletesContactById() {
        ContactService service = new ContactService();
        Contact contact = new Contact("PJ2003", "Peyton", "Johnston", "5735559090", "22 Lake Road");

        service.addContact(contact);
        service.deleteContact("PJ2003");

        assertThrows(IllegalArgumentException.class, () -> {
            service.findContact("PJ2003");
        });
    }

    @Test
    public void rejectsDeleteForMissingContactId() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("BADID");
        });
    }

    @Test
    public void updatesContactFirstAndLastName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("PJ2004", "Peyton", "Johnston", "5735559090", "22 Lake Road");

        service.addContact(contact);
        service.updateFirstName("PJ2004", "PJ");
        service.updateLastName("PJ2004", "Beats");

        assertEquals("PJ", service.findContact("PJ2004").getFirstName());
        assertEquals("Beats", service.findContact("PJ2004").getLastName());
    }

    @Test
    public void updatesContactPhoneAndAddress() {
        ContactService service = new ContactService();
        Contact contact = new Contact("PJ2005", "Peyton", "Johnston", "5735559090", "22 Lake Road");

        service.addContact(contact);
        service.updatePhone("PJ2005", "4175553333");
        service.updateAddress("PJ2005", "10 Studio Lane");

        assertEquals("4175553333", service.findContact("PJ2005").getPhone());
        assertEquals("10 Studio Lane", service.findContact("PJ2005").getAddress());
    }

    @Test
    public void rejectsUpdateForMissingContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("BADID", "Peyton");
        });
    }

    @Test
    public void rejectsInvalidFirstNameUpdate() {
        ContactService service = new ContactService();
        Contact contact = new Contact("PJ2006", "Peyton", "Johnston", "5735559090", "22 Lake Road");

        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("PJ2006", null);
        });
    }

    @Test
    public void rejectsInvalidLastNameUpdate() {
        ContactService service = new ContactService();
        Contact contact = new Contact("PJ2007", "Peyton", "Johnston", "5735559090", "22 Lake Road");

        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateLastName("PJ2007", "JohnstonLong");
        });
    }

    @Test
    public void rejectsInvalidPhoneUpdate() {
        ContactService service = new ContactService();
        Contact contact = new Contact("PJ2008", "Peyton", "Johnston", "5735559090", "22 Lake Road");

        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhone("PJ2008", "12345");
        });
    }

    @Test
    public void rejectsInvalidAddressUpdate() {
        ContactService service = new ContactService();
        Contact contact = new Contact("PJ2009", "Peyton", "Johnston", "5735559090", "22 Lake Road");

        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateAddress("PJ2009", "This address is longer than thirty characters");
        });
    }
}