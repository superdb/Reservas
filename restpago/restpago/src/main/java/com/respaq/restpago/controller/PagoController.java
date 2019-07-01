package com.respaq.restpago.controller;

import com.respaq.restpago.entidades.Pago;
import com.respaq.restpago.negocio.Negocio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@CrossOrigin(origins = "http://localhost:56363")
@RestController
@RequestMapping(value="/PagoRest")

public class PagoController {
    @Autowired
    private Negocio negocio;
    Logger logger = LoggerFactory.getLogger(PagoController.class);

    @RequestMapping(value="/pagos" , method = RequestMethod.GET , produces = "application/json")
    public List<Pago> obtenerProductos(){
        return negocio.ListarPagos();
    }

    @RequestMapping(value="/pago/add" , method = RequestMethod.POST , produces = "application/json")

    public Pago crearProducto(@RequestBody Pago pago){
        Pago p;
        try{
        logger.debug("Creando pago");
        p = negocio.RegistrarPago(pago);
    }catch(Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No es posible crear el perfil");
    }
        return p;
    }

    @RequestMapping(value="/pago" , method = RequestMethod.PUT , produces = "application/json")
    public Pago actualizarProducto(@RequestBody Pago pago){
        Pago p;
        try {
            logger.debug("Actualizando pago");
            p = negocio.actualizarPago(pago);
        }catch(Exception e)
        {
            logger.error("Error de actualizacion", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible actualzar");
        }
        return  p;
    }

    @RequestMapping(value="/pago/{idPago}" , method = RequestMethod.DELETE, produces = "application/json")

    public Pago borrarPago(@PathVariable Long idPago){
        Pago p;
        try {
            logger.debug("borrando pago");
            p = negocio.borrarPago(idPago);
        }catch(Exception e)
        {
            logger.error("Error de eliminación", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible eliminar");
        }
        return  p;
    }

}
