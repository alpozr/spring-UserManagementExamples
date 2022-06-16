package com.alp.service.impl;

import com.alp.apitutorial.UserDto;
import com.alp.model.Adress;
import com.alp.model.User;
import com.alp.repository.AdressRepository;
import com.alp.repository.UserRepository;
import com.alp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;//RequiredArgsconstructor anotasyonu bunun ıcın constructor olusturacak,
    //bunu da bizim ona verdigimiz final tipinden tanıyacak.Cunku yukarıda null bıraktık ama final bir degisken null kalamaz
    //o da bunu constructor vererek cozuyor.
    private final AdressRepository adressRepository;
    @Override
    public UserDto save(UserDto userDto) {
       // Assert.isNotNull(userDto.getFirstname(),"User name cannot be null!");
        User user = new User();
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
       final User userDb =userRepository.save(user);
      List<Adress> adressList=new ArrayList<>();

          userDto.getAdresses().forEach(item -> {
              Adress adress = new Adress();
              adress.setAdress(item);
              adress.setAdressType(Adress.AdressType.OTHER);
              adress.setActive(true);
              adress.setUser(userDb);
              adressList.add(adress);
          });
          adressRepository.saveAll(adressList);
          userDto.setId(userDb.getId());
          return userDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UserDto> getAll() {
        List<User> users= userRepository.findAll();
        List<UserDto> userDtos= new ArrayList<>();

        users.forEach(it->{
            UserDto userDto=new UserDto();
            userDto.setFirstname(it.getFirstname());
            userDto.setLastname(it.getLastname());
            userDto.setId(it.getId());
            userDto.setAdresses(it.getAdresses()
                    .stream().map(Adress::getAdress)
                    .collect(Collectors.toList()));
            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
    //Servis yalnızca dtolar ile calisir ve User bilgisini bilmez.

}
