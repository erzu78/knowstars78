package com.jk.service;

import com.jk.pojo.Information;

import java.util.HashMap;
import java.util.List;

public interface InfServiceP {
    List<Information> infoList(Integer start, Integer rows);
    long queryCount();
    void deleteInfo(Integer infid);
}
