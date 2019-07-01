package com.respaq.restpago.negocio;

import com.respaq.restpago.entidades.Pago;
import com.respaq.restpago.repositorio.PagoRepositorio;
import com.respaq.restpago.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Negocio {

    @Autowired
    private PagoRepositorio pagoRepositorio;

    private Date fechaActual = new Date();

    public Pago RegistrarPago(Pago pago) throws Exception{
        pago.setPa_registerDate(Constantes.General.fechaActual());
        pago.setPa_reisterUpdate(Constantes.General.fechaActual());
        return pagoRepositorio.save(pago);
    }

    public List<Pago> ListarPagos(){
        return(List<Pago>) pagoRepositorio.findAll();
    }

    public Pago obtenerPago(Long idPago) throws Exception{
        return pagoRepositorio.findById(idPago).
                orElseThrow(() -> new Exception("No se puede recuperar"));
    }

    public Pago actualizarPago(Pago pago) throws Exception{

        Pago p = pagoRepositorio.findById(pago.getIdPago()).
                orElseThrow(() -> new Exception("No existe"));
        p.setPa_monto(pago.getPa_monto());
        p.setIdTemp(pago.getIdTemp());
        p.setPa_tipoTarjeta(pago.getPa_tipoTarjeta());
        p.setPa_numTarjeta(pago.getPa_numTarjeta());
        p.setPa_fechaVencimiento(pago.getPa_fechaVencimiento());
        p.setPa_csc(pago.getPa_csc());
        p.setPa_nombre(pago.getPa_nombre());
        p.setPa_apellidos(pago.getPa_apellidos());
        p.setPa_correo(pago.getPa_correo());
        p.setPa_movil(pago.getPa_movil());
        return  pagoRepositorio.save(p);
    }
    public Pago borrarPago(Long idPago) throws  Exception{
        Pago p = pagoRepositorio.findById(idPago).
                orElseThrow(() -> new Exception("No existe"));
        pagoRepositorio.delete(p);
        return p;
    }

}
