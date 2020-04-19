package com.regis.JdbcTemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ClubefatoService {
	
	@Autowired
	@Qualifier("clubefatoJdbcTemplate")
	private JdbcTemplate clubefatoJdbcTemplate;

	@Scheduled(cron = "*/5 * * * * *")
	public void listarCliente() {
		String cpf = "01283704919";
		String token = null;

		SqlRowSet row = this.clubefatoJdbcTemplate.queryForRowSet(String.format("SELECT token FROM cpf_firebase WHERE cpf = '%s'", cpf));

		while (row.next()) {
			token = row.getString("token");
		}

		System.out.println("token: " + token); // Teste
	}
	
}
