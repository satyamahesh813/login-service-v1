package org.swaroopwardhinee.util;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.swaroopwardhinee.config.CustomUserDetailsService;
import org.swaroopwardhinee.exception.CustomException;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenService jwtTokenService;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private EncrypterHelper encryptHelper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = null;
		String userName = null;
		String header = request.getHeader("Authorization");
		String decryptToken = null;
		if (StringUtils.isNotBlank(header)) {
			try {
				decryptToken = encryptHelper.decrypt(header, "");
			} catch (CustomException e) {
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotBlank(decryptToken) && decryptToken.startsWith("Bearer ")) {
			token = decryptToken.substring(7);
			userName = jwtTokenService.getUsernameFromToken(token);
		}
		if (StringUtils.isNotBlank(userName) && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = customUserDetailsService.loadUserByUsername(userName);
			if (userDetails !=null && jwtTokenService.validateToken(token)) {
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}

}
