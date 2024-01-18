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

   private String co_rif_usua_cont;

   private String di_rif;

   private String nu_ci_contraparte;

   private BigDecimal nu_doc_id;

   private String in_tipo_doc_id;

   private String nb_cont_nat_1;

   private String nb_cont_nat_2;

   private String nb_ap_cont_nat_1;

   private String nb_ap_cont_nat_2;

   private String nb_cont_juridica;

   private String nb_inst_educativo;

   private String nb_usua_reg;

   private String co_activ_econ;

   private String co_ti_contraparte;

   private String co_rnc;

   private LocalDate fe_nacimiento;

   private LocalDate fe_inscrip_rif;

   private LocalDate fe_vigencia_rif;

   private OffsetDateTime fh_dec_jurada;

   private LocalDate fh_ult_act_rnc;

   private LocalDate co_oficio;

   private LocalDate co_expediente;

   private LocalDate co_institucion;

   private LocalDate co_grp_economico;

   private LocalDate co_nacion_cont;

   private BigDecimal nu_ci_conyuge;

   private String nb_conyuge;

   private String co_nacion_conyuge;

   private String co_act_econ_conyuge;

   private String nb_empresa_conyuge;

   private String in_relacion_bcv;

   private String in_dec_jurada;

   private String in_dinero_efectivo;

   private String in_inscrip_rnc;

   private String in_lista;

   private String in_ruso;

   private String in_edo_civil;

   private String in_rum;

   private String in_mineria;

   private String in_descendiente;

   private String in_nivel_educacion;

   private String in_otros_estudios;

   private String in_experiencia_lab;

   private String in_reg_profesional;

   private String in_contrato_otros;

   private String in_pep;

   private String in_autoriza_bcv;

   private String in_activo;

   private String in_ente_control;

   private String in_sujeto_obligado;

   private String tx_otro_nivel_edu;

   private String tx_denom_din_efec;

   private String tx_grado_logrado;

   private String tx_titulo_obtenido;

   private String tx_pass_usua_cont;

   private String tx_no_rum;


}
