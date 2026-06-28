/*
 * Name: Peyton Johnston
 * Course: CS 320
 * Assignment: Module Three Milestone - Contact Service
 * File: ContactService.java
 * Description: Stores contacts in memory and supports adding, deleting, finding, and updating contacts.
 */

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // HashMap stores contacts using the contact ID as the key.
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }

        String contactId = contact.getContactId();

        // Each contact must have a unique ID.
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID already exists");
        }

        contacts.put(contactId, contact);
    }

    public void deleteContact(String contactId) {
        // Contact must exist before it can be deleted.
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        contacts.remove(contactId);
    }

    public void updateFirstName(String contactId, String firstName) {
        findContact(contactId).setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        findContact(contactId).setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        findContact(contactId).setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        findContact(contactId).setAddress(address);
    }

    public Contact findContact(String contactId) {
        // Used by update and test methods to retrieve a contact by ID.
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        return contacts.get(contactId);
    }
}