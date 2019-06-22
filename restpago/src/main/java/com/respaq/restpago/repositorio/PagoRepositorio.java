package com.respaq.restpago.repositorio;

import com.respaq.restpago.entidades.Pago;
import org.springframework.data.repository.CrudRepository;

public interface PagoRepositorio extends CrudRepository<Pago,Long> {
}
