package com.jk.repository;




import com.jk.pojo.Infor;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface CurRepository extends ElasticsearchCrudRepository<Infor,Integer> {
}
