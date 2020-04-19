package com.regis.JdbcTemplate.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class AtrativaDatabaseConfig {
	
	@Qualifier("atrativaDataSource")
	@Bean(name = "atrativaDataSource")
	public DataSource dataSource() {
		HikariDataSource ds = new HikariDataSource();
		
		try {
			ds.setJdbcUrl("jdbc:oracle:thin:@ (DESCRIPTION = (LOAD_BALANCE = YES)(FAILOVER = ON)(ADDRESS = (PROTOCOL = TCP)(HOST = muf-scan-01.muffato.com.br)(PORT = 1521))(CONNECT_DATA =(SERVER = DEDICATED)(SERVICE_NAME = sgm)(FAILOVER_MODE =(TYPE = SELECT)(METHOD = BASIC)(RETRIES = 180)(DELAY = 5))))");
			ds.setUsername("atrativa");
			ds.setPassword("atrativa");
			ds.setDriverClassName("oracle.jdbc.OracleDriver");
			ds.setConnectionTestQuery("SELECT 1 FROM DUAL");

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		
		return ds;
	}
	
	@Bean(name = "atrativaNamedTemplate")
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("atrativaDataSource") DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Bean(name = "atrativaJdbcTemplate")
	public JdbcTemplate jdbcTemplate(@Qualifier("atrativaDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
