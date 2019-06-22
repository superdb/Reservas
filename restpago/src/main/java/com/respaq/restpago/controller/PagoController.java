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

@RestController
@RequestMapping("/api")

public class PagoController {
    @Autowired
    private Negocio negocio;
    Logger logger = LoggerFactory.getLogger(PagoController.class);

    @GetMapping("/pagos")
    public List<Pago> obtenerProductos(){
        return negocio.leerPagos();
    }

    @PostMapping("/pago")
    public Pago crearProducto(@RequestBody Pago pago){
        Pago p;
        logger.debug("Creando pago");
        p = negocio.crearPago(pago);
        return p;
    }
    @PutMapping("/pago")
    public Pago actualizarProducto(@RequestBody Pago pago){
        Pago p;
        try {
            logger.debug("Actualizando pago");
            p = negocio.actualizarPago(pago);
        }catch(Exception e)
        {
            logger.error("Error de actualizacion", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible, disculpe");
        }
        return  p;
    }
    @DeleteMapping("/pago/{idPago}")
    public Pago borrarPago(@PathVariable Long idPago){
        Pago p;
        try {
            logger.debug("borrando pago");
            p = negocio.borrarPago(idPago);
        }catch(Exception e)
        {
            logger.error("Error de eliminación", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible, disculpe");
        }
        return  p;
    }

}
