package net.siekiera.mgc.model;

import net.siekiera.mgc.configuration.Const;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa przechowuje dane o ogłoszeniu sprzedaży samochodu
 */
@Entity
public class Samochod extends SamochodBase {

}
