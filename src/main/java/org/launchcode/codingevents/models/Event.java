package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;


@Entity
public class Event extends AbstractEntity {

    @Size(min=3,max=50, message = "Name must be between 3 and 50 characters.")
    @NotBlank(message = "Name required.")
    private String name;
    @Size(max=500, message = "Description too long.")
    private String description;
    @NotBlank(message = "Email required.")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;
    @NotBlank(message = "Location required.")
    private String location;
    @AssertTrue(message = "Registration must be required.")
    private boolean registrationRequired;
    @Positive(message = "Number of attendees must be over 0.")
    private int attendees;

    @ManyToOne
    @NotNull(message = "Category is required.")
    private EventCategory eventCategory;

    public Event(){}

    public Event(String name, String description, String contactEmail, String location, boolean registrationRequired, int attendees, EventCategory eventCategory) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.registrationRequired = registrationRequired;
        this.attendees = attendees;
        this.eventCategory = eventCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isRegistrationRequired() {
        return registrationRequired;
    }

    public void setRegistrationRequired(boolean registrationRequired) {
        this.registrationRequired = registrationRequired;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(int attendees) {
        this.attendees = attendees;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    @Override
    public String toString() {
        return name;
    }
}
