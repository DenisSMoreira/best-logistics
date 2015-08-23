package br.com.walmart.logistics.core.repository;

import org.springframework.data.mongodb.repository.Query;

import br.com.walmart.logistics.core.entity.LogisticMap;
import br.com.walmart.logistics.core.generic.GenericMongoDBRepository;

/**
 *  LogisticsRepository estende a interface MongoRepository passando o tipo da classe e o id, funciona basicamente:
 *  Essa interface vem com muitas operações, incluindo operações CRUD padrão (create-read-update-delete)
 *  Você pode definir outras consultas quando necessário, simplesmente declarando sua assinatura do método. 
 *  Neste caso, adicionei o findByName, que visa essencialmente documentos do tipo LogisticMap corresponde ao Nome do Mapa passado por parametro.
 *
 *  @author Denis soares moreira
 */
public interface LogisticsRepository extends GenericMongoDBRepository<LogisticMap, String> {

	/**
	 * Procura o LogisticMap de acordo com o nome ou apelido cadastrado
	 * @param name {@link String} 
	 * @return LogisticMap.class
	 */
	LogisticMap findByName(String name);
	
	/**
	 * Procura o LogisticMap de acordo com o nome ou apelido cadastrado
	 * @param name {@link String} 
	 * @return LogisticMap.class
	 */
    @Query(value = "{'listRoutesMaps.pointOrigin' : ?0 }", fields = "{ 'listRoutesMaps.pointOrigin' : 0 }")
	LogisticMap findByListRoutesMapsPointOrigin(String pointOrigin);
}
