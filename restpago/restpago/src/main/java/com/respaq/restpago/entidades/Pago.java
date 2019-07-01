package com.respaq.restpago.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TB_PAGO")
public class Pago implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;
    private double pa_monto;
    private int idTemp;
    private String pa_tipoTarjeta;
    private String pa_numTarjeta;
    private String pa_fechaVencimiento;
    private String pa_csc;
    private String pa_nombre;
    private String pa_apellidos;
    private String pa_correo;
    private String pa_movil;
    private Date pa_registerDate;
    private Date pa_reisterUpdate;
    private int pa_userUpdate;

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public double getPa_monto() {
        return pa_monto;
    }

    public void setPa_monto(double pa_monto) {
        this.pa_monto = pa_monto;
    }

    public int getIdTemp() {
        return idTemp;
    }

    public void setIdTemp(int idTemp) {
        this.idTemp = idTemp;
    }

    public String getPa_tipoTarjeta() {
        return pa_tipoTarjeta;
    }

    public void setPa_tipoTarjeta(String pa_tipoTarjeta) {
        this.pa_tipoTarjeta = pa_tipoTarjeta;
    }

    public String getPa_numTarjeta() {
        return pa_numTarjeta;
    }

    public void setPa_numTarjeta(String pa_numTarjeta) {
        this.pa_numTarjeta = pa_numTarjeta;
    }

    public String getPa_fechaVencimiento() {
        return pa_fechaVencimiento;
    }

    public void setPa_fechaVencimiento(String pa_fechaVencimiento) {
        this.pa_fechaVencimiento = pa_fechaVencimiento;
    }

    public String getPa_csc() {
        return pa_csc;
    }

    public void setPa_csc(String pa_csc) {
        this.pa_csc = pa_csc;
    }

    public String getPa_nombre() {
        return pa_nombre;
    }

    public void setPa_nombre(String pa_nombre) {
        this.pa_nombre = pa_nombre;
    }

    public String getPa_apellidos() {
        return pa_apellidos;
    }

    public void setPa_apellidos(String pa_apellidos) {
        this.pa_apellidos = pa_apellidos;
    }

    public String getPa_correo() {
        return pa_correo;
    }

    public void setPa_correo(String pa_correo) {
        this.pa_correo = pa_correo;
    }

    public String getPa_movil() {
        return pa_movil;
    }

    public void setPa_movil(String pa_movil) {
        this.pa_movil = pa_movil;
    }

    public Date getPa_registerDate() {
        return pa_registerDate;
    }

    public void setPa_registerDate(Date pa_registerDate) {
        this.pa_registerDate = pa_registerDate;
    }

    public Date getPa_reisterUpdate() {
        return pa_reisterUpdate;
    }

    public void setPa_reisterUpdate(Date pa_reisterUpdate) {
        this.pa_reisterUpdate = pa_reisterUpdate;
    }

    public int getPa_userUpdate() {
        return pa_userUpdate;
    }

    public void setPa_userUpdate(int pa_userUpdate) {
        this.pa_userUpdate = pa_userUpdate;
    }
}
