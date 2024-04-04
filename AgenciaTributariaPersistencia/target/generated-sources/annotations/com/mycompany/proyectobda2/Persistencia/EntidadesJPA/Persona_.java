package com.mycompany.proyectobda2.Persistencia.EntidadesJPA;

import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-03-24T23:42:51", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> apellidoPaterno;
    public static volatile SingularAttribute<Persona, Calendar> fechaNacimiento;
    public static volatile SingularAttribute<Persona, Boolean> discapacidad;
    public static volatile SingularAttribute<Persona, Long> id;
    public static volatile SingularAttribute<Persona, String> telefono;
    public static volatile SingularAttribute<Persona, String> nombre;
    public static volatile SingularAttribute<Persona, String> RFC;
    public static volatile SingularAttribute<Persona, String> CURP;
    public static volatile SingularAttribute<Persona, String> apellidoMaterno;

}