//package tn.esprit.tp1_aymen_nefzi_4twin7.serivce;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import tn.esprit.tp1_aymen_nefzi_4twin7.repository.IUserRepositries;
//
//@RequiredArgsConstructor
//@Service
//@Slf4j
//public class UserServiceImplements implements IUserService{
//    private final IUserRepositries userRepositries;
//    @Override
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                return userRepositries.findByEmail(username).orElseThrow(()->new RuntimeException("utilisateur non trouvé"));
//            }
//        };
//    }
//}
