package applic.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class MainInfo {
    private double temp;
    private double feelsLike;
}
