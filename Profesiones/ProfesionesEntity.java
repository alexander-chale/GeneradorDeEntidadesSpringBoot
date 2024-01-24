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

@Column(nullable = false, length = 255)
private String coRifUsuaCont;

@Column(nullable = false, length = 14)
private String coRifRepLegal;

@Column(length = 4)
private String codigoProfesion;

@Column(length = 20)
private Long coNacionalidad;

@Column(length = 14)
private String nuCiRepLegal;

@Column(nullable = false, length = 50)
private String nbRepLegal;

@Column(length = 50)
private String nbCargoRepLegal;

@Column(length = 12)
private String nuPasapRepLegal;

@Column(nullable = false, length = 255)
private String inEdoCivilRep;

@Column(length = 50)
private String diRepLegal;

@Column(nullable = false, length = 15)
private String nuTlfLocalRep;

@Column(nullable = false, length = 15)
private String nuTlfCelRep;

@Column(nullable = false, length = 30)
private String txEmailRep;

@Column(length = 14)
private String nuCiConyuge;

@Column(length = 50)
private String nbConyugeRep;

@Column(nullable = false, length = 100)
private String txAutorizadoRep;

@Column(length = 50)
private String txDatoDocRep;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = co_rif_usua_cont, nullable = false)
private Contraparte coRifUsuaCont;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = co_nacionalidad, nullable = false)
private Nacionalidad coNacionalidad;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = codigo_profesion, nullable = false)
private Profesiones codigoProfesion;

}
