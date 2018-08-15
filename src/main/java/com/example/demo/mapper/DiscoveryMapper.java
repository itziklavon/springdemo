package com.example.demo.mapper;

import com.example.demo.domain.Services;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscoveryMapper {

    @Select("SELECT uri AS url, service_name AS serviceName FROM service_url LIMIT 1")
    Services getService();

}
