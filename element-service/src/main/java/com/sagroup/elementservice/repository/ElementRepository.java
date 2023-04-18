package com.sagroup.elementservice.repository;

import com.sagroup.elementservice.Domain.Element;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * @author ABDELBIF
 * @version 1.0
 * @created 6-Feb-2023 08:00:00 PM
 */

@Repository
public interface ElementRepository extends MongoRepository<Element, String> {
}
