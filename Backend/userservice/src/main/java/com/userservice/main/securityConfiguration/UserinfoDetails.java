package com.userservice.main.securityConfiguration;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.userservice.main.entity.UserEntity;


@SuppressWarnings("serial")
public class UserinfoDetails implements UserDetails {
	
	private String gmail;
	private String password;
	private List<GrantedAuthority> authorities;
	
	
	public UserinfoDetails(UserEntity userEntity) {
		gmail= userEntity.getGmail();
		password = userEntity.getPassword();
		authorities = Arrays.stream(userEntity.getRolesArray())
                       .map(SimpleGrantedAuthority :: new)
                       .collect(Collectors.toList());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return gmail;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
