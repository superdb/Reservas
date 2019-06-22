package com.respaq.restpago.negocio;

import com.respaq.restpago.entidades.Pago;
import com.respaq.restpago.repositorio.PagoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Negocio {

    @Autowired
    private PagoRepositorio pagoRepositorio;
    public Pago crearPago(Pago pago){return pagoRepositorio.save(pago);}
    public List<Pago> leerPagos(){
        return(List<Pago>) pagoRepositorio.findAll();
    }
    public Pago obtenerPago(Long idPago) throws Exception{
        return pagoRepositorio.findById(idPago).
                orElseThrow(() -> new Exception("No se puede recuperar"));
    }

    public Pago actualizarPago(Pago pago) throws Exception{

        Pago p = pagoRepositorio.findById(pago.getIdPago()).
                orElseThrow(() -> new Exception("No existe"));
        p.setPago(pago.getPago());
        p.setIdTemp(pago.getIdTemp());
        p.setNumTarjeta(pago.getNumTarjeta());
        p.setMesAno(pago.getMesAno());
        p.setCvv(pago.getCvv());
        p.setMail(pago.getMail());

        return  pagoRepositorio.save(p);
    }
    public Pago borrarPago(Long idPago) throws  Exception{
        Pago p = pagoRepositorio.findById(idPago).
                orElseThrow(() -> new Exception("No se puede recuperar"));
        pagoRepositorio.delete(p);
        return p;
    }
}
