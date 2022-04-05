/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ohalo.service;

import com.ohalo.data.UserRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bsystems4
 */

@Service
public class UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
