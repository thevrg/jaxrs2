package hu.dpc.edu;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import hu.dpc.edu.serde.LocalDateDeserializer;
import hu.dpc.edu.serde.LocalDateSerializer;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

/**
 * Created by vrg on 2017. 03. 27..
 */
@XmlRootElement
public class ConferenceVisitor {
    private Long id;
    private String firstName;
    private String lastName;
    private String company;
    private LocalDate registeredOn;
    private boolean speaker;

    public ConferenceVisitor() {
    }

    public ConferenceVisitor(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ConferenceVisitor(Long id, String firstName, String lastName, String company, LocalDate registeredOn, boolean speaker) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.registeredOn = registeredOn;
        this.speaker = speaker;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @JsonSerialize(using = LocalDateSerializer.class)
    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    @JsonDeserialize(using=LocalDateDeserializer.class)
    public void setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
    }

    public boolean isSpeaker() {
        return speaker;
    }

    public void setSpeaker(boolean speaker) {
        this.speaker = speaker;
    }
}
