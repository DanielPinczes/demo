package hu.daniel.pinczes.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "resource")
@Table(name = "resource")
@Getter
@Setter
public class Resource {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "author")
    private String author;

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ResourceType type;

    @Column(name = "uri")
    private String uri;

    @Column(name = "date")
    private LocalDate date;

}
