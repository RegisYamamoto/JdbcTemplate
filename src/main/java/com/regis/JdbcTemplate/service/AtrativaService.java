package com.regis.JdbcTemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AtrativaService {
	
	@Autowired
	@Qualifier("atrativaJdbcTemplate")
	private JdbcTemplate atrativaJdbcTemplate;

	@Scheduled(cron = "*/5 * * * * *")
	public void listarEstado() {
		int estado = 10;
		String sigla = null;

		SqlRowSet row = this.atrativaJdbcTemplate.queryForRowSet(String.format("SELECT sg_estado FROM loc_estado WHERE cd_estado = %s", estado));
		
		while (row.next()) {
			sigla = row.getString("SG_ESTADO");
		}

		System.out.println("# sigla: " + sigla); // Teste
	}
	
}
