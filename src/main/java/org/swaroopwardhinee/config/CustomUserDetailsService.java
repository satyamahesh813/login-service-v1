package org.swaroopwardhinee.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.swaroopwardhinee.exception.CustomException;
import org.swaroopwardhinee.mappers.UsersMapper;
import org.swaroopwardhinee.models.Users;
import org.swaroopwardhinee.models.UsersExample;
import org.swaroopwardhinee.util.EncrypterHelper;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersMapper usersMapper;

	@Autowired
	private EncrypterHelper encrypterHelper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UsersExample accountExample = new UsersExample();
		accountExample.createCriteria().andEmailEqualTo(username);
		List<Users> userAccountList = usersMapper.selectByExample(accountExample);
		if (userAccountList != null && !userAccountList.isEmpty()) {
			String bcryptCd = null;
			try {
				bcryptCd = encrypterHelper.decrypt(userAccountList.get(0).getPassword(),
						userAccountList.get(0).getPasswordSalt());
			} catch (CustomException e) {
				e.printStackTrace();
			}
			return new User(userAccountList.get(0).getEmail(), bcryptCd, new ArrayList<>());
		}else {
			throw  new UsernameNotFoundException(username);
		}
	}

}
