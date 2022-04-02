package sugimomoto.springiocaop.model;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Coffee {

    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
}
