//package ru.sbdh.app.config.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//public class WebSecurityConfigBearer extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/**/*").authenticated()
//                .and()
//                .logout()
//                .logoutUrl("/web/logout")
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID");
//        http.authorizeRequests().antMatchers("/login*").permitAll();
//
//        http.csrf().disable();
//
//        // HTTPS
//        http
//                .requiresChannel()
//                .anyRequest()
//                .requiresSecure();
//
//        //MAP 80 to HTTPS PORT
////        http.portMapper().http(80).mapsTo(1443);
//    }
//}
