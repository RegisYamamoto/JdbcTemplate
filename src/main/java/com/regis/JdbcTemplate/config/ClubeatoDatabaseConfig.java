package com.regis.JdbcTemplate.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class ClubeatoDatabaseConfig {
	
	@Qualifier("clubefatoDataSource")
	@Bean(name = "clubefatoDataSource")
	public DataSource dataSource() {
		HikariDataSource ds = new HikariDataSource();
		
		try {
			ds.setJdbcUrl("jdbc:mysql://10.251.22.11:3306/clubefato?characterEncoding=UTF-8");
			ds.setUsername("clubefato");
			ds.setPassword("devmaster");
			ds.setDriverClassName("com.mysql.jdbc.Driver");
			ds.setConnectionTestQuery("SELECT 1");

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		
		return ds;
	}
	
	@Bean(name = "clubefatoNamedTemplate")
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("clubefatoDataSource") DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Bean(name = "clubefatoJdbcTemplate")
	public JdbcTemplate jdbcTemplate(@Qualifier("clubefatoDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
