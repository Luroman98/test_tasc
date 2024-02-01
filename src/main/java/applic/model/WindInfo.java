package applic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class WindInfo {
    private double speed;
    private int deg;
}
