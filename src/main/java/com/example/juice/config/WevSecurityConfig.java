package com.example.juice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource; //нужен для того, чтобы менеджер мог ходить в бд и искать там юзеров и их роли

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() //для всех авторизованных
                    .antMatchers("/", "/registration", "/books").permitAll()  //разрешаем фул доступ
                    .anyRequest().authenticated() //для остальных требуем авторизацию
                .and()
                    .formLogin() //включаем логин форму
                    .loginPage("/login") //указываем, где находится страница логина
                    .permitAll() //разрешаем этим пользоваться всем
                .and()
                    .logout() //включаем логаут
                    .permitAll(); //разрешаем им поьзоваться всем
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.jdbcAuthentication()
                 .dataSource(dataSource)
                 .passwordEncoder(NoOpPasswordEncoder.getInstance()) //будет шифровать пароли, чтобы они не хранились в явном виде
                 .usersByUsernameQuery("select username, password, active from usr where username=?") //поиск пользователя по имени
                 .authoritiesByUsernameQuery("select u.username, ur.roles from usr u inner join user_role ur on u.id = ur.user_id where u.username=?"); //позволяет спрингу получить список пользователей с их ролями
                //из таблицы usr и происоед к ней user_role через поля u.id и ur.user_id выбираем поля u.username и ur.roles

    }
}