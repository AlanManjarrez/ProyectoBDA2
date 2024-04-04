package com.mycompany.proyectobda2.Persistencia.EntidadesJPA;

import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Persona;
import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-03-24T23:42:51", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Tramite.class)
public class Tramite_ { 

    public static volatile SingularAttribute<Tramite, Calendar> vigencia;
    public static volatile SingularAttribute<Tramite, Float> costo;
    public static volatile SingularAttribute<Tramite, Calendar> fechaEmision;
    public static volatile SingularAttribute<Tramite, Long> id;
    public static volatile SingularAttribute<Tramite, Persona> personas;

}