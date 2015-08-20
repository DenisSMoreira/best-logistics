/**
 * 
 */
package br.com.walmart.logistics.core.generic;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * @author Denis soares moreira
 *
 */
public interface GenericMongoDBRepository<T extends Entity, ID extends Serializable>
		extends MongoRepository<T, ID> {

}
