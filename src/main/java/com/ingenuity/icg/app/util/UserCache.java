package com.ingenuity.icg.app.util;

import org.apache.commons.collections.map.LRUMap;

/**
 * Created by IntelliJ IDEA.
 * User: pschmidt
 * Date: 5/9/12
 * Time: 10:43 AM
 * <p/>
 * Copyright (C) 2010 Ingenuity Systems, Inc. All rights reserved.
 * <p/>
 * This software is the confidential & proprietary information of Ingenuity Systems, Inc.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of any agreement or agreements you entered into with
 * Ingenuity Systems.
 */
public class UserCache {
    private LRUMap userCache;

    public UserCache() {
        this.userCache = new LRUMap();
    }

    public UserCache(int size) {
        this.userCache = new LRUMap(size);
    }

    public void putUser(int userId, String userName) {
        userCache.put(userId, userName);
    }

    public String getUser(int userId) {
        String userName = (String)userCache.get(userId);

        return userName;
    }
}
