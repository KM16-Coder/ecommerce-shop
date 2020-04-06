	package com.laptrinhjavaweb.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.constants.ActiveConstant;
import com.laptrinhjavaweb.dto.MyUserDetails;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.RoleRepository;
import com.laptrinhjavaweb.repository.UserRepository;
@Service
public class JwtUserDetailsService implements UserDetailsService {
	//mai fix doan này
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//UserEntity adminEntity =userRepository.getOne(1L); //tại sao gọi v lại sai tìm hiểu
		
//		if (adminEntity.getUserName().equals(username)) {
//			return new User(adminEntity.getUserName(), adminEntity.getPassWord(),
//					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
		
		
//		if ("admin".equals(username)) {
//			return new User("admin", "$2a$10$ATk47qDYJs1a4Bb2vxVCT./9cPHsNrtiyvwmFBCvwNHeZxxxPfe/C",
//					new ArrayList<>());
//			//$10$ATk47qDYJs1a4Bb2vxVCT./9cPHsNrtiyvwmFBCvwNHeZxxxPfe/C
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
		
		
		
		try {
			UserEntity userEntity=userRepository.findOneByUserNameAndStatus(username,ActiveConstant.ACTIVE);
			if(userEntity==null) {
				throw new UsernameNotFoundException("User not found with username: " + username);
			}
			List<GrantedAuthority> authorities=new ArrayList<>();
			for(RoleEntity item:userEntity.getRoles()) // khi m thêm vào database là nó lưu trong thằng role này rồi 
			{
				authorities.add(new SimpleGrantedAuthority("ROLE_"+item.getCode())); //Role_ là vì khi làm nó mới hiểu được
			}
			MyUserDetails myUserDetails=new MyUserDetails(userEntity.getUserName(),userEntity.getPassWord(),true,true,true,true,authorities);	
			BeanUtils.copyProperties(userEntity, myUserDetails);
			return myUserDetails;
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
