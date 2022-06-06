package com.example.demo.controller;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Comentario;
import com.example.demo.entity.Entrada;
import com.example.demo.entity.Usuario;
import com.example.demo.models.ComentarioModel;
import com.example.demo.models.ComplementoModel;
import com.example.demo.models.EntradaModel;
import com.example.demo.models.PeliculaModel;
import com.example.demo.models.SalaModel;
import com.example.demo.service.ComentarioService;
import com.example.demo.service.ComplementoService;
import com.example.demo.service.EntradaService;
import com.example.demo.service.PeliculaService;
import com.example.demo.service.SalaService;
import com.example.demo.service.impl.UsuarioServiceImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins="http://localhost:8100",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api")
public class APIController {

		@Autowired
		private AuthenticationManager authenticationManager;
	
		private String Token;
		private String email;
		
		@Autowired
		private UsuarioServiceImpl userService;
		
		@Autowired
		private PeliculaService peliculaService;
		
		@Autowired
		private SalaService salaService;
		
		@Autowired
		private ComplementoService complementoService;
		
		@Autowired
		private ComentarioService comentarioService;
		
		@Autowired
		private EntradaService entradaService;
		
		
		@PostMapping("/login")
		public Usuario login(@RequestBody(required = false) Usuario user) {
			
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String token = getJWTToken(user.getEmail());
			Usuario u = new Usuario();
			u = userService.transform(userService.findByMail(user.getEmail()));
			u.setToken(token);

			this.Token=u.getToken();
			this.email=u.getEmail();
			
			return u;
		}
		
		@PostMapping("/register")
		public Usuario registrar(@RequestBody(required = false) Usuario user)
		{
			
			Usuario u = new Usuario();
			
			u.setDni(user.getDni());
			u.setNombre(user.getNombre());
			u.setEmail(user.getEmail());
			u.setPassword(user.getPassword());
			u.setRole("ROLE_CLIENTE");
			u.setToken(null);
			userService.registrar(u);
			return u;
			
		}
		
		private String getJWTToken(String username) {
			String secretKey = "mySecretKey";
			List<GrantedAuthority> grantedAuthorities = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_CLIENTE");
			
			String token = Jwts
					.builder()
					.setId("softtekJWT")
					.setSubject(username)
					.claim("authorities",
							grantedAuthorities.stream()
									.map(GrantedAuthority::getAuthority)
									.collect(Collectors.toList()))
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 600000))
					.signWith(SignatureAlgorithm.HS512,
							secretKey.getBytes()).compact();
	
			return "Bearer " + token;
		}
		
		@GetMapping("/listPeliculas")
		public ResponseEntity<List<PeliculaModel>> listarPeliculas(){
				return ResponseEntity.ok(peliculaService.listAllPeliculas());
		}
		
		@GetMapping("/filtroPeliculas/{categoria}")
		public List<PeliculaModel> filtroPeliculas(@PathVariable("categoria")String categoria){
				return peliculaService.findByCategoria(categoria);
		}
		
		
		@GetMapping("/listSalas")
		public List<SalaModel> listarSalas(){
				return salaService.listAllSalas();
				
		}
		
		@GetMapping("/listComplementos")
		public List<ComplementoModel> listarComplementos(){
				return complementoService.listAllComplementos();
				
		}
		
		@GetMapping("/listComentarios/{titulo}")
		public List<ComentarioModel> listarComentarios(@PathVariable("titulo")String titulo){
			System.out.println("Comentarios");
			List<PeliculaModel> ps = peliculaService.findByTitulo(titulo);
			PeliculaModel p = ps.get(0);
			System.out.println("Titulo "+p.getTitulo());
				return comentarioService.findByPelicula(peliculaService.transform(p));
		}
		
		@PostMapping("/createComentario")
		public Comentario crearComentario(@RequestBody Comentario comentario)
		{
			comentarioService.addComentario(comentario);
			return comentario;
		}
		
		@GetMapping("/listEntradas")
		public List<EntradaModel> listarEntradas(){
			return entradaService.listAll();
		}
		
		@PostMapping("/comprarEntrada")
		public Entrada comprarEntrada(@RequestBody Entrada entrada)
		{
			return entradaService.addEntrada(entradaService.transform(entrada));
		}
	
}
