package com.umar.expensetracker.filters;

import com.umar.expensetracker.Constans;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class AuthFilter extends GenericFilterBean {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

		String authHeader = httpServletRequest.getHeader("Authorization");
		System.out.println("authHeader "+authHeader);
		if(authHeader!=null)
		{String[] authHeaderArr=authHeader.split("Bearer ");
			System.out.println("authHeader array"+ Arrays.toString(authHeaderArr));
		 if(authHeaderArr.length>1 && authHeaderArr[1]!=null)
		 {
		 	String token=authHeaderArr[1];
		 	System.out.println("token"+token);
		 	try{
			    System.out.println("inside try");
		 		Claims claims= Jwts.parser().setSigningKey(Constans.API_SECRET_KEY)
					    .parseClaimsJws(token).getBody();
		 		httpServletRequest.setAttribute("userId",Integer.parseInt(claims.get("userId").toString() ));
		    }
		 	catch(Exception e){
			    System.out.println("inside catch");
		 		httpServletResponse.sendError(HttpStatus.FORBIDDEN.value(),"invalid/expired token");
		 		return;
		    }
		 }
		 else{
		 	httpServletResponse.sendError(HttpStatus.FORBIDDEN.value(),"Authorization token must be Bearer [token]");
		 	return;
		 }
		}
		else{
			httpServletResponse.sendError(HttpStatus.FORBIDDEN.value(),"Authorization token must be provided");
		    return;
		}
		chain.doFilter(httpServletRequest,httpServletResponse);
	}
}