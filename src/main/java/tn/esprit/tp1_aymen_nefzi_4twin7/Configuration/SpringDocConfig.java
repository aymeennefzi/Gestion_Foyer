package tn.esprit.tp1_aymen_nefzi_4twin7.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(infoAPI());
    }

    public Info infoAPI() {
        return new Info().title("Mini Projet SpringBoot").description("Gestion Foyer").contact(contactAPI());
    }

    public Contact contactAPI() {
        Contact contact = new Contact().name("Equipe Aymen").email("aymen.nefzi@esprit.tn").url("https://www.linkedin.com/in/aymen-nefzi-831b6321b/");
        return contact;
    }

    @Bean
    public GroupedOpenApi BLOC() {
        return GroupedOpenApi.builder().group("BLOC").pathsToMatch("/bloc/**").pathsToExclude("**").build();
    }
    @Bean
    public GroupedOpenApi FOYER() {
        return GroupedOpenApi.builder().group("FOYER").pathsToMatch("/foyer/**").pathsToExclude("**").build();
    }
    @Bean
    public GroupedOpenApi CHAMBRE() {
        return GroupedOpenApi.builder().group("CHAMBRE").pathsToMatch("/chambre/**").pathsToExclude("**").build();
    }

    @Bean
    public GroupedOpenApi RESERVATION() {
        return GroupedOpenApi.builder().group("RESERVATION").pathsToMatch("/Reservation/**").pathsToExclude("**").build();
    }

    @Bean
    public GroupedOpenApi UNIVERSITE() {
        return GroupedOpenApi.builder().group("UNIVERSITE").pathsToMatch("/universite/**").pathsToExclude("**").build();
    }

    @Bean
    public GroupedOpenApi ETUDIANT() {
        return GroupedOpenApi.builder().group("ETUDIANT").pathsToMatch("/etudiant/**").pathsToExclude("**").build();
    }




}
