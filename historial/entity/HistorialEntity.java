package com.bcv.cusg.historial.entity;

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
@Table(schema = cusg, name = historial)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Historial extends Base {

   private static final long serialVersionUID = 1L;

   @Id

@Column(nullable = false, length = 14)
private String coRifUsuaCont;

@Column(nullable = false, length = 11)
private Integer coEstadoFlujo;

@Column(length = 4)
private String coAplicacion;

@Column(length = 30)
private String coUsuario;

@Columnprivate Timestamp fhHistorial;

@Column(length = 500)
private String txObservacion;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = co_rif_usua_cont, nullable = false)
private Contraparte coRifUsuaCont;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = co_estado_flujo, nullable = false)
private EstadoFlujo coEstadoFlujo;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = co_usuario, nullable = false)
private UsuarioAplicacion coUsuario;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = co_aplicacion, nullable = false)
private UsuarioAplicacion coAplicacion;

}
