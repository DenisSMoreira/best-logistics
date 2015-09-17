/**
 * 
 */
package br.com.best.logistics.core.generic;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * Entity gerenic para contrato com as entidades
 * @author Denis soares moreira
 *
 */
public interface GenericMongoDBRepository<T extends Entity, ID extends Serializable> extends MongoRepository<T, ID> {

}
