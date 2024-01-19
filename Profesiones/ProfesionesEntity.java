package com.bcv.cusg.profesiones.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(schema = "cusg", name = "accion_pregunta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Profesiones extends Base {

   private static final long serialVersionUID = 1L;

   @Id

   private String codigoProfesion;

   private String descripcion;

   private String ocptm;

   private String ocpti;

   private String ocpts;

   private String ocpu;


}
