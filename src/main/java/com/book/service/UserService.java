package com.book.service;

import jakarta.servlet.http.HttpSession;

/**
 * @author loop
 */
public interface UserService {

    /**
     *
     * @param username username
     * @param password
     * @param session
     * @return
     */
    boolean auth(String username, String password, HttpSession session);
}
