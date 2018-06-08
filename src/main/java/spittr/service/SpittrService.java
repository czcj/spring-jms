package spittr.service;

import spittr.pojo.Spitter;
import spittr.pojo.Spittle;

import java.util.List;

public interface SpittrService {

    public List<Spittle> getSpittles();
    Spitter test();
}
