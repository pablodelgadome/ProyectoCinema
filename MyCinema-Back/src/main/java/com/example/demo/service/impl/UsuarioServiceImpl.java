package com.example.demo.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Usuario;
import com.example.demo.models.UsuarioModel;
import com.example.demo.repository.UsuarioRepository;

@Service("usuarioService")
public class UsuarioServiceImpl implements UserDetailsService {

	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UsuarioModel transform(Usuario user) {
		ModelMapper modelmapper = new ModelMapper();
		return modelmapper.map(user, UsuarioModel.class);
	}

	public Usuario transform(UsuarioModel user) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(user, Usuario.class);
	}
	
	public com.example.demo.entity.Usuario registrar(com.example.demo.entity.Usuario user){
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_CLIENTE");
		return userRepository.save(user);
	}

	public UsuarioModel findByMail(String id) {
		return transform(userRepository.findByEmail(id));
	}

	public UsuarioModel findByDni(String dni) {
		return transform(userRepository.findByDni(dni));
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.example.demo.entity.Usuario usuario=userRepository.findByEmail(username);
		
		UserBuilder builder=null;
		
		if(usuario!=null)
		{
			builder=User.withUsername(username);
			builder.disabled(false);
			builder.password(usuario.getPassword());
			builder.authorities(new SimpleGrantedAuthority(usuario.getRole()));
		}
		else
			throw new UsernameNotFoundException("Usuario no encontrado");
		return builder.build();
	}
	
	/*public UserDetails findUserId(long id) throws UsernameNotFoundException {
		com.example.demo.entity.Usuario usuario=userRepository.findById(id);
		String username=usuario.getEmail();
		UserBuilder builder=null;
		
		builder=User.withUsername(username);
		builder.disabled(false);
		builder.password(usuario.getPassword());
		builder.authorities(new SimpleGrantedAuthority(usuario.getRole()));
		return builder.build();
	}*/

}
