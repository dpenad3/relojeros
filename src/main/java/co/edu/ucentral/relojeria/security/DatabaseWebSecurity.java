package co.edu.ucentral.relojeria.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	
	
	protected void configure(AuthenticationManagerBuilder auth) {
		try {
			auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select username, contrasena, estatus from Usuarios where username=?")
			.authoritiesByUsernameQuery("select u.username, p.perfil from UsuarioPerfil up "
					+ "inner join Usuarios u on u.id = up.idUsuario "
					+ "inner join Perfiles p on p.id = up.idPerfil "+ "where u.username = ?");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() // Los recursos estaticos no requieren autenticacion 
		.antMatchers( "/bootstrap/**",                        
				      "/css/**",
				      "/images/**").permitAll()
		// Las vistas publicas no requieren autenticacion 
		.antMatchers("/", 
					 "/catalogo",
					 "/login",
				     "/signup", 
				     "/search").permitAll()
		.antMatchers("/admin/***").hasAnyAuthority("ADMINISTRADOR")
		.antMatchers("/relojes/***").hasAnyAuthority("ADMINISTRADOR", "USUARIO")
		.antMatchers("/usuario/***").hasAnyAuthority("ADMINISTRADOR", "USUARIO")
		// Todas las demas URLs de la Aplicacion requieren autenticacion 
		.anyRequest().authenticated()
		// El formulario de Login no requiere autenticacion 
		.and().formLogin().permitAll();
		} 
	
	/*@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/
	
}
