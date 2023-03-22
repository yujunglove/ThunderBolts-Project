package com.greedy.thunderbolts.model.dto;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class MembersDTO implements UserDetails {
	private int membersNo;
	private String membersName;
	private String membersId;
	private String membersPwd;
	private int membersTel;
	private Date membersRegDate;
	private int membersEntire;
	private List<AuthRoleDTO> authRoleList;
	
	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		 Set<GrantedAuthority> roles = new HashSet<>();
	        for(AuthRoleDTO role : authRoleList) {
	        	roles.add(new SimpleGrantedAuthority(role.getAuth().getName()));
	        }
	        return roles;
	}
	@Override
	public String getPassword() {
		return membersPwd;
	}
	@Override
	public String getUsername() {
		
		return membersId;
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
