package main.entity;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id")
    private Application application;

    @ManyToOne
    @JoinTable(name = "ticket_release",
            joinColumns = @JoinColumn(name = "ticket_fk"),
            inverseJoinColumns = @JoinColumn(name = "release_fk"))
    private Release release;


    private String status;

    public Ticket(){

    }

    public Ticket(String title, String description, Application application,Release release,String status)
    {
        this.title=title;
        this.description=description;
        this.application = application;
        this.release = release;
        this.status=status;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Application getApplication() {
        return application;
    }

    public Release getRelease() {
        return release;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }
}
